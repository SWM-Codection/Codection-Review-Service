package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.mockito.kotlin.doNothing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.UpdateAssigneeRequest
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionAssigneesUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUseCase
import kotlin.test.Test

@WebMvcTest(DiscussionSettingController::class)
@ActiveProfiles("test")
class DiscussionSettingControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var discussionAssigneesUseCase: DiscussionAssigneesUseCase

    @MockBean
    private lateinit var discussionUseCase: DiscussionUseCase

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    @DisplayName("담당자를 수정")
    fun `should modify assignees`() {
        // Given
        val request = UpdateAssigneeRequest(discussionId = 1L, assigneeId = 1L)

        doNothing().`when`(discussionAssigneesUseCase).changeAssignee(request.discussionId, request.assigneeId)

        // When & Then
        mockMvc.perform(
            put("/discussion/assignees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isNoContent)
    }

    @Test
    @DisplayName("디스커션 데드라인을 리셋")
    fun `should reset discussion deadline`() {
        // Given
        val discussionId = 1L
        val deadline = 1620000000L

        doNothing().`when`(discussionUseCase).modifyDiscussionDeadline(discussionId, deadline)

        // When & Then
        mockMvc.perform(
            patch("/discussion/deadline/$discussionId")
                .param("deadline", deadline.toString())
        )
            .andExpect(status().isNoContent)
    }
}
