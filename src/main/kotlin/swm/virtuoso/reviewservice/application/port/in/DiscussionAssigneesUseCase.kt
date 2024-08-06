package swm.virtuoso.reviewservice.application.port.`in`

public interface DiscussionAssigneesUseCase {
    fun modifyAssignees(discussionId: Long, assignees: List<Long>)
}