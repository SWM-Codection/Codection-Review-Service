package swm.virtuoso.reviewservice.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort
import swm.virtuoso.reviewservice.application.service.DiscussionCommentService
import swm.virtuoso.reviewservice.common.enums.CommentScopeEnum
import swm.virtuoso.reviewservice.domian.DiscussionComment
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class DiscussionCommentServiceTest {

    @Mock
    lateinit var discussionCommentPort: DiscussionCommentPort

    @InjectMocks
    lateinit var discussionCommentService: DiscussionCommentService

    @Test
    @DisplayName("코멘트 생성")
    fun `createComment should create and return new comment`() {
        // given
        val discussionComment = DiscussionComment(
            id = null,
            discussionId = 1L,
            codeId = null,
            posterId = 1L,
            scope = CommentScopeEnum.GLOBAL,
            startLine = null,
            endLine = null,
            content = "Test comment"
        )

        val savedComment = discussionComment.copy(id = 1L)

        doReturn(savedComment).`when`(discussionCommentPort).saveComment(discussionComment)

        // when
        val result = discussionCommentService.createComment(discussionComment)

        // then
        assertEquals(savedComment, result)
        assertEquals(savedComment.id, result.id)
        assertEquals(discussionComment.content, result.content)
        assertEquals(discussionComment.posterId, result.posterId)
        assertEquals(discussionComment.discussionId, result.discussionId)
        assertEquals(discussionComment.scope, result.scope)
    }
}
