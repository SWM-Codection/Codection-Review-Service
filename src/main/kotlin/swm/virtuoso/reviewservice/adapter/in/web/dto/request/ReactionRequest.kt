package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum

abstract class ReactionRequest(
    open val type: ReactionTypeEnum,
    open val discussionId: Long,
    open val commentId: Long?,
    open val userId: Long
)
