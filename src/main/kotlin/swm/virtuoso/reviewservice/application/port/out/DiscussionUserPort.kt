package swm.virtuoso.reviewservice.application.port.out

public interface DiscussionUserPort {
    fun saveDiscussionUser(userId: Long, discussionId: Long)
}
