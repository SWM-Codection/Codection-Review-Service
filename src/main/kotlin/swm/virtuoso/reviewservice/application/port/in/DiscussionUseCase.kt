package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity

public interface DiscussionUseCase {
    fun createDiscussion(request: PostDiscussionRequest, lastCommitHash: String?): DiscussionEntity
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
}