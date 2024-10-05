package swm.virtuoso.reviewservice.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCommentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.CodeBlock
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionReactionPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.application.service.DiscussionFileService
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionCode
import swm.virtuoso.reviewservice.domain.DiscussionComment
import swm.virtuoso.reviewservice.domain.ExtractedLine
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class DiscussionFileServiceTest {

    @Mock
    lateinit var discussionPort: DiscussionPort

    @Mock
    lateinit var giteaPort: GiteaPort

    @Mock
    lateinit var gitUseCase: GitUseCase

    @Mock
    lateinit var discussionCommentPort: DiscussionCommentPort

    @Mock
    lateinit var discussionCodePort: DiscussionCodePort

    @Mock
    lateinit var discussionReactionPort: DiscussionReactionPort

    @InjectMocks
    lateinit var discussionFileService: DiscussionFileService

    val sampleTarget: String = """
        We are uncovering better ways of developing
        software by doing it and helping others do it.
        Through this work we have come to value:

        Individuals and interactions over processes and tools
        Working software over comprehensive documentation
        Customer collaboration over contract negotiation
        Responding to change over following a plan

        That is, while there is value in the items on
        the right, we value the items on the left more.
    """.trimIndent()

    @Test
    @DisplayName("문자열 데이터에서 행 단위로 특정 범위 추출")
    fun `extractLinesWithNumbers should return correct lines`() {
        // given
        val startLine = 2
        val endLine = 4

        // when
        val result = discussionFileService.extractLinesWithNumbers(sampleTarget, startLine, endLine)

        // then
        assertEquals(3, result.size)
        assertEquals(ExtractedLine(2, "software by doing it and helping others do it."), result[0])
        assertEquals(ExtractedLine(3, "Through this work we have come to value:"), result[1])
        assertEquals(ExtractedLine(4, ""), result[2])
    }

    @Test
    @DisplayName("파일 범위 보다 큰 범위 추출 예외")
    fun `extractLinesWithNumbers should throw IllegalArgumentException for invalid range`() {
        // given
        val startLine = 0
        val endLine = 10

        // when & then
        val exception = assertThrows<IllegalArgumentException> {
            discussionFileService.extractLinesWithNumbers(sampleTarget, startLine, endLine)
        }

        assertEquals("파일의 범위를 넘어선 범위입니다.", exception.message)
    }

    @Test
    @DisplayName("시작 줄이 끝 줄 보다 큰 경우 예외")
    fun `extractLinesWithNumbers should throw IllegalArgumentException for startLine greater than endLine`() {
        // given
        val startLine = 5
        val endLine = 3

        // when & then
        val exception = assertThrows<IllegalArgumentException> {
            discussionFileService.extractLinesWithNumbers(sampleTarget, startLine, endLine)
        }

        assertEquals("파일의 범위를 넘어선 범위입니다.", exception.message)
    }

    @Test
    @DisplayName("한 줄 추출")
    fun `extractLinesWithNumbers should handle single line extraction`() {
        // given
        val startLine = 3
        val endLine = 3

        // when
        val result = discussionFileService.extractLinesWithNumbers(sampleTarget, startLine, endLine)

        // then
        assertEquals(1, result.size)
        assertEquals(ExtractedLine(3, "Through this work we have come to value:"), result[0])
    }

    @Test
    @DisplayName("디스커션 컨텐츠(파일, 코드, 코멘트) 추출")
    fun `getDiscussionContents should return correct discussion content response`() {
        // given
        val discussionId = 1L
        val repoName = "test-repo"
        val ownerName = "test-owner"
        val commitHash = "abc123"
        val filePath = "path/to/file"
        val fileContent = "line1\nline2\nline3\nline4\nline5\nline6\nline7\nline8\nline9\nline10\nline11\nline12\nline13"

        val repository = RepositoryEntity(
            id = 1L,
            ownerName = ownerName,
            lowerName = repoName,
            name = repoName
        )

        val discussion = Discussion(
            id = discussionId,
            name = "test discussion",
            content = "test content",
            repoId = 1L,
            posterId = 1L,
            commitHash = commitHash
        )

        val codes = listOf(
            DiscussionCode(
                id = 1L,
                discussionId = discussionId,
                filePath = filePath,
                startLine = 1,
                endLine = 5
            )
        )

        val comments = listOf(
            DiscussionComment(
                id = 1L,
                discussionId = discussionId,
                codeId = 1L,
                posterId = 1L,
                scope = CommentScopeEnum.GLOBAL,
                startLine = null,
                endLine = null,
                content = "Test comment"
            )
        )

        val expectedCodeBlock = CodeBlock(
            codeId = 1L,
            lines = listOf(
                ExtractedLine(1, "line1"),
                ExtractedLine(2, "line2"),
                ExtractedLine(3, "line3"),
                ExtractedLine(4, "line4"),
                ExtractedLine(5, "line5")
            ),
            comments = listOf(
                DiscussionCommentResponse.fromDiscussionComment(comments[0], emptyList())
            )
        )

        // when
        `when`(giteaPort.findRepositoryByDiscussionId(discussionId)).thenReturn(repository)
        `when`(discussionPort.findDiscussionById(discussionId)).thenReturn(discussion)
        `when`(discussionCodePort.findDiscussionCodesByDiscussionId(discussionId)).thenReturn(codes)
        `when`(discussionCommentPort.findCommentsByDiscussionId(discussionId)).thenReturn(comments)
        `when`(gitUseCase.getFileContentByHashCode(ownerName, repoName, commitHash, filePath)).thenReturn(fileContent)

        val result = discussionFileService.getDiscussionContents(discussionId)

        // then
        assertNotNull(result)
        assertEquals(discussionId, result.discussionId)
        assertEquals(1, result.contents.size)
        assertEquals(filePath, result.contents[0].filePath)
        assertEquals(1, result.contents[0].codeBlocks.size)
        assertEquals(expectedCodeBlock, result.contents[0].codeBlocks[0])
    }
}
