package swm.virtuoso.reviewservice.application.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lswm/virtuoso/reviewservice/application/service/GiteaService;", "Lswm/virtuoso/reviewservice/application/port/in/GiteaUseCase;", "giteaPort", "Lswm/virtuoso/reviewservice/application/port/out/GiteaPort;", "(Lswm/virtuoso/reviewservice/application/port/out/GiteaPort;)V", "findUserByUserName", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/UserEntity;", "name", "", "getRepositories", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/RepositoryEntity;", "repoId", "", "getUserById", "userId", "setDiscussionAvailable", "", "enable", "", "Review-Service"})
public class GiteaService implements swm.virtuoso.reviewservice.application.port.in.GiteaUseCase {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.GiteaPort giteaPort = null;
    
    public GiteaService(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.GiteaPort giteaPort) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity getUserById(long userId) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity findUserByUserName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity getRepositories(long repoId) {
        return null;
    }
    
    @java.lang.Override()
    public void setDiscussionAvailable(long repoId, boolean enable) {
    }
}