package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domain.DiscussionComment
import swm.virtuoso.reviewservice.domain.DiscussionReaction

data class DiscussionCommentResponse(
    val id: Long,
    val posterId: Long,
    val groupId: Long?,
    val discussionId: Long,
    val filePath: String?,
    val codeId: Long?,
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
            reactions: List<DiscussionReaction>,
            filePath: String? = null,
        ): DiscussionCommentResponse {
            return DiscussionCommentResponse(
                id = discussionComment.id!!,
                scope = discussionComment.scope.toString(),
                posterId = discussionComment.posterId,
                groupId = discussionComment.groupId,
                startLine = discussionComment.startLine,
                endLine = discussionComment.endLine,
                content = discussionComment.content,
                reactions = reactions,
                createdUnix = discussionComment.createdUnix,
                updatedUnix = discussionComment.updatedUnix,
                codeId = discussionComment.codeId,
                discussionId = discussionComment.discussionId,
                filePath = filePath,
            )
        }
    }
}
