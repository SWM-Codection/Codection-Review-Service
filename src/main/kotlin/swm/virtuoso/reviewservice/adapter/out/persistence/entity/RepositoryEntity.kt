package swm.virtuoso.reviewservice.adapter.out.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "repository")
data class RepositoryEntity(
    @Id
    @ColumnDefault("nextval('repository_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "owner_id")
    val ownerId: Long? = null,

    @Column(name = "owner_name")
    val ownerName: String? = null,

    @Column(name = "lower_name", nullable = false)
    val lowerName: String,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "description", length = Int.MAX_VALUE)
    val description: String? = null,

    @Column(name = "website", length = 2048)
    val website: String? = null,

    @Column(name = "original_service_type")
    val originalServiceType: Int? = null,

    @Column(name = "original_url", length = 2048)
    val originalUrl: String? = null,

    @Column(name = "default_branch")
    val defaultBranch: String? = null,

    @Column(name = "default_wiki_branch")
    val defaultWikiBranch: String? = null,

    @Column(name = "num_watches")
    val numWatches: Int? = null,

    @Column(name = "num_stars")
    val numStars: Int? = null,

    @Column(name = "num_forks")
    val numForks: Int? = null,

    @Column(name = "num_issues")
    val numIssues: Int? = null,

    @Column(name = "num_closed_issues")
    val numClosedIssues: Int? = null,

    @Column(name = "num_pulls")
    val numPulls: Int? = null,

    @Column(name = "num_closed_pulls")
    val numClosedPulls: Int? = null,

    @ColumnDefault("0")
    @Column(name = "num_milestones", nullable = false)
    val numMilestones: Int = 0,

    @ColumnDefault("0")
    @Column(name = "num_closed_milestones", nullable = false)
    val numClosedMilestones: Int = 0,

    @ColumnDefault("0")
    @Column(name = "num_projects", nullable = false)
    val numProjects: Int = 0,

    @ColumnDefault("0")
    @Column(name = "num_closed_projects", nullable = false)
    val numClosedProjects: Int = 0,

    @ColumnDefault("0")
    @Column(name = "num_action_runs", nullable = false)
    val numActionRuns: Int = 0,

    @ColumnDefault("0")
    @Column(name = "num_closed_action_runs", nullable = false)
    val numClosedActionRuns: Int = 0,

    @Column(name = "is_private")
    val isPrivate: Boolean? = null,

    @Column(name = "is_empty")
    val isEmpty: Boolean? = null,

    @Column(name = "is_archived")
    val isArchived: Boolean? = null,

    @Column(name = "is_mirror")
    val isMirror: Boolean? = null,

    @ColumnDefault("0")
    @Column(name = "status", nullable = false)
    val status: Int = 0,

    @ColumnDefault("false")
    @Column(name = "is_fork", nullable = false)
    val isFork: Boolean = false,

    @Column(name = "fork_id")
    val forkId: Long? = null,

    @ColumnDefault("false")
    @Column(name = "is_template", nullable = false)
    val isTemplate: Boolean = false,

    @Column(name = "template_id")
    val templateId: Long? = null,

    @ColumnDefault("0")
    @Column(name = "size", nullable = false)
    val size: Long = 0L,

    @ColumnDefault("0")
    @Column(name = "git_size", nullable = false)
    val gitSize: Long = 0L,

    @ColumnDefault("0")
    @Column(name = "lfs_size", nullable = false)
    val lfsSize: Long = 0L,

    @ColumnDefault("true")
    @Column(name = "is_fsck_enabled", nullable = false)
    val isFsckEnabled: Boolean = true,

    @ColumnDefault("false")
    @Column(name = "close_issues_via_commit_in_any_branch", nullable = false)
    val closeIssuesViaCommitInAnyBranch: Boolean = false,

    @Column(name = "topics")
    @JdbcTypeCode(SqlTypes.JSON)
    val topics: Map<String, Any>? = null,

    @ColumnDefault("'sha1'")
    @Column(name = "object_format_name", nullable = false, length = 6)
    val objectFormatName: String = "sha1",

    @Column(name = "trust_model")
    val trustModel: Int? = null,

    @Column(name = "avatar", length = 64)
    val avatar: String? = null,

    @Column(name = "created_unix")
    val createdUnix: Long? = null,

    @Column(name = "updated_unix")
    val updatedUnix: Long? = null,

    @ColumnDefault("0")
    @Column(name = "archived_unix")
    val archivedUnix: Long? = null
)
