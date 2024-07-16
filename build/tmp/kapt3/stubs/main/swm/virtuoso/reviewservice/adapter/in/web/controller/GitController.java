package swm.virtuoso.reviewservice.adapter.in.web.controller;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.web.bind.annotation.RequestMapping(value = {"/"})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000bH\u0017J\u001c\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/in/web/controller/GitController;", "", "gitUseCase", "Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;", "discussionCodeUseCase", "Lswm/virtuoso/reviewservice/application/port/in/DiscussionCodeUseCase;", "(Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;Lswm/virtuoso/reviewservice/application/port/in/DiscussionCodeUseCase;)V", "getFileContent", "", "Lswm/virtuoso/reviewservice/domian/ExtractedLine;", "userName", "", "repoName", "filePath", "listGitFiles", "Lswm/virtuoso/reviewservice/adapter/in/web/dto/response/PartResponse;", "Review-Service"})
public class GitController {
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.GitUseCase gitUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final swm.virtuoso.reviewservice.application.port.in.DiscussionCodeUseCase discussionCodeUseCase = null;
    
    public GitController(@org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.GitUseCase gitUseCase, @org.jetbrains.annotations.NotNull()
    swm.virtuoso.reviewservice.application.port.in.DiscussionCodeUseCase discussionCodeUseCase) {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{username}/{reponame}/discussions"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull()
    public swm.virtuoso.reviewservice.adapter.in.web.dto.response.PartResponse listGitFiles(@org.springframework.web.bind.annotation.PathVariable(value = "username")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.springframework.web.bind.annotation.PathVariable(value = "reponame")
    @org.jetbrains.annotations.NotNull()
    java.lang.String repoName) {
        return null;
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{username}/{reponame}/discussions/contents"})
    @org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.OK)
    @org.jetbrains.annotations.NotNull()
    public java.util.List<swm.virtuoso.reviewservice.domian.ExtractedLine> getFileContent(@org.springframework.web.bind.annotation.PathVariable(value = "username")
    @org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.springframework.web.bind.annotation.PathVariable(value = "reponame")
    @org.jetbrains.annotations.NotNull()
    java.lang.String repoName, @org.springframework.web.bind.annotation.RequestParam(value = "filepath")
    @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
}