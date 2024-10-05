package swm.virtuoso.reviewservice.application.port.`in`

public interface DiscussionAssigneesUseCase {
    fun changeAssignee(discussionId: Long, assigneeId: Long)
    fun clearAssigneesByDiscussionId(discussionId: Long)
}
