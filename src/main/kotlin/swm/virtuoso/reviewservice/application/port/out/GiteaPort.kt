package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity
import swm.virtuoso.reviewservice.domian.DiscussionAvailability

public interface GiteaPort {
    fun findUserById(userId: Long): UserEntity
    fun findUserByUserName(username: String): UserEntity

    fun findRepositoryById(repoId: Long): RepositoryEntity
    fun findRepositoryByDiscussionId(discussionId: Long): RepositoryEntity

    fun switchDiscussionAvailable(discussionAvailability: DiscussionAvailability)
}
