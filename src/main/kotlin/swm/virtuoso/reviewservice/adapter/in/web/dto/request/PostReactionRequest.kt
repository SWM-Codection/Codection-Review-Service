package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum

data class PostReactionRequest(
    val type: ReactionTypeEnum,
    val discussionId: Long,
    val commentId: Long? = null,
    val userId: Long
)