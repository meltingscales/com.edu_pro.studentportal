package io.flutter.embedding.engine.h;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f364a;

    /* renamed from: b  reason: collision with root package name */
    private C0027c f365b;

    /* renamed from: c  reason: collision with root package name */
    private long f366c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.embedding.engine.h.b f367d;
    private FlutterJNI e;
    Future<b> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f368a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.flutter.embedding.engine.h.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0026a implements Runnable {
            RunnableC0026a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e.prefetchDefaultFontManager();
            }
        }

        a(Context context) {
            this.f368a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public b call() {
            d f = c.this.f(this.f368a);
            c.this.e.loadLibrary();
            Executors.newSingleThreadExecutor().execute(new RunnableC0026a());
            if (f == null) {
                return new b(c.a.d.a.c(this.f368a), c.a.d.a.a(this.f368a), c.a.d.a.b(this.f368a), null);
            }
            f.a();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final String f371a;

        /* renamed from: b  reason: collision with root package name */
        final String f372b;

        private b(String str, String str2, String str3) {
            this.f371a = str;
            this.f372b = str2;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    /* renamed from: io.flutter.embedding.engine.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027c {

        /* renamed from: a  reason: collision with root package name */
        private String f373a;

        public String a() {
            return this.f373a;
        }
    }

    public c() {
        this(c.a.a.d().c().a());
    }

    public c(FlutterJNI flutterJNI) {
        this.f364a = false;
        this.e = flutterJNI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d f(Context context) {
        return null;
    }

    public boolean c() {
        return this.f367d.e;
    }

    public void d(Context context, String[] strArr) {
        if (this.f364a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f365b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            b bVar = this.f.get();
            ArrayList arrayList = new ArrayList();
            arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
            StringBuilder sb = new StringBuilder();
            sb.append("--icu-native-lib-path=");
            sb.append(this.f367d.f363d);
            String str = File.separator;
            sb.append(str);
            sb.append("libflutter.so");
            arrayList.add(sb.toString());
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            arrayList.add("--aot-shared-library-name=" + this.f367d.f360a);
            arrayList.add("--aot-shared-library-name=" + this.f367d.f363d + str + this.f367d.f360a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("--cache-dir-path=");
            sb2.append(bVar.f372b);
            arrayList.add(sb2.toString());
            if (this.f367d.f362c != null) {
                arrayList.add("--domain-network-policy=" + this.f367d.f362c);
            }
            if (this.f365b.a() != null) {
                arrayList.add("--log-tag=" + this.f365b.a());
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            int i = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
            if (i == 0) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                double d2 = memoryInfo.totalMem;
                Double.isNaN(d2);
                i = (int) ((d2 / 1000000.0d) / 2.0d);
            }
            arrayList.add("--old-gen-heap-size=" + i);
            if (bundle != null && bundle.getBoolean("io.flutter.embedding.android.EnableSkParagraph")) {
                arrayList.add("--enable-skparagraph");
            }
            this.e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f371a, bVar.f372b, SystemClock.uptimeMillis() - this.f366c);
            this.f364a = true;
        } catch (Exception e) {
            c.a.b.c("FlutterLoader", "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    public String e() {
        return this.f367d.f361b;
    }

    public void g(Context context) {
        h(context, new C0027c());
    }

    public void h(Context context, C0027c c0027c) {
        if (this.f365b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        Context applicationContext = context.getApplicationContext();
        this.f365b = c0027c;
        this.f366c = SystemClock.uptimeMillis();
        this.f367d = io.flutter.embedding.engine.h.a.e(applicationContext);
        e.b((WindowManager) applicationContext.getSystemService("window")).c();
        this.f = Executors.newSingleThreadExecutor().submit(new a(applicationContext));
    }
}
