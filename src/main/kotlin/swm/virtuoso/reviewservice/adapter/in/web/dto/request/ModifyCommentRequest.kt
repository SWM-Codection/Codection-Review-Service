package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum

data class ModifyCommentRequest(
    @field:NotNull(message = "Discussion ID cannot be null")
    val discussionId: Long,
    @field:NotNull(message = "Comment ID cannot be null")
    val discussionCommentId: Long,
    val codeId: Long? = null,
    @field:NotNull(message = "Poster ID cannot be null")
    val posterId: Long,
    @field:NotNull(message = "Scope cannot be empty")
    val scope: CommentScopeEnum,
    val startLine: Int?,
    val endLine: Int?,
    @field:NotEmpty(message = "Contents cannot be empty")
    val content: String
)
