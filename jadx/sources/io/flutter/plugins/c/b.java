package io.flutter.plugins.c;

import android.content.Context;
import c.a.c.a.i;
import io.flutter.embedding.engine.i.a;

/* loaded from: classes.dex */
public class b implements io.flutter.embedding.engine.i.a {

    /* renamed from: a  reason: collision with root package name */
    private i f621a;

    /* renamed from: b  reason: collision with root package name */
    private a f622b;

    private void a(c.a.c.a.b bVar, Context context) {
        this.f621a = new i(bVar, "plugins.flutter.io/shared_preferences");
        a aVar = new a(context);
        this.f622b = aVar;
        this.f621a.e(aVar);
    }

    private void b() {
        this.f622b.g();
        this.f622b = null;
        this.f621a.e(null);
        this.f621a = null;
    }

    @Override // io.flutter.embedding.engine.i.a
    public void d(a.b bVar) {
        b();
    }

    @Override // io.flutter.embedding.engine.i.a
    public void g(a.b bVar) {
        a(bVar.b(), bVar.a());
    }
}
