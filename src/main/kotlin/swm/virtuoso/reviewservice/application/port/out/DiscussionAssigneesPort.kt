package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionAssignee

public interface DiscussionAssigneesPort {
    fun insertDiscussionAssignee(discussionAssignee: DiscussionAssignee)
    fun insertDiscussionAssignees(discussionAssignees: List<DiscussionAssignee>)
    fun findDiscussionAssigneesByDiscussionId(discussionId: Long): List<DiscussionAssignee>
    fun deleteDiscussionAssigneesByAssigneesIn(discussionId: Long, assignees: List<Long>)
    fun findByDiscussionIdAndAssigneeId(discussionId: Long, assigneeId: Long): DiscussionAssignee?
    fun deleteByDiscussionAssigneeById(discussionAssigneeId: Long)
    fun deleteAllByDiscussionId(discussionId: Long)
}
