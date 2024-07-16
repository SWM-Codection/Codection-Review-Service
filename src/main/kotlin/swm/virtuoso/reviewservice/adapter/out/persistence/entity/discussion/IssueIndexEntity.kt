package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "issue_index")
data class IssueIndexEntity(
    @field:Id
    @field:Column(name = "group_id", nullable = false)
    val groupId: Long,

    @field:Column(name = "max_index")
    val maxIndex: Long
)
