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

    @GetMapping("/{ownername}/{reponame}/{branchName}/discussions")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List Git files", description = "리포지토리의 파일 목록 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "파일 목록 반환 성공",
                content = [Content(schema = Schema(implementation = PartResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "깃 저장소에 파일이 하나도 존재하지 않음"
            )
        ]
    )
    fun listGitFiles(
        @PathVariable("ownername") ownerName: String,
        @PathVariable("reponame") repoName: String,
        @PathVariable("branchName") branchName: String
    ): PartResponse {
        val files: List<String> = gitUseCase.listFiles(ownerName, repoName, branchName).takeIf { it.isNotEmpty() }
            ?: throw NoSuchElementException("지정 된 깃 저장소에 파일이 존재하지 않습니다.")

        val pathTrie = PathTrie()
        files.forEach { pathTrie.insert(it) }

        return pathTrie.toTree(repoName, "")
    }

    @GetMapping("/{ownername}/{reponame}/{branchname}/discussions/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List Git files by list", description = "리포지토리의 파일 목록 리스트 형태로 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "파일 목록 반환 성공",
                content = [Content(schema = Schema(implementation = List::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "깃 저장소에 파일이 하나도 존재하지 않음"
            )
        ]
    )
    fun listGitFiles2(
        @PathVariable("ownername") ownerName: String,
        @PathVariable("reponame") repoName: String,
        @PathVariable("branchname") branchName: String
    ): List<String> {
        return gitUseCase.listFiles(ownerName, repoName, branchName).takeIf { it.isNotEmpty() }
            ?: throw NoSuchElementException("지정 된 깃 저장소에 파일이 존재하지 않습니다.")
    }

    @GetMapping("/{ownername}/{reponame}/{branchname}/discussions/contents")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get file content", description = "파일 내용 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "파일 내용 반환 성공",
                content = [Content(schema = Schema(implementation = ExtractedLine::class))]
            )
        ]
    )
    fun getFileContent(
        @PathVariable("ownername") ownerName: String,
        @PathVariable("reponame") repoName: String,
        @PathVariable("branchname") branchName: String,
        @RequestParam("filepath") filePath: String
    ): List<ExtractedLine> {
        val code = gitUseCase.getFileContent(ownerName, repoName, branchName, filePath)
        return discussionCodeUseCase.extractLinesWithNumbers(code, 1, code.lines().size)
    }
}
