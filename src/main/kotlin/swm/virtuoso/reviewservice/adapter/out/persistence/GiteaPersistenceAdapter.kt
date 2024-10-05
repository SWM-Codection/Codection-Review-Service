package swm.virtuoso.reviewservice.adapter.out.persistence

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionAvailableEntity
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.RepositoryRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.UserRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAvailableRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository
import swm.virtuoso.reviewservice.application.port.out.GiteaPort
import swm.virtuoso.reviewservice.domain.DiscussionAvailability

@Repository
class GiteaPersistenceAdapter(
    private val repositoryRepository: RepositoryRepository,
    private val userRepository: UserRepository,
    private val discussionAvailableRepository: DiscussionAvailableRepository,
    private val discussionRepository: DiscussionRepository
) : GiteaPort {
    override fun findUserById(userId: Long): UserEntity {
        return userRepository.findByIdOrNull(userId)
            ?: throw throw NoSuchElementException("유저 정보를 찾을 수 없습니다.")
    }

    override fun findUserByUserName(username: String): UserEntity {
        return userRepository.findByName(username)
            ?: throw NoSuchElementException("유저 정보를 찾을 수 없습니다.")
    }

    override fun findRepositoryById(repoId: Long): RepositoryEntity {
        return repositoryRepository.findByIdOrNull(repoId)
            ?: throw NoSuchElementException("레포지토리 정보를 찾을 수 없습니다.")
    }

    override fun switchDiscussionAvailable(discussionAvailability: DiscussionAvailability) {
        discussionAvailability.id = discussionAvailableRepository.findByRepoId(discussionAvailability.repoId)?.id
        discussionAvailableRepository.save(
            DiscussionAvailableEntity.fromDiscussionAvailability(discussionAvailability)
        )
    }

    override fun findRepositoryByDiscussionId(discussionId: Long): RepositoryEntity {
        val repoId = discussionRepository.findByIdOrNull(discussionId)?.repoId
            ?: throw NoSuchElementException("Discussion이 존재하지 않습니다. $discussionId")

        return repositoryRepository.findByIdOrNull(repoId)
            ?: throw NoSuchElementException("Repository가 존재하지 않습니다.: $repoId")
    }
}
