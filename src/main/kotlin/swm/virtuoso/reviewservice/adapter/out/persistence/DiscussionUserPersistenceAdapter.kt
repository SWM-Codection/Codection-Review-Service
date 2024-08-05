package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.domain.DiscussionUser

@Repository
class DiscussionUserPersistenceAdapter(
    private val discussionUserRepository: DiscussionUserRepository
) : DiscussionUserPort {
    override fun insertDiscussionUser(userId: Long, discussionId: Long): DiscussionUser {
        return DiscussionUser.fromEntity(
            discussionUserRepository.save(
                DiscussionUserEntity(
                    id = null,
                    userId = userId,
                    discussionId = discussionId,
                    isRead = true,
                    isMentioned = false
                )
            )
        )
    }

    override fun updateDiscussionUser(discussionUser: DiscussionUser): DiscussionUser {
        return DiscussionUser.fromEntity(
            discussionUserRepository.save(
                DiscussionUserEntity(
                    id = discussionUser.id,
                    userId = discussionUser.userId,
                    discussionId = discussionUser.discussionId,
                    isRead = discussionUser.isRead,
                    isMentioned = discussionUser.isMentioned
                )
            )
        )
    }

    override fun findDiscussionUserByUserId(userId: Long): DiscussionUser? {
        return discussionUserRepository.findByUserId(userId)?.let { DiscussionUser.fromEntity(it) }
    }
}
