package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import io.flutter.embedding.engine.f.a;
import io.flutter.plugin.platform.e;
import java.util.Arrays;

/* loaded from: classes.dex */
class f implements d<Activity> {

    /* renamed from: a  reason: collision with root package name */
    private c f257a;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.engine.b f258b;

    /* renamed from: c  reason: collision with root package name */
    private k f259c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.plugin.platform.e f260d;
    ViewTreeObserver.OnPreDrawListener e;
    private boolean f;
    private boolean g;
    private final io.flutter.embedding.engine.renderer.b h = new a();

    /* loaded from: classes.dex */
    class a implements io.flutter.embedding.engine.renderer.b {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void e() {
            f.this.f257a.e();
            f.this.g = true;
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void f() {
            f.this.f257a.f();
            f.this.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f262a;

        b(k kVar) {
            this.f262a = kVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (f.this.g && f.this.e != null) {
                this.f262a.getViewTreeObserver().removeOnPreDrawListener(this);
                f.this.e = null;
            }
            return f.this.g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c extends e.d {
        void A(i iVar);

        androidx.lifecycle.d a();

        Activity b();

        void c();

        void e();

        void f();

        String g();

        io.flutter.embedding.engine.e h();

        String k();

        io.flutter.embedding.engine.b l(Context context);

        boolean m();

        o n();

        boolean o();

        boolean p();

        r q();

        void r(j jVar);

        String s();

        void t(io.flutter.embedding.engine.b bVar);

        boolean u();

        String v();

        void w(io.flutter.embedding.engine.b bVar);

        q x();

        io.flutter.plugin.platform.e y(Activity activity, io.flutter.embedding.engine.b bVar);

        Context z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f257a = cVar;
    }

    private void f(k kVar) {
        if (this.f257a.n() != o.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.e != null) {
            kVar.getViewTreeObserver().removeOnPreDrawListener(this.e);
        }
        this.e = new b(kVar);
        kVar.getViewTreeObserver().addOnPreDrawListener(this.e);
    }

    private void g() {
        if (this.f257a.s() == null && !this.f258b.h().h()) {
            String g = this.f257a.g();
            if (g == null && (g = l(this.f257a.b().getIntent())) == null) {
                g = "/";
            }
            c.a.b.e("FlutterActivityAndFragmentDelegate", "Executing Dart entrypoint: " + this.f257a.v() + ", and sending initial route: " + g);
            this.f258b.m().c(g);
            String k = this.f257a.k();
            if (k == null || k.isEmpty()) {
                k = c.a.a.d().b().e();
            }
            this.f258b.h().f(new a.b(k, this.f257a.v()));
        }
    }

    private void h() {
        if (this.f257a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String l(Intent intent) {
        Uri data;
        if (!this.f257a.p() || (data = intent.getData()) == null || data.getPath().isEmpty()) {
            return null;
        }
        String path = data.getPath();
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + "#" + data.getFragment();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onStop()");
        h();
        this.f258b.j().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i) {
        h();
        io.flutter.embedding.engine.b bVar = this.f258b;
        if (bVar == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        bVar.h().i();
        if (i == 10) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
            this.f258b.t().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        h();
        if (this.f258b == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
        this.f258b.g().f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D() {
        this.f257a = null;
        this.f258b = null;
        this.f259c = null;
        this.f260d = null;
    }

    void E() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String s = this.f257a.s();
        if (s != null) {
            io.flutter.embedding.engine.b a2 = io.flutter.embedding.engine.c.b().a(s);
            this.f258b = a2;
            this.f = true;
            if (a2 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + s + "'");
        }
        c cVar = this.f257a;
        io.flutter.embedding.engine.b l = cVar.l(cVar.z());
        this.f258b = l;
        if (l != null) {
            this.f = true;
            return;
        }
        c.a.b.e("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f258b = new io.flutter.embedding.engine.b(this.f257a.z(), this.f257a.h().b(), false, this.f257a.u());
        this.f = false;
    }

    @Override // io.flutter.embedding.android.d
    public void c() {
        if (!this.f257a.o()) {
            this.f257a.c();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f257a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    @Override // io.flutter.embedding.android.d
    /* renamed from: i */
    public Activity d() {
        Activity b2 = this.f257a.b();
        if (b2 != null) {
            return b2;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public io.flutter.embedding.engine.b j() {
        return this.f258b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i, int i2, Intent intent) {
        h();
        if (this.f258b == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
        this.f258b.g().c(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Context context) {
        h();
        if (this.f258b == null) {
            E();
        }
        if (this.f257a.m()) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f258b.g().g(this, this.f257a.a());
        }
        c cVar = this.f257a;
        this.f260d = cVar.y(cVar.b(), this.f258b);
        this.f257a.t(this.f258b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        h();
        if (this.f258b == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
        this.f258b.m().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View p(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        k kVar;
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        h();
        if (this.f257a.n() == o.surface) {
            i iVar = new i(this.f257a.z(), this.f257a.q() == r.transparent);
            this.f257a.A(iVar);
            kVar = new k(this.f257a.z(), iVar);
        } else {
            j jVar = new j(this.f257a.z());
            jVar.setOpaque(this.f257a.q() == r.opaque);
            this.f257a.r(jVar);
            kVar = new k(this.f257a.z(), jVar);
        }
        this.f259c = kVar;
        this.f259c.i(this.h);
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
        this.f259c.k(this.f258b);
        this.f259c.setId(i);
        q x = this.f257a.x();
        if (x == null) {
            if (z) {
                f(this.f259c);
            }
            return this.f259c;
        }
        c.a.b.f("FlutterActivityAndFragmentDelegate", "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
        FlutterSplashView flutterSplashView = new FlutterSplashView(this.f257a.z());
        flutterSplashView.setId(c.a.d.d.a(486947586));
        flutterSplashView.g(this.f259c, x);
        return flutterSplashView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        h();
        if (this.e != null) {
            this.f259c.getViewTreeObserver().removeOnPreDrawListener(this.e);
            this.e = null;
        }
        this.f259c.o();
        this.f259c.u(this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onDetach()");
        h();
        this.f257a.w(this.f258b);
        if (this.f257a.m()) {
            c.a.b.e("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f257a.b().isChangingConfigurations()) {
                this.f258b.g().j();
            } else {
                this.f258b.g().h();
            }
        }
        io.flutter.plugin.platform.e eVar = this.f260d;
        if (eVar != null) {
            eVar.o();
            this.f260d = null;
        }
        this.f258b.j().a();
        if (this.f257a.o()) {
            this.f258b.e();
            if (this.f257a.s() != null) {
                io.flutter.embedding.engine.c.b().d(this.f257a.s());
            }
            this.f258b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Intent intent) {
        h();
        if (this.f258b == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
        this.f258b.g().d(intent);
        String l = l(intent);
        if (l == null || l.isEmpty()) {
            return;
        }
        this.f258b.m().b(l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onPause()");
        h();
        this.f258b.j().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onPostResume()");
        h();
        if (this.f258b == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        io.flutter.plugin.platform.e eVar = this.f260d;
        if (eVar != null) {
            eVar.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(int i, String[] strArr, int[] iArr) {
        h();
        if (this.f258b == null) {
            c.a.b.f("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        c.a.b.e("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f258b.g().a(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Bundle bundle) {
        Bundle bundle2;
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        h();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f257a.u()) {
            this.f258b.r().j(bArr);
        }
        if (this.f257a.m()) {
            this.f258b.g().b(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onResume()");
        h();
        this.f258b.j().d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(Bundle bundle) {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        h();
        if (this.f257a.u()) {
            bundle.putByteArray("framework", this.f258b.r().h());
        }
        if (this.f257a.m()) {
            Bundle bundle2 = new Bundle();
            this.f258b.g().e(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        c.a.b.e("FlutterActivityAndFragmentDelegate", "onStart()");
        h();
        g();
    }
}
