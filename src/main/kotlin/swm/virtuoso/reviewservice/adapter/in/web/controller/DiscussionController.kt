package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCodeUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GiteaUseCase
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionAvailability
import swm.virtuoso.reviewservice.domian.DiscussionComment

@RestController
@RequestMapping("/discussion")
class DiscussionController(
    private val discussionUseCase: DiscussionUseCase,
    private val discussionCommentUseCase: DiscussionCommentUseCase,
    private val giteaUseCase: GiteaUseCase,
    private val gitUseCase: GitUseCase,
    private val discussionCodeUseCase: DiscussionCodeUseCase
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
    ): Long {
        val repository = giteaUseCase.getRepositories(request.repoId)

        val discussion = Discussion.fromPostRequest(request)
        discussion.commitHash = gitUseCase.getLastCommitHash(
            userName = repository.ownerName!!,
            repoName = repository.lowerName
        )

        return discussionUseCase.createDiscussion(discussion, request.codes).id!!
    }

    @GetMapping("/{repoId}/count")
    @ResponseStatus(HttpStatus.OK)
    fun getDiscussionCount(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean
    ): Int {
        return discussionUseCase.countDiscussion(repoId, isClosed)
    }

    @GetMapping("/{repoId}/list")
    @ResponseStatus(HttpStatus.OK)
    fun getDiscussionList(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean
    ): List<Discussion> {
        return discussionUseCase.getDiscussionList(repoId, isClosed)
    }

    @PostMapping("/available")
    @ResponseStatus(HttpStatus.CREATED)
    fun handleDiscussionAvailable(
        @RequestBody request: DiscussionAvailableRequest
    ) {
        return giteaUseCase.setDiscussionAvailable(
            DiscussionAvailability.fromRequest(request)
        )
    }

    @GetMapping("/{discussionId}/contents")
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
    ): Long {
        return discussionCommentUseCase.createComment(
            DiscussionComment.fromPostRequest(request)
        ).id!!
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun modifyDiscussion(
        @Valid @RequestBody
        request: ModifyDiscussionRequest
    ) {
        discussionUseCase.modifyDiscussion(request)
        // 프론트에서 modify를 호출한 뒤 완료되면 페이지를 리로드 하면서 각 페이지를 가져오는 방식으로 해야 할듯
    }
}
