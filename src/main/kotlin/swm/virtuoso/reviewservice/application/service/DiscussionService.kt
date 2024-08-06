package swm.virtuoso.reviewservice.application.service

import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
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
    private val giteaPort: GiteaPort
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

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionPort.countDiscussion(repoId, isClosed)
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

        val targetCodes =
            discussionCodePort.findDiscussionCodesByDiscussionId(modifyDiscussionRequest.discussionId)

        val modifiedCodes = modifyDiscussionRequest.codes

        val deletedCodeIds: List<Long> =  targetCodes.filterNot { it in modifiedCodes}
            .mapNotNull { it.id }

        val newCodes : List<DiscussionCode> = modifiedCodes.filter { it.id == null }

        discussionCodePort.deleteDiscussionCodeAllById(deletedCodeIds)
        discussionCodePort.insertDiscussionCodes(newCodes, modifyDiscussionRequest.discussionId)

        targetDiscussion.name = modifyDiscussionRequest.name
        targetDiscussion.content = modifyDiscussionRequest.content


        return discussionPort.updateDiscussion(discussion = targetDiscussion)
    }
}
