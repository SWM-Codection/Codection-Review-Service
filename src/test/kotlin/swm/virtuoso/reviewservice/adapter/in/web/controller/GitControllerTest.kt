package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionFileUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.domian.ExtractedLine
import kotlin.test.Test

@WebMvcTest(GitController::class)
@ActiveProfiles("test")
class GitControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var gitUseCase: GitUseCase

    @MockBean
    private lateinit var discussionFileUseCase: DiscussionFileUseCase

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    @DisplayName("파일 목록을 리스트 형태로 반환")
    fun `should list Git files as list`() {
        // Given
        val ownerName = ".codection"
        val repoName = "test"
        val branchName = "main"
        val expectedFiles = listOf("README.md", "splug_assignment.cpp")

        whenever(gitUseCase.listFiles(ownerName, repoName, branchName)).thenReturn(expectedFiles)

        // When & Then
        mockMvc.perform(
            get("/$ownerName/$repoName/$branchName/discussions/list")
        )
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(expectedFiles)))
    }

    @Test
    @DisplayName("파일 내용 반환")
    fun `should get file content`() {
        // Given
        val ownerName = ".codection"
        val repoName = "test"
        val branchName = "main"
        val filePath = "path/file.txt"
        val fileContent = "Sample file content"
        val expectedExtractedLines = listOf(ExtractedLine(1, "Sample file content"))

        whenever(gitUseCase.getFileContent(ownerName, repoName, branchName, filePath)).thenReturn(fileContent)
        whenever(discussionFileUseCase.extractLinesWithNumbers(fileContent, 1, fileContent.lines().size))
            .thenReturn(expectedExtractedLines)

        // When & Then
        mockMvc.perform(
            get("/$ownerName/$repoName/$branchName/discussions/contents")
                .param("filepath", filePath)
        )
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(expectedExtractedLines)))
    }
}
