package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doNothing
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionUserUseCase

@WebMvcTest(DiscussionUserController::class)
@ActiveProfiles("test")
class DiscussionUserController {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var discussionUserUseCase: DiscussionUserUseCase

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    @DisplayName("유저를 멘션 상태로 변경")
    fun `should mark user as mentioned`() {
        // Given
        val discussionId = 1L
        val userId = 1L

        doNothing().`when`(discussionUserUseCase).markDiscussionAsMention(discussionId, userId)

        // When & Then
        mockMvc.perform(post("/discussion/$discussionId/$userId/mention"))
            .andExpect(status().isNoContent)
    }

    @Test
    @DisplayName("유저를 읽음 상태로 변경")
    fun `should mark user as read`() {
        // Given
        val discussionId = 1L
        val userId = 1L

        doNothing().`when`(discussionUserUseCase).markDiscussionAsRead(discussionId, userId)

        // When & Then
        mockMvc.perform(post("/discussion/$discussionId/$userId/read"))
            .andExpect(status().isNoContent)
    }
}
