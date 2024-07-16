package swm.virtuoso.reviewservice.application.port.out;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/out/GiteaPort;", "", "findRepositoryByDiscussionId", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/RepositoryEntity;", "discussionId", "", "findRepositoryById", "repoId", "findUserById", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/UserEntity;", "userId", "findUserByUserName", "username", "", "saveDiscussionAvailable", "", "enable", "", "Review-Service"})
public abstract interface GiteaPort {
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity findUserById(long userId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity findUserByUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String username);
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity findRepositoryById(long repoId);
    
    public abstract void saveDiscussionAvailable(long repoId, boolean enable);
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity findRepositoryByDiscussionId(long discussionId);
}