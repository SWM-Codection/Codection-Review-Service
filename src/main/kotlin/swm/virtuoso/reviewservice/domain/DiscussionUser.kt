package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity

data class DiscussionUser(
    val id: Long? = null,
    val userId: Long,
    val discussionId: Long,
    val isRead: Boolean,
    val isMentioned: Boolean
) {
    companion object {
        fun fromEntity(discussionUserEntity: DiscussionUserEntity): DiscussionUser {
            return DiscussionUser(
                id = discussionUserEntity.id,
                userId = discussionUserEntity.userId,
                discussionId = discussionUserEntity.discussionId,
                isRead = discussionUserEntity.isRead,
                isMentioned = discussionUserEntity.isMentioned
            )
        }
    }
}
