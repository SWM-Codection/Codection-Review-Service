package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.Discussion

interface DiscussionRepository: JpaRepository<Discussion, Long> {
}