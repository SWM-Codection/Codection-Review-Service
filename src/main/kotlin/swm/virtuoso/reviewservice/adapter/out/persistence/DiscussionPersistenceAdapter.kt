package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.IssueIndexEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionAllContent
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment
import swm.virtuoso.reviewservice.domian.DiscussionUser

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionCodeRepository: DiscussionCodeRepository,
    private val discussionIndexRepository: DiscussionIndexRepository,
    private val discussionUserRepository: DiscussionUserRepository,
    private val discussionCommentRepository: DiscussionCommentRepository
) : DiscussionPort, DiscussionCodePort, DiscussionUserPort, DiscussionCommentPort {

    private fun getIndex(repoId: Long): Long {
        return discussionIndexRepository.findById(repoId)
            .map { it.maxIndex + 1 }
            .orElse(1)
    }

    override fun insertDiscussion(discussion: Discussion): Discussion {
        discussion.index = getIndex(discussion.repoId)
        val newDiscussion = discussionRepository.save(DiscussionEntity.fromDiscussion(discussion))

        discussionIndexRepository.save(
            IssueIndexEntity(
                groupId = newDiscussion.repoId,
                maxIndex = newDiscussion.index!!
            )
        )
        return Discussion.fromEntity(newDiscussion)
    }

    override fun countDiscussion(repoId: Long, isClosed: Boolean): Int {
        return discussionRepository.countByRepoIdAndIsClosed(repoId, isClosed)
    }

    override fun findDiscussionList(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion> {
        return discussionRepository.findAllByRepoIdAndIsClosed(repoId, isClosed, pageable)
            .map { Discussion.fromEntity(it) }
    }

    override fun findDiscussion(discussionId: Long): Discussion {
        val discussionEntity = discussionRepository.findByIdOrNull(discussionId)
            ?: throw NoSuchElementException("디스커션 정보를 찾을 수 없습니다.")

        return Discussion.fromEntity(discussionEntity)
    }

    override fun saveDiscussionAllContent(
        discussionAllContent: DiscussionAllContent
    ): DiscussionEntity {
        discussionAllContent.index = getIndex(discussionAllContent.repoId)
        val discussionEntity = discussionRepository.save(
            DiscussionEntity.fromDiscussion(
                discussion = Discussion(
                    id = discussionAllContent.id,
                    name = discussionAllContent.name,
                    content = discussionAllContent.content,
                    repoId = discussionAllContent.repoId,
                    commitHash = discussionAllContent.commitHash,
                    index = discussionAllContent.index,
                    posterId = discussionAllContent.posterId
                )
            )
        )

        discussionAllContent.codes.map { discussionCode ->
            discussionCodeRepository.save(
                DiscussionCodeEntity.fromDiscussionCode(
                    discussionCode = discussionCode,
                    discussionId = discussionEntity.id!!
                )
            )
        }

        discussionIndexRepository.save(
            IssueIndexEntity(
                groupId = discussionAllContent.repoId,
                maxIndex = discussionAllContent.index!!
            )
        )

        return discussionEntity
    }

    override fun findDiscussionAllContent(discussionId: Long): DiscussionAllContent {
        val discussionEntity = discussionRepository.findById(discussionId).orElseThrow {
            throw NoSuchElementException("디스커션 정보를 찾을 수 없습니다.")
        }
        val discussionCodes = discussionCodeRepository.findAllByDiscussionId(discussionId)

        return DiscussionAllContent(
            id = discussionEntity.id,
            name = discussionEntity.name,
            posterId = discussionEntity.posterId,
            codes = discussionCodes.map { discussionCode ->
                DiscussionCode(
                    id = discussionCode.id,
                    discussionId = discussionCode.discussionId,
                    startLine = discussionCode.startLine,
                    endLine = discussionCode.endLine,
                    filePath = discussionCode.filePath
                )
            },
            content = discussionEntity.content,
            repoId = discussionEntity.repoId,
            commitHash = discussionEntity.commitHash,
            index = discussionEntity.index
        )
    }

    override fun insertDiscussionUser(userId: Long, discussionId: Long): DiscussionUser {
        return DiscussionUser.fromEntity(
            discussionUserRepository.save(
                DiscussionUserEntity(
                    id = null,
                    uid = userId,
                    discussionId = discussionId,
                    isRead = true,
                    isMentioned = false
                )
            )
        )
    }

    override fun findDiscussionCode(codeId: Long): DiscussionCode {
        val codeEntity = discussionCodeRepository.findByIdOrNull(codeId)
            ?: throw NoSuchElementException("코드 정보를 찾을 수 없습니다.")
        return DiscussionCode.fromEntity(codeEntity)
    }

    override fun findDiscussionCodes(discussionId: Long): List<DiscussionCode> {
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

    override fun insertComment(discussionComment: DiscussionComment): DiscussionComment {
        val discussion = findDiscussion(discussionComment.discussionId)
        discussionComment.codeId?.let { codeId ->
            // 조건이 안맞으면 IllegalArgumentException 발생
            require(discussion.id == findDiscussionCode(codeId).discussionId) {
                "코드의 정보와 디스커션 정보가 일치하지 않습니다."
            }
        }
        insertDiscussionUser(
            userId = discussionComment.posterId,
            discussionId = discussionComment.discussionId
        )

        val savedEntity = discussionCommentRepository.save(
            DiscussionCommentEntity.fromDiscussionComment(discussionComment)
        )

        return DiscussionComment.fromEntity(savedEntity)
    }

    override fun findCommentsByDiscussionId(discussionId: Long): List<DiscussionComment> {
        return discussionCommentRepository.findAllByDiscussionId(discussionId)
            .map { DiscussionComment.fromEntity(it) }
    }
}
