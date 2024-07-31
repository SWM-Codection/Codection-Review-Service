package swm.virtuoso.reviewservice.domain

data class DiscussionReaction(
    val id: Long? = null,
    val discussionId: Long,
    val commentId: Long,
    val uid: Long,
    val type: String
)
