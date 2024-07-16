package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "discussion_code")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003JB\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\bH\u00d6\u0001J\t\u0010!\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006#"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCodeEntity;", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/BaseTimeEntity;", "id", "", "discussionId", "filePath", "", "startLine", "", "endLine", "(Ljava/lang/Long;JLjava/lang/String;II)V", "getDiscussionId", "()J", "getEndLine", "()I", "getFilePath", "()Ljava/lang/String;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStartLine", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;JLjava/lang/String;II)Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCodeEntity;", "equals", "", "other", "", "hashCode", "toString", "Companion", "Review-Service"})
public final class DiscussionCodeEntity extends swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id()
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @jakarta.persistence.Column(nullable = false, name = "discussion_id")
    private final long discussionId = 0L;
    @jakarta.persistence.Column(name = "file_url")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String filePath = null;
    @jakarta.persistence.Column(name = "start_line")
    private final int startLine = 0;
    @jakarta.persistence.Column(name = "end_line")
    private final int endLine = 0;
    @org.jetbrains.annotations.NotNull()
    public static final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity.Companion Companion = null;
    
    public DiscussionCodeEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long discussionId, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, int startLine, int endLine) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final long getDiscussionId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilePath() {
        return null;
    }
    
    public final int getStartLine() {
        return 0;
    }
    
    public final int getEndLine() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long discussionId, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, int startLine, int endLine) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCodeEntity$Companion;", "", "()V", "from", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCodeEntity;", "discussionFile", "Lswm/virtuoso/reviewservice/domian/DiscussionCode;", "discussionId", "", "Review-Service"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity from(@org.jetbrains.annotations.NotNull()
        swm.virtuoso.reviewservice.domian.DiscussionCode discussionFile, long discussionId) {
            return null;
        }
    }
}