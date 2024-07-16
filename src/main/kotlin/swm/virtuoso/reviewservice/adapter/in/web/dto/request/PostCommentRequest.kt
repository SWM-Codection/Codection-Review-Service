package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum

data class PostCommentRequest(
    @field:NotNull(message = "Discussion ID cannot be null")
    val discussionId: Long,
    @field:NotNull(message = "Code ID cannot be null")
    val codeId: Long,
    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,
    @field:NotEmpty(message = "Scope cannot be empty")
    val scope: CommentScopeEnum,
    val startLine: Int?,
    val endLine: Int?,
    @field:NotEmpty(message = "Contents cannot be empty")
    val content: String
)