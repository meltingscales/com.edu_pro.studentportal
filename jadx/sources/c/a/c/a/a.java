package c.a.c.a;

import c.a.c.a.b;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.b f193a;

    /* renamed from: b  reason: collision with root package name */
    private final String f194b;

    /* renamed from: c  reason: collision with root package name */
    private final g<T> f195c;

    /* loaded from: classes.dex */
    private final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f196a;

        /* renamed from: c.a.c.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0017a implements e<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b.InterfaceC0018b f198a;

            C0017a(b.InterfaceC0018b interfaceC0018b) {
                this.f198a = interfaceC0018b;
            }

            @Override // c.a.c.a.a.e
            public void a(T t) {
                this.f198a.a(a.this.f195c.b(t));
            }
        }

        private b(d<T> dVar) {
            this.f196a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0018b interfaceC0018b) {
            try {
                this.f196a.a(a.this.f195c.a(byteBuffer), new C0017a(interfaceC0018b));
            } catch (RuntimeException e) {
                c.a.b.c("BasicMessageChannel#" + a.this.f194b, "Failed to handle message", e);
                interfaceC0018b.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements b.InterfaceC0018b {

        /* renamed from: a  reason: collision with root package name */
        private final e<T> f200a;

        private c(e<T> eVar) {
            this.f200a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.a.c.a.b.InterfaceC0018b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f200a.a(a.this.f195c.a(byteBuffer));
            } catch (RuntimeException e) {
                c.a.b.c("BasicMessageChannel#" + a.this.f194b, "Failed to handle message reply", e);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        void a(T t, e<T> eVar);
    }

    /* loaded from: classes.dex */
    public interface e<T> {
        void a(T t);
    }

    public a(c.a.c.a.b bVar, String str, g<T> gVar) {
        this.f193a = bVar;
        this.f194b = str;
        this.f195c = gVar;
    }

    public void c(T t) {
        d(t, null);
    }

    public void d(T t, e<T> eVar) {
        this.f193a.a(this.f194b, this.f195c.b(t), eVar != null ? new c(eVar) : null);
    }

    public void e(d<T> dVar) {
        this.f193a.c(this.f194b, dVar != null ? new b(dVar) : null);
    }
}
