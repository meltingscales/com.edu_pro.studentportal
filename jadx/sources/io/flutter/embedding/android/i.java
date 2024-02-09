package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public class i extends SurfaceView implements io.flutter.embedding.engine.renderer.c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f275a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f276b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f277c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.embedding.engine.renderer.a f278d;
    private final SurfaceHolder.Callback e;
    private final io.flutter.embedding.engine.renderer.b f;

    /* loaded from: classes.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            c.a.b.e("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (i.this.f277c) {
                i.this.j(i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            c.a.b.e("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            i.this.f276b = true;
            if (i.this.f277c) {
                i.this.k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            c.a.b.e("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            i.this.f276b = false;
            if (i.this.f277c) {
                i.this.l();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements io.flutter.embedding.engine.renderer.b {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void e() {
            c.a.b.e("FlutterSurfaceView", "onFlutterUiDisplayed()");
            i.this.setAlpha(1.0f);
            if (i.this.f278d != null) {
                i.this.f278d.l(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.b
        public void f() {
        }
    }

    private i(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.f276b = false;
        this.f277c = false;
        this.e = new a();
        this.f = new b();
        this.f275a = z;
        m();
    }

    public i(Context context, boolean z) {
        this(context, null, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, int i2) {
        if (this.f278d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        c.a.b.e("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.f278d.q(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f278d == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f278d.o(getHolder().getSurface());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        io.flutter.embedding.engine.renderer.a aVar = this.f278d;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.p();
    }

    private void m() {
        if (this.f275a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.e);
        setAlpha(0.0f);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a(io.flutter.embedding.engine.renderer.a aVar) {
        c.a.b.e("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f278d != null) {
            c.a.b.e("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f278d.p();
            this.f278d.l(this.f);
        }
        this.f278d = aVar;
        this.f277c = true;
        aVar.f(this.f);
        if (this.f276b) {
            c.a.b.e("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            k();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b() {
        if (this.f278d == null) {
            c.a.b.f("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f278d = null;
        this.f277c = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.f278d == null) {
            c.a.b.f("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            c.a.b.e("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            l();
        }
        setAlpha(0.0f);
        this.f278d.l(this.f);
        this.f278d = null;
        this.f277c = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.f278d;
    }
}
