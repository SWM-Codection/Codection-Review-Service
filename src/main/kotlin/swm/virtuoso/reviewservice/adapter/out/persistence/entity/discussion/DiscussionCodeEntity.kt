package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.domain.DiscussionCode

@Entity
@Table(name = "discussion_code")
data class DiscussionCodeEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @field:Column(name = "file_url")
    val filePath: String,

    @field:Column(name = "start_line")
    val startLine: Int,

    @field:Column(name = "end_line")
    val endLine: Int
) : BaseTimeEntity() {
    companion object {
        fun fromDiscussionCode(discussionCode: DiscussionCode, discussionId: Long): DiscussionCodeEntity {
            return DiscussionCodeEntity(
                id = null,
                discussionId = discussionId,
                filePath = discussionCode.filePath,
                startLine = discussionCode.startLine,
                endLine = discussionCode.endLine
            )
        }
    }
}
