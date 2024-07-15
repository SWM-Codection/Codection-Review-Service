package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion

import jakarta.persistence.*
import swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity

@Entity
@Table(name = "issue_index")
data class IssueIndexEntity (
    @field:Id
    @field:Column(name = "group_id", nullable = false)
    val groupId: Long,

    @field:Column(name = "max_index")
    val maxIndex: Long
)