package swm.virtuoso.reviewservice.domian

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAvailableEntity

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