package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.domian.DiscussionReaction

interface DiscussionReactionUseCase {
    fun addDiscussionReaction(reaction: DiscussionReaction): DiscussionReaction
}
