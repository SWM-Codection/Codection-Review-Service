package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
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
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DeleteCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionCommentResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionFileUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionReactionUseCase
import swm.virtuoso.reviewservice.common.annotation.SwaggerResponse
import swm.virtuoso.reviewservice.common.exception.ErrorResponse
import swm.virtuoso.reviewservice.domain.DiscussionComment

// TODO 유저 검증 로직 넣기

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion Comment", description = "Discussion Comment API")
class DiscussionCommentController(
    val discussionCommentUseCase: DiscussionCommentUseCase,
    val discussionFileUseCase: DiscussionFileUseCase,
    val discussionReactionUseCase: DiscussionReactionUseCase
) {

    @GetMapping("/comment")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get comment By id", description = "id를 통해 코멘트 가져오기")
    @SwaggerResponse("200", "코멘트 가져오기 성공", DiscussionCommentResponse::class)
    @SwaggerResponse("404", "해당하는 id 를 가진 디스커션 코멘트가 없음.", ErrorResponse::class)
    fun getComment(
        @Valid
        @RequestParam(value = "id")
        id: Long
    ): DiscussionCommentResponse {
        val discussionComment = discussionCommentUseCase.getCommentById(id)
        val discussionCommentReactions = discussionReactionUseCase.getDiscussionCommentReactions(id)
        if (discussionComment.codeId != null) {
            val filePath = discussionFileUseCase.getDiscussionFilePathByCommentId(discussionComment.codeId)
            return DiscussionCommentResponse.fromDiscussionComment(discussionComment, discussionCommentReactions, filePath)
        }
        return DiscussionCommentResponse.fromDiscussionComment(discussionComment, discussionCommentReactions)
    }

    @GetMapping("/comments/{codeId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get comment by codeId")
    @SwaggerResponse("200", "코멘트 가져오기 성공", DiscussionCommentResponse::class)
    fun getCommentByCodeId(@PathVariable codeId: Long): List<DiscussionCommentResponse> {
        return discussionCommentUseCase.getCommentsByCodeId(codeId).map {
            val reactions = discussionReactionUseCase.getDiscussionCommentReactions(it.id!!)
            DiscussionCommentResponse.fromDiscussionComment(it, reactions)
        }
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post comment", description = "새로운 코멘트 작성")
    @SwaggerResponse("201", "코멘트 작성 성공", Long::class)
    @SwaggerResponse("404", "레포지토리 혹은 GitPath 정보를 찾을 수 없음", ErrorResponse::class)
    @SwaggerResponse("400", "레포지토리 정보와 디스커션 정보가 일치하지 않음", ErrorResponse::class)
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
    @SwaggerResponse("201", "코멘트 수정 성공")
    @SwaggerResponse("404", "디스커션 정보 혹은 코드 블록의 정보를 찾을 수 없음.", ErrorResponse::class)
    @SwaggerResponse("400", "레포지토리 정보와 디스커션 정보가 일치하지 않음", ErrorResponse::class)
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
    @SwaggerResponse("201", "코멘트 삭제 성공")
    @SwaggerResponse("404", "레포지토리 혹은 Git Path 정보를 찾을 수 없음", ErrorResponse::class)
    fun deleteComment(
        @Valid @RequestBody
        request: DeleteCommentRequest
    ) {
        discussionCommentUseCase.deleteComment(
            request.discussionCommentId
        )
    }
}
