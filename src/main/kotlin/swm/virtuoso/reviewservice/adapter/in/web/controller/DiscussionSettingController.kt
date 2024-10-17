package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ChangeDiscussionWatchRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.UpdateAssigneeRequest
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionAssigneesUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import swm.virtuoso.reviewservice.common.exception.ErrorResponse

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion Setting", description = "Discussion Setting API")
class DiscussionSettingController(
    private val discussionAssigneesUseCase: DiscussionAssigneesUseCase,
    private val discussionUseCase: DiscussionUseCase
) {

    @PutMapping("/assignees")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Update Discussion Assignees", description = "디스커션 담당자 변경")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 담당자 목록 수정"
            ),
            ApiResponse(
                responseCode = "404",
                description = "디스커션 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun updateAssignee(
        @Valid @RequestBody
        request: UpdateAssigneeRequest
    ) {
        discussionAssigneesUseCase.changeAssignee(request.discussionId, request.assigneeId)
    }

    @DeleteMapping("/assignees/{discussionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Clear Discussion Assignees", description = "디스커션 담당자 초기화")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "디스커션 담당자 초기화"
            )
        ]
    )
    fun clearAssignee(
        @PathVariable discussionId: Long
    ) {
        discussionAssigneesUseCase.clearAssigneesByDiscussionId(discussionId)
    }

    @PatchMapping("/deadline/{discussionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Reset Discussion Deadline", description = "디스커션 마감일 재지정")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "마감일 재설정 성공"
            ),
            ApiResponse(
                responseCode = "404",
                description = "디스커션 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun resetDiscussionDeadline(@PathVariable discussionId: Long, @RequestParam deadline: String = "0") {
        discussionUseCase.modifyDiscussionDeadline(discussionId, deadline.toLong())
    }

    @PatchMapping("/state/{discussionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Update Discussion Closed State", description = "디스커컨 닫힘 여부 재설정")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "닫힘 상태 변경 성공"
            ),
            ApiResponse(
                responseCode = "404",
                description = "디스커션 정보를 찾을 수 없음",
                content = [Content(schema = Schema(implementation = ErrorResponse::class))]
            )
        ]
    )
    fun setReviewClosedState(@PathVariable discussionId: Long, @RequestParam isClosed: Boolean) {
        discussionUseCase.setDiscussionIsClosed(discussionId, isClosed)
    }

    /*@PutMapping("/{discussionId}/pin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "change pin status", description = "디스커션 게시글 pin")
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "202",
                description = "상태 변경 성공",
                content = [Content(schema = Schema(implementation = Boolean::class))]
            )
        ]
    )
    fun changeWatch(@PathVariable discussionId: Long): Boolean {
    }*/
}
