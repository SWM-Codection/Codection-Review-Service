package swm.virtuoso.reviewservice.domian

import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum

data class DiscussionComment (
    val id: Long? = null,
    val discussionId: Long,
    val codeId: Long? = null,
    val posterId: Long,
    val scope: CommentScopeEnum,
    var startLine: Int?,
    var endLine: Int?,
    var content: String
)