package io.flutter.embedding.engine.j;

import java.util.HashMap;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f470a;

    public m(io.flutter.embedding.engine.f.a aVar) {
        this.f470a = new c.a.c.a.a<>(aVar, "flutter/system", c.a.c.a.d.f204a);
    }

    public void a() {
        c.a.b.e("SystemChannel", "Sending memory pressure warning to Flutter.");
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "memoryPressure");
        this.f470a.c(hashMap);
    }
}
