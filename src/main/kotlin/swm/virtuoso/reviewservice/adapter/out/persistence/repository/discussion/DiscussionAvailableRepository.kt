package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAvailableEntity

interface DiscussionAvailableRepository : JpaRepository<DiscussionAvailableEntity, Long> {
    fun findByRepoId(repoId: Long): DiscussionAvailableEntity?
}
