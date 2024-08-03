package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domian.DiscussionComment
import swm.virtuoso.reviewservice.domian.DiscussionReaction

data class DiscussionCommentResponse(
    val id: Long,
    val scope: String,
    val startLine: Int?,
    val endLine: Int?,
    val content: String,
    val reactions: List<DiscussionReaction>
) {
    companion object {
        fun fromDiscussionComment(discussionComment: DiscussionComment, reactions: List<DiscussionReaction>): DiscussionCommentResponse {
            return DiscussionCommentResponse(
                id = discussionComment.id!!,
                scope = discussionComment.scope.toString(),
                startLine = discussionComment.startLine,
                endLine = discussionComment.endLine,
                content = discussionComment.content,
                reactions = reactions
            )
        }
    }
}
