package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity

public interface DiscussionPort {
    fun saveDiscussion(createDiscussionRequest: PostDiscussionRequest, lastCommitHash: String?): DiscussionEntity
    fun countDiscussion(repoId: Long, isClosed: Boolean): Int
    fun findDiscussionList(repoId: Long, isClosed: Boolean): List<DiscussionEntity>
}
