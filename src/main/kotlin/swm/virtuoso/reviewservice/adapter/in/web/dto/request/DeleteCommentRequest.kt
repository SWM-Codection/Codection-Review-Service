package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotNull

data class DeleteCommentRequest(

    @field:NotNull(message = "Comment ID cannot be null")
    val discussionCommentId: Long,
    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,
) {
}