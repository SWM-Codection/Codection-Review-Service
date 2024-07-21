package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domian.DiscussionComment

public interface DiscussionCommentPort {
    fun saveComment(discussionComment: DiscussionComment): DiscussionComment
    fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment>
}
