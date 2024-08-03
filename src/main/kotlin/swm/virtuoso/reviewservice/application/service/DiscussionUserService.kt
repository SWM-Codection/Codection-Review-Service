package swm.virtuoso.reviewservice.application.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUserUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.domian.DiscussionUser

@Service
class DiscussionUserService(
    private val discussionUserPort: DiscussionUserPort,
    private val discussionPort: DiscussionPort,
    private val giteaPort: GiteaPort
) : DiscussionUserUseCase {

    private val logger = LoggerFactory.getLogger(DiscussionUserService::class.java)

    override fun markDiscussionAsMention(discussionId: Long, userId: Long) {
        discussionPort.findDiscussion(discussionId)
        giteaPort.findUserById(userId)

        val findDiscussionUserId = discussionUserPort.findDiscussionUser(userId)
        val savedUser = discussionUserPort.updateDiscussionUser(
            DiscussionUser(
                id = findDiscussionUserId?.let { it.id },
                uid = userId,
                discussionId = discussionId,
                isRead = findDiscussionUserId?.run { isRead } ?: false,
                isMentioned = true
            )
        )
        logger.info("Marked discussion user ${savedUser.id} as mention")
    }

    override fun markDiscussionAsRead(discussionId: Long, userId: Long) {
        discussionPort.findDiscussion(discussionId)
        giteaPort.findUserById(userId)

        val findDiscussionUserId = discussionUserPort.findDiscussionUser(userId)
        val savedUser = discussionUserPort.updateDiscussionUser(
            DiscussionUser(
                id = findDiscussionUserId?.let { it.id },
                uid = userId,
                discussionId = discussionId,
                isRead = findDiscussionUserId?.run { isRead } ?: false,
                isMentioned = true
            )
        )
        logger.info("Marked discussion user ${savedUser.id} as read")
    }
}
