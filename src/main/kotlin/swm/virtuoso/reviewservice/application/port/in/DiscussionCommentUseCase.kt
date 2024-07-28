package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.domian.DiscussionComment

public interface DiscussionCommentUseCase {
    fun createComment(discussionComment: DiscussionComment): DiscussionComment
}
