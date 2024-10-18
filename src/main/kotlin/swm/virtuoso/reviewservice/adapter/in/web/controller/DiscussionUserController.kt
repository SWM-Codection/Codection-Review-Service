package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUserUseCase
import swm.virtuoso.reviewservice.common.annotation.SwaggerResponse
import swm.virtuoso.reviewservice.common.exception.ErrorResponse

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion User", description = "Discussion User API")
class DiscussionUserController(
    private val discussionUserUseCase: DiscussionUserUseCase
) {

    @PostMapping("/{discussionId}/{userId}/mention")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "mark user status as mention", description = "유저를 멘션 상태로 변경")
    @SwaggerResponse("204", "멘션 상태 변경 성공", Long::class)
    @SwaggerResponse("404", "디스커션 혹은 유저 정보를 찾을 수 없음", ErrorResponse::class)
    fun mentionUser(
        @PathVariable discussionId: Long,
        @PathVariable userId: Long
    ) {
        discussionUserUseCase.markDiscussionAsMention(discussionId, userId)
    }

    @PostMapping("/{discussionId}/{userId}/read")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "mark user status as read", description = "유저를 읽음 상태로 변경")
    @SwaggerResponse("204", "읽음 상태 변경 성공", Long::class)
    @SwaggerResponse("404", "디스커션 혹은 유저 정보를 찾을 수 없음", ErrorResponse::class)
    fun markUserReadStatus(
        @PathVariable discussionId: Long,
        @PathVariable userId: Long
    ) {
        discussionUserUseCase.markDiscussionAsRead(discussionId, userId)
    }
}
