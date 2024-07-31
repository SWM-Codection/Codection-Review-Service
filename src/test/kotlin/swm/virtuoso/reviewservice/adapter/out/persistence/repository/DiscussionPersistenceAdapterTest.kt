package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.PageRequest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionPersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAssigneesRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode
import swm.virtuoso.reviewservice.domain.DiscussionComment

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(DiscussionPersistenceAdapter::class)
class DiscussionPersistenceAdapterTest {

    @Autowired
    private lateinit var discussionPersistenceAdapter: DiscussionPersistenceAdapter

    @Autowired
    private lateinit var discussionRepository: DiscussionRepository

    @Autowired
    private lateinit var discussionCodeRepository: DiscussionCodeRepository

    @Autowired
    private lateinit var discussionIndexRepository: DiscussionIndexRepository

    @Autowired
    private lateinit var discussionUserRepository: DiscussionUserRepository

    @Autowired
    private lateinit var discussionCommentRepository: DiscussionCommentRepository

    @Autowired
    private lateinit var discussionAssigneesRepository: DiscussionAssigneesRepository

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @Test
    @DisplayName("디스커션 수 반환")
    fun `countDiscussion should return correct count`() {
        // given
        val discussion1 = Discussion(
            id = null,
            name = "test discussion 1",
            content = "content 1",
            repoId = 1,
            posterId = 1,
            commitHash = "commitHash1"
        )

        val discussion2 = Discussion(
            id = null,
            name = "test discussion 2",
            content = "content 2",
            repoId = 1,
            posterId = 2,
            commitHash = "commitHash2"
        )

        discussionPersistenceAdapter.insertDiscussion(discussion1)
        discussionPersistenceAdapter.insertDiscussion(discussion2)

        val repoId = 1L
        val isClosed = false
        val expectedCount = 2

        // when
        val count = discussionPersistenceAdapter.countDiscussion(repoId, isClosed)

        // then
        assertEquals(expectedCount, count)
    }

    @Test
    @DisplayName("디스커션 저장")
    fun `saveDiscussion should save discussion, index and return saved discussion`() {
        // given
        val discussion = Discussion(
            id = null,
            name = "test",
            content = "content",
            repoId = 1,
            posterId = 1,
            commitHash = "2vedw342k4m3km43lk2m4"
        )

        // when
        val savedDiscussionEntity = discussionPersistenceAdapter.insertDiscussion(discussion)

        // then
        assertNotNull(savedDiscussionEntity.id)
        assertEquals(discussion.name, savedDiscussionEntity.name)
        assertEquals(discussion.content, savedDiscussionEntity.content)
        assertEquals(discussion.repoId, savedDiscussionEntity.repoId)
        assertEquals(discussion.posterId, savedDiscussionEntity.posterId)
    }

    @Test
    @DisplayName("디스커션 조회")
    fun `findDiscussion should return correct discussion`() {
        // given
        val discussion1 = Discussion(
            id = null,
            name = "test discussion 1",
            content = "content 1",
            repoId = 1,
            posterId = 1,
            commitHash = "commitHash1"
        )
        val discussionId = discussionPersistenceAdapter.insertDiscussion(discussion1).id!!

        // when
        val findDiscussion = discussionPersistenceAdapter.findDiscussion(discussionId)

        // then
        assertNotNull(findDiscussion)
        assertEquals(discussionId, findDiscussion.id)
        assertEquals(findDiscussion.name, "test discussion 1")
    }

    @Test
    @DisplayName("없는 디스커션 조회")
    fun `findDiscussion should throw exception if discussion is not found`() {
        // given
        val discussionId = 999L

        // when & then
        assertThrows<NoSuchElementException> {
            discussionPersistenceAdapter.findDiscussion(discussionId)
        }
    }

    @Test
    @DisplayName("디스커션 유저 읽기 상태로 등록")
    fun `saveDiscussionUser should save discussion user`() {
        // given
        val discussion = Discussion(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3"
        )
        val discussionId = discussionPersistenceAdapter.insertDiscussion(discussion).id!!

        val userId = 1L

        // when
        val savedDiscussionUser = discussionPersistenceAdapter.insertDiscussionUser(userId, discussionId)

        // then
        assertNotNull(savedDiscussionUser.id)
        assertEquals(userId, savedDiscussionUser.uid)
        assertEquals(discussionId, savedDiscussionUser.discussionId)
    }

    @Test
    @DisplayName("코멘트 등록")
    fun `saveComment should save comment and return saved comment`() {
        // given
        val discussion1 = Discussion(
            id = null,
            name = "test discussion 1",
            content = "content 1",
            repoId = 1,
            posterId = 1,
            commitHash = "commitHash1"
        )
        val savedDiscussion = discussionPersistenceAdapter.insertDiscussion(discussion1)

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

        // when
        val savedComment = discussionPersistenceAdapter.insertComment(discussionComment)

        // then
        assertNotNull(savedComment.id)
        assertEquals(discussionComment.content, savedComment.content)
        assertEquals(discussionComment.posterId, savedComment.posterId)
        assertEquals(discussionComment.discussionId, savedComment.discussionId)
    }

    @Test
    @DisplayName("전체 디스커션 목록 조회")
    fun `findDiscussionList should return correct discussions`() {
        // given
        val discussion1 = Discussion(
            id = null,
            name = "test discussion 1",
            content = "content 1",
            repoId = 1,
            posterId = 1,
            commitHash = "commitHash1"
        )
        val discussion2 = Discussion(
            id = null,
            name = "test discussion 2",
            content = "content 2",
            repoId = 1,
            posterId = 2,
            commitHash = "commitHash2"
        )
        discussionPersistenceAdapter.insertDiscussion(discussion1)
        discussionPersistenceAdapter.insertDiscussion(discussion2)

        val repoId = 1L
        val isClosed = false
        val pageable = PageRequest.of(0, 20)

        // when
        val discussions = discussionPersistenceAdapter.findDiscussionList(repoId, isClosed, pageable)

        // then
        assertEquals(2, discussions.totalElements)
        assertEquals(discussion1.name, discussions.content[0].name)
        assertEquals(discussion2.name, discussions.content[1].name)
    }

    @Test
    @DisplayName("디스커션 코드 하나 반환")
    fun `findDiscussionCode should return correct code`() {
        // given
        val discussionCode = DiscussionCode(
            id = null,
            discussionId = 1,
            filePath = "first/testfile",
            startLine = 1,
            endLine = 5
        )
        val savedCode = discussionCodeRepository.save(DiscussionCodeEntity.fromDiscussionCode(discussionCode, 1L))

        // when
        val foundCode = discussionPersistenceAdapter.findDiscussionCode(savedCode.id!!)

        // then
        assertNotNull(foundCode)
        assertEquals(discussionCode.filePath, foundCode.filePath)
    }

    @Test
    @DisplayName("디스커션 하위 코드 전체 반환")
    fun `findDiscussionCodes should return correct codes`() {
        // given
        val discussionId = 1L
        val discussionCode1 = DiscussionCode(
            id = null,
            discussionId = discussionId,
            filePath = "first/testfile",
            startLine = 1,
            endLine = 5
        )
        val discussionCode2 = DiscussionCode(
            id = null,
            discussionId = discussionId,
            filePath = "first/testfile",
            startLine = 15,
            endLine = 20
        )
        discussionCodeRepository.save(DiscussionCodeEntity.fromDiscussionCode(discussionCode1, discussionId))
        discussionCodeRepository.save(DiscussionCodeEntity.fromDiscussionCode(discussionCode2, discussionId))

        // when
        val codes = discussionPersistenceAdapter.findDiscussionCodes(discussionId)

        // then
        assertEquals(2, codes.size)
    }

    @Test
    @DisplayName("디스커션 하위 코멘트 전체 반환")
    fun `findCommentsByDiscussionId should return correct comments`() {
        // given
        val discussion1 = Discussion(
            id = null,
            name = "test discussion 1",
            content = "content 1",
            repoId = 1,
            posterId = 1,
            commitHash = "commitHash1"
        )
        val savedDiscussion = discussionPersistenceAdapter.insertDiscussion(discussion1)

        val discussionComment1 = DiscussionComment(
            id = null,
            discussionId = savedDiscussion.id!!,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment 1"
        )
        val discussionComment2 = DiscussionComment(
            id = null,
            discussionId = savedDiscussion.id!!,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment 2"
        )
        discussionPersistenceAdapter.insertComment(discussionComment1)
        discussionPersistenceAdapter.insertComment(discussionComment2)

        // when
        val comments = discussionPersistenceAdapter.findCommentsByDiscussionId(savedDiscussion.id!!)

        // then
        assertEquals(2, comments.size)
    }

    @Test
    fun `insertDiscussionAssignees should save assignees to the database`() {
        // Given
        val discussionId = 1L
        val assignees = listOf(
            DiscussionAssignee(id = null, assigneeId = 10L, discussionId = discussionId),
            DiscussionAssignee(id = null, assigneeId = 11L, discussionId = discussionId)
        )

        // When
        discussionPersistenceAdapter.insertDiscussionAssignees(assignees)

        // Then
        val savedAssignees = discussionAssigneesRepository.findAll()
        assertEquals(assignees.size, savedAssignees.size)
    }
}
