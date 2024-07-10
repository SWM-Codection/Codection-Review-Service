package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion_available")
data class DiscussionAvailable (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "repo_id")
    val repoId: Long,

    @Column(name = "is_discussion_enabled")
    val isDiscussionEnabled: Boolean
): BaseTimeEntity()