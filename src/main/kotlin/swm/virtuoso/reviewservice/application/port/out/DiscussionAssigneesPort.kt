package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionAssignee

public interface DiscussionAssigneesPort {
    fun insertDiscussionAssignees(discussionAssignees: List<DiscussionAssignee>)
    fun findDiscussionAssigneesByDiscussionId(discussionId: Long): List<DiscussionAssignee>
    fun deleteDiscussionAssigneesById(assignees: List<Long>)
}
