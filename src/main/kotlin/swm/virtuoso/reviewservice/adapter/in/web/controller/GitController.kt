package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.PartResponse
import swm.virtuoso.reviewservice.application.service.GitService
import swm.virtuoso.reviewservice.domian.PathTrie

@RestController
@RequestMapping("/")
class GitController {
    @Autowired
    private lateinit var gitService: GitService

    @GetMapping("/{username}/{reponame}/discussions")
    @ResponseStatus(HttpStatus.OK)
    fun listGitFiles(
        @PathVariable("username") userName: String,
        @PathVariable("reponame") repoName: String
    ): PartResponse {
        val files: List<String> = gitService.listFiles(userName, repoName).takeIf { it.isNotEmpty() }
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
    ): String {
        val temp = gitService.getFileContent(userName, repoName, filePath)
        return gitService.extractLines(temp,2,6)
    }
}