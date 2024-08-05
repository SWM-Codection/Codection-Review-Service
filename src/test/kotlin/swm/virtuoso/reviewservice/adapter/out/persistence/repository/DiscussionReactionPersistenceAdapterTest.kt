package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionReactionPersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionReactionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum
import swm.virtuoso.reviewservice.domain.DiscussionReaction
import kotlin.test.assertTrue

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(DiscussionReactionPersistenceAdapter::class)
class DiscussionReactionPersistenceAdapterTest {

    @Autowired
    private lateinit var discussionReactionPersistenceAdapter: DiscussionReactionPersistenceAdapter

    @Autowired
    private lateinit var discussionReactionRepository: DiscussionReactionRepository

    @Test
    @DisplayName("반응을 삽입하고 올바르게 저장되는지 확인")
    fun `insertReaction should save the reaction correctly`() {
        // given
        val discussionReaction = DiscussionReaction(
            type = ReactionTypeEnum.LAUGH,
            discussionId = 1,
            commentId = 2,
            userId = 1
        )

        // when
        val savedReaction = discussionReactionPersistenceAdapter.insertReaction(discussionReaction)

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
        val reactions = discussionReactionPersistenceAdapter.findReactionsByDiscussionId(discussionId)

        // then
        assertNotNull(reactions)
        assertEquals(2, reactions.size)
        assertTrue(reactions.any { it.type == ReactionTypeEnum.LAUGH })
        assertTrue(reactions.any { it.type == ReactionTypeEnum.HEART })
    }
}