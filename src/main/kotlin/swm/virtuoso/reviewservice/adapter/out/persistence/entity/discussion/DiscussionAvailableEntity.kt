package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_available")
data class DiscussionAvailableEntity (
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "repo_id")
    val repoId: Long,

    @field:Column(name = "is_discussion_enabled")
    val isDiscussionEnabled: Boolean
): BaseTimeEntity()