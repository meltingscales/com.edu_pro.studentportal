package io.flutter.embedding.engine.f;

import android.content.res.AssetManager;
import c.a.c.a.b;
import c.a.c.a.r;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a implements c.a.c.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f340a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f341b;

    /* renamed from: c  reason: collision with root package name */
    private final io.flutter.embedding.engine.f.b f342c;

    /* renamed from: d  reason: collision with root package name */
    private final c.a.c.a.b f343d;
    private boolean e;
    private String f;
    private d g;
    private final b.a h;

    /* renamed from: io.flutter.embedding.engine.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0025a implements b.a {
        C0025a() {
        }

        @Override // c.a.c.a.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0018b interfaceC0018b) {
            a.this.f = r.f223b.a(byteBuffer);
            if (a.this.g != null) {
                a.this.g.a(a.this.f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f345a;

        /* renamed from: b  reason: collision with root package name */
        public final String f346b = null;

        /* renamed from: c  reason: collision with root package name */
        public final String f347c;

        public b(String str, String str2) {
            this.f345a = str;
            this.f347c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f345a.equals(bVar.f345a)) {
                return this.f347c.equals(bVar.f347c);
            }
            return false;
        }

        public int hashCode() {
            return (this.f345a.hashCode() * 31) + this.f347c.hashCode();
        }

        public String toString() {
            return "DartEntrypoint( bundle path: " + this.f345a + ", function: " + this.f347c + " )";
        }
    }

    /* loaded from: classes.dex */
    private static class c implements c.a.c.a.b {

        /* renamed from: a  reason: collision with root package name */
        private final io.flutter.embedding.engine.f.b f348a;

        private c(io.flutter.embedding.engine.f.b bVar) {
            this.f348a = bVar;
        }

        /* synthetic */ c(io.flutter.embedding.engine.f.b bVar, C0025a c0025a) {
            this(bVar);
        }

        @Override // c.a.c.a.b
        public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0018b interfaceC0018b) {
            this.f348a.a(str, byteBuffer, interfaceC0018b);
        }

        @Override // c.a.c.a.b
        public void c(String str, b.a aVar) {
            this.f348a.c(str, aVar);
        }
    }

    /* loaded from: classes.dex */
    interface d {
        void a(String str);
    }

    public a(FlutterJNI flutterJNI, AssetManager assetManager) {
        this.e = false;
        C0025a c0025a = new C0025a();
        this.h = c0025a;
        this.f340a = flutterJNI;
        this.f341b = assetManager;
        io.flutter.embedding.engine.f.b bVar = new io.flutter.embedding.engine.f.b(flutterJNI);
        this.f342c = bVar;
        bVar.c("flutter/isolate", c0025a);
        this.f343d = new c(bVar, null);
        if (flutterJNI.isAttached()) {
            this.e = true;
        }
    }

    @Override // c.a.c.a.b
    @Deprecated
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0018b interfaceC0018b) {
        this.f343d.a(str, byteBuffer, interfaceC0018b);
    }

    @Override // c.a.c.a.b
    @Deprecated
    public void c(String str, b.a aVar) {
        this.f343d.c(str, aVar);
    }

    public void f(b bVar) {
        if (this.e) {
            c.a.b.f("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        c.a.b.e("DartExecutor", "Executing Dart entrypoint: " + bVar);
        this.f340a.runBundleAndSnapshotFromLibrary(bVar.f345a, bVar.f347c, bVar.f346b, this.f341b);
        this.e = true;
    }

    public String g() {
        return this.f;
    }

    public boolean h() {
        return this.e;
    }

    public void i() {
        if (this.f340a.isAttached()) {
            this.f340a.notifyLowMemoryWarning();
        }
    }

    public void j() {
        c.a.b.e("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.f340a.setPlatformMessageHandler(this.f342c);
    }

    public void k() {
        c.a.b.e("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.f340a.setPlatformMessageHandler(null);
    }
}
