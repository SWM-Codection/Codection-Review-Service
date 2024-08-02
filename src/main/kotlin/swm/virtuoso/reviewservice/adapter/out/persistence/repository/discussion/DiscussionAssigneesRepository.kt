package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity

interface DiscussionAssigneesRepository : JpaRepository<DiscussionAssigneesEntity, Long> {
    fun findAllByDiscussionId(discussionId: Long): List<DiscussionAssigneesEntity>
}
