package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull

data class DiscussionWatchRequest(
    @field:NotNull
    val userId : Long,
    @field:NotNull
    val discussionId: Long
)
