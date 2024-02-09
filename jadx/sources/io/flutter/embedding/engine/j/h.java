package io.flutter.embedding.engine.j;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f399a;

    public h(io.flutter.embedding.engine.f.a aVar) {
        this.f399a = new c.a.c.a.i(aVar, "flutter/navigation", c.a.c.a.e.f205a);
    }

    public void a() {
        c.a.b.e("NavigationChannel", "Sending message to pop route.");
        this.f399a.c("popRoute", null);
    }

    public void b(String str) {
        c.a.b.e("NavigationChannel", "Sending message to push route '" + str + "'");
        this.f399a.c("pushRoute", str);
    }

    public void c(String str) {
        c.a.b.e("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f399a.c("setInitialRoute", str);
    }
}
