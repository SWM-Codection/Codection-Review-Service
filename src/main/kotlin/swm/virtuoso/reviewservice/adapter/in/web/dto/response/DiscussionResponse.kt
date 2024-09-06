package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee

data class DiscussionResponse(
    val id: Long,
    val name: String? = null,
    val content: String? = null,
    val repoId: Long,
    val posterId: Long,
    val commitHash: String,
    val isClosed: Boolean,
    val index: Long,
    val deadline: Long? = null,
    val assignees: List<Long>,
    val createdUnix: Long? = null,
    val updatedUnix: Long? = null
) {
    companion object {
        fun fromDiscussion(discussion: Discussion, assignees: List<DiscussionAssignee>): DiscussionResponse {
            val assigneeIds: List<Long> = assignees.map { it.assigneeId!! }

            return DiscussionResponse(
                id = discussion.id!!,
                name = discussion.name,
                content = discussion.content,
                repoId = discussion.repoId,
                posterId = discussion.posterId,
                commitHash = discussion.commitHash!!,
                isClosed = discussion.isClosed,
                index = discussion.index!!,
                deadline = discussion.deadlineUnix,
                assignees = assigneeIds,
                createdUnix = discussion.createdUnix,
                updatedUnix = discussion.updatedUnix
            )
        }
    }
}
