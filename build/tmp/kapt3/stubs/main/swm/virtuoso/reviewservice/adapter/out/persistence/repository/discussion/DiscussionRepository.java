package swm.virtuoso.reviewservice.adapter.out.persistence.repository.discussion;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/repository/discussion/DiscussionRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "", "countByRepoIdAndIsClosed", "", "repoId", "isClosed", "", "findAllByRepoIdAndIsClosed", "", "Review-Service"})
public abstract interface DiscussionRepository extends org.springframework.data.jpa.repository.JpaRepository<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity, java.lang.Long> {
    
    public abstract int countByRepoIdAndIsClosed(long repoId, boolean isClosed);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity> findAllByRepoIdAndIsClosed(long repoId, boolean isClosed);
}