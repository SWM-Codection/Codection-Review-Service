package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity

public interface DiscussionCodePort {
    fun findDiscussionFiles(discussionId: Long): List<DiscussionCodeEntity>
}