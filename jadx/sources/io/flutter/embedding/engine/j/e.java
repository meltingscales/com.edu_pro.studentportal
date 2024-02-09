package io.flutter.embedding.engine.j;

import c.a.c.a.r;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<String> f390a;

    public e(io.flutter.embedding.engine.f.a aVar) {
        this.f390a = new c.a.c.a.a<>(aVar, "flutter/lifecycle", r.f223b);
    }

    public void a() {
        c.a.b.e("LifecycleChannel", "Sending AppLifecycleState.detached message.");
        this.f390a.c("AppLifecycleState.detached");
    }

    public void b() {
        c.a.b.e("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
        this.f390a.c("AppLifecycleState.inactive");
    }

    public void c() {
        c.a.b.e("LifecycleChannel", "Sending AppLifecycleState.paused message.");
        this.f390a.c("AppLifecycleState.paused");
    }

    public void d() {
        c.a.b.e("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
        this.f390a.c("AppLifecycleState.resumed");
    }
}
