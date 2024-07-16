package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "discussion_user")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003JB\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionUserEntity;", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/BaseTimeEntity;", "id", "", "uid", "discussionId", "isRead", "", "isMentioned", "(Ljava/lang/Long;JJZZ)V", "getDiscussionId", "()J", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;JJZZ)Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionUserEntity;", "equals", "other", "", "hashCode", "", "toString", "", "Review-Service"})
public final class DiscussionUserEntity extends swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id()
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @jakarta.persistence.Column(nullable = false, name = "uid")
    private final long uid = 0L;
    @jakarta.persistence.Column(nullable = false, name = "discussion_id")
    private final long discussionId = 0L;
    @jakarta.persistence.Column(name = "is_read")
    private final boolean isRead = false;
    @jakarta.persistence.Column(name = "is_mentioned")
    private final boolean isMentioned = false;
    
    public DiscussionUserEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long uid, long discussionId, boolean isRead, boolean isMentioned) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final long getUid() {
        return 0L;
    }
    
    public final long getDiscussionId() {
        return 0L;
    }
    
    public final boolean isRead() {
        return false;
    }
    
    public final boolean isMentioned() {
        return false;
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
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionUserEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long uid, long discussionId, boolean isRead, boolean isMentioned) {
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