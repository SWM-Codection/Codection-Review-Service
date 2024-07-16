package swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "discussion")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010*\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010$J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u0010\u0010-\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\t\u00105\u001a\u00020\u000eH\u00c6\u0003J\u00a2\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010:H\u00d6\u0003J\t\u0010;\u001a\u00020\u000eH\u00d6\u0001J\t\u0010<\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001dR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u0012\u0010\u001eR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\'\u00a8\u0006>"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/BaseTimeEntity;", "id", "", "repoId", "index", "posterId", "commitHash", "", "name", "content", "isClosed", "", "numComments", "", "pinOrder", "deadlineUnix", "closedUnix", "isLocked", "(Ljava/lang/Long;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getClosedUnix", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommitHash", "()Ljava/lang/String;", "getContent", "getDeadlineUnix", "getId", "getIndex", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getNumComments", "()I", "getPinOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPosterId", "()J", "getRepoId", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;JLjava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "equals", "other", "", "hashCode", "toString", "Companion", "Review-Service"})
public final class DiscussionEntity extends swm.virtuoso.reviewservice.adapter.out.persistence.entity.BaseTimeEntity {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id()
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @jakarta.persistence.Column(nullable = false, name = "repo_id")
    private final long repoId = 0L;
    @jakarta.persistence.Column(nullable = false, name = "index")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long index = null;
    @jakarta.persistence.Column(nullable = false, name = "poster_id")
    private final long posterId = 0L;
    @jakarta.persistence.Column(nullable = false, name = "commit_hash")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String commitHash = null;
    @jakarta.persistence.Column(name = "name")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @jakarta.persistence.Column(name = "content")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String content = null;
    @jakarta.persistence.Column(name = "is_closed")
    private final boolean isClosed = false;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_comments")
    private final int numComments = 0;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "pin_order")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer pinOrder = null;
    @jakarta.persistence.Column(name = "deadline_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long deadlineUnix = null;
    @jakarta.persistence.Column(name = "closed_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long closedUnix = null;
    @jakarta.persistence.Column(name = "is_locked")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isLocked = null;
    @org.jetbrains.annotations.NotNull()
    public static final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity.Companion Companion = null;
    
    public DiscussionEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long repoId, @org.jetbrains.annotations.Nullable()
    java.lang.Long index, long posterId, @org.jetbrains.annotations.Nullable()
    java.lang.String commitHash, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String content, boolean isClosed, int numComments, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pinOrder, @org.jetbrains.annotations.Nullable()
    java.lang.Long deadlineUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long closedUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isLocked) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    public final long getRepoId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getIndex() {
        return null;
    }
    
    public final long getPosterId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCommitHash() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final boolean isClosed() {
        return false;
    }
    
    public final int getNumComments() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPinOrder() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDeadlineUnix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getClosedUnix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isLocked() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component13() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, long repoId, @org.jetbrains.annotations.Nullable()
    java.lang.Long index, long posterId, @org.jetbrains.annotations.Nullable()
    java.lang.String commitHash, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String content, boolean isClosed, int numComments, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pinOrder, @org.jetbrains.annotations.Nullable()
    java.lang.Long deadlineUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long closedUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isLocked) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000b"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity$Companion;", "", "()V", "from", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "discussion", "Lswm/virtuoso/reviewservice/domian/Discussion;", "index", "", "commitHash", "", "Review-Service"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity from(@org.jetbrains.annotations.NotNull()
        swm.virtuoso.reviewservice.domian.Discussion discussion, long index, @org.jetbrains.annotations.Nullable()
        java.lang.String commitHash) {
            return null;
        }
    }
}