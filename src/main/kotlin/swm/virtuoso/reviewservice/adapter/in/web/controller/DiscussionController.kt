package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
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
import swm.virtuoso.reviewservice.common.exception.ErrorResponse
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionAvailability
import swm.virtuoso.reviewservice.domian.DiscussionComment
import swm.virtuoso.reviewservice.domian.ExtractedLine

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion", description = "Discussion API")
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
    @Operation(summary = "Post new discussion", description = "새로운 디스커션 생성")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "생성 성공",
                content = [Content(schema = Schema(implementation = Discussion::class))]
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
            userName = repository.ownerName!!,
            repoName = repository.lowerName
        )

        return discussionUseCase.createDiscussion(discussion, request.codes).id!!
    }

    @GetMapping("/{repoId}/count")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion count", description = "특정 레포의 디스커션 수 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 수 반환 성공",
                content = [Content(schema = Schema(type = "integer"))]
            )
        ]
    )
    fun getDiscussionCount(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean
    ): Int {
        return discussionUseCase.countDiscussion(repoId, isClosed)
    }

    @GetMapping("/{repoId}/list")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion list", description = "특정 레포의 디스커션 목록 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 목록 반환 성공",
                content = [Content(schema = Schema(implementation = Discussion::class, type = "array"))]
            )
        ]
    )
    fun getDiscussionList(
        @PathVariable repoId: Long,
        @RequestParam isClosed: Boolean
    ): List<Discussion> {
        return discussionUseCase.getDiscussionList(repoId, isClosed)
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

    @GetMapping("/{discussionId}/contents")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion contents", description = "디스커션 내용 반환")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 내용 반환 성공",
                content = [Content(schema = Schema(implementation = DiscussionContentResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "레포지토리 혹은 디스커션 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "지정되었던 파일의 범위를 넘어선 범위임",
                content = [Content(schema = Schema(implementation = ExtractedLine::class, type = "array"))]
            )
        ]
    )
    fun getDiscussionContents(
        @PathVariable discussionId: Long
    ): DiscussionContentResponse {
        return discussionCodeUseCase.getDiscussionContents(discussionId)
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post comment", description = "새로운 코멘트 작성")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "코멘트 작성 성공",
                content = [Content(schema = Schema(implementation = DiscussionComment::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "레포지토리 혹은 Git Path 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "레포지토리 정보와 디스커션 정보가 일치하지 않음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
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
        discussionUseCase.modifyDiscussion(request)
        // TODO 프론트에서 modify를 호출한 뒤 완료되면 페이지를 리로드 하면서 각 페이지를 가져오는 방식으로 변경
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
