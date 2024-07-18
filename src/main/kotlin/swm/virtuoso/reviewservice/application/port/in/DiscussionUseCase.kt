package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment

public interface DiscussionUseCase {
    fun createDiscussion(discussion: Discussion, codes: List<DiscussionCode>): DiscussionEntity
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun modifyDiscussion(modifyDiscussionRequest: ModifyDiscussionRequest): DiscussionEntity
}
