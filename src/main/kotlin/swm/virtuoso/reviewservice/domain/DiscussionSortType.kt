package swm.virtuoso.reviewservice.domain

import org.springframework.data.domain.Sort

enum class DiscussionSortType(private val raw: String, private val sortDirection: Sort.Direction, private val properties: String) {
    LATEST("latest", Sort.Direction.DESC, "createdUnix"),
    OLDEST("oldest", Sort.Direction.ASC, "createdUnix"),
    RECENT_UPDATE("recentupdate", Sort.Direction.DESC, "updatedUnix"),
    LEAST_UPDATE("leastupdate", Sort.Direction.ASC, "updatedUnix"),
    MOST_COMMENT("mostcomment", Sort.Direction.DESC, "numComments"),
    LEAST_COMMENT("leastcomment", Sort.Direction.ASC, "numComments")
    // XXX: I can use Deadline unix, but it seemed to be inappropriate
    //    NEAR_DUE_DATE("nearduedate", Sort.Direction.DESC, "deadlineUnix"),
    //    FAR_DUE_DATE("farduedate", Sort.Direction.ASC, "deadlineUnix"),
    ;

    companion object {
        fun fromSortString(str: String): DiscussionSortType {
            return entries.firstOrNull { it.raw == str } ?: LATEST
        }
    }

    fun toSort(): Sort {
        return Sort.by(sortDirection, properties)
    }
}
