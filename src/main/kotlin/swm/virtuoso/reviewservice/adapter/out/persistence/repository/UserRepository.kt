package swm.virtuoso.reviewservice.adapter.out.persistence.repository

import org.springframework.data.jpa.repository.JpaRepository
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity

interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByName(username: String): UserEntity?
}
