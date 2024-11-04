package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity
import swm.virtuoso.reviewservice.domain.Discussion

@Entity
@Table(name = "discussion")
data class DiscussionEntity(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:Column(nullable = false, name = "repo_id")
    val repoId: Long,

    @field:Column(name = "idx")
    val index: Long? = null,

    @field:Column(nullable = false, name = "poster_id")
    val posterId: Long,

    @field:Column(name = "commit_hash")
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
    @ColumnDefault("0")
    val deadlineUnix: Long? = null,

    @field:Column(name = "closed_unix")
    val closedUnix: Long? = null,

    @field:Column(name = "is_locked")
    val isLocked: Boolean?
) : BaseTimeEntity() {
    fun canPinDiscussion(pinnedCount: Int, maxPin: Int): Boolean {
        if (pinnedCount >= maxPin) {
            throw IllegalStateException("pin 부여 갯수가 최대입니다.")
        }
        return true
    }

    companion object {
        fun fromDiscussion(discussion: Discussion): DiscussionEntity {
            return DiscussionEntity(
                id = discussion.id,
                repoId = discussion.repoId,
                index = discussion.index,
                posterId = discussion.posterId,
                commitHash = discussion.commitHash!!,
                name = discussion.name,
                content = discussion.content,
                isClosed = discussion.isClosed,
                numComments = 0,
                pinOrder = discussion.pinOrder,
                deadlineUnix = discussion.deadlineUnix,
                closedUnix = discussion.closedUnix,
                isLocked = false
            )
        }
    }
}
