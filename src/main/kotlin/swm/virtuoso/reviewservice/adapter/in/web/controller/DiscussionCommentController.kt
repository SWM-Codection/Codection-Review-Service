package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.service.DiscussionCommentService
import swm.virtuoso.reviewservice.common.exception.ErrorResponse
import swm.virtuoso.reviewservice.domain.DiscussionComment

// TODO 유저 검증 로직 넣기

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion Comment", description = "Discussion Comment API")
class DiscussionCommentController(val discussionCommentUseCase: DiscussionCommentUseCase) {

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post comment", description = "새로운 코멘트 작성")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "코멘트 작성 성공",
                content = [Content(schema = Schema(implementation = Long::class))]
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

    @PutMapping("/comment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "modify comment", description = "코멘트 수정")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "코멘트 수정 성공",
            ),
            ApiResponse(
                responseCode = "404",
                description = "디스커션 정보 혹은 코드 블록의 정보를 찾을 수 없음.",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "레포지토리 정보와 디스커션 정보가 일치하지 않음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun modifyComment(
        @Valid @RequestBody
        request: ModifyCommentRequest
    ) {
        discussionCommentUseCase.modifyComment(
            DiscussionComment.fromModifyRequest(request)
        )
    }



    @DeleteMapping("/comment")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "modify comment", description = "코멘트 삭제")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "201",
                description = "코멘트 삭제 성공",
            ),
            ApiResponse(
                responseCode = "404",
                description = "레포지토리 혹은 Git Path 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun deleteComment(
        @Valid @RequestBody
        request: ModifyCommentRequest
    ) {
        discussionCommentUseCase.deleteComment(
            request.discussionCommentId
        )
    }
}