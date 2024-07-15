package swm.virtuoso.reviewservice.adapter.out.persistence.entity

import org.hibernate.annotations.ColumnDefault
import jakarta.persistence.*

@Entity
@Table(name = "user")
data class UserEntity (
    @Id
    @ColumnDefault("nextval('user_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "lower_name", nullable = false)
    val lowerName: String,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "full_name")
    val fullName: String? = null,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "keep_email_private")
    val keepEmailPrivate: Boolean? = null,

    @ColumnDefault("'enabled'")
    @Column(name = "email_notifications_preference", nullable = false, length = 20)
    val emailNotificationsPreference: String = "enabled",

    @Column(name = "passwd", nullable = false)
    val passwd: String,

    @ColumnDefault("'argon2'")
    @Column(name = "passwd_hash_algo", nullable = false)
    val passwdHashAlgo: String = "argon2",

    @ColumnDefault("false")
    @Column(name = "must_change_password", nullable = false)
    val mustChangePassword: Boolean = false,

    @Column(name = "login_type")
    val loginType: Int? = null,

    @ColumnDefault("0")
    @Column(name = "login_source", nullable = false)
    val loginSource: Long = 0L,

    @Column(name = "login_name")
    val loginName: String? = null,

    @Column(name = "type")
    val type: Int? = null,

    @Column(name = "location")
    val location: String? = null,

    @Column(name = "website")
    val website: String? = null,

    @Column(name = "rands", length = 32)
    val rands: String? = null,

    @Column(name = "salt", length = 32)
    val salt: String? = null,

    @Column(name = "language", length = 5)
    val language: String? = null,

    @Column(name = "description")
    val description: String? = null,

    @Column(name = "created_unix")
    val createdUnix: Long? = null,

    @Column(name = "updated_unix")
    val updatedUnix: Long? = null,

    @Column(name = "last_login_unix")
    val lastLoginUnix: Long? = null,

    @Column(name = "last_repo_visibility")
    val lastRepoVisibility: Boolean? = null,

    @ColumnDefault("'-1'::integer")
    @Column(name = "max_repo_creation", nullable = false)
    val maxRepoCreation: Int = -1,

    @Column(name = "is_active")
    val isActive: Boolean? = null,

    @Column(name = "is_admin")
    val isAdmin: Boolean? = null,

    @ColumnDefault("false")
    @Column(name = "is_restricted", nullable = false)
    val isRestricted: Boolean = false,

    @Column(name = "allow_git_hook")
    val allowGitHook: Boolean? = null,

    @Column(name = "allow_import_local")
    val allowImportLocal: Boolean? = null,

    @ColumnDefault("true")
    @Column(name = "allow_create_organization")
    val allowCreateOrganization: Boolean = true,

    @ColumnDefault("false")
    @Column(name = "prohibit_login", nullable = false)
    val prohibitLogin: Boolean = false,

    @Column(name = "avatar", nullable = false, length = 2048)
    val avatar: String,

    @Column(name = "avatar_email", nullable = false)
    val avatarEmail: String,

    @Column(name = "use_custom_avatar")
    val useCustomAvatar: Boolean? = null,

    @Column(name = "num_followers")
    val numFollowers: Int? = null,

    @ColumnDefault("0")
    @Column(name = "num_following", nullable = false)
    val numFollowing: Int = 0,

    @Column(name = "num_stars")
    val numStars: Int? = null,

    @Column(name = "num_repos")
    val numRepos: Int? = null,

    @Column(name = "num_teams")
    val numTeams: Int? = null,

    @Column(name = "num_members")
    val numMembers: Int? = null,

    @ColumnDefault("0")
    @Column(name = "visibility", nullable = false)
    val visibility: Int = 0,

    @ColumnDefault("false")
    @Column(name = "repo_admin_change_team_access", nullable = false)
    val repoAdminChangeTeamAccess: Boolean = false,

    @ColumnDefault("''")
    @Column(name = "diff_view_style", nullable = false)
    val diffViewStyle: String = "",

    @ColumnDefault("''")
    @Column(name = "theme", nullable = false)
    val theme: String = "",

    @ColumnDefault("false")
    @Column(name = "keep_activity_private", nullable = false)
    val keepActivityPrivate: Boolean = false
)
