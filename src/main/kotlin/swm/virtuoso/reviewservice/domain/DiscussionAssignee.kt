package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity

data class DiscussionAssignee(
    val id: Long? = null,
    var assigneeId: Long,
    var discussionId: Long
) {
    companion object {
        fun fromEntity(discussionAssigneesEntity: DiscussionAssigneesEntity): DiscussionAssignee {
            return DiscussionAssignee(
                id = discussionAssigneesEntity.id,
                assigneeId = discussionAssigneesEntity.assigneeId,
                discussionId = discussionAssigneesEntity.discussionId
            )
        }
    }
}
