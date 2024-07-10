package swm.virtuoso.reviewservice.adapter.out.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class BaseTimeEntity(
    @field:Column(name = "created_at")
    var createdUnix: Long? = null,

    @field:Column(name = "updated_at")
    var updatedUnix: Long? = null
)