package swm.virtuoso.reviewservice.application.port.out;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/out/DiscussionCommentPort;", "", "findCommentsByDiscussionId", "", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCommentEntity;", "discussionId", "", "saveComment", "postCommentRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostCommentRequest;", "Review-Service"})
public abstract interface DiscussionCommentPort {
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity saveComment(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostCommentRequest postCommentRequest);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity> findCommentsByDiscussionId(long discussionId);
}