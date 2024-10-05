package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAssigneesRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.domain.DiscussionAssignee

@Repository
class DiscussionAssigneesPersistenceAdapter(
    private val discussionAssigneesRepository: DiscussionAssigneesRepository
) : DiscussionAssigneesPort {

    override fun insertDiscussionAssignee(discussionAssignee: DiscussionAssignee) {
        val entity = DiscussionAssigneesEntity.fromDiscussionAssignee(discussionAssignee)
        discussionAssigneesRepository.save(entity)
    }

    override fun insertDiscussionAssignees(discussionAssignees: List<DiscussionAssignee>) {
        val entities = discussionAssignees.map { assignee ->
            DiscussionAssigneesEntity.fromDiscussionAssignee(assignee)
        }
        discussionAssigneesRepository.saveAll(entities)
    }

    override fun findDiscussionAssigneesByDiscussionId(discussionId: Long): List<DiscussionAssignee> {
        return discussionAssigneesRepository.findAllByDiscussionId(discussionId)
            .map { DiscussionAssignee.fromEntity(it) }
    }

    override fun deleteDiscussionAssigneesByAssigneesIn(discussionId: Long, assignees: List<Long>) {
        discussionAssigneesRepository.deleteByDiscussionIdAndAssigneeIdIn(discussionId, assignees)
    }

    override fun findByDiscussionIdAndAssigneeId(discussionId: Long, assigneeId: Long): DiscussionAssignee? {
        val entity = discussionAssigneesRepository.findByDiscussionIdAndAssigneeId(discussionId, assigneeId)
            ?: return null
        return DiscussionAssignee.fromEntity(entity)
    }

    override fun deleteByDiscussionAssigneeById(discussionAssigneeId: Long) {
        discussionAssigneesRepository.deleteById(discussionAssigneeId)
    }

    override fun deleteAllByDiscussionId(discussionId: Long) {
        discussionAssigneesRepository.deleteAllByDiscussionId(discussionId)
    }
}
