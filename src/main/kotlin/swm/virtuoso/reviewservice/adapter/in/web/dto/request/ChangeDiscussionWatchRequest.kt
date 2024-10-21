package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull

data class ChangeDiscussionWatchRequest(
    @field:NotNull(message = "id not found")
    val id: Long,
    @field:NotNull(message = "userId not found")
    val userId: Long,
    @field:NotNull(message = "discussionId not found")
    val discussionId: Long

)
