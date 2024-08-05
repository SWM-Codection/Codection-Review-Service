package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.domain.DiscussionCode

@Repository
class DiscussionCodePersistenceAdapter(
    private val discussionCodeRepository: DiscussionCodeRepository
) : DiscussionCodePort {

    override fun findDiscussionCodeById(codeId: Long): DiscussionCode {
        val codeEntity = discussionCodeRepository.findByIdOrNull(codeId)
            ?: throw NoSuchElementException("코드 정보를 찾을 수 없습니다.")
        return DiscussionCode.fromEntity(codeEntity)
    }

    override fun findDiscussionCodesByDiscussionId(discussionId: Long): List<DiscussionCode> {
        return discussionCodeRepository.findAllByDiscussionId(discussionId)
            .map { DiscussionCode.fromEntity(it) }
    }

    override fun deleteDiscussionCodeAllById(id: List<Long>) {
        // TODO soft delete로 바꿀지 생각해보기
        return discussionCodeRepository.deleteAllById(id)
    }

    override fun insertDiscussionCodes(discussionCodes: List<DiscussionCode>, discussionId: Long) {
        val entities = discussionCodes.map { discussionCode ->
            DiscussionCodeEntity.fromDiscussionCode(discussionCode, discussionId)
        }
        discussionCodeRepository.saveAll(entities)
    }
}
