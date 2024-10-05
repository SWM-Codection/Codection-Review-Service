package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
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
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCountResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionListResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.application.port.`in`.GiteaUseCase
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
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "생성 성공",
                content = [Content(schema = Schema(implementation = Long::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "레포지토리 혹은 Git Path 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "204",
                description = "커밋 기록이 존재하지 않는 레포지토리임",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
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
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 반환 성공",
                content = [Content(schema = Schema(implementation = DiscussionResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "디스커션 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
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
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 수 반환 성공",
                content = [Content(schema = Schema(implementation = DiscussionCountResponse::class))]
            )
        ]
    )
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
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 목록 반환 성공",
                content = [Content(schema = Schema(implementation = DiscussionListResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "레포지토리 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
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
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "활성화 모드 설정 성공"
            )
        ]
    )
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
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "204",
                description = "수정 성공"
            )
        ]
    )
    fun modifyDiscussion(
        @Valid @RequestBody
        request: ModifyDiscussionRequest
    ) {
        // TODO 프론트에서 modify를 호출한 뒤 완료되면 페이지를 리로드 하면서 각 페이지를 가져오는 방식으로 변경

        discussionUseCase.modifyDiscussion(request)
    }
}
