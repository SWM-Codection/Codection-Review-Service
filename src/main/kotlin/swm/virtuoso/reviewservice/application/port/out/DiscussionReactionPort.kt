package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionReaction

interface DiscussionReactionPort {
    fun insertReaction(discussionReaction: DiscussionReaction): DiscussionReaction
    fun removeReaction(discussionReaction: DiscussionReaction): Boolean
    fun findReactionsByDiscussionId(discussionId: Long): List<DiscussionReaction>
    fun findReactionsByDiscussionCommentId(discussionCommentId: Long): List<DiscussionReaction>
}
