package swm.virtuoso.reviewservice.domain

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ReactionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnumSerializer

data class DiscussionReaction(
    val id: Long? = null,
    @JsonSerialize(using = ReactionTypeEnumSerializer::class)
    val type: ReactionTypeEnum,
    val discussionId: Long,
    val commentId: Long? = null,
    val userId: Long
) {
    companion object {
        fun fromReactionRequest(request: ReactionRequest): DiscussionReaction {
            return DiscussionReaction(
                type = request.type,
                discussionId = request.discussionId,
                commentId = request.commentId,
                userId = request.userId
            )
        }

        fun fromEntity(entity: DiscussionReactionEntity): DiscussionReaction {
            return DiscussionReaction(
                id = entity.id,
                type = entity.type,
                discussionId = entity.discussionId,
                commentId = entity.commentId,
                userId = entity.userId
            )
        }
    }
}
