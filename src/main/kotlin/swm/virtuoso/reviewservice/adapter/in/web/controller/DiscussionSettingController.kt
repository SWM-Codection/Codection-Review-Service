package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.ModifyAssigneesRequest
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
    @Operation(summary = "Get discussion contents", description = "디스커션 내용 반환")
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
    fun modifyAssignees(
        @Valid @RequestBody
        request: ModifyAssigneesRequest
    ) {
        discussionAssigneesUseCase.modifyAssignees(request.discussionId, request.assignees)
    }

    @PatchMapping("/assign/{discussionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Get discussion contents", description = "디스커션 내용 반환")
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
    fun resetDiscussionDeadline(@PathVariable discussionId: Long, @RequestParam deadline: Long? = null) {
        discussionUseCase.modifyDiscussionDeadline(discussionId, deadline)
    }
}
