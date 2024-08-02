package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionAssignee

public interface DiscussionAssigneesPort {
    fun insertDiscussionAssignees(discussionAssignees: List<DiscussionAssignee>)
    fun findDiscussionAssignees(discussionId: Long): List<DiscussionAssignee>
}
