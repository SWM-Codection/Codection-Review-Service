package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.IssueIndexEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.domain.Discussion

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionIndexRepository: DiscussionIndexRepository
) : DiscussionPort {

    @Value("\${max-pin}")
    private val maxPin: Int = 3

    private fun getNextIndex(repoId: Long): Long {
        return discussionIndexRepository.findById(repoId)
            .map { it.maxIndex + 1 }
            .orElse(1)
    }

    override fun insertDiscussion(discussion: Discussion): Discussion {
        discussion.index = getNextIndex(discussion.repoId)
        val newDiscussion = discussionRepository.save(DiscussionEntity.fromDiscussion(discussion))

        discussionIndexRepository.save(
            IssueIndexEntity(
                groupId = newDiscussion.repoId,
                maxIndex = newDiscussion.index!!
            )
        )
        return Discussion.fromEntity(newDiscussion)
    }

    override fun updateDiscussion(discussion: Discussion): Discussion {
        val updatedDiscussion = discussionRepository.save(DiscussionEntity.fromDiscussion(discussion))

        return Discussion.fromEntity(updatedDiscussion)
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionRepository.countByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussions(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion> {
        return discussionRepository.findAllByRepoIdAndIsClosed(repoId, isClosed, pageable)
            .map { Discussion.fromEntity(it) }
    }

    override fun findDiscussionById(discussionId: Long): Discussion {
        val discussionEntity = discussionRepository.findByIdOrNull(discussionId)
            ?: throw NoSuchElementException("디스커션 정보를 찾을 수 없습니다.")

        return Discussion.fromEntity(discussionEntity)
    }

    override fun isNewPinAllowed(repoId: Long): Boolean {
        return discussionRepository.countPinnedDiscussions(repoId) < maxPin
    }

    override fun pinDiscussion(discussion: Discussion): Discussion {
        val discussionEntity = DiscussionEntity.fromDiscussion(discussion)
        val pinnedCount = discussionRepository.countPinnedDiscussions(discussion.repoId)

        // 이미 고정된 디스커션이 maxPin보다 많으면 예외 발생
        if (pinnedCount >= maxPin) {
            throw IllegalStateException("pin 부여 갯수가 최대입니다.")
        }

        val updatedDiscussion = discussionEntity.copy(pinOrder = discussionEntity.pinOrder!!.plus(1))
        return Discussion.fromEntity(discussionRepository.save(updatedDiscussion))
    }

    override fun unpinDiscussion(discussion: Discussion): Discussion {
        val discussionEntity = DiscussionEntity.fromDiscussion(discussion)

        // 같은 repoId에서 pinOrder가 더 큰 모든 디스커션의 pinOrder를 하나씩 줄임
        val pinnedDiscussions = discussionRepository.findByRepoIdAndPinOrderGreaterThan(discussion.repoId, discussion.pinOrder!!)

        pinnedDiscussions.forEach { entity ->
            val updatedEntity = entity.copy(pinOrder = entity.pinOrder?.minus(1))
            discussionRepository.save(updatedEntity)
        }

        // 인자로 받은 discussion의 pinOrder를 0으로 설정하고 저장
        val unpinnedDiscussion = discussionEntity.copy(pinOrder = 0)
        return Discussion.fromEntity(discussionRepository.save(unpinnedDiscussion))
    }

    override fun findPinnedDiscussions(repoId: Long): List<Discussion> {
        val pinnedDiscussionEntities = discussionRepository.findByRepoIdAndPinOrderGreaterThan(repoId, 0)
        val pinnedDiscussions: List<Discussion> = pinnedDiscussionEntities.map { entity ->
            Discussion.fromEntity(entity)
        }
        return pinnedDiscussions
    }
}
