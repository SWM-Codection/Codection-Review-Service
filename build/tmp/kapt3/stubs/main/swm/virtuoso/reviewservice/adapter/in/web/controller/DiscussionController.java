package swm.virtuoso.reviewservice.adapter.in.web.controller;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/discussion"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0017J\u001c\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u00102\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0017J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u0018\u001a\u00020\u001cH\u0017J\u0012\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0018\u001a\u00020\u001fH\u0017J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\"H\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/in/web/controller/DiscussionController;", "", "discussionUseCase", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionUseCase;", "discussionCommentUseCase", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionCommentUseCase;", "gitUseCase", "Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;", "giteaUseCase", "Lswm/virtuoso/reviewservice/application/port/in/GiteaUseCase;", "discussionCodeUseCase", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionCodeUseCase;", "(Lswm/virtuoso/reviewservice/application/port/in/DiscussionUseCase;Lswm/virtuoso/reviewservice/application/port/in/DiscussionCommentUseCase;Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;Lswm/virtuoso/reviewservice/application/port/in/GiteaUseCase;Lswm/virtuoso/reviewservice/application/port/in/DiscussionCodeUseCase;)V", "getDiscussionContents", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/response/DiscussionContentResponse;", "discussionId", "", "getDiscussionCount", "", "repoId", "isClosed", "", "handleDiscussionAvailable", "", "request", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/DiscussionEnableRequest;", "postComment", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionCommentEntity;", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostCommentRequest;", "postDiscussion", "Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/discussion/DiscussionEntity;", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostDiscussionRequest;", "status", "", "Ljakarta/servlet/http/HttpServletRequest;", "Review-Service"})
public class DiscussionController {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.DiscussionUseCase discussionUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.DiscussionCommentUseCase discussionCommentUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.GitUseCase gitUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.GiteaUseCase giteaUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.DiscussionCodeUseCase discussionCodeUseCase = null;
    
    public DiscussionController(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.DiscussionUseCase discussionUseCase, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.DiscussionCommentUseCase discussionCommentUseCase, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.GitUseCase gitUseCase, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.GiteaUseCase giteaUseCase, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.DiscussionCodeUseCase discussionCodeUseCase) {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/health-check"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull()
    public java.lang.String status(@org.jetbrains.annotations.NotNull()
    jakarta.servlet.http.HttpServletRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {""})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionEntity postDiscussion(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostDiscussionRequest request) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{repoId}/count"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    public int getDiscussionCount(@org.springframework.web.bind.annotation.PathVariable()
    long repoId, @org.springframework.web.bind.annotation.RequestParam()
    boolean isClosed) {
        return 0;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/available"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
    public void handleDiscussionAvailable(@org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.DiscussionEnableRequest request) {
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{discussionId}/codes"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.in.web.dto.response.DiscussionContentResponse getDiscussionContents(@org.springframework.web.bind.annotation.PathVariable()
    long discussionId) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.PostMapping(value = {"/comment"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.out.persistence.entity.discussion.DiscussionCommentEntity postComment(@jakarta.validation.Valid()
    @org.springframework.web.bind.annotation.RequestBody()
    @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostCommentRequest request) {
        return null;
    }
}