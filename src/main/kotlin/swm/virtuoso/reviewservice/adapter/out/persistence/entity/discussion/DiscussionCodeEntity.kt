package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.domian.DiscussionCode

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
        fun from(discussionFile: DiscussionCode, discussionId: Long): DiscussionCodeEntity {
            return DiscussionCodeEntity(
                id = null,
                discussionId = discussionId,
                filePath = discussionFile.filePath,
                startLine = discussionFile.startLine,
                endLine = discussionFile.endLine
            )
        }
    }
}
