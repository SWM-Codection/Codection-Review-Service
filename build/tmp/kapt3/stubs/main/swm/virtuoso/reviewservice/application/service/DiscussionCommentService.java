package swm.virtuoso.reviewservice.application.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lswm/virtuoso/reviewservice/application/service/DiscussionCommentService;", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionCommentUseCase;", "discussionCommentPort", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionCommentPort;", "(Lswm/virtuoso/reviewservice/application/port/out/DiscussionCommentPort;)V", "createComment", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCommentEntity;", "request", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostCommentRequest;", "Review-Service"})
public class DiscussionCommentService implements swm.virtuoso.reviewservice.application.port.in.DiscussionCommentUseCase {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort discussionCommentPort = null;
    
    public DiscussionCommentService(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort discussionCommentPort) {
        super();
    }
    
    @org.springframework.transaction.annotation.Transactional()
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity createComment(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostCommentRequest request) {
        return null;
    }
}