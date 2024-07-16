package swm.virtuoso.reviewservice.application.port.in;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/in/DiscussionCodeUseCase;", "", "extractLinesWithNumbers", "", "Lswm/virtuoso/reviewservice/domian/ExtractedLine;", "target", "", "startLine", "", "endLine", "getDiscussionContents", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/response/DiscussionContentResponse;", "discussionId", "", "Review-Service"})
public abstract interface DiscussionCodeUseCase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract swm.virtuoso.reviewservice.adapter.in.web.dto.response.DiscussionContentResponse getDiscussionContents(long discussionId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<swm.virtuoso.reviewservice.domian.ExtractedLine> extractLinesWithNumbers(@org.jetbrains.annotations.NotNull()
    java.lang.String target, int startLine, int endLine);
}