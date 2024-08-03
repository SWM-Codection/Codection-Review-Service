package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domian.DiscussionComment

public interface DiscussionCommentPort {
    fun insertComment(discussionComment: DiscussionComment): DiscussionComment
    fun findComment(commentId: Long): DiscussionComment
    fun findCommentListByDiscussionId(discussionId: Long): List<DiscussionComment>
}
