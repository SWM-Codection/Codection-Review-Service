package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.domain.DiscussionComment

interface DiscussionCommentUseCase {
    fun createComment(discussionComment: DiscussionComment): DiscussionComment
    fun deleteComment(commentId: Long)
    fun modifyComment(discussionComment: DiscussionComment)
    fun getCommentById(commentId: Long): DiscussionComment
}
