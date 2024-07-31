package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import jakarta.validation.constraints.NotEmpty
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

    @field:NotEmpty(message = "Discussion files cannot be empty")
    val codes: List<DiscussionCode>
)
