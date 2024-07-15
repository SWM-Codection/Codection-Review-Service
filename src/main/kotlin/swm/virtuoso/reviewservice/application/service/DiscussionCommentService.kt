package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort

@Service
class DiscussionCommentService(
    private val discussionCommentPort: DiscussionCommentPort
): DiscussionCommentUseCase {
    @Transactional
    override fun createComment(request: PostCommentRequest): DiscussionCommentEntity {
        return discussionCommentPort.saveComment(request)
    }
}