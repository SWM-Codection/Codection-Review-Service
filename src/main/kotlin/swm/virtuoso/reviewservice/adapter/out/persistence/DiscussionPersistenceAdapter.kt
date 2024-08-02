package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.IssueIndexEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAssigneesRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAllContent
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode
import swm.virtuoso.reviewservice.domain.DiscussionComment
import swm.virtuoso.reviewservice.domain.DiscussionUser

@Repository
class DiscussionPersistenceAdapter(
    private val discussionRepository: DiscussionRepository,
    private val discussionCodeRepository: DiscussionCodeRepository,
    private val discussionIndexRepository: DiscussionIndexRepository,
    private val discussionUserRepository: DiscussionUserRepository,
    private val discussionCommentRepository: DiscussionCommentRepository,
    private val discussionAssigneesRepository: DiscussionAssigneesRepository
) : DiscussionPort, DiscussionCodePort, DiscussionUserPort, DiscussionCommentPort, DiscussionAssigneesPort {

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
        discussionAllContent.index = getNextIndex(discussionAllContent.repoId)
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

    override fun deleteCommentById(commentId: Long) {
        discussionCommentRepository.deleteById(commentId)
    }

    override fun findCommentById(commentId: Long): DiscussionComment {
        val commentEntity = discussionCommentRepository.findById(commentId).orElseThrow {
            throw NoSuchElementException("디스커션 코멘트를 찾을 수 없습니다. id : $commentId")
        }
        return DiscussionComment.fromEntity(commentEntity)
    }

    override fun saveComment(modifiedComment: DiscussionComment) {
        val exisingComment = findCommentById(modifiedComment.discussionId)

        modifiedComment.let { comment ->
            require(exisingComment.codeId == modifiedComment.codeId) {
                "수정된 코멘트와 기존 코멘트의 코드블록 정보가 일치하지 않습니다."
            }
            require(exisingComment.discussionId == modifiedComment.discussionId) {
                "수정된 코멘트와 기존 코멘트의 디스커션 정보가 일치하지 않습니다."
            }
        }

        // TODO discussion이 존재하지 않을 경우 예외처리

        val modifiedDiscussionComment = DiscussionCommentEntity.fromDiscussionComment(modifiedComment)
        discussionCommentRepository.save(modifiedDiscussionComment)
    }

    override fun insertDiscussionAssignees(discussionAssignees: List<DiscussionAssignee>) {
        val entities = discussionAssignees.map { assignee ->
            DiscussionAssigneesEntity.fromDiscussionAssignee(assignee)
        }
        discussionAssigneesRepository.saveAll(entities)
    }

    override fun findDiscussionAssignees(discussionId: Long): List<DiscussionAssignee> {
        return discussionAssigneesRepository.findAllByDiscussionId(discussionId)
            .map { DiscussionAssignee.fromEntity(it) }
    }
}
