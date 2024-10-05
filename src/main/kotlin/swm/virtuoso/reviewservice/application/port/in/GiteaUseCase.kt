package swm.virtuoso.reviewservice.application.port.`in`

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity
import swm.virtuoso.reviewservice.domain.DiscussionAvailability

public interface GiteaUseCase {
    fun getUserById(userId: Long): UserEntity
    fun findUserByUserName(name: String): UserEntity

    fun getRepositories(repoId: Long): RepositoryEntity
    fun setDiscussionAvailable(discussionAvailability: DiscussionAvailability)
}
