package swm.virtuoso.reviewservice.adapter.out.persistence;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/DiscussionMapper;", "", "postRequestToDiscussion", "Lswm/virtuoso/reviewservice/domian/Discussion;", "postDiscussionRequest", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/request/PostDiscussionRequest;", "Review-Service"})
@org.mapstruct.Mapper()
public abstract interface DiscussionMapper {
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.domian.Discussion postRequestToDiscussion(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.adapter.in.web.dto.request.PostDiscussionRequest postDiscussionRequest);
}