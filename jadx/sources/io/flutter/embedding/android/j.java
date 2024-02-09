package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes.dex */
public class j extends TextureView implements io.flutter.embedding.engine.renderer.c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f281a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f282b;

    /* renamed from: c  reason: collision with root package name */
    private io.flutter.embedding.engine.renderer.a f283c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f284d;
    private final TextureView.SurfaceTextureListener e;

    /* loaded from: classes.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            c.a.b.e("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            j.this.f281a = true;
            if (j.this.f282b) {
                j.this.j();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            c.a.b.e("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            j.this.f281a = false;
            if (j.this.f282b) {
                j.this.k();
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            c.a.b.e("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (j.this.f282b) {
                j.this.i(i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f281a = false;
        this.f282b = false;
        this.e = new a();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, int i2) {
        if (this.f283c == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        c.a.b.e("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i + " x " + i2);
        this.f283c.q(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f283c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = new Surface(getSurfaceTexture());
        this.f284d = surface;
        this.f283c.o(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        io.flutter.embedding.engine.renderer.a aVar = this.f283c;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.p();
        Surface surface = this.f284d;
        if (surface != null) {
            surface.release();
            this.f284d = null;
        }
    }

    private void l() {
        setSurfaceTextureListener(this.e);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a(io.flutter.embedding.engine.renderer.a aVar) {
        c.a.b.e("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f283c != null) {
            c.a.b.e("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f283c.p();
        }
        this.f283c = aVar;
        this.f282b = true;
        if (this.f281a) {
            c.a.b.e("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            j();
        }
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b() {
        if (this.f283c == null) {
            c.a.b.f("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f283c = null;
        this.f282b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.f283c == null) {
            c.a.b.f("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            c.a.b.e("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            k();
        }
        this.f283c = null;
        this.f282b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.f283c;
    }
}
