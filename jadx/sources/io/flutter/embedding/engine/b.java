package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.j.f;
import io.flutter.embedding.engine.j.g;
import io.flutter.embedding.engine.j.h;
import io.flutter.embedding.engine.j.i;
import io.flutter.embedding.engine.j.k;
import io.flutter.embedding.engine.j.l;
import io.flutter.embedding.engine.j.m;
import io.flutter.embedding.engine.j.n;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f324a;

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.a f325b;

    /* renamed from: c  reason: collision with root package name */
    private final io.flutter.embedding.engine.f.a f326c;

    /* renamed from: d  reason: collision with root package name */
    private final d f327d;
    private final c.a.c.b.a e;
    private final io.flutter.embedding.engine.j.b f;
    private final io.flutter.embedding.engine.j.c g;
    private final io.flutter.embedding.engine.j.d h;
    private final io.flutter.embedding.engine.j.e i;
    private final f j;
    private final g k;
    private final h l;
    private final k m;
    private final i n;
    private final l o;
    private final m p;
    private final n q;
    private final io.flutter.plugin.platform.k r;
    private final Set<InterfaceC0023b> s;
    private final InterfaceC0023b t;

    /* loaded from: classes.dex */
    class a implements InterfaceC0023b {
        a() {
        }

        @Override // io.flutter.embedding.engine.b.InterfaceC0023b
        public void a() {
            c.a.b.e("FlutterEngine", "onPreEngineRestart()");
            for (InterfaceC0023b interfaceC0023b : b.this.s) {
                interfaceC0023b.a();
            }
            b.this.r.W();
            b.this.m.g();
        }

        @Override // io.flutter.embedding.engine.b.InterfaceC0023b
        public void b() {
        }
    }

    /* renamed from: io.flutter.embedding.engine.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0023b {
        void a();

        void b();
    }

    public b(Context context, io.flutter.embedding.engine.h.c cVar, FlutterJNI flutterJNI, io.flutter.plugin.platform.k kVar, String[] strArr, boolean z, boolean z2) {
        AssetManager assets;
        this.s = new HashSet();
        this.t = new a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        c.a.a d2 = c.a.a.d();
        flutterJNI = flutterJNI == null ? d2.c().a() : flutterJNI;
        this.f324a = flutterJNI;
        io.flutter.embedding.engine.f.a aVar = new io.flutter.embedding.engine.f.a(flutterJNI, assets);
        this.f326c = aVar;
        aVar.j();
        io.flutter.embedding.engine.g.a a2 = c.a.a.d().a();
        this.f = new io.flutter.embedding.engine.j.b(aVar, flutterJNI);
        io.flutter.embedding.engine.j.c cVar2 = new io.flutter.embedding.engine.j.c(aVar);
        this.g = cVar2;
        this.h = new io.flutter.embedding.engine.j.d(aVar);
        this.i = new io.flutter.embedding.engine.j.e(aVar);
        f fVar = new f(aVar);
        this.j = fVar;
        this.k = new g(aVar);
        this.l = new h(aVar);
        this.n = new i(aVar);
        this.m = new k(aVar, z2);
        this.o = new l(aVar);
        this.p = new m(aVar);
        this.q = new n(aVar);
        if (a2 != null) {
            a2.f(cVar2);
        }
        c.a.c.b.a aVar2 = new c.a.c.b.a(context, fVar);
        this.e = aVar2;
        cVar = cVar == null ? d2.b() : cVar;
        if (!flutterJNI.isAttached()) {
            cVar.g(context.getApplicationContext());
            cVar.d(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.t);
        flutterJNI.setPlatformViewsController(kVar);
        flutterJNI.setLocalizationPlugin(aVar2);
        flutterJNI.setDeferredComponentManager(d2.a());
        if (!flutterJNI.isAttached()) {
            d();
        }
        this.f325b = new io.flutter.embedding.engine.renderer.a(flutterJNI);
        this.r = kVar;
        kVar.Q();
        this.f327d = new d(context.getApplicationContext(), this, cVar);
        if (z && cVar.c()) {
            io.flutter.embedding.engine.i.g.a.a(this);
        }
    }

    public b(Context context, String[] strArr, boolean z, boolean z2) {
        this(context, null, null, new io.flutter.plugin.platform.k(), strArr, z, z2);
    }

    private void d() {
        c.a.b.e("FlutterEngine", "Attaching to JNI.");
        this.f324a.attachToNative(false);
        if (!v()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean v() {
        return this.f324a.isAttached();
    }

    public void e() {
        c.a.b.e("FlutterEngine", "Destroying.");
        for (InterfaceC0023b interfaceC0023b : this.s) {
            interfaceC0023b.b();
        }
        this.f327d.m();
        this.r.S();
        this.f326c.k();
        this.f324a.removeEngineLifecycleListener(this.t);
        this.f324a.setDeferredComponentManager(null);
        this.f324a.detachFromNativeAndReleaseResources();
        if (c.a.a.d().a() != null) {
            c.a.a.d().a().d();
            this.g.c(null);
        }
    }

    public io.flutter.embedding.engine.j.b f() {
        return this.f;
    }

    public io.flutter.embedding.engine.i.c.b g() {
        return this.f327d;
    }

    public io.flutter.embedding.engine.f.a h() {
        return this.f326c;
    }

    public io.flutter.embedding.engine.j.d i() {
        return this.h;
    }

    public io.flutter.embedding.engine.j.e j() {
        return this.i;
    }

    public c.a.c.b.a k() {
        return this.e;
    }

    public g l() {
        return this.k;
    }

    public h m() {
        return this.l;
    }

    public i n() {
        return this.n;
    }

    public io.flutter.plugin.platform.k o() {
        return this.r;
    }

    public io.flutter.embedding.engine.i.b p() {
        return this.f327d;
    }

    public io.flutter.embedding.engine.renderer.a q() {
        return this.f325b;
    }

    public k r() {
        return this.m;
    }

    public l s() {
        return this.o;
    }

    public m t() {
        return this.p;
    }

    public n u() {
        return this.q;
    }
}
