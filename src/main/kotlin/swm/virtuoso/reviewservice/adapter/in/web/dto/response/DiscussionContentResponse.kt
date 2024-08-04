package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.FileContent
import swm.virtuoso.reviewservice.domain.DiscussionReaction

data class DiscussionContentResponse(
    val discussionId: Long,
    val contents: List<FileContent>,
    val globalComments: List<DiscussionCommentResponse>,
    val globalReactions: List<DiscussionReaction>
)
