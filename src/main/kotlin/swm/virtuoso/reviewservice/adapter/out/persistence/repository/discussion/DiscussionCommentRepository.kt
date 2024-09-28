package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity

interface DiscussionCommentRepository : JpaRepository<DiscussionCommentEntity, Long> {
    fun findAllByDiscussionId(discussionId: Long): List<DiscussionCommentEntity>
    fun findAllByCodeId(codeId: Long): List<DiscussionCommentEntity>
}
