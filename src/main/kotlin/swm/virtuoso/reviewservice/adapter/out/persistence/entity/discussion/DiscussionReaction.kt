package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_reaction")
data class DiscussionReaction (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @Column(nullable = false, name = "comment_id")
    val commentId: Long,

    @Column(nullable = false, name = "uid")
    val uid: Long,

    @Column(name = "type")
    val type: String,
): BaseTimeEntity()