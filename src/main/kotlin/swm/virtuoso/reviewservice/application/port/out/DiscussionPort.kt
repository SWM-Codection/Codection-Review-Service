package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.domian.Discussion

public interface DiscussionPort {
    fun saveDiscussion(discussion: Discussion): DiscussionEntity
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun findDiscussionList(repoId: Long, isClosed: Boolean): List<DiscussionEntity>
    fun findDiscussion(discussionId: Long): Discussion
}
