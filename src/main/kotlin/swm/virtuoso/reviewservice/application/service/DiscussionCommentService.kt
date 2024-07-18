package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.domian.DiscussionComment

@Service
class DiscussionCommentService(
    private val discussionCommentPort: DiscussionCommentPort
) : DiscussionCommentUseCase {
    @Transactional
    override fun createComment(discussionComment: DiscussionComment): DiscussionComment {
        return discussionCommentPort.saveComment(discussionComment)
    }
}
