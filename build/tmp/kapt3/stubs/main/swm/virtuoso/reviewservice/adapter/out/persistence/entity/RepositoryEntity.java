package swm.virtuoso.reviewservice.adapter.out.persistence.entity;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "repository")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\bl\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\"\u001a\u00020\f\u0012\b\b\u0002\u0010#\u001a\u00020\u001e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\'\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\b\u0002\u0010*\u001a\u00020\u001e\u0012\b\b\u0002\u0010+\u001a\u00020\u001e\u0012\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010-\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\u000b\u0010g\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\u0010\u0010j\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\u0010\u0010k\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\u0010\u0010l\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\u0010\u0010m\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\u0010\u0010n\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\u0010\u0010o\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\t\u0010p\u001a\u00020\fH\u00c6\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\t\u0010r\u001a\u00020\fH\u00c6\u0003J\t\u0010s\u001a\u00020\fH\u00c6\u0003J\t\u0010t\u001a\u00020\fH\u00c6\u0003J\t\u0010u\u001a\u00020\fH\u00c6\u0003J\t\u0010v\u001a\u00020\fH\u00c6\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003\u00a2\u0006\u0002\u0010DJ\u0010\u0010x\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003\u00a2\u0006\u0002\u0010DJ\u0010\u0010y\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003\u00a2\u0006\u0002\u0010DJ\u0010\u0010z\u001a\u0004\u0018\u00010\u001eH\u00c6\u0003\u00a2\u0006\u0002\u0010DJ\t\u0010{\u001a\u00020\fH\u00c6\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010}\u001a\u00020\u001eH\u00c6\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\t\u0010\u007f\u001a\u00020\u001eH\u00c6\u0003J\u0011\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u001eH\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u001eH\u00c6\u0003J\u0018\u0010\u0086\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010-H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0006H\u00c6\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u00106J\n\u0010\u008e\u0001\u001a\u00020\u0006H\u00c6\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010MJ\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0096\u0004\u0010\u0093\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\"\u001a\u00020\f2\b\b\u0002\u0010#\u001a\u00020\u001e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010%\u001a\u00020\u001e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u001e2\b\b\u0002\u0010+\u001a\u00020\u001e2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010-2\b\b\u0002\u0010.\u001a\u00020\u00062\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u0094\u0001J\u0015\u0010\u0095\u0001\u001a\u00020\u001e2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u0097\u0001\u001a\u00020\fH\u00d6\u0001J\n\u0010\u0098\u0001\u001a\u00020\u0006H\u00d6\u0001R\u001a\u00103\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0018\u00100\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010+\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u00101\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b<\u00106R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00109R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u00109R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00109R\u001a\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b@\u00106R\u0016\u0010(\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\bC\u00106R\u001a\u0010 \u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010E\u001a\u0004\b \u0010DR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010E\u001a\u0004\b\u001f\u0010DR\u0016\u0010#\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010;R\u0016\u0010*\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010;R\u001a\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010E\u001a\u0004\b!\u0010DR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010E\u001a\u0004\b\u001d\u0010DR\u0016\u0010%\u001a\u00020\u001e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010;R\u0016\u0010)\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010BR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00109R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00109R\u0016\u0010\u001b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0016\u0010\u001c\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010JR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bL\u0010MR\u0016\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010JR\u0016\u0010\u001a\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010JR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bQ\u0010MR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bR\u0010MR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bS\u0010MR\u0016\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010JR\u0016\u0010\u0019\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010JR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bV\u0010MR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bW\u0010MR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bX\u0010MR\u0016\u0010.\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u00109R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bZ\u0010MR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u00109R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b\\\u00106R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u00109R\u0016\u0010\'\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010BR\u0016\u0010\"\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010JR\u001a\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b`\u00106R$\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010-8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u001a\u0010/\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010N\u001a\u0004\bc\u0010MR\u001a\u00102\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\bd\u00106R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\be\u00109\u00a8\u0006\u0099\u0001"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/RepositoryEntity;", "", "id", "", "ownerId", "ownerName", "", "lowerName", "name", "description", "website", "originalServiceType", "", "originalUrl", "defaultBranch", "defaultWikiBranch", "numWatches", "numStars", "numForks", "numIssues", "numClosedIssues", "numPulls", "numClosedPulls", "numMilestones", "numClosedMilestones", "numProjects", "numClosedProjects", "numActionRuns", "numClosedActionRuns", "isPrivate", "", "isEmpty", "isArchived", "isMirror", "status", "isFork", "forkId", "isTemplate", "templateId", "size", "gitSize", "lfsSize", "isFsckEnabled", "closeIssuesViaCommitInAnyBranch", "topics", "", "objectFormatName", "trustModel", "avatar", "createdUnix", "updatedUnix", "archivedUnix", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIIIIILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;IZLjava/lang/Long;ZLjava/lang/Long;JJJZZLjava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getArchivedUnix", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAvatar", "()Ljava/lang/String;", "getCloseIssuesViaCommitInAnyBranch", "()Z", "getCreatedUnix", "getDefaultBranch", "getDefaultWikiBranch", "getDescription", "getForkId", "getGitSize", "()J", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLfsSize", "getLowerName", "getName", "getNumActionRuns", "()I", "getNumClosedActionRuns", "getNumClosedIssues", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumClosedMilestones", "getNumClosedProjects", "getNumClosedPulls", "getNumForks", "getNumIssues", "getNumMilestones", "getNumProjects", "getNumPulls", "getNumStars", "getNumWatches", "getObjectFormatName", "getOriginalServiceType", "getOriginalUrl", "getOwnerId", "getOwnerName", "getSize", "getStatus", "getTemplateId", "getTopics", "()Ljava/util/Map;", "getTrustModel", "getUpdatedUnix", "getWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIIIIILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;IZLjava/lang/Long;ZLjava/lang/Long;JJJZZLjava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/RepositoryEntity;", "equals", "other", "hashCode", "toString", "Review-Service"})
public final class RepositoryEntity {
    @jakarta.persistence.Id()
    @org.hibernate.annotations.ColumnDefault(value = "nextval(\'repository_id_seq\'::regclass)")
    @jakarta.persistence.Column(name = "id", nullable = false)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @jakarta.persistence.Column(name = "owner_id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long ownerId = null;
    @jakarta.persistence.Column(name = "owner_name")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String ownerName = null;
    @jakarta.persistence.Column(name = "lower_name", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lowerName = null;
    @jakarta.persistence.Column(name = "name", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @jakarta.persistence.Column(name = "description", length = 2147483647)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String description = null;
    @jakarta.persistence.Column(name = "website", length = 2048)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String website = null;
    @jakarta.persistence.Column(name = "original_service_type")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer originalServiceType = null;
    @jakarta.persistence.Column(name = "original_url", length = 2048)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String originalUrl = null;
    @jakarta.persistence.Column(name = "default_branch")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String defaultBranch = null;
    @jakarta.persistence.Column(name = "default_wiki_branch")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String defaultWikiBranch = null;
    @jakarta.persistence.Column(name = "num_watches")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numWatches = null;
    @jakarta.persistence.Column(name = "num_stars")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numStars = null;
    @jakarta.persistence.Column(name = "num_forks")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numForks = null;
    @jakarta.persistence.Column(name = "num_issues")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numIssues = null;
    @jakarta.persistence.Column(name = "num_closed_issues")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numClosedIssues = null;
    @jakarta.persistence.Column(name = "num_pulls")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numPulls = null;
    @jakarta.persistence.Column(name = "num_closed_pulls")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numClosedPulls = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_milestones", nullable = false)
    private final int numMilestones = 0;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_closed_milestones", nullable = false)
    private final int numClosedMilestones = 0;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_projects", nullable = false)
    private final int numProjects = 0;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_closed_projects", nullable = false)
    private final int numClosedProjects = 0;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_action_runs", nullable = false)
    private final int numActionRuns = 0;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_closed_action_runs", nullable = false)
    private final int numClosedActionRuns = 0;
    @jakarta.persistence.Column(name = "is_private")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isPrivate = null;
    @jakarta.persistence.Column(name = "is_empty")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isEmpty = null;
    @jakarta.persistence.Column(name = "is_archived")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isArchived = null;
    @jakarta.persistence.Column(name = "is_mirror")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isMirror = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "status", nullable = false)
    private final int status = 0;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "is_fork", nullable = false)
    private final boolean isFork = false;
    @jakarta.persistence.Column(name = "fork_id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long forkId = null;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "is_template", nullable = false)
    private final boolean isTemplate = false;
    @jakarta.persistence.Column(name = "template_id")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long templateId = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "size", nullable = false)
    private final long size = 0L;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "git_size", nullable = false)
    private final long gitSize = 0L;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "lfs_size", nullable = false)
    private final long lfsSize = 0L;
    @org.hibernate.annotations.ColumnDefault(value = "true")
    @jakarta.persistence.Column(name = "is_fsck_enabled", nullable = false)
    private final boolean isFsckEnabled = false;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "close_issues_via_commit_in_any_branch", nullable = false)
    private final boolean closeIssuesViaCommitInAnyBranch = false;
    @jakarta.persistence.Column(name = "topics")
    @org.hibernate.annotations.JdbcTypeCode(value = org.hibernate.type.SqlTypes.JSON)
    @org.jetbrains.annotations.Nullable()
    private final java.util.Map<java.lang.String, java.lang.Object> topics = null;
    @org.hibernate.annotations.ColumnDefault(value = "\'sha1\'")
    @jakarta.persistence.Column(name = "object_format_name", nullable = false, length = 6)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String objectFormatName = null;
    @jakarta.persistence.Column(name = "trust_model")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer trustModel = null;
    @jakarta.persistence.Column(name = "avatar", length = 64)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String avatar = null;
    @jakarta.persistence.Column(name = "created_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long createdUnix = null;
    @jakarta.persistence.Column(name = "updated_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long updatedUnix = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "archived_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long archivedUnix = null;
    
    public RepositoryEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long ownerId, @org.jetbrains.annotations.Nullable()
    java.lang.String ownerName, @org.jetbrains.annotations.NotNull()
    java.lang.String lowerName, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    java.lang.Integer originalServiceType, @org.jetbrains.annotations.Nullable()
    java.lang.String originalUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultBranch, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultWikiBranch, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numWatches, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numStars, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numForks, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numIssues, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numClosedIssues, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numPulls, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numClosedPulls, int numMilestones, int numClosedMilestones, int numProjects, int numClosedProjects, int numActionRuns, int numClosedActionRuns, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isPrivate, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isEmpty, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isArchived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isMirror, int status, boolean isFork, @org.jetbrains.annotations.Nullable()
    java.lang.Long forkId, boolean isTemplate, @org.jetbrains.annotations.Nullable()
    java.lang.Long templateId, long size, long gitSize, long lfsSize, boolean isFsckEnabled, boolean closeIssuesViaCommitInAnyBranch, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> topics, @org.jetbrains.annotations.NotNull()
    java.lang.String objectFormatName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer trustModel, @org.jetbrains.annotations.Nullable()
    java.lang.String avatar, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long archivedUnix) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getOwnerId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOwnerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLowerName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWebsite() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getOriginalServiceType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOriginalUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDefaultBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDefaultWikiBranch() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumWatches() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumStars() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumForks() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumIssues() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumClosedIssues() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumPulls() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumClosedPulls() {
        return null;
    }
    
    public final int getNumMilestones() {
        return 0;
    }
    
    public final int getNumClosedMilestones() {
        return 0;
    }
    
    public final int getNumProjects() {
        return 0;
    }
    
    public final int getNumClosedProjects() {
        return 0;
    }
    
    public final int getNumActionRuns() {
        return 0;
    }
    
    public final int getNumClosedActionRuns() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isPrivate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isEmpty() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isArchived() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isMirror() {
        return null;
    }
    
    public final int getStatus() {
        return 0;
    }
    
    public final boolean isFork() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getForkId() {
        return null;
    }
    
    public final boolean isTemplate() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getTemplateId() {
        return null;
    }
    
    public final long getSize() {
        return 0L;
    }
    
    public final long getGitSize() {
        return 0L;
    }
    
    public final long getLfsSize() {
        return 0L;
    }
    
    public final boolean isFsckEnabled() {
        return false;
    }
    
    public final boolean getCloseIssuesViaCommitInAnyBranch() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, java.lang.Object> getTopics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getObjectFormatName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTrustModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getCreatedUnix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getUpdatedUnix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getArchivedUnix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component18() {
        return null;
    }
    
    public final int component19() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    public final int component20() {
        return 0;
    }
    
    public final int component21() {
        return 0;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final int component24() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component28() {
        return null;
    }
    
    public final int component29() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component30() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component31() {
        return null;
    }
    
    public final boolean component32() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component33() {
        return null;
    }
    
    public final long component34() {
        return 0L;
    }
    
    public final long component35() {
        return 0L;
    }
    
    public final long component36() {
        return 0L;
    }
    
    public final boolean component37() {
        return false;
    }
    
    public final boolean component38() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, java.lang.Object> component39() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component40() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component41() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component42() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component43() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component44() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component45() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.RepositoryEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long ownerId, @org.jetbrains.annotations.Nullable()
    java.lang.String ownerName, @org.jetbrains.annotations.NotNull()
    java.lang.String lowerName, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    java.lang.Integer originalServiceType, @org.jetbrains.annotations.Nullable()
    java.lang.String originalUrl, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultBranch, @org.jetbrains.annotations.Nullable()
    java.lang.String defaultWikiBranch, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numWatches, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numStars, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numForks, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numIssues, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numClosedIssues, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numPulls, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numClosedPulls, int numMilestones, int numClosedMilestones, int numProjects, int numClosedProjects, int numActionRuns, int numClosedActionRuns, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isPrivate, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isEmpty, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isArchived, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isMirror, int status, boolean isFork, @org.jetbrains.annotations.Nullable()
    java.lang.Long forkId, boolean isTemplate, @org.jetbrains.annotations.Nullable()
    java.lang.Long templateId, long size, long gitSize, long lfsSize, boolean isFsckEnabled, boolean closeIssuesViaCommitInAnyBranch, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> topics, @org.jetbrains.annotations.NotNull()
    java.lang.String objectFormatName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer trustModel, @org.jetbrains.annotations.Nullable()
    java.lang.String avatar, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long archivedUnix) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}