package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.IssueIndexEntity

interface DiscussionIndexRepository: JpaRepository<IssueIndexEntity, Long> {
}