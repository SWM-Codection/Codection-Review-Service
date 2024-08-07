package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum

data class PostReactionRequest(
    @field:NotNull(message = "type cannot be null")
    val type: ReactionTypeEnum,
    @field:NotNull(message = "Discussion ID cannot be null")
    val discussionId: Long,
    val commentId: Long? = null,
    @field:NotNull(message = "User ID cannot be null")
    val userId: Long
)
