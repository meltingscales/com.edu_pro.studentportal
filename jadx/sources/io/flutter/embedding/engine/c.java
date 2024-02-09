package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f329b;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f330a = new HashMap();

    c() {
    }

    public static c b() {
        if (f329b == null) {
            f329b = new c();
        }
        return f329b;
    }

    public b a(String str) {
        return this.f330a.get(str);
    }

    public void c(String str, b bVar) {
        if (bVar != null) {
            this.f330a.put(str, bVar);
        } else {
            this.f330a.remove(str);
        }
    }

    public void d(String str) {
        c(str, null);
    }
}
