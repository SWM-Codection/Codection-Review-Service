package swm.virtuoso.reviewservice.domain

data class DiscussionWatch(
    val id: Long,
    val userId: Long,
    val discussionId: Long,
    var isWatching: Boolean
) {
    fun changeWatchingStatus() {
        isWatching = !isWatching
    }
}
