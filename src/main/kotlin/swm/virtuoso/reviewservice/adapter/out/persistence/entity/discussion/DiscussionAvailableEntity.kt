package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.domain.DiscussionAvailability

@Entity
@Table(name = "discussion_available")
data class DiscussionAvailableEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "repo_id")
    val repoId: Long,

    @field:Column(name = "is_discussion_availabled")
    val available: Boolean
) : BaseTimeEntity() {
    companion object {
        fun fromDiscussionAvailability(discussionAvailability: DiscussionAvailability): DiscussionAvailableEntity {
            return DiscussionAvailableEntity(
                id = discussionAvailability.id,
                repoId = discussionAvailability.repoId,
                available = discussionAvailability.available
            )
        }
    }
}
