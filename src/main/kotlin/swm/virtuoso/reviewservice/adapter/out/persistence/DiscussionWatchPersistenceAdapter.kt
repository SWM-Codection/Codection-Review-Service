package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionWatchEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionWatchRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionWatchPort
import swm.virtuoso.reviewservice.domain.DiscussionWatch

@Repository
class DiscussionWatchPersistenceAdapter(
    private val discussionWatchRepository: DiscussionWatchRepository
) : DiscussionWatchPort {

    override fun findById(id: Long): DiscussionWatch {
        val entity = discussionWatchRepository.findById(id).orElseThrow {
            throw IllegalArgumentException("No discussion watch found for id $id")
        }

        return DiscussionWatch(
            id = entity.id!!,
            userId = entity.userId,
            discussionId = entity.discussionId,
            isWatching = entity.isWatching
        )
    }

    override fun findByUserIdAndDiscussionId(userId: Long, discussionId: Long): DiscussionWatch {
        val search = discussionWatchRepository.findByUserIdAndDiscussionId(userId, discussionId)

        if (search.isEmpty) {
            return DiscussionWatch(
                id = null,
                userId = userId,
                discussionId = discussionId,
                isWatching = false
            )
        }

        val entity = search.get()

        return DiscussionWatch(
            id = entity.id!!,
            userId = entity.userId,
            discussionId = entity.discussionId,
            isWatching = entity.isWatching
        )
    }

    override fun checkWatchDuplication(userId: Long, discussionId: Long) {
        val result = discussionWatchRepository.existsByUserIdAndDiscussionId(discussionId, userId)
        //
        if (result == true) {
            // TODO Global ExceptionHandler
            throw IllegalArgumentException("watch is duplicated")
        }
    }

    override fun save(userId: Long, discussionId: Long) {
        discussionWatchRepository.save(
            DiscussionWatchEntity(
                id = null,
                discussionId = discussionId,
                userId = userId,
                isWatching = true
            )
        )
    }

    override fun update(discussionWatch: DiscussionWatch) {
        discussionWatchRepository.save(
            DiscussionWatchEntity(
                id = discussionWatch.discussionId,
                userId = discussionWatch.userId,
                discussionId = discussionWatch.discussionId,
                isWatching = discussionWatch.isWatching
            )
        )
    }
}
