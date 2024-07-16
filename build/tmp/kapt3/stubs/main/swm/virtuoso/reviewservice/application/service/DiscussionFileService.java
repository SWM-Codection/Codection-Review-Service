package swm.virtuoso.reviewservice.application.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lswm/virtuoso/reviewservice/application/service/DiscussionFileService;", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionCodeUseCase;", "discussionCodePort", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionCodePort;", "giteaPort", "Lswm/virtuoso/reviewservice/application/port/out/GiteaPort;", "gitUseCase", "Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;", "discussionCommentPort", "Lswm/virtuoso/reviewservice/application/port/out/DiscussionCommentPort;", "(Lswm/virtuoso/reviewservice/application/port/out/DiscussionCodePort;Lswm/virtuoso/reviewservice/application/port/out/GiteaPort;Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;Lswm/virtuoso/reviewservice/application/port/out/DiscussionCommentPort;)V", "extractLinesWithNumbers", "", "Lswm/virtuoso/reviewservice/domian/ExtractedLine;", "target", "", "startLine", "", "endLine", "getDiscussionContents", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/response/DiscussionContentResponse;", "discussionId", "", "Review-Service"})
public class DiscussionFileService implements swm.virtuoso.reviewservice.application.port.in.DiscussionCodeUseCase {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort discussionCodePort = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.GiteaPort giteaPort = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.GitUseCase gitUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort discussionCommentPort = null;
    
    public DiscussionFileService(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.DiscussionCodePort discussionCodePort, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.GiteaPort giteaPort, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.GitUseCase gitUseCase, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.out.DiscussionCommentPort discussionCommentPort) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.util.List<swm.virtuoso.reviewservice.domian.ExtractedLine> extractLinesWithNumbers(@org.jetbrains.annotations.NotNull()
    java.lang.String target, int startLine, int endLine) {
        return null;
    }
    
    /**
     * CodeBlock: 디스커션 작성 시 파일 내용에 드래그한 코드의 단위 + 해당 부분에 달린 코멘트
     * FileContents: 하나의 파일에 작성된 코드 블록의 집합
     * DiscussionContents: discussion에 있는 fileContents의 집합
     */
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.in.web.dto.response.DiscussionContentResponse getDiscussionContents(long discussionId) {
        return null;
    }
}