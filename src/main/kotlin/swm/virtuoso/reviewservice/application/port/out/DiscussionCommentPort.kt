package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionComment

public interface DiscussionCommentPort {
    fun insertComment(discussionComment: DiscussionComment): DiscussionComment
    fun findCommentById(commentId: Long): DiscussionComment
    fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment>
    fun deleteCommentById(commentId: Long)
    fun updateComment(discussionComment: DiscussionComment)
}
