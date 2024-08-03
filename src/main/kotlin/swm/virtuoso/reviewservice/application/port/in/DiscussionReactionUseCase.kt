package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.domain.DiscussionReaction

interface DiscussionReactionUseCase {
    fun addDiscussionReaction(reaction: DiscussionReaction): DiscussionReaction
}
