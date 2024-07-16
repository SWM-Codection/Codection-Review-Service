package swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.model

data class FileContent(
    val filePath: String,
    val codeBlocks: List<CodeBlock>
)
