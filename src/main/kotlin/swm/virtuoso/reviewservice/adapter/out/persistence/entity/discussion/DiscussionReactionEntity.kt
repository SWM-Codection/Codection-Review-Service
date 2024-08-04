package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnumConverter
import swm.virtuoso.reviewservice.domain.DiscussionReaction

@Entity
@Table(name = "discussion_reaction")
data class DiscussionReactionEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(name = "type", nullable = false)
    @Convert(converter = ReactionTypeEnumConverter::class)
    val type: ReactionTypeEnum,

    @field:Column(name = "discussion_id", nullable = false)
    val discussionId: Long,

    @field:Column(name = "comment_id")
    val commentId: Long? = null,

    @field:Column(name = "user_id", nullable = false)
    val userId: Long
) : BaseTimeEntity() {
    companion object {
        fun fromDiscussionReaction(discussionReaction: DiscussionReaction): DiscussionReactionEntity {
            return DiscussionReactionEntity(
                id = discussionReaction.id,
                type = discussionReaction.type,
                discussionId = discussionReaction.discussionId,
                commentId = discussionReaction.commentId,
                userId = discussionReaction.userId
            )
        }
    }
}
