package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_user")
data class DiscussionUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "uid")
    val uid: Long,

    @Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @Column(name = "is_read")
    val isRead: Boolean,

    @Column(name = "is_mentioned")
    val isMentioned: Boolean
): BaseTimeEntity()