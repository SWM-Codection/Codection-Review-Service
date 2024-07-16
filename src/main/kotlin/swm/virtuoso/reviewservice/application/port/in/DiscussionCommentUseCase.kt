package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity

public interface DiscussionCommentUseCase {
    fun createComment(request: PostCommentRequest): DiscussionCommentEntity
}
