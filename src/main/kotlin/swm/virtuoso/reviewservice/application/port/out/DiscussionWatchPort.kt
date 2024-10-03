package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionWatch
import java.util.*

interface DiscussionWatchPort {

    fun findById(id: Long): DiscussionWatch
    fun findByUserIdAndDiscussionId(userId: Long, discussionId: Long): DiscussionWatch
    fun checkWatchDuplication(userId: Long, discussionId: Long)
    fun save(userId: Long, discussionId: Long)
    fun update(discussionWatch: DiscussionWatch)
}
