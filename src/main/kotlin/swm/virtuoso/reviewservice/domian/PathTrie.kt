package swm.virtuoso.reviewservice.domian

import swm.virtuoso.reviewservice.adapter.`in`.web.dto.response.PartResponse
import swm.virtuoso.reviewservice.exception.EmptyPathException

class PathTrie {
    val next: MutableMap<String, PathTrie> = mutableMapOf()

    fun insert(path: String) {
        val parts = path.split("/")
        var current = this
        for (part in parts) {
            if (part.isNotEmpty()) {
                if (!current.next.containsKey(part)) {
                    current.next[part] = PathTrie()
                }
                current = current.next[part]!!
            } else {
                throw EmptyPathException()
            }
        }
    }

    fun toTree(name: String, fullPath: String): PartResponse {
        val children = next.map { (key, value) -> value.toTree(key, "$fullPath$key/") }
        val type = if (children.isEmpty()) "FILE" else "DIRECTORY"
        return PartResponse(name, type, fullPath.removeSuffix("/"), children)
    }
}
