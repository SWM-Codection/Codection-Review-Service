package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.domain.ExtractedLine

public interface DiscussionCodeUseCase {
    fun getDiscussionContents(discussionId: Long): DiscussionContentResponse
    fun extractLinesWithNumbers(target: String, startLine: Int, endLine: Int): List<ExtractedLine>
}
