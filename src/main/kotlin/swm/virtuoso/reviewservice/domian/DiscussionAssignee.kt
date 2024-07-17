package swm.virtuoso.reviewservice.domian

data class DiscussionAssignee(
    val id: Long? = null,
    var assigneeId: Long,
    var discussionId: Long
)