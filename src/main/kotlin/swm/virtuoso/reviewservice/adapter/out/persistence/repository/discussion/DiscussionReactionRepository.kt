package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.domain.DiscussionReaction
import java.util.Optional

interface DiscussionReactionRepository : JpaRepository<DiscussionReactionEntity, Long> {
    fun findAllByDiscussionId(discussionId: Long): List<DiscussionReactionEntity>
    fun findAllByCommentId(commentId: Long): List<DiscussionReactionEntity>

    @Query(
        """
        SELECT entity
        FROM DiscussionReactionEntity entity 
        WHERE 1 = 1  
            AND entity.discussionId = #{#reaction.discussionId} 
            AND entity.commentId = #{#reaction.commentId} 
            AND entity.userId = #{#reaction.userId}
            AND entity.type = #{#reaction.type}
    """
    )
    fun findByDiscussionReaction(@Param("reaction") discussionReaction: DiscussionReaction): Optional<DiscussionReactionEntity>
}
