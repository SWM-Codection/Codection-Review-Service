package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GiteaUseCase
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAssignee
import swm.virtuoso.reviewservice.domain.DiscussionCode

@WebMvcTest(DiscussionController::class)
@ActiveProfiles("test")
class DiscussionControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var discussionUseCase: DiscussionUseCase

    @MockBean
    private lateinit var giteaUseCase: GiteaUseCase

    @MockBean
    private lateinit var gitUseCase: GitUseCase

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    @DisplayName("디스커션 생성")
    fun `postDiscussion should create discussion and return discussion`() {
        // given
        val request = PostDiscussionRequest(
            repoId = 1L,
            posterId = 1L,
            name = "test discussion",
            content = "test content",
            branchName = "test branch",
            codes = listOf(
                DiscussionCode(
                    id = null,
                    discussionId = 1L,
                    filePath = "path/to/file",
                    startLine = 1,
                    endLine = 10
                )
            ),
            assignees = emptyList(),
            deadline = null
        )

        val repository = RepositoryEntity(
            id = 1L,
            ownerName = "owner",
            lowerName = "repo",
            name = "repository"
        )

        val savedDiscussion = Discussion(
            id = 1L,
            name = "test discussion",
            content = "test content",
            repoId = 1L,
            posterId = 1L,
            commitHash = "commitHash1",
            index = 1L
        )

        whenever(giteaUseCase.getRepositories(request.repoId)).thenReturn(repository)
        whenever(gitUseCase.getLastCommitHash(repository.ownerName!!, repository.lowerName, request.branchName)).thenReturn("commitHash1")
        whenever(discussionUseCase.createDiscussion(any(), any(), any())).thenReturn(savedDiscussion)

        // When & Then
        mockMvc.perform(
            post("/discussion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$").value(savedDiscussion.id))
    }

    @Test
    @DisplayName("디스커션 상세 반환")
    fun `should get discussion detail`() {
        // Given
        val discussionId = 1L

        val expectedDiscussion = Discussion(
            id = discussionId,
            name = "test discussion",
            content = "test content",
            repoId = 1L,
            posterId = 1L,
            commitHash = "commitHash1"
        )

        val assignees = listOf(
            DiscussionAssignee(id = 1L, assigneeId = 10L, discussionId = discussionId),
            DiscussionAssignee(id = 2L, assigneeId = 11L, discussionId = discussionId)
        )

        whenever(discussionUseCase.getDiscussion(discussionId)).thenReturn(expectedDiscussion)
        whenever(discussionUseCase.getDiscussionAssignees(discussionId)).thenReturn(assignees)

        mockMvc.perform(
            get("/discussion/$discussionId")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(discussionId))
            .andExpect(jsonPath("$.name").value(expectedDiscussion.name))
    }

    @Test
    @DisplayName("디스커션 개수 반환")
    fun `should get discussion count`() {
        // Given
        val repoId = 1L
        val expectedCount = Pair(5, 2)

        // Mocking the discussionUseCase to return the expected result
        whenever(discussionUseCase.countDiscussion(repoId)).thenReturn(expectedCount)

        // When & Then
        mockMvc.perform(
            get("/discussion/$repoId/count")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.openCount").value(expectedCount.first))
            .andExpect(jsonPath("$.closeCount").value(expectedCount.second))
    }

    @Test
    @DisplayName("디스커션 목록 반환")
    fun `should get discussion list`() {
        // Given
        val repoId = 1L
        val isClosed = true
        val page = 0
        val pageable = PageRequest.of(page, 20)
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
        val expectedDiscussionList = PageImpl(discussions, pageable, discussions.size.toLong())

        whenever(discussionUseCase.getDiscussions(repoId, isClosed, pageable)).thenReturn(expectedDiscussionList)

        // When & Then
        mockMvc.perform(
            get("/discussion/$repoId/list")
                .param("isClosed", isClosed.toString())
                .param("page", page.toString())
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.totalCount").value(expectedDiscussionList.totalElements))
            .andExpect(jsonPath("$.discussions[0].id").value(discussions[0].id))
            .andExpect(jsonPath("$.discussions[0].name").value(discussions[0].name))
            .andExpect(jsonPath("$.discussions[1].id").value(discussions[1].id))
            .andExpect(jsonPath("$.discussions[1].name").value(discussions[1].name))
    }

    @Test
    @DisplayName("디스커션 활성화 상태 변경")
    fun `should handle discussion available`() {
        // Given
        val request = DiscussionAvailableRequest(repoId = 1L, available = true)

        // When & Then
        mockMvc.perform(
            post("/discussion/available")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isCreated)
    }
}
