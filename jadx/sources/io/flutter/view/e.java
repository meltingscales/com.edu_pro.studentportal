package io.flutter.view;

import android.view.Choreographer;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    private static e f719c;

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f720a;

    /* renamed from: b  reason: collision with root package name */
    private final FlutterJNI.b f721b = new a();

    /* loaded from: classes.dex */
    class a implements FlutterJNI.b {

        /* renamed from: io.flutter.view.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class Choreographer$FrameCallbackC0043a implements Choreographer.FrameCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f723a;

            Choreographer$FrameCallbackC0043a(long j) {
                this.f723a = j;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                double refreshRate = e.this.f720a.getDefaultDisplay().getRefreshRate();
                Double.isNaN(refreshRate);
                FlutterJNI.nativeOnVsync(j, j + ((long) (1.0E9d / refreshRate)), this.f723a);
            }
        }

        a() {
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j) {
            Choreographer.getInstance().postFrameCallback(new Choreographer$FrameCallbackC0043a(j));
        }
    }

    private e(WindowManager windowManager) {
        this.f720a = windowManager;
    }

    public static e b(WindowManager windowManager) {
        if (f719c == null) {
            f719c = new e(windowManager);
        }
        return f719c;
    }

    public void c() {
        FlutterJNI.setAsyncWaitForVsyncDelegate(this.f721b);
        FlutterJNI.setRefreshRateFPS(this.f720a.getDefaultDisplay().getRefreshRate());
    }
}
