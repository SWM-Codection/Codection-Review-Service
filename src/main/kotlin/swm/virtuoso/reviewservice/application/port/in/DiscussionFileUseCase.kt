package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.DiscussionContentResponse
import swm.virtuoso.reviewservice.domian.ExtractedLine

public interface DiscussionFileUseCase {
    fun getDiscussionContents(discussionId: Long): DiscussionContentResponse
    fun extractLinesWithNumbers(target: String, startLine: Int, endLine: Int): List<ExtractedLine>
}
