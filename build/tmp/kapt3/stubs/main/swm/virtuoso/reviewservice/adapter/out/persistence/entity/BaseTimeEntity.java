package swm.virtuoso.reviewservice.adapter.out.persistence.entity;

@jakarta.persistence.MappedSuperclass()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0005J\b\u0010\u000f\u001a\u00020\u000eH\u0005R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/BaseTimeEntity;", "", "createdUnix", "", "updatedUnix", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getCreatedUnix", "()Ljava/lang/Long;", "setCreatedUnix", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUpdatedUnix", "setUpdatedUnix", "onCreate", "", "onUpdate", "Review-Service"})
public class BaseTimeEntity {
    @jakarta.persistence.Column(name = "created_unix", updatable = false)
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long createdUnix;
    @jakarta.persistence.Column(name = "updated_unix")
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long updatedUnix;
    
    public BaseTimeEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long createdUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedUnix) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCreatedUnix() {
        return null;
    }
    
    public final void setCreatedUnix(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getUpdatedUnix() {
        return null;
    }
    
    public final void setUpdatedUnix(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
    
    @jakarta.persistence.PrePersist()
    protected final void onCreate() {
    }
    
    @jakarta.persistence.PreUpdate()
    protected final void onUpdate() {
    }
    
    public BaseTimeEntity() {
        super();
    }
}