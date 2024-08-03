package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domian.DiscussionReaction

public interface DiscussionReactionPort {
    fun insertReaction(discussionReaction: DiscussionReaction): DiscussionReaction
    fun findReactionListByDiscussionId(discussionId: Long): List<DiscussionReaction>
}
