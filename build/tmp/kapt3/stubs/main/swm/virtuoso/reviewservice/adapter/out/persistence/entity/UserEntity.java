package swm.virtuoso.reviewservice.adapter.out.persistence.entity;

@jakarta.persistence.Entity()
@jakarta.persistence.Table(name = "user")
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0003\b\u008e\u0001\b\u0087\b\u0018\u00002\u00020\u0001B\u00f9\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010$\u001a\u00020\n\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010\'\u001a\u00020\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010*\u001a\u00020\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010/\u001a\u00020\u0010\u0012\b\b\u0002\u00100\u001a\u00020\n\u0012\b\b\u0002\u00101\u001a\u00020\u0005\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u0012\b\b\u0002\u00103\u001a\u00020\n\u00a2\u0006\u0002\u00104J\u0010\u0010j\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010?J\t\u0010k\u001a\u00020\nH\u00c6\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\t\u0010m\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\u000b\u0010p\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010u\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u0010\u0010x\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u0010\u0010y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u0010\u0010z\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\t\u0010{\u001a\u00020\u0010H\u00c6\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\u0010\u0010}\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\t\u0010~\u001a\u00020\nH\u00c6\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\n\u0010\u0080\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\n\u0010\u0082\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\n\u0010\u0088\u0001\u001a\u00020\u0010H\u00c6\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\u0011\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010QJ\n\u0010\u008e\u0001\u001a\u00020\u0010H\u00c6\u0003J\n\u0010\u008f\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0092\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u0093\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u00108J\n\u0010\u0095\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0097\u0001\u001a\u00020\u0005H\u00c6\u0003J\u0090\u0004\u0010\u0098\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010!\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\u00052\b\b\u0002\u0010\'\u001a\u00020\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010*\u001a\u00020\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010/\u001a\u00020\u00102\b\b\u0002\u00100\u001a\u00020\n2\b\b\u0002\u00101\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u00052\b\b\u0002\u00103\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0003\u0010\u0099\u0001J\u0015\u0010\u009a\u0001\u001a\u00020\n2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0010H\u00d6\u0001J\n\u0010\u009d\u0001\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010$\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010\"\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u001a\u0010#\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u0016\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0016\u0010\'\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010<R\u0016\u00101\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010<R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010<R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010<R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010<R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bF\u0010?R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b\u001f\u00108R\u001a\u0010 \u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\b \u00108R\u0016\u0010!\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u00106R\u0016\u00103\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00106R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\bH\u00108R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010<R\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bJ\u0010?R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\bK\u00108R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010<R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010<R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010QR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010<R\u0016\u0010\u001e\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u00106R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010<R\u001a\u0010)\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\bX\u0010QR\u0016\u0010*\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010UR\u001a\u0010.\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\bZ\u0010QR\u001a\u0010,\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\b[\u0010QR\u001a\u0010+\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\b\\\u0010QR\u001a\u0010-\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\b]\u0010QR\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010<R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010<R\u0016\u0010%\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u00106R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010<R\u0016\u00100\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u00106R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010<R\u0016\u00102\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010<R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010R\u001a\u0004\be\u0010QR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bf\u0010?R\u001a\u0010(\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u00109\u001a\u0004\bg\u00108R\u0016\u0010/\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010UR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010<\u00a8\u0006\u009e\u0001"}, d2 = {"Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/UserEntity;", "", "id", "", "lowerName", "", "name", "fullName", "email", "keepEmailPrivate", "", "emailNotificationsPreference", "passwd", "passwdHashAlgo", "mustChangePassword", "loginType", "", "loginSource", "loginName", "type", "location", "website", "rands", "salt", "language", "description", "createdUnix", "updatedUnix", "lastLoginUnix", "lastRepoVisibility", "maxRepoCreation", "isActive", "isAdmin", "isRestricted", "allowGitHook", "allowImportLocal", "allowCreateOrganization", "prohibitLogin", "avatar", "avatarEmail", "useCustomAvatar", "numFollowers", "numFollowing", "numStars", "numRepos", "numTeams", "numMembers", "visibility", "repoAdminChangeTeamAccess", "diffViewStyle", "theme", "keepActivityPrivate", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;ILjava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/Boolean;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IZLjava/lang/String;Ljava/lang/String;Z)V", "getAllowCreateOrganization", "()Z", "getAllowGitHook", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAllowImportLocal", "getAvatar", "()Ljava/lang/String;", "getAvatarEmail", "getCreatedUnix", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "getDiffViewStyle", "getEmail", "getEmailNotificationsPreference", "getFullName", "getId", "getKeepActivityPrivate", "getKeepEmailPrivate", "getLanguage", "getLastLoginUnix", "getLastRepoVisibility", "getLocation", "getLoginName", "getLoginSource", "()J", "getLoginType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLowerName", "getMaxRepoCreation", "()I", "getMustChangePassword", "getName", "getNumFollowers", "getNumFollowing", "getNumMembers", "getNumRepos", "getNumStars", "getNumTeams", "getPasswd", "getPasswdHashAlgo", "getProhibitLogin", "getRands", "getRepoAdminChangeTeamAccess", "getSalt", "getTheme", "getType", "getUpdatedUnix", "getUseCustomAvatar", "getVisibility", "getWebsite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;ILjava/lang/Boolean;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/Boolean;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IZLjava/lang/String;Ljava/lang/String;Z)Lswm/virtuoso/reviewservice/adapter/out/persistence/entity/UserEntity;", "equals", "other", "hashCode", "toString", "Review-Service"})
public final class UserEntity {
    @jakarta.persistence.Id()
    @org.hibernate.annotations.ColumnDefault(value = "nextval(\'user_id_seq\'::regclass)")
    @jakarta.persistence.Column(name = "id", nullable = false)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long id = null;
    @jakarta.persistence.Column(name = "lower_name", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String lowerName = null;
    @jakarta.persistence.Column(name = "name", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @jakarta.persistence.Column(name = "full_name")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String fullName = null;
    @jakarta.persistence.Column(name = "email", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @jakarta.persistence.Column(name = "keep_email_private")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean keepEmailPrivate = null;
    @org.hibernate.annotations.ColumnDefault(value = "\'enabled\'")
    @jakarta.persistence.Column(name = "email_notifications_preference", nullable = false, length = 20)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String emailNotificationsPreference = null;
    @jakarta.persistence.Column(name = "passwd", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String passwd = null;
    @org.hibernate.annotations.ColumnDefault(value = "\'argon2\'")
    @jakarta.persistence.Column(name = "passwd_hash_algo", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String passwdHashAlgo = null;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "must_change_password", nullable = false)
    private final boolean mustChangePassword = false;
    @jakarta.persistence.Column(name = "login_type")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer loginType = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "login_source", nullable = false)
    private final long loginSource = 0L;
    @jakarta.persistence.Column(name = "login_name")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String loginName = null;
    @jakarta.persistence.Column(name = "type")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer type = null;
    @jakarta.persistence.Column(name = "location")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String location = null;
    @jakarta.persistence.Column(name = "website")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String website = null;
    @jakarta.persistence.Column(name = "rands", length = 32)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String rands = null;
    @jakarta.persistence.Column(name = "salt", length = 32)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String salt = null;
    @jakarta.persistence.Column(name = "language", length = 5)
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String language = null;
    @jakarta.persistence.Column(name = "description")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String description = null;
    @jakarta.persistence.Column(name = "created_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long createdUnix = null;
    @jakarta.persistence.Column(name = "updated_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long updatedUnix = null;
    @jakarta.persistence.Column(name = "last_login_unix")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long lastLoginUnix = null;
    @jakarta.persistence.Column(name = "last_repo_visibility")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean lastRepoVisibility = null;
    @org.hibernate.annotations.ColumnDefault(value = "\'-1\'::integer")
    @jakarta.persistence.Column(name = "max_repo_creation", nullable = false)
    private final int maxRepoCreation = 0;
    @jakarta.persistence.Column(name = "is_active")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isActive = null;
    @jakarta.persistence.Column(name = "is_admin")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isAdmin = null;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "is_restricted", nullable = false)
    private final boolean isRestricted = false;
    @jakarta.persistence.Column(name = "allow_git_hook")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean allowGitHook = null;
    @jakarta.persistence.Column(name = "allow_import_local")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean allowImportLocal = null;
    @org.hibernate.annotations.ColumnDefault(value = "true")
    @jakarta.persistence.Column(name = "allow_create_organization")
    private final boolean allowCreateOrganization = false;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "prohibit_login", nullable = false)
    private final boolean prohibitLogin = false;
    @jakarta.persistence.Column(name = "avatar", nullable = false, length = 2048)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String avatar = null;
    @jakarta.persistence.Column(name = "avatar_email", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String avatarEmail = null;
    @jakarta.persistence.Column(name = "use_custom_avatar")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean useCustomAvatar = null;
    @jakarta.persistence.Column(name = "num_followers")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numFollowers = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "num_following", nullable = false)
    private final int numFollowing = 0;
    @jakarta.persistence.Column(name = "num_stars")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numStars = null;
    @jakarta.persistence.Column(name = "num_repos")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numRepos = null;
    @jakarta.persistence.Column(name = "num_teams")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numTeams = null;
    @jakarta.persistence.Column(name = "num_members")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer numMembers = null;
    @org.hibernate.annotations.ColumnDefault(value = "0")
    @jakarta.persistence.Column(name = "visibility", nullable = false)
    private final int visibility = 0;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "repo_admin_change_team_access", nullable = false)
    private final boolean repoAdminChangeTeamAccess = false;
    @org.hibernate.annotations.ColumnDefault(value = "\'\'")
    @jakarta.persistence.Column(name = "diff_view_style", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String diffViewStyle = null;
    @org.hibernate.annotations.ColumnDefault(value = "\'\'")
    @jakarta.persistence.Column(name = "theme", nullable = false)
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String theme = null;
    @org.hibernate.annotations.ColumnDefault(value = "false")
    @jakarta.persistence.Column(name = "keep_activity_private", nullable = false)
    private final boolean keepActivityPrivate = false;
    
    public UserEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String lowerName, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean keepEmailPrivate, @org.jetbrains.annotations.NotNull()
    java.lang.String emailNotificationsPreference, @org.jetbrains.annotations.NotNull()
    java.lang.String passwd, @org.jetbrains.annotations.NotNull()
    java.lang.String passwdHashAlgo, boolean mustChangePassword, @org.jetbrains.annotations.Nullable()
    java.lang.Integer loginType, long loginSource, @org.jetbrains.annotations.Nullable()
    java.lang.String loginName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer type, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    java.lang.String rands, @org.jetbrains.annotations.Nullable()
    java.lang.String salt, @org.jetbrains.annotations.Nullable()
    java.lang.String language, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastLoginUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean lastRepoVisibility, int maxRepoCreation, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isActive, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isAdmin, boolean isRestricted, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean allowGitHook, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean allowImportLocal, boolean allowCreateOrganization, boolean prohibitLogin, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarEmail, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean useCustomAvatar, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numFollowers, int numFollowing, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numStars, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numRepos, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numTeams, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numMembers, int visibility, boolean repoAdminChangeTeamAccess, @org.jetbrains.annotations.NotNull()
    java.lang.String diffViewStyle, @org.jetbrains.annotations.NotNull()
    java.lang.String theme, boolean keepActivityPrivate) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getId() {
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
    public final java.lang.String getFullName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getKeepEmailPrivate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmailNotificationsPreference() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPasswd() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPasswdHashAlgo() {
        return null;
    }
    
    public final boolean getMustChangePassword() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLoginType() {
        return null;
    }
    
    public final long getLoginSource() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLoginName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWebsite() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRands() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSalt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
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
    public final java.lang.Long getLastLoginUnix() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getLastRepoVisibility() {
        return null;
    }
    
    public final int getMaxRepoCreation() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isActive() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isAdmin() {
        return null;
    }
    
    public final boolean isRestricted() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getAllowGitHook() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getAllowImportLocal() {
        return null;
    }
    
    public final boolean getAllowCreateOrganization() {
        return false;
    }
    
    public final boolean getProhibitLogin() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatarEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getUseCustomAvatar() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumFollowers() {
        return null;
    }
    
    public final int getNumFollowing() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumStars() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumRepos() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumTeams() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumMembers() {
        return null;
    }
    
    public final int getVisibility() {
        return 0;
    }
    
    public final boolean getRepoAdminChangeTeamAccess() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDiffViewStyle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTheme() {
        return null;
    }
    
    public final boolean getKeepActivityPrivate() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component24() {
        return null;
    }
    
    public final int component25() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component27() {
        return null;
    }
    
    public final boolean component28() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component30() {
        return null;
    }
    
    public final boolean component31() {
        return false;
    }
    
    public final boolean component32() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component36() {
        return null;
    }
    
    public final int component37() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component40() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component41() {
        return null;
    }
    
    public final int component42() {
        return 0;
    }
    
    public final boolean component43() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component44() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component45() {
        return null;
    }
    
    public final boolean component46() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final swm.virtuoso.reviewservice.adapter.out.persistence.entity.UserEntity copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long id, @org.jetbrains.annotations.NotNull()
    java.lang.String lowerName, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean keepEmailPrivate, @org.jetbrains.annotations.NotNull()
    java.lang.String emailNotificationsPreference, @org.jetbrains.annotations.NotNull()
    java.lang.String passwd, @org.jetbrains.annotations.NotNull()
    java.lang.String passwdHashAlgo, boolean mustChangePassword, @org.jetbrains.annotations.Nullable()
    java.lang.Integer loginType, long loginSource, @org.jetbrains.annotations.Nullable()
    java.lang.String loginName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer type, @org.jetbrains.annotations.Nullable()
    java.lang.String location, @org.jetbrains.annotations.Nullable()
    java.lang.String website, @org.jetbrains.annotations.Nullable()
    java.lang.String rands, @org.jetbrains.annotations.Nullable()
    java.lang.String salt, @org.jetbrains.annotations.Nullable()
    java.lang.String language, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.Long createdUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long updatedUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Long lastLoginUnix, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean lastRepoVisibility, int maxRepoCreation, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isActive, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isAdmin, boolean isRestricted, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean allowGitHook, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean allowImportLocal, boolean allowCreateOrganization, boolean prohibitLogin, @org.jetbrains.annotations.NotNull()
    java.lang.String avatar, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarEmail, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean useCustomAvatar, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numFollowers, int numFollowing, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numStars, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numRepos, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numTeams, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numMembers, int visibility, boolean repoAdminChangeTeamAccess, @org.jetbrains.annotations.NotNull()
    java.lang.String diffViewStyle, @org.jetbrains.annotations.NotNull()
    java.lang.String theme, boolean keepActivityPrivate) {
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