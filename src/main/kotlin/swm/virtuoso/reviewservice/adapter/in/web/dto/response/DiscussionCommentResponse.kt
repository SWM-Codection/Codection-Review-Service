package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

data class DiscussionCommentResponse (
    val id: Long,
    val scope: String,
    val startLine: Int?,
    val endLine: Int?,
    val content: String
)