package swm.virtuoso.reviewservice.adapter.`in`.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostReactionRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model.FileContent
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionFileUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionReactionUseCase
import swm.virtuoso.reviewservice.application.port.`in`.DiscussionWatchUseCase
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnum
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnumDeserializer
import swm.virtuoso.reviewservice.common.enums.ReactionTypeEnumSerializer
import swm.virtuoso.reviewservice.domain.DiscussionReaction
import kotlin.test.BeforeTest

@WebMvcTest(DiscussionDetailController::class)
@ActiveProfiles("test")
class DiscussionDetailControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var discussionWatchUseCase: DiscussionWatchUseCase

    @MockBean
    private lateinit var discussionFileUseCase: DiscussionFileUseCase

    @MockBean
    private lateinit var discussionReactionUseCase: DiscussionReactionUseCase

    @MockBean
    private lateinit var discussionWatchUseCase: DiscussionWatchUseCase

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @BeforeTest
    fun setup() {
        objectMapper.registerModules(
            SimpleModule().apply {
                addSerializer(ReactionTypeEnum::class.java, ReactionTypeEnumSerializer())
                addDeserializer(ReactionTypeEnum::class.java, ReactionTypeEnumDeserializer())
            }
        )
    }

    @Test
    @DisplayName("디스커션 컨텐츠(파일, 코드, 코멘트) 반환")
    fun `should get discussion contents`() {
        // Given
        val discussionId = 1L
        val response = DiscussionContentResponse(
            discussionId = discussionId,
            contents = listOf(FileContent(filePath = "path/to/file", codeBlocks = listOf())),
            globalComments = emptyList(),
            globalReactions = emptyList()
        )

        whenever(discussionFileUseCase.getDiscussionContents(discussionId)).thenReturn(response)

        // When & Then
        mockMvc.perform(get("/discussion/$discussionId/contents"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.discussionId").value(discussionId))
    }

    @Test
    @DisplayName("게시글 혹은 코멘트에 반응 추가")
    fun `should give reaction`() {
        // Given
        val reactionId = 1L
        val request = PostReactionRequest(
            type = ReactionTypeEnum.LAUGH,
            discussionId = 1L,
            commentId = null,
            userId = 1L
        )

        val discussionReaction = DiscussionReaction(
            id = reactionId,
            type = ReactionTypeEnum.LAUGH,
            discussionId = 1L,
            commentId = null,
            userId = 1L
        )

        whenever(discussionReactionUseCase.addDiscussionReaction(any())).thenReturn(discussionReaction)
        val jsonValue = objectMapper.writeValueAsString(request)
        // When & Then
        mockMvc.perform(
            post("/discussion/reaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonValue)
        )
            .andExpect(status().isCreated)
            .andExpect(content().string(reactionId.toString()))
    }
}
