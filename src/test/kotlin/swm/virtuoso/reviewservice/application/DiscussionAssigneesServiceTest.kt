package swm.virtuoso.reviewservice.application

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.doReturn
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.service.DiscussionAssigneesService
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class DiscussionAssigneesServiceTest {

    @Mock
    private lateinit var discussionAssigneesPort: DiscussionAssigneesPort

    @Mock
    private lateinit var discussionPort: DiscussionPort

    @InjectMocks
    private lateinit var discussionAssigneesService: DiscussionAssigneesService

    @Test
    @DisplayName("디스커션의 담당자 리스트 수정")
    fun `should modify discussion assignees`() {
        // Given
        val discussionId = 1L
        val assigneeId = 3L // 새로운 assignee IDs

        doReturn(mock(Discussion::class.java)).`when`(discussionPort).findDiscussionById(discussionId)
        doNothing().`when`(discussionAssigneesPort).insertDiscussionAssignee(any())

        // When
        discussionAssigneesService.changeAssignee(discussionId, assigneeId)

        // 확인 추가된 assignees
        val toAdd = DiscussionAssignee(discussionId = discussionId, assigneeId = 3L)
        verify(discussionAssigneesPort).insertDiscussionAssignee(toAdd)
    }
}
