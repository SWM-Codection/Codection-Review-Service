package swm.virtuoso.reviewservice.application.port.`in`

public interface DiscussionUserUseCase {
    fun markDiscussionAsMention(discussionId: Long, userId: Long)
    fun markDiscussionAsRead(discussionId: Long, userId: Long)
}
