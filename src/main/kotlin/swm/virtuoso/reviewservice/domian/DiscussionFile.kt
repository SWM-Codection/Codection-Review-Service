package swm.virtuoso.reviewservice.domian

data class DiscussionFile(
    val filePath: String,
    val startLine: Int,
    val endLine: Int
)
