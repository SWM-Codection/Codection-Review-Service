package swm.virtuoso.reviewservice.domian

data class DiscussionCode(
    val id: Long?,
    val filePath: String,
    val startLine: Int,
    val endLine: Int

)
