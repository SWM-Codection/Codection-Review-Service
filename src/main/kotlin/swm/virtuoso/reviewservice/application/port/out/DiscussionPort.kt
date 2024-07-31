package swm.virtuoso.reviewservice.application.port.out

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionAllContent

public interface DiscussionPort {
    fun insertDiscussion(discussion: Discussion): Discussion
    fun saveDiscussionAllContent(discussionAllContent: DiscussionAllContent): DiscussionEntity
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun findDiscussionList(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion>
    fun findDiscussion(discussionId: Long): Discussion
    fun findDiscussionAllContent(discussionId: Long): DiscussionAllContent
}
