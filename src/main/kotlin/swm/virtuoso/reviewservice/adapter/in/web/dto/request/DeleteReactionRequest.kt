package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum

data class DeleteReactionRequest(
    @field:NotNull(message = "type cannot be null")
    override val type: ReactionTypeEnum,
    @field:NotNull(message = "Discussion ID cannot be null")
    override val discussionId: Long,
    override val commentId: Long? = null,
    @field:NotNull(message = "User ID cannot be null")
    override val userId: Long
) : ReactionRequest(type, discussionId, commentId, userId)
