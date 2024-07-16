package swm.virtuoso.reviewservice.application.port.in;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/in/DiscussionUseCase;", "", "countDiscussion", "", "repoId", "", "isClosed", "", "createDiscussion", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "postDiscussionRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostDiscussionRequest;", "lastCommitHash", "", "modifyDiscussion", "", "modifyDiscussionRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/response/ModifyDiscussionRequest;", "Review-Service"})
public abstract interface DiscussionUseCase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity createDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostDiscussionRequest postDiscussionRequest, @org.jetbrains.annotations.Nullable()
    java.lang.String lastCommitHash);
    
    public abstract int countDiscussion(long repoId, boolean isClosed);
    
    public abstract void modifyDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.response.ModifyDiscussionRequest modifyDiscussionRequest);
}