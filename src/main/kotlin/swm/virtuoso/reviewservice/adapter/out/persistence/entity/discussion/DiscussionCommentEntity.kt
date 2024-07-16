package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum

@Entity
@Table(name = "discussion_comment")
data class DiscussionCommentEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @field:Column(nullable = false, name = "code_id")
    val codeId: Long,

    @field:Column(nullable = false, name = "poster_id")
    val posterId: Long,

    @field:Column(name = "scope")
    val scope: CommentScopeEnum,

    @field:Column(name = "start_line")
    val startLine: Int?,

    @field:Column(name = "end_line")
    val endLine: Int?,

    @field:Column(name = "content")
    val content: String
) : BaseTimeEntity()
