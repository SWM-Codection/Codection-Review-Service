package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort

@Service
class DiscussionService (
    private val discussionPort: DiscussionPort
): DiscussionUseCase {
}