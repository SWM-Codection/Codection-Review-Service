package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion")
data class DiscussionEntity (
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "repo_id")
    val repoId: Long,

    @field:Column(nullable = false, name = "index")
    val index: Long? = null,

    @field:Column(nullable = false, name = "poster_id")
    val posterId: Long,

    @field:Column(nullable = false, name = "commit_hash")
    val commitHash: String? = null,

    @field:Column(name = "name")
    val name: String? = null,

    @field:Column(name = "content")
    val content: String? = null,

    @field:Column(name = "is_closed")
    val isClosed: Boolean = false,

    @field:Column(name = "num_comments")
    @ColumnDefault("0")
    val numComments: Int = 0,

    @field:Column(name = "pin_order")
    @ColumnDefault("0")
    val pinOrder: Int? = null,

    @field:Column(name = "deadline_unix")
    val deadlineUnix: Long? = null,

    @field:Column(name = "closed_unix")
    val closedUnix: Long? = null,

    @field:Column(name = "is_locked")
    val isLocked: Boolean?
): BaseTimeEntity() {
    companion object {
        fun from(createDiscussionRequest: PostDiscussionRequest, index: Long, commitHash: String?): DiscussionEntity {
            return DiscussionEntity(
                id = null,
                repoId = createDiscussionRequest.repoId,
                index = index,
                posterId = createDiscussionRequest.posterId,
                commitHash = commitHash,
                name = createDiscussionRequest.name,
                content = createDiscussionRequest.content,
                isClosed = false,
                numComments = 0,
                pinOrder = 0,
                deadlineUnix = null,
                isLocked = false
            )
        }
    }
}