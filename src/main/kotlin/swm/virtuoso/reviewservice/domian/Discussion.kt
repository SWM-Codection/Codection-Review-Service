package swm.virtuoso.reviewservice.domian

class Discussion(
    val id: Long?,

    var name: String?,

    var content: String?,

    var repoId: Long,

    val posterId: Long,

    val commitHash: String?,

    var codes: List<DiscussionCode>
) {

    fun calculateDeletedCodes(modifiedDiscussionCodes: List<DiscussionCode>): List<DiscussionCode> {
        return codes.filterNot { it in modifiedDiscussionCodes }
    }
}
