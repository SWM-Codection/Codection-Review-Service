package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.domian.DiscussionCode

public interface DiscussionCodePort {
    fun findDiscussionCodes(discussionId: Long): List<DiscussionCode>
    fun deleteDiscussionCodeAllById(id: List<Long>)
}
