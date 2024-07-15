package swm.virtuoso.reviewservice.application.port.out

import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity

public interface GiteaPort {
    fun findUserById(userId: Long): UserEntity
    fun findUserByUserName(username: String): UserEntity
    fun findRepositoryById(repoId: Long): RepositoryEntity
    fun saveDiscussionAvailable(repoId: Long, enable: Boolean)
    fun findRepositoryByDiscussionId(discussionId: Long): RepositoryEntity
}