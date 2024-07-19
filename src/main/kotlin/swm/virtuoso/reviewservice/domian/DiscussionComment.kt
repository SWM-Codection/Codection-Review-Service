package swm.virtuoso.reviewservice.domian

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum

data class DiscussionComment (
    val id: Long? = null,
    val discussionId: Long,
    val codeId: Long? = null,
    val posterId: Long,
    val scope: CommentScopeEnum,
    var startLine: Int? = null,
    var endLine: Int? = null,
    var content: String
) {
    companion object {
        fun fromPostRequest(request: PostCommentRequest): DiscussionComment {
            return DiscussionComment(
                id = null,
                discussionId = request.discussionId,
                codeId = request.codeId,
                posterId = request.posterId,
                scope = request.scope,
                startLine = request.startLine,
                endLine = request.endLine,
                content = request.content
            )
        }

        fun fromEntity(entity: DiscussionCommentEntity): DiscussionComment {
            return DiscussionComment(
                id = entity.id,
                discussionId = entity.discussionId,
                codeId = entity.codeId,
                posterId = entity.posterId,
                scope = entity.scope,
                startLine = entity.startLine,
                endLine = entity.endLine,
                content = entity.content
            )
        }
    }
    }