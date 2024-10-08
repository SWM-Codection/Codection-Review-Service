package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import swm.virtuoso.reviewservice.domain.DiscussionAssignee

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
) {
    companion object {
        fun fromDiscussionAssignee(discussionAssignee: DiscussionAssignee): DiscussionAssigneesEntity {
            return DiscussionAssigneesEntity(
                id = discussionAssignee.id,
                assigneeId = discussionAssignee.assigneeId,
                discussionId = discussionAssignee.discussionId
            )
        }
    }
}
