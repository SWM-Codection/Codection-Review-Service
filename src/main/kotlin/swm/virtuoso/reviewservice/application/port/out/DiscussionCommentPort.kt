package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity

public interface DiscussionCommentPort {
    fun saveComment(postCommentRequest: PostCommentRequest): DiscussionCommentEntity
    fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionCommentEntity>
}
