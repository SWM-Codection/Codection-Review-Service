package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.PartResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCodeUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.domian.ExtractedLine
import swm.virtuoso.reviewservice.domian.PathTrie

@RestController
@RequestMapping("/")
class GitController(
    private val gitUseCase: GitUseCase,
    private val discussionCodeUseCase: DiscussionCodeUseCase
) {

    @GetMapping("/{username}/{reponame}/discussions")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List Git files", description = "리포지토리의 파일 목록 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "파일 목록 반환 성공",
                content = [Content(schema = Schema(implementation = PartResponse::class))]
            ),
            ApiResponse(
                responseCode = "204", description = "깃 저장소에 파일이 하나도 존재하지 않음"
            )
        ]
    )
    fun listGitFiles(
        @PathVariable("username") userName: String,
        @PathVariable("reponame") repoName: String
    ): PartResponse {
        val files: List<String> = gitUseCase.listFiles(userName, repoName).takeIf { it.isNotEmpty() }
            ?: throw ResponseStatusException(HttpStatus.NO_CONTENT)

        val pathTrie = PathTrie()
        files.forEach { pathTrie.insert(it) }

        return pathTrie.toTree(repoName, "")
    }

    @GetMapping("/{username}/{reponame}/discussions/contents")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get file content", description = "파일 내용 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", description = "파일 내용 반환 성공",
                content = [Content(schema = Schema(implementation = ExtractedLine::class))]
            )
        ]
    )
    fun getFileContent(
        @PathVariable("username") userName: String,
        @PathVariable("reponame") repoName: String,
        @RequestParam("filepath") filePath: String
    ): List<ExtractedLine> {
        val code = gitUseCase.getFileContent(userName, repoName, filePath)
        return discussionCodeUseCase.extractLinesWithNumbers(code, 1, code.lines().size)
    }
}
