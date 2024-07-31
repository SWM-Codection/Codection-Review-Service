package swm.virtuoso.reviewservice.domain

data class DiscussionAssignee(
    val id: Long? = null,
    var assigneeId: Long,
    var discussionId: Long
)
