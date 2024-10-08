package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity

interface DiscussionUserRepository : JpaRepository<DiscussionUserEntity, Long> {
    fun findByUserId(userId: Long): DiscussionUserEntity?
}
