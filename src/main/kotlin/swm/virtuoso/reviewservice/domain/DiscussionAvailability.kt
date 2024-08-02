package swm.virtuoso.reviewservice.domain

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest

data class DiscussionAvailability(
    var id: Long? = null,
    var repoId: Long,
    var available: Boolean
) {
    companion object {
        fun fromRequest(request: DiscussionAvailableRequest): DiscussionAvailability {
            return DiscussionAvailability(
                id = null,
                repoId = request.repoId,
                available = request.available
            )
        }
    }
}
