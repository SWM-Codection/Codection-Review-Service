package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity

interface DiscussionReactionRepository : JpaRepository<DiscussionReactionEntity, Long> {
    fun findAllByDiscussionId(discussionId: Long): List<DiscussionReactionEntity>
    fun findAllByCommentId(commentId: Long): List<DiscussionReactionEntity>
}
