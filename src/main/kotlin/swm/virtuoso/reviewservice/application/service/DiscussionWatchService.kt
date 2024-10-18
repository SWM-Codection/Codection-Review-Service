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

    override fun getDiscussionWatch(userId: Long, discussionId: Long): DiscussionWatchResponse {
        val discussionWatch = discussionWatchPort.findByUserIdAndDiscussionId(
            userId = userId,
            discussionId = discussionId
        )

        if (discussionWatch == null) {
            return DiscussionWatchResponse(
                id = -1L,
                isWatching = false
            )
        }

        return DiscussionWatchResponse(
            id = discussionWatch.id,
            isWatching = discussionWatch.isWatching
        )

    }
}
