package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domian.DiscussionCode

public interface DiscussionCodePort {
    fun findDiscussionCode(codeId: Long): DiscussionCode
    fun findDiscussionCodeList(discussionId: Long): List<DiscussionCode>
    fun deleteDiscussionCodeAllById(id: List<Long>)
    fun insertDiscussionCodeList(discussionCodes: List<DiscussionCode>, discussionId: Long)
}
