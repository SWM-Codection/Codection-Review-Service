package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_watch")
data class DiscussionWatchEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(name = "user_id", nullable = false)
    val userId: Long,

    @field:Column(name = "discussion_id", nullable = false)
    val discussionId: Long,

    @field:Column(name = "is_watching", nullable = false)
    val isWatching: Boolean = false
) : BaseTimeEntity()
