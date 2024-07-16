package swm.virtuoso.reviewservice.application.service

import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity
import swm.virtuoso.reviewservice.application.port.`in`.GiteaUseCase
import swm.virtuoso.reviewservice.application.port.out.GiteaPort

@Service
class GiteaService(
    private val giteaPort: GiteaPort
) : GiteaUseCase {
    override fun getUserById(userId: Long): UserEntity {
        return giteaPort.findUserById(userId)
    }

    override fun findUserByUserName(name: String): UserEntity {
        return giteaPort.findUserByUserName(name)
    }

    override fun getRepositories(repoId: Long): RepositoryEntity {
        return giteaPort.findRepositoryById(repoId)
    }

    override fun setDiscussionAvailable(repoId: Long, enable: Boolean) {
        giteaPort.saveDiscussionAvailable(repoId, enable)
    }
}