package io.flutter.embedding.engine.j;

import c.a.c.a.i;
import c.a.c.a.q;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f395a;

    /* renamed from: b  reason: collision with root package name */
    private b f396b;

    /* renamed from: c  reason: collision with root package name */
    private final i.c f397c;

    /* loaded from: classes.dex */
    class a implements i.c {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        @Override // c.a.c.a.i.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void f(c.a.c.a.h r7, c.a.c.a.i.d r8) {
            /*
                r6 = this;
                java.lang.String r0 = "error"
                io.flutter.embedding.engine.j.g r1 = io.flutter.embedding.engine.j.g.this
                io.flutter.embedding.engine.j.g$b r1 = io.flutter.embedding.engine.j.g.a(r1)
                if (r1 != 0) goto Lb
                return
            Lb:
                java.lang.String r1 = r7.f206a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Received '"
                r2.append(r3)
                r2.append(r1)
                java.lang.String r3 = "' message."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                java.lang.String r3 = "MouseCursorChannel"
                c.a.b.e(r3, r2)
                r2 = -1
                r3 = 0
                int r4 = r1.hashCode()     // Catch: java.lang.Exception -> L75
                r5 = -1307105544(0xffffffffb21726f8, float:-8.798217E-9)
                if (r4 == r5) goto L34
                goto L3d
            L34:
                java.lang.String r4 = "activateSystemCursor"
                boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> L75
                if (r1 == 0) goto L3d
                r2 = 0
            L3d:
                if (r2 == 0) goto L40
                goto L8e
            L40:
                java.lang.Object r7 = r7.f207b     // Catch: java.lang.Exception -> L75
                java.util.HashMap r7 = (java.util.HashMap) r7     // Catch: java.lang.Exception -> L75
                java.lang.String r1 = "kind"
                java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L75
                io.flutter.embedding.engine.j.g r1 = io.flutter.embedding.engine.j.g.this     // Catch: java.lang.Exception -> L5b
                io.flutter.embedding.engine.j.g$b r1 = io.flutter.embedding.engine.j.g.a(r1)     // Catch: java.lang.Exception -> L5b
                r1.a(r7)     // Catch: java.lang.Exception -> L5b
                java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L75
                r8.b(r7)     // Catch: java.lang.Exception -> L75
                goto L8e
            L5b:
                r7 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L75
                r1.<init>()     // Catch: java.lang.Exception -> L75
                java.lang.String r2 = "Error when setting cursors: "
                r1.append(r2)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Exception -> L75
                r1.append(r7)     // Catch: java.lang.Exception -> L75
                java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L75
                r8.a(r0, r7, r3)     // Catch: java.lang.Exception -> L75
                goto L8e
            L75:
                r7 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unhandled error: "
                r1.append(r2)
                java.lang.String r7 = r7.getMessage()
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r8.a(r0, r7, r3)
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.j.g.a.f(c.a.c.a.h, c.a.c.a.i$d):void");
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str);
    }

    public g(io.flutter.embedding.engine.f.a aVar) {
        a aVar2 = new a();
        this.f397c = aVar2;
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/mousecursor", q.f220b);
        this.f395a = iVar;
        iVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f396b = bVar;
    }
}
