package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.domian.DiscussionCode

data class PostDiscussionRequest(
    @field:NotNull(message = "Repository ID cannot be null")
    val repoId: Long,

    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,

    val name: String,

    val content: String,

    val commitHash: String,

    @field:NotEmpty(message = "Discussion files cannot be empty")
    val codes: List<DiscussionCode>
)