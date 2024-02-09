package c.a.c.a;

import c.a.c.a.p;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class q implements j {

    /* renamed from: b  reason: collision with root package name */
    public static final q f220b = new q(p.f217a);

    /* renamed from: a  reason: collision with root package name */
    private final p f221a;

    public q(p pVar) {
        this.f221a = pVar;
    }

    private static String g(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // c.a.c.a.j
    public ByteBuffer a(String str, String str2, Object obj, String str3) {
        p.a aVar = new p.a();
        aVar.write(1);
        this.f221a.p(aVar, str);
        this.f221a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f221a.p(aVar, g((Throwable) obj));
        } else {
            this.f221a.p(aVar, obj);
        }
        this.f221a.p(aVar, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // c.a.c.a.j
    public ByteBuffer b(h hVar) {
        p.a aVar = new p.a();
        this.f221a.p(aVar, hVar.f206a);
        this.f221a.p(aVar, hVar.f207b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // c.a.c.a.j
    public ByteBuffer c(String str, String str2, Object obj) {
        p.a aVar = new p.a();
        aVar.write(1);
        this.f221a.p(aVar, str);
        this.f221a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f221a.p(aVar, g((Throwable) obj));
        } else {
            this.f221a.p(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // c.a.c.a.j
    public ByteBuffer d(Object obj) {
        p.a aVar = new p.a();
        aVar.write(0);
        this.f221a.p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // c.a.c.a.j
    public h e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f = this.f221a.f(byteBuffer);
        Object f2 = this.f221a.f(byteBuffer);
        if (!(f instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new h((String) f, f2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r0 == 1) goto L8;
     */
    @Override // c.a.c.a.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            c.a.c.a.p r0 = r4.f221a
            java.lang.Object r0 = r0.f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            c.a.c.a.p r0 = r4.f221a
            java.lang.Object r0 = r0.f(r5)
            c.a.c.a.p r1 = r4.f221a
            java.lang.Object r1 = r1.f(r5)
            c.a.c.a.p r2 = r4.f221a
            java.lang.Object r2 = r2.f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            c.a.c.a.c r5 = new c.a.c.a.c
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.c.a.q.f(java.nio.ByteBuffer):java.lang.Object");
    }
}
