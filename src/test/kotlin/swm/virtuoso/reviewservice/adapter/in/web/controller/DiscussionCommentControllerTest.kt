package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionCommentUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionFileUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionReactionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionWatchUseCase
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.domain.DiscussionComment

@WebMvcTest(DiscussionCommentController::class)
@ActiveProfiles("test")
class DiscussionCommentControllerTest {

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var discussionCommentUseCase: DiscussionCommentUseCase

    @MockBean
    private lateinit var discussionReactionUseCase: DiscussionReactionUseCase

    @MockBean
    private lateinit var discussionFileUseCase: DiscussionFileUseCase

    @MockBean
    private lateinit var discussionWatchUseCase: DiscussionWatchUseCase

    @Test
    @DisplayName("코멘트 등록")
    fun `should post comment`() {
        // Given
        val request = PostCommentRequest(
            discussionId = 1L,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        val savedComment = DiscussionComment(
            id = 1L,
            discussionId = 1L,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        whenever(discussionCommentUseCase.createComment(any())).thenReturn(savedComment)

        // When & Then
        mockMvc.perform(
            post("/discussion/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$").value(savedComment.id))
    }
}
