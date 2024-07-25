package swm.virtuoso.reviewservice.application.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.domian.DiscussionComment

@Service
class DiscussionCommentService(
    private val discussionCommentPort: DiscussionCommentPort
) : DiscussionCommentUseCase {

    private val logger = LoggerFactory.getLogger(DiscussionCommentService::class.java)

    @Transactional
    override fun createComment(discussionComment: DiscussionComment): DiscussionComment {
        val newDiscussionComment = discussionCommentPort.saveComment(discussionComment)
        logger.info("Saved discussionComment with ID: {}", newDiscussionComment.id)
        return newDiscussionComment
    }
}
