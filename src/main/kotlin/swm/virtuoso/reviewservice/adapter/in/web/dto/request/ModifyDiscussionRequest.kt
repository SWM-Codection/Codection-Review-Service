package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.domain.DiscussionCode

data class ModifyDiscussionRequest(
    @field:NotNull(message = "Repository ID cannot be null")
    val repoId: Long,

    @field:NotNull(message = "Discussion ID cannot be null")
    val discussionId: Long,

    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,

    val name: String,

    val content: String,

    val deletedCodesIds: List<Long>,

    val newCodes: List<DiscussionCode>
)
