package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionReactionRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionReactionPort
import swm.virtuoso.reviewservice.domain.DiscussionReaction

@Repository
class DiscussionReactionPersistenceAdapter(
    private val discussionReactionRepository: DiscussionReactionRepository
) : DiscussionReactionPort {
    override fun insertReaction(discussionReaction: DiscussionReaction): DiscussionReaction {
        val reactionEntity = discussionReactionRepository.findByDiscussionReaction(discussionReaction)
            ?: discussionReactionRepository.save(DiscussionReactionEntity.fromDiscussionReaction(discussionReaction))
        return DiscussionReaction.fromEntity(reactionEntity)
    }

    override fun removeReaction(discussionReaction: DiscussionReaction): Boolean {
        val entity = discussionReactionRepository
            .findByDiscussionReaction(discussionReaction)
        if (entity == null) {
            throw RuntimeException("Could not find DiscussionReactionEntity from DiscussionReaction")
        }
        return runCatching { discussionReactionRepository.delete(entity) }.isSuccess
    }

    override fun findReactionsByDiscussionId(discussionId: Long): List<DiscussionReaction> {
        return discussionReactionRepository.findAllByDiscussionId(discussionId)
            .map { DiscussionReaction.fromEntity(it) }
    }

    override fun findReactionsByDiscussionCommentId(discussionCommentId: Long): List<DiscussionReaction> {
        return discussionReactionRepository.findAllByCommentId(discussionCommentId)
            .map { DiscussionReaction.fromEntity(it) }
    }
}
