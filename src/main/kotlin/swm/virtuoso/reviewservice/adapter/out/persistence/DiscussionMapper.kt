package swm.virtuoso.reviewservice.adapter.out.persistence

import org.mapstruct.Mapper
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.DiscussionAvailableRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostCommentRequest
import swm.virtuoso.reviewservice.adapter.`in`.web.dto.request.PostDiscussionRequest
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAssigneesEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAvailableEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionReactionEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity
import swm.virtuoso.reviewservice.domian.Discussion
import swm.virtuoso.reviewservice.domian.DiscussionAssignee
import swm.virtuoso.reviewservice.domian.DiscussionAvailability
import swm.virtuoso.reviewservice.domian.DiscussionCode
import swm.virtuoso.reviewservice.domian.DiscussionComment
import swm.virtuoso.reviewservice.domian.DiscussionReaction
import swm.virtuoso.reviewservice.domian.DiscussionUser

@Mapper
interface DiscussionMapper {
    fun postDiscussionRequestToDiscussion(postDiscussionRequest: PostDiscussionRequest): Discussion
    fun postCommentRequestToDiscussionComment(postCommentRequest: PostCommentRequest): DiscussionComment
    fun DiscussionAvailableRequestToDiscussionAvailability(request: DiscussionAvailableRequest): DiscussionAvailability

    // Entity to Domain
    fun discussionEntityToDiscussion(discussionEntity: DiscussionEntity): Discussion
    fun discussionCommentEntityToDiscussionComment(discussionCommentEntity: DiscussionCommentEntity): DiscussionComment
    fun discussionCodeEntityToDiscussionCode(discussionCodeEntity: DiscussionCodeEntity): DiscussionCode
    fun discussionAssigneesEntityToDiscussionAssignee(entity: DiscussionAssigneesEntity): DiscussionAssignee
    fun discussionAvailableEntityToDiscussionAvailability(entity: DiscussionAvailableEntity): DiscussionAvailability
    fun discussionReactionEntityToDiscussionReaction(entity: DiscussionReactionEntity): DiscussionReaction
    fun discussionUserEntityToDiscussionUser(entity: DiscussionUserEntity): DiscussionUser

    // Domain to Entity
    fun discussionToDiscussionEntity(discussion: Discussion): DiscussionEntity
    fun discussionCommentToDiscussionCommentEntity(discussionComment: DiscussionComment): DiscussionCommentEntity
    fun discussionCodeToDiscussionCodeEntity(discussionCode: DiscussionCode): DiscussionCodeEntity
    fun discussionAssigneeToDiscussionAssigneesEntity(discussionAssignee: DiscussionAssignee): DiscussionAssigneesEntity
    fun discussionAvailabilityToDiscussionAvailableEntity(discussionAvailability: DiscussionAvailability): DiscussionAvailableEntity
    fun discussionReactionToDiscussionReactionEntity(discussionReaction: DiscussionReaction): DiscussionReactionEntity
    fun discussionUserToDiscussionUserEntity(discussionUser: DiscussionUser): DiscussionUserEntity
}
