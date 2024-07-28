package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domian.DiscussionUser

public interface DiscussionUserPort {
    fun insertDiscussionUser(userId: Long, discussionId: Long): DiscussionUser
}
