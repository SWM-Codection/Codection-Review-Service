package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_file")
data class DiscussionFile (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @Column(name = "file_url")
    val fileUrl: String,

    @Column(name = "start_line")
    val startLine: Int,

    @Column(name = "end_line")
    val endLine: Int
): BaseTimeEntity()