package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity

data class Discussion(
    val id: Long?,

    var name: String?,

    var content: String?,

    var repoId: Long,

    val posterId: Long,

    var commitHash: String? = null,

    var index: Long? = null,

    var isClosed: Boolean = false,

    var deadlineUnix: Long? = null,

    var createdUnix: Long? = null,

    var updatedUnix: Long? = null,

    val pinOrder: Int = 0,
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
                deadlineUnix = request.deadline,
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
                updatedUnix = entity.updatedUnix,
                pinOrder = entity.pinOrder!!
            )
        }
    }
}
