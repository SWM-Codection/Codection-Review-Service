package swm.virtuoso.reviewservice.application.service

import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode

@Service
class DiscussionService(
    private val discussionPort: DiscussionPort,
    private val discussionUserPort: DiscussionUserPort,
    private val discussionCodePort: DiscussionCodePort,
    private val discussionAssigneesPort: DiscussionAssigneesPort,
    private val giteaPort: GiteaPort,
) : DiscussionUseCase {

    private val logger = LoggerFactory.getLogger(DiscussionService::class.java)

    @Transactional
    override fun createDiscussion(
        discussion: Discussion,
        codes: List<DiscussionCode>,
        assignees: List<Long>?
    ): Discussion {
        val savedDiscussion = discussionPort.insertDiscussion(discussion = discussion)
        discussionCodePort.insertDiscussionCodes(codes, savedDiscussion.id!!)
        logger.info("Saved discussion with ID: {}", savedDiscussion.id)

        val savedDiscussionUser = discussionUserPort.insertDiscussionUser(savedDiscussion.posterId, savedDiscussion.id)
        logger.info("Saved discussionUser with ID: {}", savedDiscussionUser.id)

        val discussionAssignees: List<DiscussionAssignee> = assignees?.map { assigneeId ->
            DiscussionAssignee(assigneeId = assigneeId, discussionId = savedDiscussion.id)
        }.orEmpty()
        discussionAssigneesPort.insertDiscussionAssignees(discussionAssignees)

        return savedDiscussion
    }

    override fun getDiscussionAssignees(discussionId: Long): List<DiscussionAssignee> {
        return discussionAssigneesPort.findDiscussionAssigneesByDiscussionId(discussionId)
    }

    override fun getDiscussion(discussionId: Long): Discussion {
        return discussionPort.findDiscussionById(discussionId)
    }

    override fun countDiscussion(repoId: Long): Pair<Int, Int> {
        return Pair(
            discussionPort.countDiscussion(repoId, false),
            discussionPort.countDiscussion(repoId, true)
        )
    }

    override fun getDiscussions(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion> {
        giteaPort.findRepositoryById(repoId)
        return discussionPort.findDiscussions(repoId, isClosed, pageable)
    }

    // TODO modify 하는 유저와 discussion 작성 유저가 동일인인지 체크
    // TODO 이미 comment가 달린 discussion code 부분은 삭제에서 제외하도록 함
    @Transactional
    override fun modifyDiscussion(modifyDiscussionRequest: ModifyDiscussionRequest): Discussion {
        val targetDiscussion = discussionPort.findDiscussionById(modifyDiscussionRequest.discussionId)

        val deletedCodeIds: List<Long> = modifyDiscussionRequest.deletedCodesIds
        val newCodes: List<DiscussionCode> = modifyDiscussionRequest.newCodes

        discussionCodePort.deleteDiscussionCodeAllById(deletedCodeIds)
        discussionCodePort.insertDiscussionCodes(newCodes, modifyDiscussionRequest.discussionId)

        targetDiscussion.name = modifyDiscussionRequest.name
        targetDiscussion.content = modifyDiscussionRequest.content

        return discussionPort.updateDiscussion(discussion = targetDiscussion)
    }

    @Transactional
    override fun setDiscussionIsClosed(discussionId: Long, isClosed: Boolean) {
        val targetDiscussion = discussionPort.findDiscussionById(discussionId)

        targetDiscussion.isClosed = isClosed
        discussionPort.updateDiscussion(targetDiscussion)
        logger.info("Updated discussion: {}", targetDiscussion)
    }

    @Transactional
    override fun modifyDiscussionDeadline(discussionId: Long, deadline: Long) {
        val targetDiscussion = discussionPort.findDiscussionById(discussionId)

        targetDiscussion.deadlineUnix = deadline
        discussionPort.updateDiscussion(targetDiscussion)
        logger.info("Updated discussion: {}", targetDiscussion.id)
    }

    override fun isNewPinAllowed(repoId: Long): Boolean {
        return discussionPort.isNewPinAllowed(repoId)
    }

    @Transactional
    override fun pinOrUnpinDiscussion(discussionId: Long) {
        val targetDiscussion = discussionPort.findDiscussionById(discussionId)
        val changedDiscussion: Discussion
        logger.info("Before updated discussion pinOrder: {}", targetDiscussion.pinOrder)

        if(targetDiscussion.pinOrder!! == 0) {
            changedDiscussion = discussionPort.pinDiscussion(targetDiscussion)
        } else {
            changedDiscussion = discussionPort.unpinDiscussion(targetDiscussion)
        }
        logger.info("After updated discussion pinOrder: {}", changedDiscussion.pinOrder)
    }

    @Transactional
    override fun unpinDiscussion(discussionId: Long) {
        val targetDiscussion = discussionPort.findDiscussionById(discussionId)
        val changedDiscussion: Discussion
        logger.info("Before updated discussion pinOrder: {}", targetDiscussion.pinOrder)

        if(targetDiscussion.pinOrder!! == 0) {
            throw IllegalStateException("디스커션 $discussionId 은 unpin 상태 입니다.")
        } else {
            changedDiscussion = discussionPort.unpinDiscussion(targetDiscussion)
        }
        logger.info("After updated discussion pinOrder: {}", changedDiscussion.pinOrder)
    }

    override fun getPinnedDiscussions(repoId: Long): List<Discussion> {
        return discussionPort.findPinnedDiscussions(repoId)
    }

    @Transactional
    override fun moveDiscussionPin(discussionId: Long, newPinOrder: Int) {
        if (newPinOrder < 1) {
            throw IllegalStateException("새로운 pinOrder는 0이 될 수 없습니다.")
        }
        val targetDiscussion = discussionPort.findDiscussionById(discussionId)

        discussionPort.decreasePinOrderAfterTarget(targetDiscussion)
        val newDiscussion = targetDiscussion.copy(pinOrder = newPinOrder)
        discussionPort.increasePinOrderAfterTarget(newDiscussion)
        discussionPort.updateDiscussion(newDiscussion)
    }
}
