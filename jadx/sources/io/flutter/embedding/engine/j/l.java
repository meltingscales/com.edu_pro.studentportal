package io.flutter.embedding.engine.j;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f463a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final c.a.c.a.a<Object> f464a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f465b = new HashMap();

        a(c.a.c.a.a<Object> aVar) {
            this.f464a = aVar;
        }

        public void a() {
            c.a.b.e("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f465b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f465b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f465b.get("platformBrightness"));
            this.f464a.c(this.f465b);
        }

        public a b(b bVar) {
            this.f465b.put("platformBrightness", bVar.f469a);
            return this;
        }

        public a c(float f) {
            this.f465b.put("textScaleFactor", Float.valueOf(f));
            return this;
        }

        public a d(boolean z) {
            this.f465b.put("alwaysUse24HourFormat", Boolean.valueOf(z));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        light("light"),
        dark("dark");
        

        /* renamed from: a  reason: collision with root package name */
        public String f469a;

        b(String str) {
            this.f469a = str;
        }
    }

    public l(io.flutter.embedding.engine.f.a aVar) {
        this.f463a = new c.a.c.a.a<>(aVar, "flutter/settings", c.a.c.a.d.f204a);
    }

    public a a() {
        return new a(this.f463a);
    }
}
