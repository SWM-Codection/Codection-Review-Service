package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ChangeDiscussionWatchRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionWatchResponse

interface DiscussionWatchUseCase {
    fun changeWatchStatus(changeDiscussionWatchRequest: ChangeDiscussionWatchRequest): Boolean
    fun getDiscussionWatch(userId: Long, discussionId: Long): DiscussionWatchResponse
    fun createWatchStatus(changeDiscussionWatchRequest: ChangeDiscussionWatchRequest): Boolean
}
