package swm.virtuoso.reviewservice.application.port.`in`

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.ModifyDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.domain.Discussion
import swm.virtuoso.reviewservice.domain.DiscussionCode

public interface DiscussionUseCase {
    fun createDiscussion(discussion: Discussion, codes: List<DiscussionCode>, assignees: List<Long>?): Discussion
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun getDiscussionList(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<Discussion>
    fun modifyDiscussion(modifyDiscussionRequest: ModifyDiscussionRequest): DiscussionEntity
}
