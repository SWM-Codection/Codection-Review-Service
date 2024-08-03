package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionPersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionReactionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment
import kotlin.test.assertTrue

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@TestPropertySource(locations = ["classpath:application-test.yml"])
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
    private lateinit var discussionReactionRepository: DiscussionReactionRepository

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    private val logger: Logger = LoggerFactory.getLogger(DiscussionPersistenceAdapterTest::class.java)

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
        logger.info("Saved Discussion ID: ${savedDiscussionEntity.id}")

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

        // when
        val discussions = discussionPersistenceAdapter.findDiscussionList(repoId, isClosed)

        // then
        assertEquals(2, discussions.size)
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
        val codes = discussionPersistenceAdapter.findDiscussionCodeList(discussionId)

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
        val comments = discussionPersistenceAdapter.findCommentListByDiscussionId(savedDiscussion.id!!)

        // then
        assertEquals(2, comments.size)
    }

    @Test
    @DisplayName("반응을 삽입하고 올바르게 저장되는지 확인")
    fun `insertReaction should save the reaction correctly`() {
        // given
        val discussionReaction = DiscussionReactionEntity(
            type = ReactionTypeEnum.LAUGH,
            discussionId = 1,
            commentId = 2,
            userId = 1
        )

        // when
        val savedReaction = discussionReactionRepository.save(discussionReaction)

        // then
        assertNotNull(savedReaction)
        assertNotNull(savedReaction.id)
        assertEquals(discussionReaction.type, savedReaction.type)
        assertEquals(discussionReaction.discussionId, savedReaction.discussionId)
    }

    @Test
    @DisplayName("디스커션 ID로 모든 리액션을 반환해야 한다")
    fun `findReactionListByDiscussionId should return all reactions for the given discussionId`() {
        // given
        val discussionId = 1L
        val reaction1 = DiscussionReactionEntity(
            type = ReactionTypeEnum.LAUGH,
            discussionId = discussionId,
            commentId = 2,
            userId = 1
        )
        val reaction2 = DiscussionReactionEntity(
            type = ReactionTypeEnum.HEART,
            discussionId = discussionId,
            commentId = 3,
            userId = 2
        )
        discussionReactionRepository.saveAll(listOf(reaction1, reaction2))

        // when
        val reactions = discussionReactionRepository.findAllByDiscussionId(discussionId)

        // then
        assertNotNull(reactions)
        assertEquals(2, reactions.size)
        assertTrue(reactions.any { it.type == ReactionTypeEnum.LAUGH })
        assertTrue(reactions.any { it.type == ReactionTypeEnum.HEART })
    }
}
