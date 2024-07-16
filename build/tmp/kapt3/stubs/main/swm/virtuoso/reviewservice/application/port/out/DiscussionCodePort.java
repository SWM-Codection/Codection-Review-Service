package swm.virtuoso.reviewservice.application.port.out;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/out/DiscussionCodePort;", "", "deleteDiscussionCodeAllById", "", "id", "", "", "findDiscussionCodes", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCodeEntity;", "discussionId", "Review-Service"})
public abstract interface DiscussionCodePort {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity> findDiscussionCodes(long discussionId);
    
    public abstract void deleteDiscussionCodeAllById(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> id);
}