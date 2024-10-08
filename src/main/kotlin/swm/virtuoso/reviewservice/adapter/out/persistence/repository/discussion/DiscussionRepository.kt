package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity

interface DiscussionRepository : JpaRepository<DiscussionEntity, Long> {
    fun countByRepoIdAndIsClosed(repoId: Long, isClosed: Boolean): Int
    fun findAllByRepoIdAndIsClosed(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<DiscussionEntity>
}
