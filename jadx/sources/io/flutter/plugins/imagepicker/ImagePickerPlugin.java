package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import c.a.c.a.h;
import c.a.c.a.i;
import c.a.c.a.m;
import io.flutter.embedding.engine.i.a;
import java.io.File;

/* loaded from: classes.dex */
public class ImagePickerPlugin implements i.c, io.flutter.embedding.engine.i.a, io.flutter.embedding.engine.i.c.a {

    /* renamed from: a  reason: collision with root package name */
    private i f623a;

    /* renamed from: b  reason: collision with root package name */
    private e f624b;

    /* renamed from: c  reason: collision with root package name */
    private a.b f625c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.embedding.engine.i.c.c f626d;
    private Application e;
    private Activity f;
    private androidx.lifecycle.d g;
    private LifeCycleObserver h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class LifeCycleObserver implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f627a;

        LifeCycleObserver(Activity activity) {
            this.f627a = activity;
        }

        @Override // androidx.lifecycle.b
        public void a(androidx.lifecycle.g gVar) {
        }

        @Override // androidx.lifecycle.b
        public void b(androidx.lifecycle.g gVar) {
        }

        @Override // androidx.lifecycle.b
        public void c(androidx.lifecycle.g gVar) {
            onActivityDestroyed(this.f627a);
        }

        @Override // androidx.lifecycle.b
        public void d(androidx.lifecycle.g gVar) {
            onActivityStopped(this.f627a);
        }

        @Override // androidx.lifecycle.b
        public void e(androidx.lifecycle.g gVar) {
        }

        @Override // androidx.lifecycle.b
        public void f(androidx.lifecycle.g gVar) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f627a != activity || activity.getApplicationContext() == null) {
                return;
            }
            ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (this.f627a == activity) {
                ImagePickerPlugin.this.f624b.G();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class a implements i.d {

        /* renamed from: a  reason: collision with root package name */
        private i.d f629a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f630b = new Handler(Looper.getMainLooper());

        /* renamed from: io.flutter.plugins.imagepicker.ImagePickerPlugin$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0040a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f631a;

            RunnableC0040a(Object obj) {
                this.f631a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f629a.b(this.f631a);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f633a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f634b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Object f635c;

            b(String str, String str2, Object obj) {
                this.f633a = str;
                this.f634b = str2;
                this.f635c = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f629a.a(this.f633a, this.f634b, this.f635c);
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f629a.c();
            }
        }

        a(i.d dVar) {
            this.f629a = dVar;
        }

        @Override // c.a.c.a.i.d
        public void a(String str, String str2, Object obj) {
            this.f630b.post(new b(str, str2, obj));
        }

        @Override // c.a.c.a.i.d
        public void b(Object obj) {
            this.f630b.post(new RunnableC0040a(obj));
        }

        @Override // c.a.c.a.i.d
        public void c() {
            this.f630b.post(new c());
        }
    }

    private void j(c.a.c.a.b bVar, Application application, Activity activity, m mVar, io.flutter.embedding.engine.i.c.c cVar) {
        this.f = activity;
        this.e = application;
        this.f624b = i(activity);
        i iVar = new i(bVar, "plugins.flutter.io/image_picker");
        this.f623a = iVar;
        iVar.e(this);
        LifeCycleObserver lifeCycleObserver = new LifeCycleObserver(activity);
        this.h = lifeCycleObserver;
        if (mVar != null) {
            application.registerActivityLifecycleCallbacks(lifeCycleObserver);
            mVar.c(this.f624b);
            mVar.d(this.f624b);
            return;
        }
        cVar.c(this.f624b);
        cVar.d(this.f624b);
        androidx.lifecycle.d a2 = io.flutter.embedding.engine.plugins.lifecycle.a.a(cVar);
        this.g = a2;
        a2.a(this.h);
    }

    private void k() {
        this.f626d.f(this.f624b);
        this.f626d.e(this.f624b);
        this.f626d = null;
        this.g.c(this.h);
        this.g = null;
        this.f624b = null;
        this.f623a.e(null);
        this.f623a = null;
        this.e.unregisterActivityLifecycleCallbacks(this.h);
        this.e = null;
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void a() {
        k();
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void b(io.flutter.embedding.engine.i.c.c cVar) {
        this.f626d = cVar;
        j(this.f625c.b(), (Application) this.f625c.a(), this.f626d.b(), null, this.f626d);
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void c(io.flutter.embedding.engine.i.c.c cVar) {
        b(cVar);
    }

    @Override // io.flutter.embedding.engine.i.a
    public void d(a.b bVar) {
        this.f625c = null;
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void e() {
        a();
    }

    @Override // c.a.c.a.i.c
    public void f(h hVar, i.d dVar) {
        if (this.f == null) {
            dVar.a("no_activity", "image_picker plugin requires a foreground activity.", null);
            return;
        }
        a aVar = new a(dVar);
        if (hVar.a("cameraDevice") != null) {
            this.f624b.H(((Integer) hVar.a("cameraDevice")).intValue() == 1 ? io.flutter.plugins.imagepicker.a.FRONT : io.flutter.plugins.imagepicker.a.REAR);
        }
        String str = hVar.f206a;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1708939613:
                if (str.equals("pickMultiImage")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1457314374:
                if (str.equals("pickImage")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1445424934:
                if (str.equals("pickVideo")) {
                    c2 = 2;
                    break;
                }
                break;
            case -310034372:
                if (str.equals("retrieve")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.f624b.f(hVar, aVar);
                return;
            case 1:
                int intValue = ((Integer) hVar.a("source")).intValue();
                if (intValue == 0) {
                    this.f624b.J(hVar, aVar);
                    return;
                } else if (intValue == 1) {
                    this.f624b.e(hVar, aVar);
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid image source: " + intValue);
                }
            case 2:
                int intValue2 = ((Integer) hVar.a("source")).intValue();
                if (intValue2 == 0) {
                    this.f624b.K(hVar, aVar);
                    return;
                } else if (intValue2 == 1) {
                    this.f624b.g(hVar, aVar);
                    return;
                } else {
                    throw new IllegalArgumentException("Invalid video source: " + intValue2);
                }
            case 3:
                this.f624b.F(aVar);
                return;
            default:
                throw new IllegalArgumentException("Unknown method " + hVar.f206a);
        }
    }

    @Override // io.flutter.embedding.engine.i.a
    public void g(a.b bVar) {
        this.f625c = bVar;
    }

    final e i(Activity activity) {
        d dVar = new d(activity);
        File cacheDir = activity.getCacheDir();
        return new e(activity, cacheDir, new g(cacheDir, new b()), dVar);
    }
}
