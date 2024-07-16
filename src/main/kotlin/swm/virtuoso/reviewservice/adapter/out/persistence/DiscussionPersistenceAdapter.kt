package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.*
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.*
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.common.exception.NoSuchDiscussionException
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionCode

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionCodeRepository: DiscussionCodeRepository,
    private val discussionIndexRepository: DiscussionIndexRepository,
    private val discussionUserRepository: DiscussionUserRepository,
    private val discussionCommentRepository: DiscussionCommentRepository
) : DiscussionPort, DiscussionCodePort, DiscussionUserPort, DiscussionCommentPort {

    private fun getIndex(repoId: Long): Long =
        discussionIndexRepository.findById(repoId)
            .map { it.maxIndex + 1 }
            .orElse(1)

    override fun saveDiscussion(
        discussion: Discussion
    ): DiscussionEntity {
        val index = getIndex(discussion.repoId)
        val discussionEntity = discussionRepository.save(
            DiscussionEntity.from(
                discussion = discussion,
                index = index,
            )
        )

        discussion.codes.map { discussionCode ->
            discussionCodeRepository.save(
                DiscussionCodeEntity.from(
                    discussionFile = discussionCode,
                    discussionId = discussionEntity.id!!
                )
            )
        }

        discussionIndexRepository.save(
            IssueIndexEntity(
                groupId = discussion.repoId,
                maxIndex = index
            )
        )

        return discussionEntity
    }

    override fun saveDiscussionUser(userId: Long, discussionId: Long) {
        discussionUserRepository.save(
            DiscussionUserEntity(
                id = null,
                uid = userId,
                discussionId = discussionId,
                isRead = true,
                isMentioned = false
            )
        )
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionRepository.countByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussionList(repoId: Long, isClosed: Boolean): List<DiscussionEntity> {
        return discussionRepository.findAllByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussion(discussionId: Long): Discussion {
        val discussionEntity = discussionRepository.findById(discussionId).orElseThrow {
            NoSuchDiscussionException()
        }
        val discussionCodes = discussionCodeRepository.findAllByDiscussionId(discussionId)

        return Discussion(
            id = discussionEntity.id,
            name = discussionEntity.name,
            posterId = discussionEntity.posterId,
            codes = discussionCodes.map { discussionCode ->
                DiscussionCode(
                    id = discussionCode.id,
                    startLine = discussionCode.startLine,
                    endLine = discussionCode.endLine,
                    filePath = discussionCode.filePath
                )
            },
            content = discussionEntity.content,
            repoId = discussionEntity.repoId,
            commitHash = discussionEntity.commitHash
        )
    }

    override fun findDiscussionCodes(discussionId: Long): List<DiscussionCodeEntity> {
        return discussionCodeRepository.findAllByDiscussionId(discussionId)
    }

    override fun deleteDiscussionCodeAllById(id: List<Long>) {
        // TODO soft delete로 바꿀지 생각해보기
        return discussionCodeRepository.deleteAllById(id)
    }

    override fun saveComment(postCommentRequest: PostCommentRequest): DiscussionCommentEntity {
        saveDiscussionUser(
            userId = postCommentRequest.posterId,
            discussionId = postCommentRequest.discussionId
        )

        return discussionCommentRepository.save(
            DiscussionCommentEntity(
                id = null,
                discussionId = postCommentRequest.discussionId,
                codeId = postCommentRequest.codeId,
                posterId = postCommentRequest.posterId,
                scope = postCommentRequest.scope,
                startLine = postCommentRequest.startLine,
                endLine = postCommentRequest.endLine,
                content = postCommentRequest.content
            )
        )
    }

    override fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionCommentEntity> {
        return discussionCommentRepository.findAllByDiscussionId(discussionId)
    }
}