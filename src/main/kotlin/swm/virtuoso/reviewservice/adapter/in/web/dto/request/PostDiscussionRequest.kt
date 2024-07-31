package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.domain.DiscussionCode

data class PostDiscussionRequest(
    @field:NotNull(message = "Repository ID cannot be null")
    val repoId: Long,

    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,

    val name: String? = null,

    val content: String? = null,

    @field:NotNull(message = "Branch Name cannot be null")
    val branchName: String,

    @field:NotEmpty(message = "Discussion files cannot be empty")
    val codes: List<DiscussionCode>,

    val assignees: List<Long>? = null,

    val deadline: String? = null
)
