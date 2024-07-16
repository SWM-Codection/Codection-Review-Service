package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.DiscussionItem

data class DiscussionItemListResponse(
    val repoId: Long,
    val items: List<DiscussionItem>
)
