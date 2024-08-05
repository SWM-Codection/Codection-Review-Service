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
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionUserPersistenceAdapter
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(DiscussionUserPersistenceAdapter::class)
class DiscussionUserPersistenceAdapterTest {

    @Autowired
    private lateinit var discussionUserPersistenceAdapter: DiscussionUserPersistenceAdapter

    @Autowired
    private lateinit var repository: DiscussionUserRepository

    @Autowired
    private lateinit var discussionRepository: DiscussionRepository

    @Test
    @DisplayName("디스커션 유저 읽기 상태로 등록")
    fun `saveDiscussionUser should save discussion user`() {
        // given
        val discussion = DiscussionEntity(
            id = null,
            name = "test discussion 3",
            content = "content 3",
            repoId = 1,
            posterId = 3,
            commitHash = "commitHash3",
            isClosed = false,
            numComments = 0,
            pinOrder = 0,
            deadlineUnix = null,
            isLocked = false
        )
        val discussionId = discussionRepository.save(discussion).id!!

        val userId = 1L

        // when
        val savedDiscussionUser = discussionUserPersistenceAdapter.insertDiscussionUser(userId, discussionId)

        // then
        assertNotNull(savedDiscussionUser.id)
        assertEquals(userId, savedDiscussionUser.userId)
        assertEquals(discussionId, savedDiscussionUser.discussionId)
    }
}
