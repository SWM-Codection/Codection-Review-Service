package swm.virtuoso.reviewservice.application.port.out;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/out/DiscussionPort;", "", "countDiscussion", "", "repoId", "", "isClosed", "", "findDiscussion", "Lswm/virtuoso/reviewservice/domian/Discussion;", "discussionId", "findDiscussionList", "", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "saveDiscussion", "discussion", "lastCommitHash", "", "Review-Service"})
public abstract interface DiscussionPort {
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity saveDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.domian.Discussion discussion, @org.jetbrains.annotations.Nullable()
    java.lang.String lastCommitHash);
    
    public abstract int countDiscussion(long repoId, boolean isClosed);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity> findDiscussionList(long repoId, boolean isClosed);
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.domian.Discussion findDiscussion(long discussionId);
}