package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.PartResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCodeUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.domian.ExtractedLine
import swm.virtuoso.reviewservice.domian.PathTrie

@RestController
@RequestMapping("/")
class GitController (
    private val gitUseCase: GitUseCase,
    private val discussionCodeUseCase: DiscussionCodeUseCase
) {

    @GetMapping("/{username}/{reponame}/discussions")
    @ResponseStatus(HttpStatus.OK)
    fun listGitFiles(
        @PathVariable("username") userName: String,
        @PathVariable("reponame") repoName: String
    ): PartResponse {
        val files: List<String> = gitUseCase.listFiles(userName, repoName).takeIf { it.isNotEmpty() }
            ?: throw ResponseStatusException(HttpStatus.NO_CONTENT)

        val pathTrie = PathTrie()
        files.forEach { pathTrie.insert(it) }

        return pathTrie.toTree(repoName,"")
    }

    @GetMapping("/{username}/{reponame}/discussions/contents")
    @ResponseStatus(HttpStatus.OK)
    fun getFileContent(
        @PathVariable("username") userName: String,
        @PathVariable("reponame") repoName: String,
        @RequestParam("filepath") filePath: String
    ): List<ExtractedLine> {
        val code = gitUseCase.getFileContent(userName, repoName, filePath)
        return discussionCodeUseCase.extractLinesWithNumbers(code, 1, code.lines().size)
    }
}