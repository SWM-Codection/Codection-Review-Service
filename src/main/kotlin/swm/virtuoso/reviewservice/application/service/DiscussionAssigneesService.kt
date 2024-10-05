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
    override fun changeAssignee(discussionId: Long, assigneeId: Long) {
        discussionPort.findDiscussionById(discussionId)
        val assignee = discussionAssigneesPort.findByDiscussionIdAndAssigneeId(discussionId, assigneeId)

        assignee?.let {
            discussionAssigneesPort.deleteByDiscussionAssigneeById(it.id!!)
        } ?: run {
            discussionAssigneesPort.insertDiscussionAssignee(
                DiscussionAssignee(id = null, assigneeId = assigneeId, discussionId = discussionId)
            )
        }
    }

    @Transactional
    override fun clearAssigneesByDiscussionId(discussionId: Long) {
        discussionAssigneesPort.deleteAllByDiscussionId(discussionId)
    }
}
