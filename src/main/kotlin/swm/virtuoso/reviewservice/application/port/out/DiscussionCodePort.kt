package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domain.DiscussionCode

public interface DiscussionCodePort {
    fun findDiscussionCode(codeId: Long): DiscussionCode
    fun findDiscussionCodes(discussionId: Long): List<DiscussionCode>
    fun deleteDiscussionCodeAllById(id: List<Long>)
    fun insertDiscussionCodes(discussionCodes: List<DiscussionCode>, discussionId: Long)
}
