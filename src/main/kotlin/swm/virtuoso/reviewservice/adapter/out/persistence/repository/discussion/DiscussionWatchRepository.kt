package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionWatchEntity
import java.util.*

interface DiscussionWatchRepository : JpaRepository<DiscussionWatchEntity, Long> {
    fun existsByUserIdAndDiscussionId(userId: Long, discussionId: Long): Boolean
    fun findByUserIdAndDiscussionId(userId: Long, discussionId: Long): Optional<DiscussionWatchEntity>
}
