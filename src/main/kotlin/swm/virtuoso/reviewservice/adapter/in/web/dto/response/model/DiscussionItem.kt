package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model

data class DiscussionItem (
    val id: Long,
    val name: String,
    val content: String,
    val index: Long,
    val commentCount: Int
)