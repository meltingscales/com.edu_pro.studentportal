package io.flutter.embedding.engine.i;

import android.content.Context;
import io.flutter.plugin.platform.h;
import io.flutter.view.d;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: io.flutter.embedding.engine.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0028a {
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f374a;

        /* renamed from: b  reason: collision with root package name */
        private final c.a.c.a.b f375b;

        public b(Context context, io.flutter.embedding.engine.b bVar, c.a.c.a.b bVar2, d dVar, h hVar, InterfaceC0028a interfaceC0028a) {
            this.f374a = context;
            this.f375b = bVar2;
        }

        public Context a() {
            return this.f374a;
        }

        public c.a.c.a.b b() {
            return this.f375b;
        }
    }

    void d(b bVar);

    void g(b bVar);
}
