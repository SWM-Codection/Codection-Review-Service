package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.domian.DiscussionComment

public interface DiscussionCommentPort {
    fun saveComment(postCommentRequest: PostCommentRequest): DiscussionComment
    fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment>
}
