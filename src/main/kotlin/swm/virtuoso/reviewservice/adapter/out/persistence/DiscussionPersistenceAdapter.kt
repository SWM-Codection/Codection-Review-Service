package swm.virtuoso.reviewservice.adapter.out.persistence

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
        discussion.index = getNextIndex(discussion.repoId)
        val updatedDiscussion = discussionRepository.save(DiscussionEntity.fromDiscussion(discussion))

        discussionIndexRepository.save(
            IssueIndexEntity(
                groupId = updatedDiscussion.repoId,
                maxIndex = updatedDiscussion.index!!
            )
        )
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
}
