package swm.virtuoso.reviewservice.adapter.`in`.web.controller

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
import swm.virtuoso.reviewservice.application.service.DiscussionAssigneesService

@RestController
@RequestMapping("/discussion")
@Tag(name = "Discussion Setting", description = "Discussion Setting API")
class DiscussionSettingController(
    private val discussionAssigneesUseCase: DiscussionAssigneesUseCase,
    private val discussionUseCase: DiscussionUseCase
) {

    @PutMapping("/assignees")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun modifyAssignees(@Valid @RequestBody request: ModifyAssigneesRequest) {
        discussionAssigneesUseCase.modifyAssignees(request.discussionId, request.assignees)
    }

    // TODO 작성 전 Gitea 메소드 참고하기
    @PatchMapping("/assign/{discussionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun resetDiscussionDeadline(@PathVariable discussionId: String, @RequestParam deadline: String) {
    }
}