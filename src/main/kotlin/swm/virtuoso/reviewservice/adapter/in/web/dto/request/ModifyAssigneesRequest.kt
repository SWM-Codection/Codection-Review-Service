package swm.virtuoso.reviewservice.adapter.`in`.web.dto.request

data class ModifyAssigneesRequest (
    val discussionId: Long,
    val assignees: List<Long>
)