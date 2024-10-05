package swm.virtuoso.reviewservice.application.port.`in`

public interface GitUseCase {
    fun listFiles(ownerName: String, repoName: String, branchName: String): List<String>
    fun getFileContent(ownerName: String, repoName: String, branchName: String, filePath: String): String
    fun getFileContentByHashCode(ownerName: String, repoName: String, hashCode: String, filePath: String): String
    fun getLastCommitHash(ownerName: String, repoName: String, branchName: String): String
}
