package androidx.core.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class a extends a.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static c f76a;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class RunnableC0005a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f77a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f78b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f79c;

        RunnableC0005a(String[] strArr, Activity activity, int i) {
            this.f77a = strArr;
            this.f78b = activity;
            this.f79c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f77a.length];
            PackageManager packageManager = this.f78b.getPackageManager();
            String packageName = this.f78b.getPackageName();
            int length = this.f77a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f77a[i], packageName);
            }
            ((b) this.f78b).a(this.f79c, this.f77a, iArr);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String[] strArr, int[] iArr);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(Activity activity, String[] strArr, int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);
    }

    public static void d(Activity activity, String[] strArr, int i) {
        c cVar = f76a;
        if (cVar == null || !cVar.a(activity, strArr, i)) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof d) {
                    ((d) activity).a(i);
                }
                activity.requestPermissions(strArr, i);
            } else if (activity instanceof b) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0005a(strArr, activity, i));
            }
        }
    }
}
