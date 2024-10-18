package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity

interface DiscussionRepository : JpaRepository<DiscussionEntity, Long> {
    fun countByRepoIdAndIsClosed(repoId: Long, isClosed: Boolean): Int
    fun findAllByRepoIdAndIsClosed(repoId: Long, isClosed: Boolean, pageable: Pageable): Page<DiscussionEntity>

    @Query(
        """
        SELECT COUNT(entity)
        FROM DiscussionEntity entity
        WHERE entity.repoId = :repoId
            AND entity.pinOrder > 0
        """
    )
    fun countPinnedDiscussions(@Param("repoId") repoId: Long): Int
    fun findByRepoIdAndPinOrderGreaterThanOrderByPinOrderAsc(repoId: Long, pinOrder: Int): List<DiscussionEntity>

    @Modifying
    @Query(
        """
        UPDATE DiscussionEntity entity
        SET entity.pinOrder = entity.pinOrder - 1
        WHERE entity.repoId = :repoId
            AND entity.pinOrder > :targetPosition
        """
    )
    fun decreasePinOrderAfterTargetPosition(repoId: Long, targetPosition: Int)

    @Modifying
    @Query(
        """
        UPDATE DiscussionEntity entity
        SET entity.pinOrder = entity.pinOrder + 1
        WHERE entity.repoId = :repoId
            AND entity.pinOrder >= :targetPosition
        """
    )
    fun increasePinOrderAfterTargetPosition(repoId: Long, targetPosition: Int)
}
