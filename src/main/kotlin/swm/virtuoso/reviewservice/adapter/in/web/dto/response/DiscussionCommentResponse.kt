package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domain.DiscussionComment
import swm.virtuoso.reviewservice.domain.DiscussionReaction

data class DiscussionCommentResponse(
    val id: Long,
    val posterId: Long,
    val scope: String,
    val startLine: Int?,
    val endLine: Int?,
    val content: String,
    val createdUnix: Long?,
    val updatedUnix: Long?,
    val reactions: List<DiscussionReaction>
) {
    companion object {
        fun fromDiscussionComment(
            discussionComment: DiscussionComment,
            reactions: List<DiscussionReaction>
        ): DiscussionCommentResponse {
            return DiscussionCommentResponse(
                id = discussionComment.id!!,
                scope = discussionComment.scope.toString(),
                posterId = discussionComment.posterId,
                startLine = discussionComment.startLine,
                endLine = discussionComment.endLine,
                content = discussionComment.content,
                reactions = reactions,
                createdUnix = discussionComment.createdUnix,
                updatedUnix = discussionComment.updatedUnix,
            )
        }
    }
}
