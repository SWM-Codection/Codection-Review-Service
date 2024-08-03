package swm.virtuoso.reviewservice.application

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.application.service.DiscussionUserService
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionUser
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class DiscussionUserServiceTest {

    @Mock
    lateinit var discussionUserPort: DiscussionUserPort

    @Mock
    lateinit var discussionPort: DiscussionPort

    @Mock
    lateinit var giteaPort: GiteaPort

    @InjectMocks
    lateinit var discussionUserService: DiscussionUserService

    @Test
    @DisplayName("유저를 멘션 됨으로 마크")
    fun `markDiscussionAsMention should mark user as mentioned`() {
        // given
        val discussionId = 1L
        val userId = 2L
        val findDiscussionUser = DiscussionUser(
            id = 3L,
            uid = userId,
            discussionId = discussionId,
            isRead = false,
            isMentioned = false
        )
        val updatedDiscussionUser = findDiscussionUser.copy(isMentioned = true)

        doReturn(mock(Discussion::class.java)).`when`(discussionPort).findDiscussionById(discussionId)
        doReturn(mock(UserEntity::class.java)).`when`(giteaPort).findUserById(userId)
        doReturn(findDiscussionUser).`when`(discussionUserPort).findDiscussionUserByUid(userId)
        doReturn(updatedDiscussionUser).`when`(discussionUserPort).updateDiscussionUser(any())

        // when
        discussionUserService.markDiscussionAsMention(discussionId, userId)

        // then
        verify(discussionPort).findDiscussionById(discussionId)
        verify(giteaPort).findUserById(userId)
        verify(discussionUserPort).findDiscussionUserByUid(userId)
        verify(discussionUserPort).updateDiscussionUser(any())
    }

    @Test
    @DisplayName("유저를 읽음으로 마크")
    fun `markDiscussionAsRead should mark user as read`() {
        // given
        val discussionId = 1L
        val userId = 2L
        val findDiscussionUser = DiscussionUser(
            id = 3L,
            uid = userId,
            discussionId = discussionId,
            isRead = false,
            isMentioned = false
        )
        val updatedDiscussionUser = findDiscussionUser.copy(isRead = true)

        doReturn(mock(Discussion::class.java)).`when`(discussionPort).findDiscussionById(discussionId)
        doReturn(mock(UserEntity::class.java)).`when`(giteaPort).findUserById(userId)
        doReturn(findDiscussionUser).`when`(discussionUserPort).findDiscussionUserByUid(userId)
        doReturn(updatedDiscussionUser).`when`(discussionUserPort).updateDiscussionUser(any())

        // when
        discussionUserService.markDiscussionAsRead(discussionId, userId)

        // then
        verify(discussionPort).findDiscussionById(discussionId)
        verify(giteaPort).findUserById(userId)
        verify(discussionUserPort).findDiscussionUserByUid(userId)
        verify(discussionUserPort).updateDiscussionUser(any())
    }
}
