package swm.virtuoso.reviewservice.domian;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0013\"\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001d\"\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lswm/virtuoso/reviewservice/domian/Discussion;", "", "id", "", "name", "", "content", "repoId", "posterId", "commitHash", "codes", "", "Lswm/virtuoso/reviewservice/domian/DiscussionCode;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;)V", "getCodes", "()Ljava/util/List;", "setCodes", "(Ljava/util/List;)V", "getCommitHash", "()Ljava/lang/String;", "getContent", "setContent", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "setName", "getPosterId", "()J", "getRepoId", "setRepoId", "(J)V", "calculateDeletedCodes", "modifiedDiscussionCodes", "Review-Service"})
public final class Discussion {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String content;
    private long repoId;
    private final long posterId = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String commitHash = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<swm.virtuoso.reviewservice.domian.DiscussionCode> codes;
    
    public Discussion(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String content, long repoId, long posterId, @org.jetbrains.annotations.Nullable()
    java.lang.String commitHash, @org.jetbrains.annotations.NotNull()
    java.util.List<swm.virtuoso.reviewservice.domian.DiscussionCode> codes) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long getRepoId() {
        return 0L;
    }
    
    public final void setRepoId(long p0) {
    }
    
    public final long getPosterId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommitHash() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<swm.virtuoso.reviewservice.domian.DiscussionCode> getCodes() {
        return null;
    }
    
    public final void setCodes(@org.jetbrains.annotations.NotNull()
    java.util.List<swm.virtuoso.reviewservice.domian.DiscussionCode> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<swm.virtuoso.reviewservice.domian.DiscussionCode> calculateDeletedCodes(@org.jetbrains.annotations.NotNull()
    java.util.List<swm.virtuoso.reviewservice.domian.DiscussionCode> modifiedDiscussionCodes) {
        return null;
    }
}