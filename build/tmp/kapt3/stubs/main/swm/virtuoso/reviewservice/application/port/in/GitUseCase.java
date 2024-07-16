package swm.virtuoso.reviewservice.application.port.in;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lswm/virtuoso/reviewservice/application/port/in/GitUseCase;", "", "getFileContent", "", "ownerName", "repoName", "filePath", "getLastCommitHash", "userName", "listFiles", "", "Review-Service"})
public abstract interface GitUseCase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.String> listFiles(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getFileContent(@org.jetbrains.annotations.NotNull()
    java.lang.String ownerName, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getLastCommitHash(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String repoName);
}