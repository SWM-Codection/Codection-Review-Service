package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import java.time.LocalDate
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

data class Discussion(
    val id: Long?,

    var name: String?,

    var content: String?,

    var repoId: Long,

    val posterId: Long,

    var commitHash: String? = null,

    var index: Long? = null,

    var isClosed: Boolean = false,

    var deadlineUnix: Long? = null

    var createdUnix: Long? = null,

    var updatedUnix: Long? = null
) {
    companion object {
        fun fromPostRequest(request: PostDiscussionRequest): Discussion {
            return Discussion(
                id = null,
                name = request.name,
                content = request.content,
                repoId = request.repoId,
                posterId = request.posterId,
                commitHash = null,
                isClosed = false,
                index = null,
                deadlineUnix = request.deadline?.let { convertToEpoch(it) }
            )
        }

        fun fromEntity(entity: DiscussionEntity): Discussion {
            return Discussion(
                id = entity.id,
                name = entity.name,
                content = entity.content,
                repoId = entity.repoId,
                posterId = entity.posterId,
                commitHash = entity.commitHash,
                index = entity.index,
                isClosed = entity.isClosed,
                deadlineUnix = entity.deadlineUnix,
                createdUnix = entity.createdUnix,
                updatedUnix = entity.updatedUnix
            )
        }

        private fun convertToEpoch(dateString: String): Long {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val localDate = LocalDate.parse(dateString, formatter)
            return localDate.atStartOfDay(ZoneOffset.UTC).toEpochSecond()
        }
    }
}
