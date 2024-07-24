package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionCode

@Service
class DiscussionService(
    private val discussionPort: DiscussionPort,
    private val discussionUserPort: DiscussionUserPort,
    private val discussionCodePort: DiscussionCodePort,
    private val giteaPort: GiteaPort
) : DiscussionUseCase {

    @Transactional
    override fun createDiscussion(
        discussion: Discussion,
        codes: List<DiscussionCode>
    ): Discussion {
        val newDiscussion = discussionPort.insertDiscussion(discussion = discussion)
        discussionCodePort.insertDiscussionCodes(codes, newDiscussion.id!!)
        discussionUserPort.insertDiscussionUser(newDiscussion.posterId, newDiscussion.id)
        return newDiscussion
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionPort.countDiscussion(repoId, isClosed)
    }

    override fun getDiscussionList(repoId: Long, isClosed: Boolean): List<Discussion> {
        giteaPort.findRepositoryById(repoId)
        return discussionPort.findDiscussionList(repoId, isClosed)
    }

    // TODO modify 하는 유저와 discussion 작성 유저가 동일인인지 체크
    // TODO 이미 comment가 달린 discussion code 부분은 삭제에서 제외하도록 함 ->
    @Transactional
    override fun modifyDiscussion(modifyDiscussionRequest: ModifyDiscussionRequest): DiscussionEntity {
        // 테스트의 편의성을 위해 도메인 로직을 pojo에 위임하기 위해 Entity-domain 객체 변환해서 가져옴
        val targetDiscussion = discussionPort.findDiscussionAllContent(modifyDiscussionRequest.discussionId)

        val deletedCodeIds: List<Long> = targetDiscussion.calculateDeletedCodes(modifyDiscussionRequest.codes).map { it.id!! }

        discussionCodePort.deleteDiscussionCodeAllById(deletedCodeIds)

        targetDiscussion.name = modifyDiscussionRequest.name
        targetDiscussion.content = modifyDiscussionRequest.content

        targetDiscussion.codes = modifyDiscussionRequest.codes

        return discussionPort.saveDiscussionAllContent(discussionAllContent = targetDiscussion)
    }
}
