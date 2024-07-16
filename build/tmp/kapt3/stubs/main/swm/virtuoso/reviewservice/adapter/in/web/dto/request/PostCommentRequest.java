package swm.virtuoso.reviewservice.adapter.in.web.dto.request;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\fH\u00c6\u0003JX\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001\u00a2\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\tH\u00d6\u0001J\t\u0010\'\u001a\u00020\fH\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014\u00a8\u0006("}, d2 = {"Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostCommentRequest;", "", "discussionId", "", "codeId", "posterId", "scope", "Lswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;", "startLine", "", "endLine", "content", "", "(JJJLswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCodeId", "()J", "getContent", "()Ljava/lang/String;", "getDiscussionId", "getEndLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosterId", "getScope", "()Lswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;", "getStartLine", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JJJLswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostCommentRequest;", "equals", "", "other", "hashCode", "toString", "Review-Service"})
public final class PostCommentRequest {
    @jakarta.validation.constraints.NotNull(message = "Discussion ID cannot be null")
    private final long discussionId = 0L;
    @jakarta.validation.constraints.NotNull(message = "Code ID cannot be null")
    private final long codeId = 0L;
    @jakarta.validation.constraints.NotNull(message = "Poster ID cannot be null")
    private final long posterId = 0L;
    @jakarta.validation.constraints.NotEmpty(message = "Scope cannot be empty")
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.common.enums.CommentScopeEnum scope = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer startLine = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer endLine = null;
    @jakarta.validation.constraints.NotEmpty(message = "Contents cannot be empty")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    
    public PostCommentRequest(long discussionId, long codeId, long posterId, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.common.enums.CommentScopeEnum scope, @org.jetbrains.annotations.Nullable()
    java.lang.Integer startLine, @org.jetbrains.annotations.Nullable()
    java.lang.Integer endLine, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
        super();
    }
    
    public final long getDiscussionId() {
        return 0L;
    }
    
    public final long getCodeId() {
        return 0L;
    }
    
    public final long getPosterId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.common.enums.CommentScopeEnum getScope() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getStartLine() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getEndLine() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.common.enums.CommentScopeEnum component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostCommentRequest copy(long discussionId, long codeId, long posterId, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.common.enums.CommentScopeEnum scope, @org.jetbrains.annotations.Nullable()
    java.lang.Integer startLine, @org.jetbrains.annotations.Nullable()
    java.lang.Integer endLine, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}