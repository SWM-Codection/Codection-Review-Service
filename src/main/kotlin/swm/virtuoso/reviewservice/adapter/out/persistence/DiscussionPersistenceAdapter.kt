package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.CreateDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCodeListResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.DiscussionItem
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionFileEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.IssueIndexEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity
import swm.virtuoso.reviewservice.application.port.out.DiscussionFilePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.domian.DiscussionFile

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionFileRepository: DiscussionFileRepository,
    private val discussionIndexRepository: DiscussionIndexRepository,
    private val discussionUserRepository: DiscussionUserRepository
): DiscussionPort, DiscussionFilePort, DiscussionUserPort {
    private fun getIndex(repoId: Long): Long =
        discussionIndexRepository.findById(repoId)
            .map { it.maxIndex + 1 }
            .orElse(1)

    override fun createDiscussion(
        createDiscussionRequest: CreateDiscussionRequest,
        lastCommitHash: String?
    ): DiscussionEntity {
        val index = getIndex(createDiscussionRequest.repoId)
        val discussionEntity = discussionRepository.save(DiscussionEntity.from(
            createDiscussionRequest = createDiscussionRequest,
            index = index,
            commitHash = lastCommitHash)
        )

        createDiscussionRequest.discussionFiles.map { discussionFile ->
            discussionFileRepository.save(DiscussionFileEntity.from(
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

    override fun addDiscussionUser(userId: Long, discussionId: Long) {
        discussionUserRepository.save(DiscussionUserEntity(
            id = null,
            uid = userId,
            discussionId = discussionId,
            isRead = true,
            isMentioned = false)
        )
    }

    override fun getDiscussionCount(repoId: Long, isClosed: Boolean): Int {
        return discussionRepository.countByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun getDiscussionList(repoId: Long, isClosed: Boolean): List<DiscussionEntity> {
        return discussionRepository.findAllByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun getDiscussionFiles(discussionId: Long): List<DiscussionFileEntity> {
        return discussionFileRepository.findAllByDiscussionId(discussionId)
    }

}