package io.flutter.embedding.engine.j;

import c.a.c.a.i;
import c.a.c.a.q;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f456a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f457b;

    /* renamed from: c  reason: collision with root package name */
    private c.a.c.a.i f458c;

    /* renamed from: d  reason: collision with root package name */
    private i.d f459d;
    private boolean e;
    private boolean f;
    private final i.c g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements i.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f460a;

        a(byte[] bArr) {
            this.f460a = bArr;
        }

        @Override // c.a.c.a.i.d
        public void a(String str, String str2, Object obj) {
            c.a.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // c.a.c.a.i.d
        public void b(Object obj) {
            k.this.f457b = this.f460a;
        }

        @Override // c.a.c.a.i.d
        public void c() {
        }
    }

    /* loaded from: classes.dex */
    class b implements i.c {
        b() {
        }

        @Override // c.a.c.a.i.c
        public void f(c.a.c.a.h hVar, i.d dVar) {
            Map i;
            String str = hVar.f206a;
            Object obj = hVar.f207b;
            str.hashCode();
            if (str.equals("get")) {
                k.this.f = true;
                if (!k.this.e) {
                    k kVar = k.this;
                    if (kVar.f456a) {
                        kVar.f459d = dVar;
                        return;
                    }
                }
                k kVar2 = k.this;
                i = kVar2.i(kVar2.f457b);
            } else if (!str.equals("put")) {
                dVar.c();
                return;
            } else {
                k.this.f457b = (byte[]) obj;
                i = null;
            }
            dVar.b(i);
        }
    }

    k(c.a.c.a.i iVar, boolean z) {
        this.e = false;
        this.f = false;
        b bVar = new b();
        this.g = bVar;
        this.f458c = iVar;
        this.f456a = z;
        iVar.e(bVar);
    }

    public k(io.flutter.embedding.engine.f.a aVar, boolean z) {
        this(new c.a.c.a.i(aVar, "flutter/restoration", q.f220b), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void g() {
        this.f457b = null;
    }

    public byte[] h() {
        return this.f457b;
    }

    public void j(byte[] bArr) {
        this.e = true;
        i.d dVar = this.f459d;
        if (dVar != null) {
            dVar.b(i(bArr));
            this.f459d = null;
        } else if (this.f) {
            this.f458c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f457b = bArr;
    }
}
