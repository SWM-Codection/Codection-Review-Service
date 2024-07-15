package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionEnableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.application.port.`in`.*

@RestController
@RequestMapping("/discussion")
class DiscussionController(
    private val discussionUseCase: DiscussionUseCase,
    private val discussionCommentUseCase: DiscussionCommentUseCase,
    private val gitUseCase: GitUseCase,
    private val giteaUseCase: GiteaUseCase,
    private val discussionCodeUseCase: DiscussionCodeUseCase
) {

    @GetMapping("/health-check")
    @ResponseStatus(HttpStatus.OK)
    fun status(request: HttpServletRequest): String {
        return "It's working in Review Service on Port ${request.serverPort}"
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun postDiscussion(@Valid @RequestBody request: PostDiscussionRequest): DiscussionEntity {
        val repository = giteaUseCase.getRepositories(request.repoId)
        val commitHash = gitUseCase.getLastCommitHash(
            userName = repository.ownerName!!,
            repoName = repository.lowerName
        )
        return discussionUseCase.createDiscussion(request, commitHash)
    }

    @GetMapping("/{repoId}/count")
    @ResponseStatus(HttpStatus.OK)
    fun getDiscussionCount(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean
    ): Int = discussionUseCase.countDiscussion(repoId, isClosed)

    @PostMapping("/available")
    @ResponseStatus(HttpStatus.CREATED)
    fun handleDiscussionAvailable(
        @RequestBody request: DiscussionEnableRequest
    ) = giteaUseCase.setDiscussionAvailable(repoId = request.repoId, enable = request.enable)

    @GetMapping("/{discussionId}/codes")
    @ResponseStatus(HttpStatus.OK)
    fun getDiscussionContents (
        @PathVariable discussionId: Long
    ): DiscussionContentResponse {
        return discussionCodeUseCase.getDiscussionContents(discussionId)
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    fun postComment(@Valid @RequestBody request: PostCommentRequest): DiscussionCommentEntity {
        return discussionCommentUseCase.createComment(request)
    }
}
