package swm.virtuoso.reviewservice.adapter.out.persistence

import org.mapstruct.Mapper
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.domian.Discussion

@Mapper
interface DiscussionMapper {

    fun postRequestToDiscussion(postDiscussionRequest: PostDiscussionRequest): Discussion
}
