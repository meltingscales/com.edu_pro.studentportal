package c.a.c.a;

import c.a.c.a.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.b f208a;

    /* renamed from: b  reason: collision with root package name */
    private final String f209b;

    /* renamed from: c  reason: collision with root package name */
    private final j f210c;

    /* loaded from: classes.dex */
    private final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final c f211a;

        /* renamed from: c.a.c.a.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0019a implements d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0018b f213a;

            C0019a(b.InterfaceC0018b interfaceC0018b) {
                this.f213a = interfaceC0018b;
            }

            @Override // c.a.c.a.i.d
            public void a(String str, String str2, Object obj) {
                this.f213a.a(i.this.f210c.c(str, str2, obj));
            }

            @Override // c.a.c.a.i.d
            public void b(Object obj) {
                this.f213a.a(i.this.f210c.d(obj));
            }

            @Override // c.a.c.a.i.d
            public void c() {
                this.f213a.a(null);
            }
        }

        a(c cVar) {
            this.f211a = cVar;
        }

        private String b(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        @Override // c.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0018b interfaceC0018b) {
            try {
                this.f211a.f(i.this.f210c.e(byteBuffer), new C0019a(interfaceC0018b));
            } catch (RuntimeException e) {
                c.a.b.c("MethodChannel#" + i.this.f209b, "Failed to handle method call", e);
                interfaceC0018b.a(i.this.f210c.a("error", e.getMessage(), null, b(e)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b implements b.InterfaceC0018b {

        /* renamed from: a  reason: collision with root package name */
        private final d f215a;

        b(d dVar) {
            this.f215a = dVar;
        }

        @Override // c.a.c.a.b.InterfaceC0018b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f215a.c();
                } else {
                    try {
                        this.f215a.b(i.this.f210c.f(byteBuffer));
                    } catch (c.a.c.a.c e) {
                        this.f215a.a(e.f202a, e.getMessage(), e.f203b);
                    }
                }
            } catch (RuntimeException e2) {
                c.a.b.c("MethodChannel#" + i.this.f209b, "Failed to handle method call result", e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void f(h hVar, d dVar);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(String str, String str2, Object obj);

        void b(Object obj);

        void c();
    }

    public i(c.a.c.a.b bVar, String str) {
        this(bVar, str, q.f220b);
    }

    public i(c.a.c.a.b bVar, String str, j jVar) {
        this.f208a = bVar;
        this.f209b = str;
        this.f210c = jVar;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f208a.a(this.f209b, this.f210c.b(new h(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        this.f208a.c(this.f209b, cVar == null ? null : new a(cVar));
    }
}
