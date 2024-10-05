package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull

data class UpdateAssigneeRequest(
    @field:NotNull(message = "Discussion Id cannot be null.")
    val discussionId: Long,
    @field:NotNull(message = "Assignees Ids cannot be null.")
    val assigneeId: Long
)
