package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionAssigneesUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.domain.DiscussionAssignee

@Service
class DiscussionAssigneesService(
    private val discussionAssigneesPort: DiscussionAssigneesPort,
    private val discussionPort: DiscussionPort
) : DiscussionAssigneesUseCase {

    @Transactional
    override fun modifyAssignees(discussionId: Long, assignees: List<Long>) {
        discussionPort.findDiscussionById(discussionId)

        val prevAssignees = discussionAssigneesPort.findDiscussionAssigneesByDiscussionId(discussionId)
        val prevAssigneeIds = prevAssignees.map { it.assigneeId }

        val toRemove = prevAssigneeIds.filterNot { it in assignees }
        discussionAssigneesPort.deleteDiscussionAssigneesByAssigneesIn(discussionId, toRemove)

        val toAdd = assignees.filterNot { it in prevAssigneeIds }
        val newAssignees = toAdd.map { assigneeId ->
            DiscussionAssignee(discussionId = discussionId, assigneeId = assigneeId)
        }

        discussionAssigneesPort.insertDiscussionAssignees(newAssignees)
    }
}
