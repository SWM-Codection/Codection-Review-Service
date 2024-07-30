package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.FileContent
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCodeUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GiteaUseCase
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = ["classpath:application-test.yml"])
class DiscussionControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var discussionUseCase: DiscussionUseCase

    @MockBean
    private lateinit var discussionCommentUseCase: DiscussionCommentUseCase

    @MockBean
    private lateinit var giteaUseCase: GiteaUseCase

    @MockBean
    private lateinit var gitUseCase: GitUseCase

    @MockBean
    private lateinit var discussionCodeUseCase: DiscussionCodeUseCase

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
            )
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
        whenever(discussionUseCase.createDiscussion(any(), any())).thenReturn(savedDiscussion)

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
    @DisplayName("디스커션 개수 반환")
    fun `should get discussion count`() {
        // Given
        val repoId = 1L
        val isClosed = false
        val expectedCount = 5

        whenever(discussionUseCase.countDiscussion(repoId, isClosed)).thenReturn(expectedCount)

        // When & Then
        mockMvc.perform(
            get("/discussion/$repoId/count")
                .param("isClosed", isClosed.toString())
        )
            .andExpect(status().isOk)
            .andExpect(content().string(expectedCount.toString()))
    }

    @Test
    @DisplayName("디스커션 목록 반환")
    fun `should get discussion list`() {
        // Given
        val repoId = 1L
        val isClosed = true
        val expectedDiscussions: List<Discussion> = listOf(
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

        whenever(discussionUseCase.getDiscussionList(repoId, isClosed)).thenReturn(expectedDiscussions)

        // When & Then
        mockMvc.perform(
            get("/discussion/$repoId/list")
                .param("isClosed", isClosed.toString())
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()").value(expectedDiscussions.size))
            .andExpect(jsonPath("$[0].id").value(expectedDiscussions[0].id))
            .andExpect(jsonPath("$[0].name").value(expectedDiscussions[0].name))
            .andExpect(jsonPath("$[1].id").value(expectedDiscussions[1].id))
            .andExpect(jsonPath("$[1].name").value(expectedDiscussions[1].name))
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

    @Test
    @DisplayName("디스커션 컨텐츠(파일, 코드, 코멘트) 반환")
    fun `should get discussion contents`() {
        // Given
        val discussionId = 1L
        val response = DiscussionContentResponse(
            discussionId = discussionId,
            contents = listOf(FileContent(filePath = "path/to/file", codeBlocks = listOf())),
            globalComments = listOf()
        )

        whenever(discussionCodeUseCase.getDiscussionContents(discussionId)).thenReturn(response)

        // When & Then
        mockMvc.perform(get("/discussion/$discussionId/contents"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.discussionId").value(discussionId))
    }

    @Test
    @DisplayName("코멘트 등록")
    fun `should post comment`() {
        // Given
        val request = PostCommentRequest(
            discussionId = 1L,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        val savedComment = DiscussionComment(
            id = 1L,
            discussionId = 1L,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        whenever(discussionCommentUseCase.createComment(any())).thenReturn(savedComment)

        // When & Then
        mockMvc.perform(
            post("/discussion/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$").value(savedComment.id))
    }
}
