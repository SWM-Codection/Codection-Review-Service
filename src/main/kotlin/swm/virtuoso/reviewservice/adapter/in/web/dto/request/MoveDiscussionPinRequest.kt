package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull

data class MoveDiscussionPinRequest(
    @field:NotNull
    val id: Long,
    @field:NotNull
    val position: Int
)