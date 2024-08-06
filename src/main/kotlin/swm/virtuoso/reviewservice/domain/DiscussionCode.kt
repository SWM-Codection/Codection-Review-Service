package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity

data class DiscussionCode(
    val id: Long? = null,
    val discussionId: Long,
    val filePath: String,
    var startLine: Int,
    var endLine: Int
) {
    companion object {
        fun fromEntity(entity: DiscussionCodeEntity): DiscussionCode {
            return DiscussionCode(
                id = entity.id,
                discussionId = entity.discussionId,
                filePath = entity.filePath,
                startLine = entity.startLine,
                endLine = entity.endLine
            )
        }
    }
}
