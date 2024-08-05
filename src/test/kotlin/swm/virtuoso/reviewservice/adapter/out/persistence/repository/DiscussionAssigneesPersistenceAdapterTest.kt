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
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionAssigneesPersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAssigneesRepository
import swm.virtuoso.reviewservice.domain.DiscussionAssignee

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(DiscussionAssigneesPersistenceAdapter::class)
class DiscussionAssigneesPersistenceAdapterTest {

    @Autowired
    private lateinit var discussionAssigneesPersistenceAdapter: DiscussionAssigneesPersistenceAdapter

    @Autowired
    private lateinit var discussionAssigneesRepository: DiscussionAssigneesRepository

    @Test
    @DisplayName("디스커션 담당자 등록")
    fun `insertDiscussionAssignees should save assignees to the database`() {
        // Given
        val discussionId = 1L
        val assignees = listOf(
            DiscussionAssignee(id = null, assigneeId = 10L, discussionId = discussionId),
            DiscussionAssignee(id = null, assigneeId = 11L, discussionId = discussionId)
        )

        // When
        discussionAssigneesPersistenceAdapter.insertDiscussionAssignees(assignees)

        // Then
        val savedAssignees = discussionAssigneesRepository.findAll()
        assertEquals(assignees.size, savedAssignees.size)
    }

    @Test
    @DisplayName("디스커션 담당자 목록 조회")
    fun `findDiscussionAssignees should return correct assignees for the given discussionId`() {
        // Given
        val discussionId = 2L
        val assignees = listOf(
            DiscussionAssignee(id = null, assigneeId = 3L, discussionId = discussionId),
            DiscussionAssignee(id = null, assigneeId = 5L, discussionId = discussionId)
        )
        discussionAssigneesRepository.saveAll(assignees.map { DiscussionAssigneesEntity.fromDiscussionAssignee(it) })

        // When
        val foundAssignees = discussionAssigneesPersistenceAdapter.findDiscussionAssigneesByDiscussionId(discussionId)

        // Then
        assertEquals(assignees.size, foundAssignees.size)
        assertNotNull(foundAssignees[0].id)
        assertEquals(assignees[1].assigneeId, foundAssignees[1].assigneeId)
    }
}
