package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity

interface DiscussionRepository: JpaRepository<DiscussionEntity, Long> {
}