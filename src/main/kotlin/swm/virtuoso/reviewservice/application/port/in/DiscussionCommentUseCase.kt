package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.domain.DiscussionComment

public interface DiscussionCommentUseCase {
    fun createComment(discussionComment: DiscussionComment): DiscussionComment
    fun deleteComment(commentId : Long)
    fun modifyComment(discussionComment: DiscussionComment)

}
