package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum

data class DiscussionComment(
    val id: Long? = null,
    val discussionId: Long,
    val codeId: Long? = null,
    var groupId: Long? = null,
    val posterId: Long,
    val scope: CommentScopeEnum,
    var startLine: Int? = null,
    var endLine: Int? = null,
    var content: String,
    var createdUnix: Long? = null,
    val updatedUnix: Long? = null
) {
    companion object {
        fun fromPostRequest(request: PostCommentRequest): DiscussionComment {
            return DiscussionComment(
                id = null,
                discussionId = request.discussionId,
                groupId = request.groupId,
                codeId = request.codeId,
                posterId = request.posterId,
                scope = request.scope,
                startLine = request.startLine,
                endLine = request.endLine,
                content = request.content,
            )
        }

        fun fromEntity(entity: DiscussionCommentEntity): DiscussionComment {
            return DiscussionComment(
                id = entity.id,
                discussionId = entity.discussionId,
                codeId = entity.codeId,
                posterId = entity.posterId,
                groupId = entity.groupId,
                scope = entity.scope,
                startLine = entity.startLine,
                endLine = entity.endLine,
                content = entity.content,
                createdUnix = entity.createdUnix,
                updatedUnix = entity.updatedUnix,

            )
        }

        fun fromModifyRequest(request: ModifyCommentRequest): DiscussionComment {
            return DiscussionComment(
                id = request.discussionCommentId,
                discussionId = request.discussionId,
                codeId = request.codeId,
                posterId = request.posterId,
                scope = request.scope,
                startLine = request.startLine,
                endLine = request.endLine,
                content = request.content
            )
        }
    }
}
