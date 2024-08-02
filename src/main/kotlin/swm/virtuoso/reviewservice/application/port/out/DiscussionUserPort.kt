package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionUser

public interface DiscussionUserPort {
    fun insertDiscussionUser(userId: Long, discussionId: Long): DiscussionUser
}
