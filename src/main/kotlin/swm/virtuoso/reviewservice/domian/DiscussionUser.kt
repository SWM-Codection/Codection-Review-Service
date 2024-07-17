package swm.virtuoso.reviewservice.domian

data class DiscussionUser(
    val id: Long? = null,
    val uid: Long,
    val discussionId: Long,
    val isRead: Boolean,
    val isMentioned: Boolean
)