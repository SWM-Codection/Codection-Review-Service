package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionAssigneesUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.domain.DiscussionAssignee

@Service
class DiscussionAssigneesService(
    private val discussionAssigneesPort: DiscussionAssigneesPort,
    private val discussionPort: DiscussionPort
): DiscussionAssigneesUseCase {

    override fun modifyAssignees(discussionId: Long, assignees: List<Long>) {
        discussionPort.findDiscussionById(discussionId)

        val prevAssignees = discussionAssigneesPort.findDiscussionAssigneesByDiscussionId(discussionId)
        val prevAssigneeIds = prevAssignees.map { it.assigneeId }

        val toRemove = prevAssigneeIds.filter { it !in assignees }
        discussionAssigneesPort.deleteDiscussionAssigneesById(toRemove)

        val toAdd = assignees.filter { it !in prevAssigneeIds }
        val newAssignees = toAdd.map { assigneeId ->
            DiscussionAssignee(discussionId = discussionId, assigneeId = assigneeId)
        }

        discussionAssigneesPort.insertDiscussionAssignees(newAssignees)
    }
}