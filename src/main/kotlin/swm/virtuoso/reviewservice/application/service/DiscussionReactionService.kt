package swm.virtuoso.reviewservice.application.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionReactionUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionReactionPort
import swm.virtuoso.reviewservice.domain.DiscussionReaction

@Service
class DiscussionReactionService(
    private val discussionReactionPort: DiscussionReactionPort,
    private val discussionPort: DiscussionPort,
    private val discussionCommentPort: DiscussionCommentPort
) : DiscussionReactionUseCase {

    private val logger = LoggerFactory.getLogger(DiscussionReactionService::class.java)

    override fun addDiscussionReaction(reaction: DiscussionReaction): DiscussionReaction {
        discussionPort.findDiscussionById(reaction.discussionId)
        reaction.commentId?.let {
            val comment = discussionCommentPort.findCommentById(it)
            require(reaction.discussionId == comment.discussionId) {
                "디스커션 id와 코멘트의 디스커션 id가 일치하지 않습니다."
            }
        }
        val savedReaction = discussionReactionPort.insertReaction(reaction)
        logger.info("Saved reaction with ID: {}", savedReaction.id)

        return savedReaction
    }

    override fun removeDiscussionReaction(reaction: DiscussionReaction) {
        discussionPort.findDiscussionById(reaction.discussionId)
        // validate reaction
        require(reaction.id != null) { "리액션 id가 존재하지 않습니다." }
        require(reaction.commentId != null) { "리액션 코멘트 id가 존재하지 않습니다." }
        require(reaction.discussionId != discussionCommentPort.findCommentById(reaction.commentId).discussionId) {
            "디스커션 id와 코멘트의 디스커션 id가 일치하지 않습니다."
        }
        // FIXME: For now, i don't have any fancy-solution for handle remove failure
        discussionReactionPort.removeReaction(reaction)
    }

    override fun getDiscussionCommentReactions(discussionCommentId: Long): List<DiscussionReaction> {
        return discussionReactionPort.findReactionsByDiscussionCommentId(discussionCommentId)
    }
}
