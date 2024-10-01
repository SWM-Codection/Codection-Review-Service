package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.test.context.ActiveProfiles
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionCommentPersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.common.exception.NoSuchDiscussionCommentException
import swm.virtuoso.reviewservice.domain.DiscussionComment

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(DiscussionCommentPersistenceAdapter::class)
class DiscussionCommentPersistenceAdapterTest {

    @Autowired
    private lateinit var discussionCodeRepository: DiscussionCodeRepository

    @Autowired
    private lateinit var discussionCommentPersistenceAdapter: DiscussionCommentPersistenceAdapter

    @Autowired
    private lateinit var discussionCommentRepository: DiscussionCommentRepository

    @Autowired
    private lateinit var discussionRepository: DiscussionRepository

    @Test
    @DisplayName("코멘트 등록")
    fun `saveComment should save comment and return saved comment`() {
        // given

        // given
        val savedDiscussion = DiscussionEntity(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3",
            isClosed = false,
            numComments = 0,
            pinOrder = 0,
            deadlineUnix = 0,
            isLocked = false
        )

        val discussionId = discussionRepository.save(savedDiscussion).id!!

        val discussionComment = DiscussionComment(
            id = null,
            discussionId = discussionId,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        val discussionCodeEntity = DiscussionCodeEntity(
            id = null,
            discussionId = discussionId,
            filePath = "ddd",
            startLine = 1,
            endLine = 2
        )

        val savedCode = discussionCodeRepository.save(discussionCodeEntity)

        val discussionFileComment = DiscussionComment(
            id = null,
            discussionId = discussionId,
            codeId = savedCode.id,
            posterId = 1L,
            scope = CommentScopeEnum.LOCAL,
            startLine = 1,
            endLine = 2,
            content = "Test comment"
        )

        // when
        val savedComment = discussionCommentPersistenceAdapter.insertComment(discussionComment)
        val savedFileComment = discussionCommentPersistenceAdapter.insertComment(discussionFileComment)

        // then
        assertNotNull(savedComment.id)
        assertEquals(discussionComment.content, savedComment.content)
        assertEquals(savedFileComment.groupId, savedFileComment.id)
        assertEquals(savedComment.groupId, null)
        assertEquals(discussionComment.posterId, savedComment.posterId)
        assertEquals(discussionComment.discussionId, savedComment.discussionId)
    }

    @Test
    @DisplayName("코멘트 답변 등록")
    fun `saveComment should save comment`() {
        // given
        val savedDiscussion = DiscussionEntity(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3",
            isClosed = false,
            numComments = 0,
            pinOrder = 0,
            deadlineUnix = 0,
            isLocked = false
        )
        val discussionId = discussionRepository.save(savedDiscussion).id!!

        val discussionFileCommentReply = DiscussionComment(
            id = null,
            discussionId = savedDiscussion.id!!,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.LOCAL,
            startLine = 1,
            endLine = 2,
            content = "Test comment"
        )

        // when
        val savedComment = discussionCommentPersistenceAdapter.insertComment(discussionFileCommentReply)

        // then
        assertNotNull(savedComment.id)
        assertNull(discussionFileCommentReply.groupId)
    }

    @Test
    @DisplayName("코멘트 조회")
    fun `findCommentById should return correct comment`() {
        // given
        val savedDiscussion = DiscussionEntity(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3",
            isClosed = false,
            numComments = 0,
            pinOrder = 0,
            deadlineUnix = 0,
            isLocked = false
        )
        val discussionId = discussionRepository.save(savedDiscussion).id!!

        val discussionComment = DiscussionComment(
            id = null,
            discussionId = savedDiscussion.id!!,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )
        val savedComment = discussionCommentPersistenceAdapter.insertComment(discussionComment)

        // when
        val foundComment = discussionCommentPersistenceAdapter.findCommentById(savedComment.id!!)

        // then
        assertNotNull(foundComment)
        assertEquals(savedComment.id, foundComment.id)
        assertEquals(savedComment.content, foundComment.content)
    }

    @Test
    @DisplayName("없는 코멘트 조회")
    fun `findCommentById should throw exception if comment is not found`() {
        // given
        val commentId = 999L

        // when & then
        assertThrows<NoSuchDiscussionCommentException> {
            discussionCommentPersistenceAdapter.findCommentById(commentId)
        }
    }

    @Test
    @DisplayName("코멘트 삭제")
    fun `deleteCommentById should delete the comment`() {
        // given
        val savedDiscussion = DiscussionEntity(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3",
            isClosed = false,
            numComments = 0,
            pinOrder = 0,
            deadlineUnix = 0,
            isLocked = false
        )
        val discussionId = discussionRepository.save(savedDiscussion).id!!

        val discussionComment = DiscussionComment(
            id = null,
            discussionId = savedDiscussion.id!!,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )
        val savedComment = discussionCommentPersistenceAdapter.insertComment(discussionComment)

        // when
        discussionCommentPersistenceAdapter.deleteCommentById(savedComment.id!!)

        // then
        assertThrows<NoSuchDiscussionCommentException> {
            discussionCommentPersistenceAdapter.findCommentById(savedComment.id!!)
        }
    }

    @Test
    @DisplayName("코멘트 수정")
    fun `saveComment should update the comment`() {
        // given
        val savedDiscussion = DiscussionEntity(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3",
            isClosed = false,
            numComments = 0,
            pinOrder = 0,
            deadlineUnix = 0,
            isLocked = false
        )
        val discussionId = discussionRepository.save(savedDiscussion).id!!

        val discussionComment = DiscussionComment(
            id = null,
            discussionId = discussionId,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        val discussionCode: DiscussionCodeEntity = DiscussionCodeEntity(
            id = null,
            discussionId = discussionId,
            filePath = "dd",
            startLine = 1,
            endLine = 2
        )

        val savedCode = discussionCodeRepository.save(discussionCode)

        val discussionFileComment = DiscussionComment(
            id = null,
            discussionId = discussionId,
            codeId = savedCode.id,
            posterId = 1L,
            scope = CommentScopeEnum.LOCAL,
            startLine = 1,
            endLine = 3,
            content = "Test comment"
        )

        val savedComment = discussionCommentPersistenceAdapter.insertComment(discussionComment)
        val savedFileComment = discussionCommentPersistenceAdapter.insertComment(discussionFileComment)

        val modifiedComment = savedComment.copy(content = "Updated comment")

        val modifiedFileComment = savedFileComment.copy(content = "Updated comment")

        // when
        discussionCommentPersistenceAdapter.updateComment(modifiedComment)
        discussionCommentPersistenceAdapter.updateComment(modifiedFileComment)

        // then
        val updatedComment = discussionCommentPersistenceAdapter.findCommentById(savedComment.id!!)
        val updatedFileComment = discussionCommentPersistenceAdapter.findCommentById(savedFileComment.id!!)

        assertEquals(modifiedComment.content, updatedComment.content)
        assertEquals(modifiedFileComment.content, updatedFileComment.content)
        assertEquals(modifiedFileComment.groupId, updatedFileComment.groupId)
    }
}
