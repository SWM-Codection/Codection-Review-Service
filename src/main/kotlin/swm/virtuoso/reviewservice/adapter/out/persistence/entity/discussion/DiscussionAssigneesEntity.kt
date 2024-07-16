package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*

@Entity
@Table(name = "discussion_assignees")
data class DiscussionAssigneesEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @field:Column(name = "id", nullable = false)
    val id: Long? = null,

    @field:Column(name = "assignee_id")
    val assigneeId: Long,

    @field:Column(name = "issue_id")
    val discussionId: Long
)