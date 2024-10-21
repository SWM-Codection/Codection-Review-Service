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
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ChangeDiscussionWatchRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DeleteReactionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostReactionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionWatchResponse
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionFileUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionReactionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionWatchUseCase
import swm.virtuoso.reviewservice.common.annotation.SwaggerResponse
import swm.virtuoso.reviewservice.common.exception.ErrorResponse
import swm.virtuoso.reviewservice.domain.DiscussionReaction

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion Detail", description = "Discussion Detail API")
class DiscussionDetailController(
    private val discussionFileUseCase: DiscussionFileUseCase,
    private val discussionReactionUseCase: DiscussionReactionUseCase,
    private val discussionWatchUseCase: DiscussionWatchUseCase
) {

    @GetMapping("/{discussionId}/contents")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get discussion contents", description = "디스커션 내용 반환")
    @SwaggerResponse("200", "디스커션 내용 반환 성공", DiscussionContentResponse::class)
    @SwaggerResponse("404", "레포지토리 혹은 디스커션 정보를 찾을 수 없음", ErrorResponse::class)
    fun getDiscussionContents(
        @PathVariable discussionId: Long
    ): DiscussionContentResponse {
        return discussionFileUseCase.getDiscussionContents(discussionId)
    }

    @GetMapping("/reaction")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "give reaction", description = "게시글 혹은 코멘트에 반응 추가")
    @SwaggerResponse(responseStatus = "204", description = "반응 추가 성공", Long::class)
    @SwaggerResponse(responseStatus = "404", description = "디스커션 혹은 코멘트 정보를 찾을 수 없음", ErrorResponse::class)
    fun getReaction(
        @RequestParam commentId: Long
    ): List<DiscussionReaction> {
        return discussionReactionUseCase.getDiscussionCommentReactions(commentId)
    }

    @PostMapping("/reaction")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "give reaction", description = "게시글 혹은 코멘트에 반응 추가")
    @SwaggerResponse("204", "반응 추가 성공", Long::class)
    @SwaggerResponse("404", "디스커션 혹은 코멘트 정보를 찾을 수 없음", ErrorResponse::class)
    fun giveReaction(
        @Valid @RequestBody
        request: PostReactionRequest
    ): Long {
        val discussionReaction = DiscussionReaction.fromReactionRequest(request)
        return discussionReactionUseCase.addDiscussionReaction(discussionReaction).id!!
    }

    @DeleteMapping("/reaction")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "remove reaction", description = "게시글 혹은 코멘트에 반응 제거")
    @SwaggerResponse("200", "반응 제거 성공", Unit::class)
    @SwaggerResponse("404", "디스커션 혹은 코멘트 정보를 찾을 수 없음", ErrorResponse::class)
    fun removeReaction(
        @Valid @RequestBody
        request: DeleteReactionRequest
    ) {
        val discussionReaction = DiscussionReaction.fromReactionRequest(request)
        discussionReactionUseCase.removeDiscussionReaction(discussionReaction)
    }

    @PutMapping("/watch")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "change watch status", description = "디스커션 게시글 구독")
    @SwaggerResponse("202", "상태 변경 성공", Boolean::class)
    fun changeWatch(
        @Valid @RequestBody
        request: ChangeDiscussionWatchRequest
    ): Boolean {
        if (request.id == -1L) {
            return discussionWatchUseCase.createWatchStatus(request)
        }

        return discussionWatchUseCase.changeWatchStatus(request)
    }

    @GetMapping("/watch")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "get watch", description = "유저의 디스커션에 대한 구독 상태 확인")
    @SwaggerResponse("200", "확인 성공", DiscussionWatchResponse::class)
    fun getWatch(
        @RequestParam discussionId: Long,
        @RequestParam userId: Long
    ): DiscussionWatchResponse {
        return discussionWatchUseCase.getDiscussionWatch(userId, discussionId)
    }
}
