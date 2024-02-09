package c.a;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.h.c;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static a f186d;

    /* renamed from: a  reason: collision with root package name */
    private c f187a;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.engine.g.a f188b;

    /* renamed from: c  reason: collision with root package name */
    private FlutterJNI.c f189c;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private c f190a;

        /* renamed from: b  reason: collision with root package name */
        private io.flutter.embedding.engine.g.a f191b;

        /* renamed from: c  reason: collision with root package name */
        private FlutterJNI.c f192c;

        private void b() {
            if (this.f192c == null) {
                this.f192c = new FlutterJNI.c();
            }
            if (this.f190a == null) {
                this.f190a = new c(this.f192c.a());
            }
        }

        public a a() {
            b();
            return new a(this.f190a, this.f191b, this.f192c);
        }
    }

    private a(c cVar, io.flutter.embedding.engine.g.a aVar, FlutterJNI.c cVar2) {
        this.f187a = cVar;
        this.f188b = aVar;
        this.f189c = cVar2;
    }

    public static a d() {
        if (f186d == null) {
            f186d = new b().a();
        }
        return f186d;
    }

    public io.flutter.embedding.engine.g.a a() {
        return this.f188b;
    }

    public c b() {
        return this.f187a;
    }

    public FlutterJNI.c c() {
        return this.f189c;
    }
}
