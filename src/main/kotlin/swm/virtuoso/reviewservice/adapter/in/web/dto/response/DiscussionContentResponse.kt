package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.FileContent

data class DiscussionContentResponse (
    val discussionId: Long,
    val contents: List<FileContent>
)