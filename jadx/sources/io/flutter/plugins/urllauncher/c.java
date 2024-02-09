package io.flutter.plugins.urllauncher;

import android.util.Log;
import io.flutter.embedding.engine.i.a;

/* loaded from: classes.dex */
public final class c implements io.flutter.embedding.engine.i.a, io.flutter.embedding.engine.i.c.a {

    /* renamed from: a  reason: collision with root package name */
    private a f668a;

    /* renamed from: b  reason: collision with root package name */
    private b f669b;

    @Override // io.flutter.embedding.engine.i.c.a
    public void a() {
        if (this.f668a == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            this.f669b.d(null);
        }
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void b(io.flutter.embedding.engine.i.c.c cVar) {
        if (this.f668a == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            this.f669b.d(cVar.b());
        }
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void c(io.flutter.embedding.engine.i.c.c cVar) {
        b(cVar);
    }

    @Override // io.flutter.embedding.engine.i.a
    public void d(a.b bVar) {
        a aVar = this.f668a;
        if (aVar == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
            return;
        }
        aVar.g();
        this.f668a = null;
        this.f669b = null;
    }

    @Override // io.flutter.embedding.engine.i.c.a
    public void e() {
        a();
    }

    @Override // io.flutter.embedding.engine.i.a
    public void g(a.b bVar) {
        b bVar2 = new b(bVar.a(), null);
        this.f669b = bVar2;
        a aVar = new a(bVar2);
        this.f668a = aVar;
        aVar.e(bVar.b());
    }
}
