package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "discussion")
data class Discussion (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, name = "repo_id")
    val repoId: Long,

    @Column(nullable = false, name = "index")
    val index: Long? = null,

    @Column(nullable = false, name = "poster_id")
    val posterId: Long,

    @Column(nullable = false, name = "commit_hash")
    val commitHash: String,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "content")
    val content: String? = null,

    @Column(name = "is_closed")
    val isClosed: Boolean? = null,

    @Column(name = "num_comments")
    @ColumnDefault("0")
    val numComments: Int? = null,

    @Column(name = "pin_order")
    @ColumnDefault("0")
    val pinOrder: Int? = null,

    @Column(name = "deadline_unix")
    val deadlineUnix: Long? = null,

    @Column(name = "closed_unix")
    val closedUnix: Long? = null,

    @Column(name = "is_locked")
    val isLocked: Boolean?
): BaseTimeEntity() {
}