package swm.virtuoso.reviewservice.domian

data class DiscussionAvailability(
    var id: Long? = null,
    var repoId: Long,
    var available: Boolean
)