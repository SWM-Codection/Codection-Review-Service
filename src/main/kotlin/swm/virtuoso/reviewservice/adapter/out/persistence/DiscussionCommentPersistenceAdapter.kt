package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.common.exception.NoSuchDiscussionCommentException
import swm.virtuoso.reviewservice.domain.DiscussionComment

@Repository
class DiscussionCommentPersistenceAdapter(
    private val discussionCommentRepository: DiscussionCommentRepository
) : DiscussionCommentPort {

    override fun insertComment(discussionComment: DiscussionComment): DiscussionComment {
        val savedEntity = discussionCommentRepository.save(
            DiscussionCommentEntity.fromDiscussionComment(discussionComment)
        )

        return DiscussionComment.fromEntity(savedEntity)
    }

    override fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment> {
        return discussionCommentRepository.findAllByDiscussionId(discussionId)
            .map { DiscussionComment.fromEntity(it) }
    }

    override fun deleteCommentById(commentId: Long) {
        discussionCommentRepository.deleteById(commentId)
    }

    override fun findCommentById(commentId: Long): DiscussionComment {
        val commentEntity = discussionCommentRepository.findById(commentId).orElseThrow {
            throw NoSuchDiscussionCommentException()
        }
        return DiscussionComment.fromEntity(commentEntity)
    }

    override fun updateComment(modifiedComment: DiscussionComment) {
        val exisingComment = findCommentById(modifiedComment.discussionId)

        modifiedComment.let { comment ->
            require(exisingComment.codeId == modifiedComment.codeId) {
                "수정된 코멘트와 기존 코멘트의 코드블록 정보가 일치하지 않습니다."
            }
            require(exisingComment.discussionId == modifiedComment.discussionId) {
                "수정된 코멘트와 기존 코멘트의 디스커션 정보가 일치하지 않습니다."
            }
        }

        // TODO discussion이 존재하지 않을 경우 예외처리

        val modifiedDiscussionComment = DiscussionCommentEntity.fromDiscussionComment(modifiedComment)
        discussionCommentRepository.save(modifiedDiscussionComment)
    }
}
