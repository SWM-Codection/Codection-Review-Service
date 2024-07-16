package swm.virtuoso.reviewservice.application.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lswm/virtuoso/reviewservice/application/service/DiscussionService;", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionUseCase;", "discussionPort", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionPort;", "discussionUserPort", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionUserPort;", "discussionCodePort", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionCodePort;", "converter", "Lswm/virtuoso/reviewservice/adapter/out/persistence/DiscussionMapper;", "(Lswm/virtuoso/reviewservice/application/port/out/DiscussionPort;Lswm/virtuoso/reviewservice/application/port/out/DiscussionUserPort;Lswm/virtuoso/reviewservice/application/port/out/DiscussionCodePort;Lswm/virtuoso/reviewservice/adapter/out/persistence/DiscussionMapper;)V", "countDiscussion", "", "repoId", "", "isClosed", "", "createDiscussion", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "postDiscussionRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostDiscussionRequest;", "lastCommitHash", "", "modifyDiscussion", "", "modifyDiscussionRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/response/ModifyDiscussionRequest;", "Review-Service"})
public class DiscussionService implements swm.virtuoso.reviewservice.application.port.in.DiscussionUseCase {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.DiscussionPort discussionPort = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort discussionUserPort = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort discussionCodePort = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionMapper converter = null;
    
    public DiscussionService(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.DiscussionPort discussionPort, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort discussionUserPort, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort discussionCodePort, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.DiscussionMapper converter) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity createDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostDiscussionRequest postDiscussionRequest, @org.jetbrains.annotations.Nullable()
    java.lang.String lastCommitHash) {
        return null;
    }
    
    @java.lang.Override()
    public int countDiscussion(long repoId, boolean isClosed) {
        return 0;
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @java.lang.Override()
    public void modifyDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.response.ModifyDiscussionRequest modifyDiscussionRequest) {
    }
}