package swm.virtuoso.reviewservice.domian

data class Discussion (
    val id: Long?,

    var name: String?,

    var content: String?,

    var repoId: Long,

    val posterId: Long,

    var commitHash: String?,
)