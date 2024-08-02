package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionComment

public interface DiscussionCommentPort {
    fun insertComment(discussionComment: DiscussionComment): DiscussionComment
    fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment>
}
