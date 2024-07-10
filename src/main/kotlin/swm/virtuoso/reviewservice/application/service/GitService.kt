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
import swm.virtuoso.reviewservice.exception.NoSuchGitPathException
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

@Service
class GitService(
    @Value("\${git.baseUrl}") private val baseUrl: String
) {

    private fun getAbsoluteGitDirPath(userName: String, repoName: String): String {
        return "${baseUrl}/${userName}/${repoName}.git"
    }

    private fun checkValidGitRepository(gitDir: File) {
        RepositoryBuilder().setGitDir(gitDir).findGitDir().build().use { repository ->
            if (!repository.objectDatabase.exists()) {
                throw NoSuchGitPathException()
            }
        }
    }

    @Throws(IOException::class)
    fun listFiles(userName: String, repoName: String): List<String> {
        val fileList = mutableListOf<String>()
        val gitDir = File(getAbsoluteGitDirPath(userName, repoName))
        checkValidGitRepository(gitDir)

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

    fun extractLines(target: String, startLine: Int, endLine: Int): String {
        val lines = target.lines()
        if (startLine < 1 || endLine > lines.size || startLine > endLine) {
            throw IllegalArgumentException("Invalid start or end line numbers")
        }
        return lines.subList(startLine - 1, endLine).joinToString("\n")
    }

    @Throws(IOException::class)
    fun getFileContent(userName: String, repoName: String, filePath: String): String {
        val gitDir = File(getAbsoluteGitDirPath(userName, repoName))
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
}