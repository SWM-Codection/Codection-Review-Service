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
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAssigneesRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionReactionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode
import swm.virtuoso.reviewservice.domain.DiscussionComment
import kotlin.test.assertTrue

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
        val findDiscussion = discussionPersistenceAdapter.findDiscussionById(discussionId)

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
            discussionPersistenceAdapter.findDiscussionById(discussionId)
        }
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
        val discussions = discussionPersistenceAdapter.findDiscussions(repoId, isClosed, pageable)

        // then
        assertEquals(2, discussions.totalElements)
        assertEquals(discussion1.name, discussions.content[0].name)
        assertEquals(discussion2.name, discussions.content[1].name)
    }
}
