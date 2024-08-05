package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

data class DiscussionResponse(
    val id: Long,
    val name: String? = null,
    val content: String? = null,
    val repoId: Long,
    val posterId: Long,
    val commitHash: String,
    val isClosed: Boolean,
    val deadline: String?,
    val assignees: List<Long>
) {
    companion object {
        fun fromDiscussion(discussion: Discussion, assignees: List<DiscussionAssignee>): DiscussionResponse {
            val assigneeIds: List<Long> = assignees.map { it.id!! }

            return DiscussionResponse(
                id = discussion.id!!,
                name = discussion.name,
                content = discussion.content,
                repoId = discussion.repoId,
                posterId = discussion.posterId,
                commitHash = discussion.commitHash!!,
                isClosed = discussion.isClosed,
                deadline = discussion.deadlineUnix?.let { convertFromEpoch(it) },
                assignees = assigneeIds
            )
        }

        private fun convertFromEpoch(epochTime: Long): String {
            val dateTime = LocalDateTime.ofEpochSecond(epochTime, 0, ZoneOffset.UTC)
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            return dateTime.format(formatter)
        }
    }
}
