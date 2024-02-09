package io.flutter.plugins.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import c.a.c.a.i;
import c.a.c.a.j;
import c.a.c.a.q;
import io.flutter.embedding.engine.i.a;
import io.flutter.plugins.b.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class h implements io.flutter.embedding.engine.i.a, i.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f604a;

    /* renamed from: b  reason: collision with root package name */
    private c.a.c.a.i f605b;

    /* renamed from: c  reason: collision with root package name */
    private c f606c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements c {
        private b() {
        }

        @Override // io.flutter.plugins.b.h.c
        public void a(i.d dVar) {
            dVar.b(h.this.k());
        }

        @Override // io.flutter.plugins.b.h.c
        public void b(i.d dVar) {
            dVar.b(h.this.o());
        }

        @Override // io.flutter.plugins.b.h.c
        public void c(i.d dVar) {
            dVar.b(h.this.n());
        }

        @Override // io.flutter.plugins.b.h.c
        public void d(String str, i.d dVar) {
            dVar.b(h.this.m(str));
        }

        @Override // io.flutter.plugins.b.h.c
        public void e(i.d dVar) {
            dVar.b(h.this.l());
        }

        @Override // io.flutter.plugins.b.h.c
        public void f(i.d dVar) {
            dVar.b(h.this.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        void a(i.d dVar);

        void b(i.d dVar);

        void c(i.d dVar);

        void d(String str, i.d dVar);

        void e(i.d dVar);

        void f(i.d dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f608a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f609b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX INFO: Add missing generic type declarations: [T] */
        /* loaded from: classes.dex */
        public class a<T> implements b.a.a.b.a.b<T> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i.d f611a;

            a(d dVar, i.d dVar2) {
                this.f611a = dVar2;
            }

            @Override // b.a.a.b.a.b
            public void a(Throwable th) {
                this.f611a.a(th.getClass().getName(), th.getMessage(), null);
            }

            @Override // b.a.a.b.a.b
            public void b(T t) {
                this.f611a.b(t);
            }
        }

        private d() {
            this.f608a = new e();
            b.a.a.b.a.g gVar = new b.a.a.b.a.g();
            gVar.e("path-provider-background-%d");
            gVar.f(5);
            this.f609b = Executors.newSingleThreadExecutor(gVar.b());
        }

        private <T> void g(final Callable<T> callable, i.d dVar) {
            final b.a.a.b.a.f C = b.a.a.b.a.f.C();
            b.a.a.b.a.c.a(C, new a(this, dVar), this.f608a);
            this.f609b.execute(new Runnable() { // from class: io.flutter.plugins.b.a
                @Override // java.lang.Runnable
                public final void run() {
                    h.d.h(b.a.a.b.a.f.this, callable);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void h(b.a.a.b.a.f fVar, Callable callable) {
            try {
                fVar.z(callable.call());
            } catch (Throwable th) {
                fVar.A(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i */
        public /* synthetic */ String j() {
            return h.this.k();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k */
        public /* synthetic */ String l() {
            return h.this.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: m */
        public /* synthetic */ List n() {
            return h.this.l();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ List p(String str) {
            return h.this.m(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: q */
        public /* synthetic */ String r() {
            return h.this.n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: s */
        public /* synthetic */ String t() {
            return h.this.o();
        }

        @Override // io.flutter.plugins.b.h.c
        public void a(i.d dVar) {
            g(new Callable() { // from class: io.flutter.plugins.b.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.d.this.j();
                }
            }, dVar);
        }

        @Override // io.flutter.plugins.b.h.c
        public void b(i.d dVar) {
            g(new Callable() { // from class: io.flutter.plugins.b.c
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.d.this.t();
                }
            }, dVar);
        }

        @Override // io.flutter.plugins.b.h.c
        public void c(i.d dVar) {
            g(new Callable() { // from class: io.flutter.plugins.b.d
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.d.this.r();
                }
            }, dVar);
        }

        @Override // io.flutter.plugins.b.h.c
        public void d(final String str, i.d dVar) {
            g(new Callable() { // from class: io.flutter.plugins.b.f
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.d.this.p(str);
                }
            }, dVar);
        }

        @Override // io.flutter.plugins.b.h.c
        public void e(i.d dVar) {
            g(new Callable() { // from class: io.flutter.plugins.b.b
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.d.this.n();
                }
            }, dVar);
        }

        @Override // io.flutter.plugins.b.h.c
        public void f(i.d dVar) {
            g(new Callable() { // from class: io.flutter.plugins.b.e
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.d.this.l();
                }
            }, dVar);
        }
    }

    /* loaded from: classes.dex */
    private static class e implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f612a;

        private e() {
            this.f612a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f612a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j() {
        return c.a.d.a.c(this.f604a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        return c.a.d.a.b(this.f604a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> l() {
        File[] externalCacheDirs;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.f604a.getExternalCacheDirs()) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalCacheDir = this.f604a.getExternalCacheDir();
            if (externalCacheDir != null) {
                arrayList.add(externalCacheDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> m(String str) {
        File[] externalFilesDirs;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 19) {
            for (File file : this.f604a.getExternalFilesDirs(str)) {
                if (file != null) {
                    arrayList.add(file.getAbsolutePath());
                }
            }
        } else {
            File externalFilesDir = this.f604a.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                arrayList.add(externalFilesDir.getAbsolutePath());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        File externalFilesDir = this.f604a.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o() {
        return this.f604a.getCacheDir().getPath();
    }

    private void p(c.a.c.a.b bVar, Context context) {
        try {
            this.f605b = (c.a.c.a.i) Class.forName("c.a.c.a.i").getConstructor(c.a.c.a.b.class, String.class, j.class, Class.forName("io.flutter.plugin.common.BinaryMessenger$TaskQueue")).newInstance(bVar, "plugins.flutter.io/path_provider", q.f220b, bVar.getClass().getMethod("makeBackgroundTaskQueue", new Class[0]).invoke(bVar, new Object[0]));
            this.f606c = new b();
            Log.d("PathProviderPlugin", "Use TaskQueues.");
        } catch (Exception unused) {
            this.f605b = new c.a.c.a.i(bVar, "plugins.flutter.io/path_provider");
            this.f606c = new d();
            Log.d("PathProviderPlugin", "Don't use TaskQueues.");
        }
        this.f604a = context;
        this.f605b.e(this);
    }

    @Override // io.flutter.embedding.engine.i.a
    public void d(a.b bVar) {
        this.f605b.e(null);
        this.f605b = null;
    }

    @Override // c.a.c.a.i.c
    public void f(c.a.c.a.h hVar, i.d dVar) {
        String str = hVar.f206a;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1832373352:
                if (str.equals("getApplicationSupportDirectory")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1208689078:
                if (str.equals("getExternalCacheDirectories")) {
                    c2 = 1;
                    break;
                }
                break;
            case 299667825:
                if (str.equals("getExternalStorageDirectories")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1200320591:
                if (str.equals("getApplicationDocumentsDirectory")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1252916648:
                if (str.equals("getStorageDirectory")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1711844626:
                if (str.equals("getTemporaryDirectory")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.f606c.f(dVar);
                return;
            case 1:
                this.f606c.e(dVar);
                return;
            case 2:
                this.f606c.d(i.a((Integer) hVar.a("type")), dVar);
                return;
            case 3:
                this.f606c.a(dVar);
                return;
            case 4:
                this.f606c.c(dVar);
                return;
            case 5:
                this.f606c.b(dVar);
                return;
            default:
                dVar.c();
                return;
        }
    }

    @Override // io.flutter.embedding.engine.i.a
    public void g(a.b bVar) {
        p(bVar.b(), bVar.a());
    }
}
