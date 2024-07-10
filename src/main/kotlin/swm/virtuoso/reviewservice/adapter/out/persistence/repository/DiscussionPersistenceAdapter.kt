package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort

@Repository
class DiscussionPersistenceAdapter (
    private val discussionJpaRepository: DiscussionRepository
): DiscussionPort {
}