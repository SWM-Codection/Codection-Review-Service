package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domian.DiscussionComment

data class DiscussionCommentResponse(
    val id: Long,
    val scope: String,
    val startLine: Int?,
    val endLine: Int?,
    val content: String
) {
    companion object {
        fun fromDiscussionComment(discussionComment: DiscussionComment): DiscussionCommentResponse {
            return DiscussionCommentResponse(
                id = discussionComment.id!!,
                scope = discussionComment.scope.toString(),
                startLine = discussionComment.startLine,
                endLine = discussionComment.endLine,
                content = discussionComment.content
            )
        }
    }
}
