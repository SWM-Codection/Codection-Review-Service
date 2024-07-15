package swm.virtuoso.reviewservice.application.port.`in`

public interface GitUseCase {
    fun listFiles(userName: String, repoName: String): List<String>
    fun getFileContent(ownerName: String, repoName: String, filePath: String): String
    fun getLastCommitHash(userName: String, repoName: String): String?
}