package swm.virtuoso.reviewservice.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import java.io.IOException

@RestControllerAdvice
class GlobalExceptionHandler {

    companion object {
        private const val INVALID_PATH_IO_EXCEPTION = "Git-001"
        private const val EMPTY_PATH_EXCEPTION = "Git-002"
        private const val RESPONSE_STATUS_EXCEPTION = "Git-003"
        private const val NO_SUCH_GIT_PATH_EXCEPTION = "Git-004"
        private const val COMMIT_NOT_EXIST_EXCEPTION = "Git-005"
        private const val NO_SUCH_ELEMENT_EXCEPTION = "Git-006"
        private const val ILLEGAL_ARGUMENT_EXCEPTION = "Git-007"
        private const val NO_SUCH_DISCUSSION_COMMENT_EXCEPTION = "Git-008"
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IOException::class)
    fun handleIOException(exception: IOException): ErrorResponse {
        return ErrorResponse(HttpStatus.NOT_FOUND, INVALID_PATH_IO_EXCEPTION, "지정한 경로의 파일이 없거나, 읽을 수 없습니다.")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyPathException::class)
    fun handleEmptyPathException(exception: EmptyPathException): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST, EMPTY_PATH_EXCEPTION, exception.message!!)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(exception: ResponseStatusException): ErrorResponse {
        return ErrorResponse(HttpStatus.NO_CONTENT, RESPONSE_STATUS_EXCEPTION, "지정된 깃 파일이 비어있습니다.")
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchGitPathException::class)
    fun handlerNoSuchGitPathException(exception: NoSuchGitPathException): ErrorResponse {
        return ErrorResponse(HttpStatus.NOT_FOUND, NO_SUCH_GIT_PATH_EXCEPTION, exception.message!!)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(CommitNotExistException::class)
    fun handlerCommitNotExistException(exception: CommitNotExistException): ErrorResponse {
        return ErrorResponse(HttpStatus.NOT_FOUND, COMMIT_NOT_EXIST_EXCEPTION, exception.message!!)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException::class)
    fun handlerNoSuchElementException(exception: NoSuchElementException): ErrorResponse {
        return ErrorResponse(HttpStatus.NOT_FOUND, NO_SUCH_ELEMENT_EXCEPTION, exception.message!!)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    fun handlerIllegalArgumentException(exception: IllegalArgumentException): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST, ILLEGAL_ARGUMENT_EXCEPTION, exception.message!!)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchDiscussionCommentException::class)
    fun handlerDiscussionCommentNotExistsException(exception: NoSuchDiscussionCommentException): ErrorResponse {
        return ErrorResponse(HttpStatus.NOT_FOUND, NO_SUCH_DISCUSSION_COMMENT_EXCEPTION, exception.message!!)
    }
}
