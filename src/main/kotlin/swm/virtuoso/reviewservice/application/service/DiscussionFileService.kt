package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCommentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.CodeBlock
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.FileContent
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCodeUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.domian.ExtractedLine

@Service
class DiscussionFileService(
    private val discussionCodePort: DiscussionCodePort,
    private val giteaPort: GiteaPort,
    private val gitUseCase: GitUseCase,
    private val discussionCommentPort: DiscussionCommentPort
) : DiscussionCodeUseCase {

    override fun extractLinesWithNumbers(target: String, startLine: Int, endLine: Int): List<ExtractedLine> {
        val lines = target.lines()
        if (startLine < 1 || endLine > lines.size || startLine > endLine) {
            throw IllegalArgumentException("파일의 범위를 넘어선 범위입니다.")
        }

        val result = mutableListOf<ExtractedLine>()
        for (i in startLine..endLine) {
            result.add(ExtractedLine(i, lines[i - 1]))
        }
        return result
    }

    /**
     * CodeBlock: 디스커션 작성 시 파일 내용에 드래그한 코드의 단위 + 해당 부분에 달린 코멘트
     * FileContents: 하나의 파일에 작성된 코드 블록의 집합
     * DiscussionContents: discussion에 있는 fileContents의 집합
     */
    // TODO 최신 커밋 기반으로 가져오는 중 -> 디비에 저장된 커밋 해시 기반으로 가져오도록 수정
    // TODO 코드가 길어서 추후 리팩토링 할 예정
    override fun getDiscussionContents(discussionId: Long): DiscussionContentResponse {
        val repository = giteaPort.findRepositoryByDiscussionId(discussionId)
        val codes = discussionCodePort.findDiscussionFiles(discussionId)
        val comments = discussionCommentPort.findCommentsByDiscussionId(discussionId)

        val fileContentMap = mutableMapOf<String, MutableList<CodeBlock>>()

        codes.forEach { code ->
            val fileContent = gitUseCase.getFileContent(
                ownerName = repository.ownerName!!,
                repoName = repository.lowerName,
                filePath = code.filePath
            )
            val lines = extractLinesWithNumbers(fileContent, code.startLine, code.endLine)

            val commentsForFile = comments.filter { it.codeId == code.id }
            val codeBlock = CodeBlock(
                codeId = code.id!!,
                lines = lines,
                comments = commentsForFile.map {
                    DiscussionCommentResponse(
                        id = it.id!!,
                        scope = it.scope.toString(),
                        startLine = it.startLine,
                        endLine = it.endLine,
                        content = it.content
                    )
                }
            )

            fileContentMap.computeIfAbsent(code.filePath) { mutableListOf() }.add(codeBlock)
        }

        //
        val fileContents = fileContentMap.map { (fileUrl, codeBlocks) ->
            FileContent(filePath = fileUrl, codeBlocks = codeBlocks)
        }

        // Discussion 단위의 코드와 코멘트 집합
        return DiscussionContentResponse(
            discussionId = discussionId,
            contents = fileContents
        )
    }
}
