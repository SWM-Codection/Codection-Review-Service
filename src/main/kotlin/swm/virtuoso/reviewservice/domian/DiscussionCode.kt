package swm.virtuoso.reviewservice.domian

data class DiscussionCode(
    val id: Long?,
    val filePath: String,
    var startLine: Int,
    var endLine: Int
)
