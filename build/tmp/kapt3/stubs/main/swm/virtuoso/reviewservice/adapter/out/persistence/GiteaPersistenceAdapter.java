package swm.virtuoso.reviewservice.adapter.out.persistence;

@org.springframework.stereotype.Repository()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/GiteaPersistenceAdapter;", "Lswm/virtuoso/reviewservice/application/port/out/GiteaPort;", "repositoryRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/RepositoryRepository;", "userRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/UserRepository;", "discussionAvailableRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionAvailableRepository;", "discussionRepository", "Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionRepository;", "(Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/RepositoryRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/UserRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionAvailableRepository;Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionRepository;)V", "findRepositoryByDiscussionId", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/RepositoryEntity;", "discussionId", "", "findRepositoryById", "repoId", "findUserById", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/UserEntity;", "userId", "findUserByUserName", "username", "", "saveDiscussionAvailable", "", "enable", "", "Review-Service"})
public class GiteaPersistenceAdapter implements swm.virtuoso.reviewservice.application.port.out.GiteaPort {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.RepositoryRepository repositoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAvailableRepository discussionAvailableRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository discussionRepository = null;
    
    public GiteaPersistenceAdapter(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.RepositoryRepository repositoryRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionAvailableRepository discussionAvailableRepository, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion.DiscussionRepository discussionRepository) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity findUserById(long userId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity findUserByUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity findRepositoryById(long repoId) {
        return null;
    }
    
    @java.lang.Override()
    public void saveDiscussionAvailable(long repoId, boolean enable) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity findRepositoryByDiscussionId(long discussionId) {
        return null;
    }
}