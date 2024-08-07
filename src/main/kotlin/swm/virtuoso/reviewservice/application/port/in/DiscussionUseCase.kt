package swm.virtuoso.reviewservice.application.port.`in`

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode

public interface DiscussionUseCase {
    fun createDiscussion(discussion: Discussion, codes: List<DiscussionCode>, assignees: List<Long>?): Discussion
    fun getDiscussionAssignees(discussionId: Long): List<DiscussionAssignee>
    fun getDiscussion(discussionId: Long): Discussion
    fun countDiscussion(repoId: Long): Pair<Int, Int>
    fun getDiscussions(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion>
    fun modifyDiscussionDeadline(discussionId: Long, deadline: Long?)
    fun modifyDiscussion(modifyDiscussionRequest: ModifyDiscussionRequest): Discussion
}
