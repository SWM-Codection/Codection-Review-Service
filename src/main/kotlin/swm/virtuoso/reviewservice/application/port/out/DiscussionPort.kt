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
}
