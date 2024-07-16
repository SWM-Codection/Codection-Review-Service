package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCommentResponse
import swm.virtuoso.reviewservice.domian.ExtractedLine

data class CodeBlock(
    val codeId: Long,
    val lines: List<ExtractedLine>,
    val comments: List<DiscussionCommentResponse>
)
