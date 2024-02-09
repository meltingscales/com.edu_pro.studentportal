package io.flutter.embedding.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;

@TargetApi(19)
/* loaded from: classes.dex */
public class h extends View implements io.flutter.embedding.engine.renderer.c {

    /* renamed from: a  reason: collision with root package name */
    private ImageReader f267a;

    /* renamed from: b  reason: collision with root package name */
    private Image f268b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f269c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.embedding.engine.renderer.a f270d;
    private b e;
    private boolean f;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f271a;

        static {
            int[] iArr = new int[b.values().length];
            f271a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f271a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        background,
        overlay
    }

    public h(Context context, int i, int i2, b bVar) {
        this(context, f(i, i2), bVar);
    }

    h(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f = false;
        this.f267a = imageReader;
        this.e = bVar;
        g();
    }

    private void e() {
        Image image = this.f268b;
        if (image != null) {
            image.close();
            this.f268b = null;
        }
    }

    @TargetApi(19)
    private static ImageReader f(int i, int i2) {
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i, i2, 1, 3, 768L) : ImageReader.newInstance(i, i2, 1, 3);
    }

    private void g() {
        setAlpha(0.0f);
    }

    @TargetApi(29)
    private void i() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f268b.getHardwareBuffer();
            this.f269c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f268b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f268b.getHeight();
        Bitmap bitmap = this.f269c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f269c.getHeight() != height) {
            this.f269c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f269c.copyPixelsFromBuffer(buffer);
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void a(io.flutter.embedding.engine.renderer.a aVar) {
        if (a.f271a[this.e.ordinal()] == 1) {
            aVar.r(this.f267a.getSurface());
        }
        setAlpha(1.0f);
        this.f270d = aVar;
        this.f = true;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void b() {
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public void c() {
        if (this.f) {
            setAlpha(0.0f);
            d();
            this.f269c = null;
            e();
            invalidate();
            this.f = false;
        }
    }

    @TargetApi(19)
    public boolean d() {
        if (this.f) {
            Image acquireLatestImage = this.f267a.acquireLatestImage();
            if (acquireLatestImage != null) {
                e();
                this.f268b = acquireLatestImage;
                invalidate();
            }
            return acquireLatestImage != null;
        }
        return false;
    }

    @Override // io.flutter.embedding.engine.renderer.c
    public io.flutter.embedding.engine.renderer.a getAttachedRenderer() {
        return this.f270d;
    }

    public Surface getSurface() {
        return this.f267a.getSurface();
    }

    public void h(int i, int i2) {
        if (this.f270d == null) {
            return;
        }
        if (i == this.f267a.getWidth() && i2 == this.f267a.getHeight()) {
            return;
        }
        e();
        this.f267a.close();
        this.f267a = f(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f268b != null) {
            i();
        }
        Bitmap bitmap = this.f269c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == this.f267a.getWidth() && i2 == this.f267a.getHeight()) && this.e == b.background && this.f) {
            h(i, i2);
            this.f270d.r(this.f267a.getSurface());
        }
    }
}
