package io.flutter.embedding.engine.renderer;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.d;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f508a;

    /* renamed from: c  reason: collision with root package name */
    private Surface f510c;
    private final io.flutter.embedding.engine.renderer.b e;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicLong f509b = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    private boolean f511d = false;

    /* renamed from: io.flutter.embedding.engine.renderer.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0033a implements io.flutter.embedding.engine.renderer.b {
        C0033a() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void e() {
            a.this.f511d = true;
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void f() {
            a.this.f511d = false;
        }
    }

    /* loaded from: classes.dex */
    final class b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final long f513a;

        /* renamed from: b  reason: collision with root package name */
        private final SurfaceTextureWrapper f514b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f515c;

        /* renamed from: d  reason: collision with root package name */
        private SurfaceTexture.OnFrameAvailableListener f516d = new C0034a();

        /* renamed from: io.flutter.embedding.engine.renderer.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0034a implements SurfaceTexture.OnFrameAvailableListener {
            C0034a() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (b.this.f515c || !a.this.f508a.isAttached()) {
                    return;
                }
                b bVar = b.this;
                a.this.j(bVar.f513a);
            }
        }

        b(long j, SurfaceTexture surfaceTexture) {
            this.f513a = j;
            this.f514b = new SurfaceTextureWrapper(surfaceTexture);
            if (Build.VERSION.SDK_INT >= 21) {
                c().setOnFrameAvailableListener(this.f516d, new Handler());
            } else {
                c().setOnFrameAvailableListener(this.f516d);
            }
        }

        @Override // io.flutter.view.d.a
        public void a() {
            if (this.f515c) {
                return;
            }
            c.a.b.e("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f513a + ").");
            this.f514b.release();
            a.this.s(this.f513a);
            this.f515c = true;
        }

        @Override // io.flutter.view.d.a
        public long b() {
            return this.f513a;
        }

        @Override // io.flutter.view.d.a
        public SurfaceTexture c() {
            return this.f514b.surfaceTexture();
        }

        public SurfaceTextureWrapper f() {
            return this.f514b;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public float f518a = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public int f519b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f520c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f521d = 0;
        public int e = 0;
        public int f = 0;
        public int g = 0;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;
        public int n = 0;
        public int o = 0;
        public int p = -1;

        boolean a() {
            return this.f519b > 0 && this.f520c > 0 && this.f518a > 0.0f;
        }
    }

    public a(FlutterJNI flutterJNI) {
        C0033a c0033a = new C0033a();
        this.e = c0033a;
        this.f508a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0033a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.f508a.markTextureFrameAvailable(j);
    }

    private void k(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f508a.registerTexture(j, surfaceTextureWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j) {
        this.f508a.unregisterTexture(j);
    }

    @Override // io.flutter.view.d
    public d.a a() {
        c.a.b.e("FlutterRenderer", "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        b bVar = new b(this.f509b.getAndIncrement(), surfaceTexture);
        c.a.b.e("FlutterRenderer", "New SurfaceTexture ID: " + bVar.b());
        k(bVar.b(), bVar.f());
        return bVar;
    }

    public void f(io.flutter.embedding.engine.renderer.b bVar) {
        this.f508a.addIsDisplayingFlutterUiListener(bVar);
        if (this.f511d) {
            bVar.e();
        }
    }

    public void g(ByteBuffer byteBuffer, int i) {
        this.f508a.dispatchPointerDataPacket(byteBuffer, i);
    }

    public boolean h() {
        return this.f511d;
    }

    public boolean i() {
        return this.f508a.getIsSoftwareRenderingEnabled();
    }

    public void l(io.flutter.embedding.engine.renderer.b bVar) {
        this.f508a.removeIsDisplayingFlutterUiListener(bVar);
    }

    public void m(boolean z) {
        this.f508a.setSemanticsEnabled(z);
    }

    public void n(c cVar) {
        if (cVar.a()) {
            c.a.b.e("FlutterRenderer", "Setting viewport metrics\nSize: " + cVar.f519b + " x " + cVar.f520c + "\nPadding - L: " + cVar.g + ", T: " + cVar.f521d + ", R: " + cVar.e + ", B: " + cVar.f + "\nInsets - L: " + cVar.k + ", T: " + cVar.h + ", R: " + cVar.i + ", B: " + cVar.j + "\nSystem Gesture Insets - L: " + cVar.o + ", T: " + cVar.l + ", R: " + cVar.m + ", B: " + cVar.j);
            this.f508a.setViewportMetrics(cVar.f518a, cVar.f519b, cVar.f520c, cVar.f521d, cVar.e, cVar.f, cVar.g, cVar.h, cVar.i, cVar.j, cVar.k, cVar.l, cVar.m, cVar.n, cVar.o, cVar.p);
        }
    }

    public void o(Surface surface) {
        if (this.f510c != null) {
            p();
        }
        this.f510c = surface;
        this.f508a.onSurfaceCreated(surface);
    }

    public void p() {
        this.f508a.onSurfaceDestroyed();
        this.f510c = null;
        if (this.f511d) {
            this.e.f();
        }
        this.f511d = false;
    }

    public void q(int i, int i2) {
        this.f508a.onSurfaceChanged(i, i2);
    }

    public void r(Surface surface) {
        this.f510c = surface;
        this.f508a.onSurfaceWindowChanged(surface);
    }
}
