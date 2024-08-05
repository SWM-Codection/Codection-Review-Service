package swm.virtuoso.reviewservice.application.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.domain.DiscussionComment

@Service
class DiscussionCommentService(
    private val discussionCommentPort: DiscussionCommentPort,
    private val discussionPort: DiscussionPort,
    private val discussionCodePort: DiscussionCodePort,
    private val discussionUserPort: DiscussionUserPort
) : DiscussionCommentUseCase {

    private val logger = LoggerFactory.getLogger(DiscussionCommentService::class.java)

    @Transactional
    override fun createComment(discussionComment: DiscussionComment): DiscussionComment {
        val discussion = discussionPort.findDiscussionById(discussionComment.discussionId)
        discussionComment.codeId?.let { codeId ->
            // 조건이 안맞으면 IllegalArgumentException 발생
            require(discussion.id == discussionCodePort.findDiscussionCodeById(codeId).discussionId) {
                "코드의 정보와 디스커션 정보가 일치하지 않습니다."
            }
        }

        val newDiscussionComment = discussionCommentPort.insertComment(discussionComment)
        logger.info("Saved discussionComment with ID: {}", newDiscussionComment.id)

        val savedDiscussionUser = discussionUserPort.insertDiscussionUser(
            userId = discussionComment.posterId,
            discussionId = discussionComment.discussionId
        )
        logger.info("Saved discussionUser with ID: {}", savedDiscussionUser.id)

        return newDiscussionComment
    }

    override fun deleteComment(commentId: Long) {
        discussionCommentPort.deleteCommentById(commentId)
    }

    override fun modifyComment(modifiedComment: DiscussionComment) {
        // TODO 코드 블록이 있는지 검증한 뒤에 삭제하기
        discussionCommentPort.updateComment(modifiedComment)
    }
}
