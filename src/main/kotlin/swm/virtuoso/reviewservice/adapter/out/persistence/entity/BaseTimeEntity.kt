package swm.virtuoso.reviewservice.adapter.out.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import java.time.Instant

@MappedSuperclass
open class BaseTimeEntity(
    @field:Column(name = "created_unix", updatable = false)
    var createdUnix: Long? = null,

    @field:Column(name = "updated_unix")
    var updatedUnix: Long? = null
) {

    @PrePersist
    protected fun onCreate() {
        val now = Instant.now().epochSecond
        createdUnix = now
        updatedUnix = now
    }

    @PreUpdate
    protected fun onUpdate() {
        updatedUnix = Instant.now().epochSecond
    }
}
