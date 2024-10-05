package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ChangeDiscussionWatchRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionWatchRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionWatchResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionWatchUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionWatchPort

@Service
class DiscussionWatchService(
    private val discussionWatchPort: DiscussionWatchPort
) : DiscussionWatchUseCase {

    override fun changeWatchStatus(changeDiscussionWatchRequest: ChangeDiscussionWatchRequest): Boolean {
        val discussionWatch = discussionWatchPort.findById(changeDiscussionWatchRequest.id!!)
        discussionWatch.changeWatchingStatus()
        discussionWatchPort.update(discussionWatch)

        return discussionWatch.isWatching
    }

    override fun createWatchStatus(changeDiscussionWatchRequest: ChangeDiscussionWatchRequest): Boolean {
        discussionWatchPort.checkWatchDuplication(
            changeDiscussionWatchRequest.userId,
            changeDiscussionWatchRequest.discussionId
        )

        discussionWatchPort.save(changeDiscussionWatchRequest.userId, changeDiscussionWatchRequest.discussionId)
        return false
    }

    override fun getDiscussionWatch(changeDiscussionWatchRequest: DiscussionWatchRequest): DiscussionWatchResponse {
        val discussionWatch = discussionWatchPort.findByUserIdAndDiscussionId(
            userId = changeDiscussionWatchRequest.userId,
            changeDiscussionWatchRequest.discussionId
        )

        return DiscussionWatchResponse(
            id = discussionWatch.id,
            isWatching = discussionWatch.isWatching
        )
    }
}
