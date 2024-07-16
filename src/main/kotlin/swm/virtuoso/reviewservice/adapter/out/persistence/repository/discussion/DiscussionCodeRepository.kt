package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity

interface DiscussionCodeRepository : JpaRepository<DiscussionCodeEntity, Long> {
    fun findAllByDiscussionId(discussionId: Long): List<DiscussionCodeEntity>
}
