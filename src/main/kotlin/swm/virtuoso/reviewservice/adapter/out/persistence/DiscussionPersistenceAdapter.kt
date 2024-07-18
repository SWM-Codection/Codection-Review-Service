package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.IssueIndexEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.common.exception.NoSuchDiscussionException
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionAllContent
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionCodeRepository: DiscussionCodeRepository,
    private val discussionIndexRepository: DiscussionIndexRepository,
    private val discussionUserRepository: DiscussionUserRepository,
    private val discussionCommentRepository: DiscussionCommentRepository,
    private val mapper: DiscussionMapper
) : DiscussionPort, DiscussionCodePort, DiscussionUserPort, DiscussionCommentPort {

    private fun getIndex(repoId: Long): Long =
        discussionIndexRepository.findById(repoId)
            .map { it.maxIndex + 1 }
            .orElse(1)

    override fun saveDiscussion(discussion: Discussion): DiscussionEntity {
        return discussionRepository.save(mapper.discussionToDiscussionEntity(discussion))
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionRepository.countByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussionList(repoId: Long, isClosed: Boolean): List<DiscussionEntity> {
        return discussionRepository.findAllByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussion(discussionId: Long): Discussion {
        val discussionEntity = discussionRepository.findByIdOrNull(discussionId)
            ?: throw NoSuchElementException("디스커션 정보를 찾을 수 없습니다.")

        return mapper.discussionEntityToDiscussion(discussionEntity)
    }

    override fun saveDiscussionAllContent(
        discussionAllContent: DiscussionAllContent
    ): DiscussionEntity {
        val index = getIndex(discussionAllContent.repoId)
        val discussionEntity = discussionRepository.save(
            DiscussionEntity.fromDiscussionAllContent(
                discussion = discussionAllContent,
                index = index,
            )
        )

        discussionAllContent.codes.map { discussionCode ->
            discussionCodeRepository.save(
                DiscussionCodeEntity.from(
                    discussionCode = discussionCode,
                    discussionId = discussionEntity.id!!
                )
            )
        }

        discussionIndexRepository.save(
            IssueIndexEntity(
                groupId = discussionAllContent.repoId,
                maxIndex = index
            )
        )

        return discussionEntity
    }

    override fun findDiscussionAllContent(discussionId: Long): DiscussionAllContent {
        val discussionEntity = discussionRepository.findById(discussionId).orElseThrow {
            NoSuchDiscussionException()
        }
        val discussionCodes = discussionCodeRepository.findAllByDiscussionId(discussionId)

        return DiscussionAllContent(
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

    override fun findDiscussionCodes(discussionId: Long): List<DiscussionCode> {
        return discussionCodeRepository.findAllByDiscussionId(discussionId)
            .map { mapper.discussionCodeEntityToDiscussionCode(it) }
    }

    override fun deleteDiscussionCodeAllById(id: List<Long>) {
        // TODO soft delete로 바꿀지 생각해보기
        return discussionCodeRepository.deleteAllById(id)
    }

    override fun saveDiscussionCodes(discussionCodes: List<DiscussionCode>) {
        val entities: List<DiscussionCodeEntity> = discussionCodes.map { discussionCode ->
            mapper.discussionCodeToDiscussionCodeEntity(discussionCode)
        }
        discussionCodeRepository.saveAll(entities)
    }

    override fun saveComment(discussionComment: DiscussionComment): DiscussionComment {
        saveDiscussionUser(
            userId = discussionComment.posterId,
            discussionId = discussionComment.discussionId
        )

        val savedEntity = discussionCommentRepository.save(
            mapper.discussionCommentToDiscussionCommentEntity(discussionComment)
        )

        return mapper.discussionCommentEntityToDiscussionComment(savedEntity)
    }

    override fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment> {
        return discussionCommentRepository.findAllByDiscussionId(discussionId)
            .map { mapper.discussionCommentEntityToDiscussionComment(it) }
    }
}
