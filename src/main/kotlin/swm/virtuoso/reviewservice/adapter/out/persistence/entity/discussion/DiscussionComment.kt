package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_comment")
data class DiscussionComment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @Column(nullable = false, name = "file_id")
    val fileId: Long,

    @Column(name = "scope")
    val scope: String,

    @Column(name = "start_line")
    val startLine: Long,

    @Column(name = "end_line")
    val endLine: Long,

    @Column(name = "content")
    val content: String
): BaseTimeEntity()