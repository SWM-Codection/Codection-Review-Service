package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "discussion_comment")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\bH\u00c6\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010%\u001a\u00020\rH\u00c6\u0003Jd\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001\u00a2\u0006\u0002\u0010\'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u00d6\u0003J\t\u0010,\u001a\u00020\nH\u00d6\u0001J\t\u0010-\u001a\u00020\rH\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015\u00a8\u0006."}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCommentEntity;", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/BaseTimeEntity;", "id", "", "discussionId", "codeId", "posterId", "scope", "Lswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;", "startLine", "", "endLine", "content", "", "(Ljava/lang/Long;JJJLswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCodeId", "()J", "getContent", "()Ljava/lang/String;", "getDiscussionId", "getEndLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPosterId", "getScope", "()Lswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;", "getStartLine", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;JJJLswm/virtuoso/reviewservice/common/enums/CommentScopeEnum;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCommentEntity;", "equals", "", "other", "", "hashCode", "toString", "Review-Service"})
public final class DiscussionCommentEntity extends swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id()
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @jakarta.persistence.Column(nullable = false, name = "discussion_id")
    private final long discussionId = 0L;
    @jakarta.persistence.Column(nullable = false, name = "code_id")
    private final long codeId = 0L;
    @jakarta.persistence.Column(nullable = false, name = "poster_id")
    private final long posterId = 0L;
    @jakarta.persistence.Column(name = "scope")
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.common.enums.CommentScopeEnum scope = null;
    @jakarta.persistence.Column(name = "start_line")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer startLine = null;
    @jakarta.persistence.Column(name = "end_line")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer endLine = null;
    @jakarta.persistence.Column(name = "content")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    
    public DiscussionCommentEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long discussionId, long codeId, long posterId, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.common.enums.CommentScopeEnum scope, @org.jetbrains.annotations.Nullable()
    java.lang.Integer startLine, @org.jetbrains.annotations.Nullable()
    java.lang.Integer endLine, @org.jetbrains.annotations.NotNull()
    java.lang.String content) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.common.enums.CommentScopeEnum component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long discussionId, long codeId, long posterId, @org.jetbrains.annotations.NotNull()
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