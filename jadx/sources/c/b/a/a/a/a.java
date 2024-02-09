package c.b.a.a.a;

import android.content.Context;
import c.a.c.a.i;
import io.flutter.embedding.engine.i.a;

/* loaded from: classes.dex */
public final class a implements io.flutter.embedding.engine.i.a {

    /* renamed from: a  reason: collision with root package name */
    private i f232a;

    private final void b() {
        i iVar = this.f232a;
        if (iVar != null) {
            iVar.e(null);
        }
        this.f232a = null;
    }

    public final void a(c.a.c.a.b bVar, Context context) {
        d.d.a.a.c(bVar, "messenger");
        d.d.a.a.c(context, "context");
        this.f232a = new i(bVar, "PonnamKarthik/fluttertoast");
        b bVar2 = new b(context);
        i iVar = this.f232a;
        if (iVar != null) {
            iVar.e(bVar2);
        }
    }

    @Override // io.flutter.embedding.engine.i.a
    public void d(a.b bVar) {
        d.d.a.a.c(bVar, "p0");
        b();
    }

    @Override // io.flutter.embedding.engine.i.a
    public void g(a.b bVar) {
        d.d.a.a.c(bVar, "binding");
        c.a.c.a.b b2 = bVar.b();
        d.d.a.a.b(b2, "binding.binaryMessenger");
        Context a2 = bVar.a();
        d.d.a.a.b(a2, "binding.applicationContext");
        a(b2, a2);
    }
}
