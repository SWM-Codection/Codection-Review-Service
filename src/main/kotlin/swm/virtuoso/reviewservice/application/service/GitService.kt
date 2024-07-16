package swm.virtuoso.reviewservice.application.service

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.ObjectId
import org.eclipse.jgit.lib.RepositoryBuilder
import org.eclipse.jgit.revwalk.RevWalk
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.eclipse.jgit.treewalk.TreeWalk
import org.eclipse.jgit.treewalk.filter.PathFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import swm.virtuoso.reviewservice.application.port.`in`.GitUseCase
import swm.virtuoso.reviewservice.common.exception.NoSuchGitPathException
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

@Service
class GitService(
    @Value("\${git.baseUrl}") private val baseUrl: String
) : GitUseCase {

    // TODO 개인 레포는 Owner/레포이름에 저장되고 조직 레포는 조직 밑에 저장되는 현재는 개인 레포에 대해서만 경로가 설정됨 수정 해야 함
    private fun getAbsoluteGitDirPath(userName: String, repoName: String): String {
        return "$baseUrl/$userName/$repoName.git"
    }

    private fun checkValidGitRepository(gitDir: File) {
        RepositoryBuilder().setGitDir(gitDir).findGitDir().build().use { repository ->
            if (!repository.objectDatabase.exists()) {
                throw NoSuchGitPathException()
            }
        }
    }

    @Throws(IOException::class)
    override fun listFiles(userName: String, repoName: String): List<String> {
        val gitDir = File(getAbsoluteGitDirPath(userName, repoName))
        checkValidGitRepository(gitDir)

        val fileList = mutableListOf<String>()
        FileRepositoryBuilder().setGitDir(gitDir).build().use { repository ->
            Git(repository).use { git ->
                val treeWalk = TreeWalk(repository)
                treeWalk.addTree(repository.resolve("HEAD^{tree}"))
                treeWalk.isRecursive = true
                while (treeWalk.next()) {
                    fileList.add(treeWalk.pathString)
                }
            }
        }
        return fileList
    }

    @Throws(IOException::class)
    override fun getFileContent(ownerName: String, repoName: String, filePath: String): String {
        val gitDir = File(getAbsoluteGitDirPath(ownerName, repoName))
        checkValidGitRepository(gitDir)

        FileRepositoryBuilder().setGitDir(gitDir).build().use { repository ->
            val headId = repository.resolve("HEAD")
            repository.newObjectReader().use { objectReader ->
                val revWalk = RevWalk(repository)
                val commit = revWalk.parseCommit(headId)
                val tree = commit.tree

                val treeWalk = TreeWalk(repository).apply {
                    addTree(tree)
                    isRecursive = true
                    filter = PathFilter.create(filePath)
                }

                if (!treeWalk.next()) {
                    throw IOException("File not found: $filePath")
                }

                val objectId: ObjectId = treeWalk.getObjectId(0)
                val loader = repository.open(objectId)
                ByteArrayOutputStream().use { out ->
                    loader.copyTo(out)
                    return out.toString()
                }
            }
        }
    }

    override fun getLastCommitHash(userName: String, repoName: String): String? {
        val gitDir = File(getAbsoluteGitDirPath(userName, repoName))
        checkValidGitRepository(gitDir)
        return FileRepositoryBuilder()
            .setGitDir(gitDir)
            .readEnvironment()
            .findGitDir()
            .build().use { repository ->
                Git(repository).use { git ->
                    val head = repository.resolve("HEAD")
                    head?.name
                }
            }
    }
}
