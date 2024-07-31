package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domian.Discussion

data class DiscussionListResponse (
    val totalCount: Long,
    val discussions: List<Discussion>
)