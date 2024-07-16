package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_user")
data class DiscussionUserEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "uid")
    val uid: Long,

    @field:Column(nullable = false, name = "discussion_id")
    val discussionId: Long,

    @field:Column(name = "is_read")
    val isRead: Boolean,

    @field:Column(name = "is_mentioned")
    val isMentioned: Boolean
) : BaseTimeEntity()
