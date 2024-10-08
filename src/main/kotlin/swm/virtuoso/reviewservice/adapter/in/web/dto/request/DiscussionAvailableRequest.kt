package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull

data class DiscussionAvailableRequest(
    @field:NotNull(message = "Repository Id cannot be null.")
    val repoId: Long,
    @field:NotNull(message = "Discussion Key cannot be null.")
    val available: Boolean
)
