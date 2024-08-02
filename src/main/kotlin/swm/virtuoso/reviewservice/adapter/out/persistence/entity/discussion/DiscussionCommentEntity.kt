package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.domain.DiscussionComment

@Entity
@Table(name = "discussion_comment")
data class DiscussionCommentEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @field:Column(name = "code_id")
    val codeId: Long? = null,

    @field:Column(nullable = false, name = "poster_id")
    val posterId: Long,

    @field:Column(name = "scope")
    val scope: CommentScopeEnum,

    @field:Column(nullable = true, name = "start_line")
    val startLine: Int? = null,

    @field:Column(nullable = true, name = "end_line")
    val endLine: Int? = null,

    @field:Column(name = "content")
    val content: String
) : BaseTimeEntity() {
    companion object {
        fun fromDiscussionComment(domain: DiscussionComment): DiscussionCommentEntity {
            return DiscussionCommentEntity(
                id = domain.id,
                discussionId = domain.discussionId,
                codeId = domain.codeId,
                posterId = domain.posterId,
                scope = domain.scope,
                startLine = domain.startLine,
                endLine = domain.endLine,
                content = domain.content
            )
        }
    }
}
