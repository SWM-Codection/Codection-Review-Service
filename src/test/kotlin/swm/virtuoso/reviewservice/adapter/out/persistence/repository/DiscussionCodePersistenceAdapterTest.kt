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
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionCodePersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository
import swm.virtuoso.reviewservice.domain.DiscussionCode

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(DiscussionCodePersistenceAdapter::class)
class DiscussionCodePersistenceAdapterTest {

    @Autowired
    private lateinit var discussionCodeRepository: DiscussionCodeRepository

    @Autowired
    private lateinit var discussionCodePersistenceAdapter: DiscussionCodePersistenceAdapter

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
        val foundCode = discussionCodePersistenceAdapter.findDiscussionCodeById(savedCode.id!!)

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
        val codes = discussionCodePersistenceAdapter.findDiscussionCodesByDiscussionId(discussionId)

        // then
        assertEquals(2, codes.size)
    }
}
