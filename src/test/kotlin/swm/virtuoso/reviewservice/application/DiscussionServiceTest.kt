package swm.virtuoso.reviewservice.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import swm.virtuoso.reviewservice.application.port.out.DiscussionAssigneesPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.application.service.DiscussionService
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode
import swm.virtuoso.reviewservice.domain.DiscussionUser
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class DiscussionServiceTest {

    @Mock
    private lateinit var discussionPort: DiscussionPort

    @Mock
    private lateinit var discussionUserPort: DiscussionUserPort

    @Mock
    private lateinit var discussionCodePort: DiscussionCodePort

    @Mock
    private lateinit var discussionAssigneePort: DiscussionAssigneesPort

    @Mock
    private lateinit var giteaPort: GiteaPort

    @InjectMocks
    private lateinit var discussionService: DiscussionService

    val discussion = Discussion(
        id = null,
        name = "test discussion",
        content = "test content",
        repoId = 1L,
        posterId = 1L,
        commitHash = "commitHash1"
    )

    val codes = listOf(
        DiscussionCode(
            id = null,
            discussionId = 1L,
            filePath = "path/to/file",
            startLine = 1,
            endLine = 10
        )
    )

    @Test
    @DisplayName("디스커션 생성")
    fun `createDiscussion should create discussion, save codes and return new discussion`() {
        // given
        val savedDiscussion = Discussion(
            id = 1L,
            name = "test discussion",
            content = "test content",
            repoId = 1L,
            posterId = 1L,
            commitHash = "commitHash1",
            index = 1L
        )

        val savedDiscussionUser = DiscussionUser(
            id = 1L,
            userId = 1L,
            discussionId = 1L,
            isRead = true,
            isMentioned = false
        )

        val savedAssigneeUser = listOf(2L)

        doReturn(savedDiscussion).`when`(discussionPort).insertDiscussion(discussion)
        doNothing().`when`(discussionCodePort).insertDiscussionCodes(codes, savedDiscussion.id!!)
        doReturn(savedDiscussionUser).`when`(discussionUserPort).insertDiscussionUser(savedDiscussion.posterId, savedDiscussion.id!!)

        // when
        val result = discussionService.createDiscussion(discussion, codes, savedAssigneeUser)

        // then
        assertNotNull(result.id)
        assertEquals(savedDiscussion.id, result.id)
        assertEquals(savedDiscussion.name, result.name)
        assertEquals(savedDiscussion.content, result.content)
        assertEquals(savedDiscussion.repoId, result.repoId)
        assertEquals(savedDiscussion.posterId, result.posterId)

        verify(discussionPort, times(1)).insertDiscussion(discussion)
        verify(discussionCodePort, times(1)).insertDiscussionCodes(codes, savedDiscussion.id!!)
        verify(discussionUserPort, times(1)).insertDiscussionUser(savedDiscussion.posterId, savedDiscussion.id!!)
    }

    @Test
    @DisplayName("특정 디스커션의 Assignees 반환")
    fun `getDiscussionAssignees should return correct assignees`() {
        // given
        val discussionId = 1L
        val assignees = listOf(
            DiscussionAssignee(assigneeId = 10L, discussionId = discussionId),
            DiscussionAssignee(assigneeId = 11L, discussionId = discussionId)
        )

        doReturn(assignees).`when`(discussionAssigneePort).findDiscussionAssigneesByDiscussionId(discussionId)

        // when
        val result = discussionService.getDiscussionAssignees(discussionId)

        // then
        assertEquals(assignees.size, result.size)
        assertEquals(assignees, result)
    }

    @Test
    @DisplayName("ID로 디스커션 조회")
    fun `getDiscussion should return correct discussion`() {
        // given
        val discussionId = 1L
        val expectedDiscussion = Discussion(
            id = discussionId,
            name = "test discussion",
            content = "test content",
            repoId = 1L,
            posterId = 1L,
            commitHash = "commitHash1"
        )

        doReturn(expectedDiscussion).`when`(discussionPort).findDiscussionById(discussionId)

        // when
        val result = discussionService.getDiscussion(discussionId)

        // then
        assertEquals(expectedDiscussion, result)
    }

    @Test
    @DisplayName("특정 레포의 디스커션 수 반환")
    fun `countDiscussion should return correct count`() {
        // given
        val repoId = 1L
        val isClosed = false
        val expectedCount = 5

        doReturn(expectedCount).`when`(discussionPort).countDiscussion(repoId, isClosed)

        // when
        val result = discussionService.countDiscussion(repoId, isClosed)

        // then
        assertEquals(expectedCount, result)
    }

    @Test
    @DisplayName("특정 레포의 디스커션 목록 반환")
    fun `getDiscussionList should return discussion list`() {
        // given
        val repoId = 1L
        val isClosed = false
        val pageable = PageRequest.of(0, 20)
        val discussions = listOf(
            Discussion(
                id = 1L,
                name = "discussion 1",
                content = "content 1",
                repoId = repoId,
                posterId = 1L,
                commitHash = "commitHash1"
            ),
            Discussion(
                id = 2L,
                name = "discussion 2",
                content = "content 2",
                repoId = repoId,
                posterId = 2L,
                commitHash = "commitHash2"
            )
        )

        val expectedDiscussions = PageImpl(discussions, pageable, discussions.size.toLong())
        doReturn(expectedDiscussions).`when`(discussionPort).findDiscussions(repoId, isClosed, pageable)

        // when
        val result = discussionService.getDiscussions(repoId, isClosed, pageable)

        // then
        assertEquals(expectedDiscussions.totalElements, result.totalElements)
        assertEquals(discussions, result.content)
    }
}
