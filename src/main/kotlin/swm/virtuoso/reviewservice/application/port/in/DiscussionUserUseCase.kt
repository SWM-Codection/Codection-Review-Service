package swm.virtuoso.reviewservice.application.port.`in`

interface DiscussionUserUseCase {
    fun markDiscussionAsMention(discussionId: Long, userId: Long)
    fun markDiscussionAsRead(discussionId: Long, userId: Long)
}
