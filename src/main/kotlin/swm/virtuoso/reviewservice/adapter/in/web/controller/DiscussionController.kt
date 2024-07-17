package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionMapper
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.application.port.`in`.*
import swm.virtuoso.reviewservice.domian.DiscussionComment

@RestController
@RequestMapping("/discussion")
class DiscussionController(
    private val discussionUseCase: DiscussionUseCase,
    private val discussionCommentUseCase: DiscussionCommentUseCase,
    private val giteaUseCase: GiteaUseCase,
    private val gitUseCase: GitUseCase,
    private val discussionCodeUseCase: DiscussionCodeUseCase,
    private val converter: DiscussionMapper
) {

    @GetMapping("/health-check")
    @ResponseStatus(HttpStatus.OK)
    fun status(request: HttpServletRequest): String {
        return "It's working in Review Service on Port ${request.serverPort}"
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun postDiscussion(
        @Valid @RequestBody
        request: PostDiscussionRequest
    ): DiscussionEntity {
        val repository = giteaUseCase.getRepositories(request.repoId)
        val discussion = converter.postDiscussionRequestToDiscussion(request)
        discussion.commitHash = gitUseCase.getLastCommitHash(
            userName = repository.ownerName!!,
            repoName = repository.lowerName
        )
        return discussionUseCase.createDiscussion(discussion)
    }

    @GetMapping("/{repoId}/count")
    @ResponseStatus(HttpStatus.OK)
    fun getDiscussionCount(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean
    ): Int {
        return discussionUseCase.countDiscussion(repoId, isClosed)
    }

    @PostMapping("/available")
    @ResponseStatus(HttpStatus.CREATED)
    fun handleDiscussionAvailable(
        @RequestBody request: DiscussionAvailableRequest
    ) {
        return giteaUseCase.setDiscussionAvailable(
            converter.DiscussionAvailableRequestToDiscussionAvailability(request)
        )
    }

    @GetMapping("/{discussionId}/codes")
    @ResponseStatus(HttpStatus.OK)
    fun getDiscussionContents(
        @PathVariable discussionId: Long
    ): DiscussionContentResponse {
        return discussionCodeUseCase.getDiscussionContents(discussionId)
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    fun postComment(
        @Valid @RequestBody
        request: PostCommentRequest
    ): DiscussionComment {
        return discussionCommentUseCase.createComment(request)
    }


    @PutMapping("")
    @ResponseStatus(HttpStatus.FOUND)
    fun modifyDiscussion(
        @Valid @RequestBody
        request: ModifyDiscussionRequest
    ): ResponseEntity<Void> {

        discussionUseCase.modifyDiscussion(request)
        // 프론트에서 modify를 호출한 뒤 완료되면 페이지를 리로드 하면서 각 페이지를 가져오는 방식으로 해야 할듯
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }


}
