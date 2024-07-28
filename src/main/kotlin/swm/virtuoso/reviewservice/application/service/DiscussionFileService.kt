package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCommentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.CodeBlock
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.FileContent
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCodeUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.port.out.DiscussionPort
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment
import swm.virtuoso.reviewservice.domian.ExtractedLine

@Service
class DiscussionFileService(
    private val discussionCodePort: DiscussionCodePort,
    private val giteaPort: GiteaPort,
    private val gitUseCase: GitUseCase,
    private val discussionCommentPort: DiscussionCommentPort,
    private val discussionPort: DiscussionPort
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
    private fun createCodeBlock(
        codeId: Long,
        lines: List<ExtractedLine>,
        comments: List<DiscussionComment>
    ): CodeBlock {
        return CodeBlock(
            codeId = codeId,
            lines = lines,
            comments = comments.map { DiscussionCommentResponse.fromDiscussionComment(it) }
        )
    }

    private fun buildFileContentMap(
        codes: List<DiscussionCode>,
        comments: List<DiscussionComment>,
        repository: RepositoryEntity,
        commitHash: String
    ): Map<String, MutableList<CodeBlock>> {
        return codes.groupBy { it.filePath }.mapValues { (filePath, codes) ->
            codes.map { code ->
                val fileContent = gitUseCase.getFileContentByHashCode(
                    ownerName = repository.ownerName!!,
                    repoName = repository.lowerName,
                    filePath = filePath,
                    hashCode = commitHash
                )
                createCodeBlock(
                    code.id!!,
                    extractLinesWithNumbers(fileContent, code.startLine, code.endLine),
                    comments.filter { it.codeId == code.id }
                )
            }.toMutableList()
        }
    }

    override fun getDiscussionContents(discussionId: Long): DiscussionContentResponse {
        val repository = giteaPort.findRepositoryByDiscussionId(discussionId)
        val discussion = discussionPort.findDiscussion(discussionId)
        val commitHash = discussion.commitHash ?: throw IllegalArgumentException("Commit hash not found")
        val codes = discussionCodePort.findDiscussionCodes(discussionId)
        val comments = discussionCommentPort.findCommentsByDiscussionId(discussionId)

        val fileContentMap = buildFileContentMap(codes, comments, repository, commitHash)

        val globalComments = comments.filter { it.codeId == null }.map {
            DiscussionCommentResponse.fromDiscussionComment(it)
        }

        return DiscussionContentResponse(
            discussionId = discussionId,
            contents = fileContentMap.map { (filePath, codeBlocks) ->
                FileContent(filePath = filePath, codeBlocks = codeBlocks)
            },
            globalComments = globalComments
        )
    }
}
