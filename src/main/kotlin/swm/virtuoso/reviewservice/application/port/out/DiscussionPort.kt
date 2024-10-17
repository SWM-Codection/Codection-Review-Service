package swm.virtuoso.reviewservice.application.port.out

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import swm.virtuoso.reviewservice.domain.Discussion

public interface DiscussionPort {
    fun insertDiscussion(discussion: Discussion): Discussion
    fun updateDiscussion(discussion: Discussion): Discussion
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun findDiscussions(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion>
    fun findDiscussionById(discussionId: Long): Discussion
    fun isNewPinAllowed(repoId: Long): Boolean
    fun pinDiscussion(discussion: Discussion): Discussion
    fun unpinDiscussion(discussion: Discussion): Discussion
    fun findPinnedDiscussions(repoId: Long): List<Discussion>
}
