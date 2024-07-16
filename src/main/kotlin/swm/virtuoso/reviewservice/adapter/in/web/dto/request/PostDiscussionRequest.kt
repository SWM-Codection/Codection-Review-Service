package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.domian.DiscussionFile

data class PostDiscussionRequest(
    @field:NotNull(message = "Repository ID cannot be null")
    val repoId: Long,

    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,

    val name: String,

    val content: String,

    @field:NotEmpty(message = "Discussion files cannot be empty")
    val discussionFiles: List<DiscussionFile>
)
