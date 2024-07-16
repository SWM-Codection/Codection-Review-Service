package swm.virtuoso.reviewservice.adapter.out.persistence;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00192\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0012J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010\'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/DiscussionPersistenceAdapter;", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionPort;", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionCodePort;", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionUserPort;", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionCommentPort;", "discussionRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionRepository;", "discussionCodeRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionCodeRepository;", "discussionIndexRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionIndexRepository;", "discussionUserRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionUserRepository;", "discussionCommentRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionCommentRepository;", "(Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionCodeRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionIndexRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionUserRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionCommentRepository;)V", "countDiscussion", "", "repoId", "", "isClosed", "", "deleteDiscussionCodeAllById", "", "id", "", "findCommentsByDiscussionId", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCommentEntity;", "discussionId", "findDiscussion", "Lswm/virtuoso/reviewservice/domian/Discussion;", "findDiscussionCodes", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCodeEntity;", "findDiscussionList", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "getIndex", "saveComment", "postCommentRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostCommentRequest;", "saveDiscussion", "discussion", "lastCommitHash", "", "saveDiscussionUser", "userId", "Review-Service"})
public class DiscussionPersistenceAdapter implements swm.virtuoso.reviewservice.application.port.out.DiscussionPort, swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort, swm.virtuoso.reviewservice.application.port.out.DiscussionUserPort, swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository discussionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository discussionCodeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository discussionIndexRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository discussionUserRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository discussionCommentRepository = null;
    
    public DiscussionPersistenceAdapter(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository discussionRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCodeRepository discussionCodeRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionIndexRepository discussionIndexRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionUserRepository discussionUserRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionCommentRepository discussionCommentRepository) {
        super();
    }
    
    private long getIndex(long repoId) {
        return 0L;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity saveDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.domian.Discussion discussion, @org.jetbrains.annotations.Nullable()
    java.lang.String lastCommitHash) {
        return null;
    }
    
    @java.lang.Override()
    public void saveDiscussionUser(long userId, long discussionId) {
    }
    
    @java.lang.Override()
    public int countDiscussion(long repoId, boolean isClosed) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity> findDiscussionList(long repoId, boolean isClosed) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.domian.Discussion findDiscussion(long discussionId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCodeEntity> findDiscussionCodes(long discussionId) {
        return null;
    }
    
    @java.lang.Override()
    public void deleteDiscussionCodeAllById(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> id) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity saveComment(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostCommentRequest postCommentRequest) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity> findCommentsByDiscussionId(long discussionId) {
        return null;
    }
}