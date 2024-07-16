package swm.virtuoso.reviewservice.application.service;

@org.springframework.stereotype.Service()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0012J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0012J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lswm/virtuoso/reviewservice/application/service/GitService;", "Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;", "baseUrl", "", "(Ljava/lang/String;)V", "checkValidGitRepository", "", "gitDir", "Ljava/io/File;", "getAbsoluteGitDirPath", "userName", "repoName", "getFileContent", "ownerName", "filePath", "getLastCommitHash", "listFiles", "", "Review-Service"})
public class GitService implements swm.virtuoso.reviewservice.application.port.in.GitUseCase {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = null;
    
    public GitService(@org.springframework.beans.factory.annotation.Value(value = "${git.baseUrl}")
    @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl) {
        super();
    }
    
    private java.lang.String getAbsoluteGitDirPath(java.lang.String userName, java.lang.String repoName) {
        return null;
    }
    
    private void checkValidGitRepository(java.io.File gitDir) {
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> listFiles(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName) {
        return null;
    }
    
    @java.lang.Override()
    @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getFileContent(@org.jetbrains.annotations.NotNull()
    java.lang.String ownerName, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) throws java.io.IOException {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getLastCommitHash(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName) {
        return null;
    }
}