package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DeleteDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.MoveDiscussionPinRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCountResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionListResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GiteaUseCase
import swm.virtuoso.reviewservice.common.annotation.SwaggerResponse
import swm.virtuoso.reviewservice.common.exception.ErrorResponse
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionAvailability
import swm.virtuoso.reviewservice.domain.DiscussionSortType

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion", description = "Discussion API")
class DiscussionController(
    private val discussionUseCase: DiscussionUseCase,
    private val giteaUseCase: GiteaUseCase,
    private val gitUseCase: GitUseCase
) {

    @GetMapping("/health-check")
    @ResponseStatus(HttpStatus.OK)
    fun status(request: HttpServletRequest): String {
        return "It's working in Review Service on Port ${request.serverPort}"
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post new discussion", description = "새로운 디스커션 생성")
    @SwaggerResponse("201", "생성 성공", Long::class)
    @SwaggerResponse("404", "레포지토리 혹은 Git Path 정보를 찾을 수 없음", ErrorResponse::class)
    @SwaggerResponse("204", "커밋 기록이 존재하지 않는 레포지토리임", ErrorResponse::class)
    fun postDiscussion(
        @Valid @RequestBody
        request: PostDiscussionRequest
    ): Long {
        val repository = giteaUseCase.getRepositories(request.repoId)

        val discussion = Discussion.fromPostRequest(request)
        discussion.commitHash = gitUseCase.getLastCommitHash(
            ownerName = repository.ownerName!!,
            repoName = repository.lowerName,
            request.branchName
        )

        return discussionUseCase.createDiscussion(
            discussion = discussion,
            codes = request.codes,
            assignees = request.assignees
        ).id!!
    }

    @GetMapping("/{discussionId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion detail", description = "디스커션의 상세 정보 반환")
    @SwaggerResponse("200", "디스커션 반환 성공", DiscussionResponse::class)
    @SwaggerResponse("404", "디스커션 정보를 찾을 수 없음", ErrorResponse::class)
    fun getDiscussion(
        @PathVariable("discussionId") discussionId: Long
    ): DiscussionResponse {
        return DiscussionResponse.fromDiscussion(
            discussion = discussionUseCase.getDiscussion(discussionId),
            assignees = discussionUseCase.getDiscussionAssignees(discussionId)
        )
    }

    @GetMapping("/{repoId}/count")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion count", description = "특정 레포의 디스커션 수 반환")
    @SwaggerResponse("200", "디스커션 수 반환 성공", DiscussionCountResponse::class)
    fun getDiscussionCount(
        @PathVariable repoId: Long
    ): DiscussionCountResponse {
        val totalCount = discussionUseCase.countDiscussion(repoId)
        return DiscussionCountResponse(
            openCount = totalCount.first,
            closeCount = totalCount.second
        )
    }

    @GetMapping("/{repoId}/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion list", description = "특정 레포의 디스커션 목록 반환")
    @SwaggerResponse("200", "디스커션 목록 반환 성공", DiscussionListResponse::class)
    @SwaggerResponse("404", "레포지토리 정보를 찾을 수 없음", ErrorResponse::class)
    fun getDiscussionList(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean,
        @RequestParam page: Int,
        @RequestParam sort: String
    ): DiscussionListResponse {
        val discussionSortType = DiscussionSortType.fromSortString(sort)
        val pageable = PageRequest.of(page, 20, discussionSortType.toSort())
        val discussions = discussionUseCase.getDiscussions(repoId, isClosed, pageable)
        return DiscussionListResponse(
            totalCount = discussions.totalElements,
            discussions = discussions.toList()
        )
    }

    @PostMapping("/available")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Handle discussion availability", description = "디스커션 활성화 모드 설정")
    @SwaggerResponse("201", "활성화 모드 설정 성공")
    fun handleDiscussionAvailable(
        @RequestBody request: DiscussionAvailableRequest
    ) {
        return giteaUseCase.setDiscussionAvailable(
            DiscussionAvailability.fromRequest(request)
        )
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Modify discussion", description = "디스커션 수정 (수정 필요)")
    @SwaggerResponse("204", "수정 성공")
    fun modifyDiscussion(
        @Valid @RequestBody
        request: ModifyDiscussionRequest
    ) {
        // TODO 프론트에서 modify를 호출한 뒤 완료되면 페이지를 리로드 하면서 각 페이지를 가져오는 방식으로 변경

        discussionUseCase.modifyDiscussion(request)
    }

    @GetMapping("/{repoId}/max-pin")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Is pin allow", description = "디스커션 pin 설정 가능 여부")
    @SwaggerResponse(responseStatus = "200", description = "pin 가능 여부 반환", responseType = Boolean::class)
    fun isNewPinAllowed(@PathVariable repoId: Long): Boolean {
        return discussionUseCase.isNewPinAllowed(repoId)
    }

    @PostMapping("/{discussionId}/pin")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Pin or Unpin discussion", description = "디스커션 pin 상태 변경")
    @SwaggerResponse(responseStatus = "204", description = "pin 상태 변경 성공")
    fun pinOrUnpinDiscussion(@PathVariable discussionId: Long) {
        discussionUseCase.pinOrUnpinDiscussion(discussionId)
    }

    @GetMapping("/{repoId}/pin")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Pinned Discussion List", description = "pin 상태인 디스커션만 반환")
    @SwaggerResponse(
        responseStatus = "200",
        description = "pin 등록 된 디스커션 반환",
        responseType = DiscussionListResponse::class
    )
    fun getPinnedDiscussions(@PathVariable repoId: Long): DiscussionListResponse {
        val discussions = discussionUseCase.getPinnedDiscussions(repoId)
        return DiscussionListResponse(
            totalCount = discussions.count().toLong(),
            discussions = discussions
        )
    }

    @DeleteMapping("/{discussionId}/unpin")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Unpin discussion", description = "디스커션 unpin 상태 변경")
    @SwaggerResponse(responseStatus = "204", description = "unpin 변경 성공")
    fun unpinDiscussion(@PathVariable discussionId: Long) {
        discussionUseCase.unpinDiscussion(discussionId)
    }

    @PostMapping("/move-pin")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Move discussion pin", description = "디스커션 pin 순서 변경")
    @SwaggerResponse(responseStatus = "204", description = "pin 순서 변경 성공")
    fun movePinDiscussion(@RequestBody request: MoveDiscussionPinRequest) {
        discussionUseCase.moveDiscussionPin(request.id, request.position)
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete discussion", description = "디스커션 삭제")
    @SwaggerResponse(responseStatus = "204", description = "디스커션 삭제 성공")
    fun deleteDiscussion(@RequestBody request: DeleteDiscussionRequest) {
        discussionUseCase.deleteDiscussions(request.ids)
    }
}
