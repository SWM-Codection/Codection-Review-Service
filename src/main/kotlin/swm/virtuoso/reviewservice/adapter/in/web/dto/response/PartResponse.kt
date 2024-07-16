package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response

data class PartResponse(
    val partName: String,
    val partType: String,
    val totalPath: String,
    val children: List<PartResponse> = emptyList()
)
