package swm.virtuoso.reviewservice.common.exception;

@org.springframework.web.bind.annotation.RestControllerAdvice()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0017J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0017\u00a8\u0006\u0010"}, d2 = {"Lswm/virtuoso/reviewservice/common/exception/GlobalExceptionHandler;", "", "()V", "handleEmptyPathException", "Lswm/virtuoso/reviewservice/common/exception/ErrorResponse;", "exception", "Lswm/virtuoso/reviewservice/common/exception/EmptyPathException;", "handleIOException", "Ljava/io/IOException;", "handleResponseStatusException", "Lorg/springframework/web/server/ResponseStatusException;", "handlerNoSuchDiscussionException", "Lswm/virtuoso/reviewservice/common/exception/NoSuchDiscussionException;", "handlerNoSuchGitPathException", "Lswm/virtuoso/reviewservice/common/exception/NoSuchGitPathException;", "Companion", "Review-Service"})
public class GlobalExceptionHandler {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String INVALID_PATH_IO_EXCEPTION = "Git-001";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EMPTY_PATH_EXCEPTION = "Git-002";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String RESPONSE_STATUS_EXCEPTION = "Git-003";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NO_SUCH_GIT_PATH_EXCEPTION = "Git-004";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NO_SUCH_Discussion_EXCEPTION = "Git-005";
    @org.jetbrains.annotations.NotNull()
    public static final swm.virtuoso.reviewservice.common.exception.GlobalExceptionHandler.Companion Companion = null;
    
    public GlobalExceptionHandler() {
        super();
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {java.io.IOException.class})
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.common.exception.ErrorResponse handleIOException(@org.jetbrains.annotations.NotNull()
    java.io.IOException exception) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {swm.virtuoso.reviewservice.common.exception.EmptyPathException.class})
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.common.exception.ErrorResponse handleEmptyPathException(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.common.exception.EmptyPathException exception) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.NO_CONTENT)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {org.springframework.web.server.ResponseStatusException.class})
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.common.exception.ErrorResponse handleResponseStatusException(@org.jetbrains.annotations.NotNull()
    org.springframework.web.server.ResponseStatusException exception) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {swm.virtuoso.reviewservice.common.exception.NoSuchGitPathException.class})
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.common.exception.ErrorResponse handlerNoSuchGitPathException(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.common.exception.NoSuchGitPathException exception) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {swm.virtuoso.reviewservice.common.exception.NoSuchDiscussionException.class})
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.common.exception.ErrorResponse handlerNoSuchDiscussionException(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.common.exception.NoSuchDiscussionException exception) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lswm/virtuoso/reviewservice/common/exception/GlobalExceptionHandler$Companion;", "", "()V", "EMPTY_PATH_EXCEPTION", "", "INVALID_PATH_IO_EXCEPTION", "NO_SUCH_Discussion_EXCEPTION", "NO_SUCH_GIT_PATH_EXCEPTION", "RESPONSE_STATUS_EXCEPTION", "Review-Service"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}