package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort

@Service
class DiscussionService(
    private val discussionPort: DiscussionPort,
    private val discussionUserPort: DiscussionUserPort
) : DiscussionUseCase {

    @Transactional
    override fun createDiscussion(
        request: PostDiscussionRequest,
        lastCommitHash: String?
    ): DiscussionEntity {
        val discussion = discussionPort.saveDiscussion(request, lastCommitHash)
        discussionUserPort.saveDiscussionUser(discussion.posterId, discussion.id!!)
        return discussion
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionPort.countDiscussion(repoId, isClosed)
    }
}
