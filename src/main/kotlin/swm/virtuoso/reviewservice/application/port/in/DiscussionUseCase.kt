package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionCode

public interface DiscussionUseCase {
    fun createDiscussion(discussion: Discussion, codes: List<DiscussionCode>): Discussion
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun getDiscussionList(repoId: Long, isClosed: Boolean): List<Discussion>
    fun modifyDiscussion(modifyDiscussionRequest: ModifyDiscussionRequest): DiscussionEntity
}
