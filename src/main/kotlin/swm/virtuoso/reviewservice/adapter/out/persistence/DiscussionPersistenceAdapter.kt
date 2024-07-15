package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.*
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.*
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionCodeRepository: DiscussionCodeRepository,
    private val discussionIndexRepository: DiscussionIndexRepository,
    private val discussionUserRepository: DiscussionUserRepository,
    private val discussionCommentRepository: DiscussionCommentRepository
): DiscussionPort, DiscussionCodePort, DiscussionUserPort, DiscussionCommentPort {

    private fun getIndex(repoId: Long): Long =
        discussionIndexRepository.findById(repoId)
            .map { it.maxIndex + 1 }
            .orElse(1)

    override fun saveDiscussion(
        createDiscussionRequest: PostDiscussionRequest,
        lastCommitHash: String?
    ): DiscussionEntity {
        val index = getIndex(createDiscussionRequest.repoId)
        val discussionEntity = discussionRepository.save(DiscussionEntity.from(
            createDiscussionRequest = createDiscussionRequest,
            index = index,
            commitHash = lastCommitHash)
        )

        createDiscussionRequest.discussionFiles.map { discussionFile ->
            discussionCodeRepository.save(DiscussionCodeEntity.from(
                discussionFile = discussionFile,
                discussionId = discussionEntity.id!!)
            )
        }

        discussionIndexRepository.save(IssueIndexEntity(
            groupId = createDiscussionRequest.repoId,
            maxIndex = index)
        )

        return discussionEntity
    }

    override fun saveDiscussionUser(userId: Long, discussionId: Long) {
        discussionUserRepository.save(DiscussionUserEntity(
            id = null,
            uid = userId,
            discussionId = discussionId,
            isRead = true,
            isMentioned = false)
        )
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionRepository.countByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussionList(repoId: Long, isClosed: Boolean): List<DiscussionEntity> {
        return discussionRepository.findAllByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussionFiles(discussionId: Long): List<DiscussionCodeEntity> {
        return discussionCodeRepository.findAllByDiscussionId(discussionId)
    }

    override fun saveComment(postCommentRequest: PostCommentRequest): DiscussionCommentEntity {
        saveDiscussionUser(
            userId = postCommentRequest.posterId,
            discussionId = postCommentRequest.discussionId
        )

        return discussionCommentRepository.save(DiscussionCommentEntity(
            id = null,
            discussionId = postCommentRequest.discussionId,
            codeId = postCommentRequest.codeId,
            posterId = postCommentRequest.posterId,
            scope = postCommentRequest.scope,
            startLine = postCommentRequest.startLine,
            endLine = postCommentRequest.endLine,
            content = postCommentRequest.content
        ))
    }

    override fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionCommentEntity> {
        return discussionCommentRepository.findAllByDiscussionId(discussionId)
    }
}