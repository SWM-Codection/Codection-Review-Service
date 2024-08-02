package swm.virtuoso.reviewservice.application

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import swm.virtuoso.reviewservice.application.service.GitService
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExtendWith(MockitoExtension::class)
class GitServiceTest {
    private lateinit var gitService: GitService
    private var baseUrl : String
    private val ownerName = ".codection"
    private val repoName = "test/"
    private val branchName = "main"
    private val filePath = "splug_assignment.cpp"
    private val commitHash = "d5bb24a99fc62f737ecdd07b102dcc3bfa352e9b"

    private fun isWindows(): Boolean {
        val property = System.getProperty("os.name")
        return property.lowercase().contains("win")
    }

    init {
        if (isWindows()) {
            baseUrl = System.getenv("USERPROFILE").toString()
        }
        else {
            baseUrl = System.getenv("HOME").toString()
        }

    }

    @BeforeEach
    fun setUp() {
        gitService = GitService(baseUrl)
    }

    @Test
    @DisplayName("최신 커밋 해시 가져오기")
    fun `test getLastCommitHash`() {
        // when
        val actualHash = gitService.getLastCommitHash(ownerName, repoName, branchName)

        // then
        assertEquals(commitHash, actualHash)
    }

    @Test
    @DisplayName("파일 리스트 가져오기")
    fun `test listFiles`() {
        // given
        val files = listOf("README.md", "splug_assignment.cpp")

        // when
        val fileList = gitService.listFiles(ownerName, repoName, branchName)

        // then
        assertTrue(fileList.containsAll(files))
    }

    @Test
    @DisplayName("브랜치 바탕으로 파일 내용 가져오기")
    fun `test getFileContent`() {
        // given
        val expectedContent = """
        #include<stdio.h>
        #include<malloc.h>
        #include<string.h>
        typedef struct Client
        {
        """.trimIndent()

        // when
        val fileContent = gitService.getFileContent(ownerName, repoName, branchName, filePath)
        val actualFirstFiveLines = fileContent.lines().take(5).joinToString("\n")

        // then
        assertEquals(expectedContent, actualFirstFiveLines)
    }

    @Test
    @DisplayName("해시 코드로 파일 내용 가져오기")
    fun `test getFileContentByHashCode`() {
        // Given
        val expectedContent = """
        #include<stdio.h>
        #include<malloc.h>
        #include<string.h>
        typedef struct Client
        {
        """.trimIndent()

        // When
        val fileContent = gitService.getFileContentByHashCode(ownerName, repoName, commitHash, filePath)
        val actualFirstFiveLines = fileContent.lines().take(5).joinToString("\n")

        // Then
        assertEquals(expectedContent, actualFirstFiveLines)
    }
}
