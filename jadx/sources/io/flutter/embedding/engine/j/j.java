package io.flutter.embedding.engine.j;

import c.a.c.a.i;
import c.a.c.a.q;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.i f440a;

    /* renamed from: b  reason: collision with root package name */
    private e f441b;

    /* renamed from: c  reason: collision with root package name */
    private final i.c f442c;

    /* loaded from: classes.dex */
    class a implements i.c {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.flutter.embedding.engine.j.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0031a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i.d f444a;

            RunnableC0031a(a aVar, i.d dVar) {
                this.f444a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f444a.b(null);
            }
        }

        a() {
        }

        private void a(c.a.c.a.h hVar, i.d dVar) {
            try {
                j.this.f441b.a(((Integer) hVar.b()).intValue());
                dVar.b(null);
            } catch (IllegalStateException e) {
                dVar.a("error", j.c(e), null);
            }
        }

        private void b(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            b bVar = new b(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), z ? 0.0d : ((Double) map.get("width")).doubleValue(), z ? 0.0d : ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null);
            try {
                if (z) {
                    j.this.f441b.h(bVar);
                    dVar.b(null);
                } else {
                    dVar.b(Long.valueOf(j.this.f441b.f(bVar)));
                }
            } catch (IllegalStateException e) {
                dVar.a("error", j.c(e), null);
            }
        }

        private void c(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            int intValue = ((Integer) map.get("id")).intValue();
            try {
                if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                    j.this.f441b.d(intValue);
                } else {
                    j.this.f441b.e(intValue);
                }
                dVar.b(null);
            } catch (IllegalStateException e) {
                dVar.a("error", j.c(e), null);
            }
        }

        private void d(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            try {
                j.this.f441b.c(new c(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new RunnableC0031a(this, dVar));
            } catch (IllegalStateException e) {
                dVar.a("error", j.c(e), null);
            }
        }

        private void e(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            try {
                j.this.f441b.g(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.b(null);
            } catch (IllegalStateException e) {
                dVar.a("error", j.c(e), null);
            }
        }

        private void g(c.a.c.a.h hVar, i.d dVar) {
            try {
                j.this.f441b.b(((Boolean) hVar.b()).booleanValue());
                dVar.b(null);
            } catch (IllegalStateException e) {
                dVar.a("error", j.c(e), null);
            }
        }

        private void h(c.a.c.a.h hVar, i.d dVar) {
            i.d dVar2;
            List list = (List) hVar.b();
            try {
                j.this.f441b.i(new d(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
                try {
                    dVar2.b(null);
                } catch (IllegalStateException e) {
                    e = e;
                    dVar2.a("error", j.c(e), null);
                }
            } catch (IllegalStateException e2) {
                e = e2;
                dVar2 = dVar;
            }
        }

        @Override // c.a.c.a.i.c
        public void f(c.a.c.a.h hVar, i.d dVar) {
            if (j.this.f441b == null) {
                return;
            }
            c.a.b.e("PlatformViewsChannel", "Received '" + hVar.f206a + "' message.");
            String str = hVar.f206a;
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -308988850:
                    if (str.equals("synchronizeToNativeViewHierarchy")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    b(hVar, dVar);
                    return;
                case 1:
                    d(hVar, dVar);
                    return;
                case 2:
                    a(hVar, dVar);
                    return;
                case 3:
                    g(hVar, dVar);
                    return;
                case 4:
                    h(hVar, dVar);
                    return;
                case 5:
                    e(hVar, dVar);
                    return;
                case 6:
                    c(hVar, dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f445a;

        /* renamed from: b  reason: collision with root package name */
        public final String f446b;

        /* renamed from: c  reason: collision with root package name */
        public final double f447c;

        /* renamed from: d  reason: collision with root package name */
        public final double f448d;
        public final int e;
        public final ByteBuffer f;

        public b(int i, String str, double d2, double d3, int i2, ByteBuffer byteBuffer) {
            this.f445a = i;
            this.f446b = str;
            this.f447c = d2;
            this.f448d = d3;
            this.e = i2;
            this.f = byteBuffer;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f449a;

        /* renamed from: b  reason: collision with root package name */
        public final double f450b;

        /* renamed from: c  reason: collision with root package name */
        public final double f451c;

        public c(int i, double d2, double d3) {
            this.f449a = i;
            this.f450b = d2;
            this.f451c = d3;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f452a;

        /* renamed from: b  reason: collision with root package name */
        public final Number f453b;

        /* renamed from: c  reason: collision with root package name */
        public final Number f454c;

        /* renamed from: d  reason: collision with root package name */
        public final int f455d;
        public final int e;
        public final Object f;
        public final Object g;
        public final int h;
        public final int i;
        public final float j;
        public final float k;
        public final int l;
        public final int m;
        public final int n;
        public final int o;
        public final long p;

        public d(int i, Number number, Number number2, int i2, int i3, Object obj, Object obj2, int i4, int i5, float f, float f2, int i6, int i7, int i8, int i9, long j) {
            this.f452a = i;
            this.f453b = number;
            this.f454c = number2;
            this.f455d = i2;
            this.e = i3;
            this.f = obj;
            this.g = obj2;
            this.h = i4;
            this.i = i5;
            this.j = f;
            this.k = f2;
            this.l = i6;
            this.m = i7;
            this.n = i8;
            this.o = i9;
            this.p = j;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(int i);

        void b(boolean z);

        void c(c cVar, Runnable runnable);

        void d(int i);

        void e(int i);

        long f(b bVar);

        void g(int i, int i2);

        void h(b bVar);

        void i(d dVar);
    }

    public j(io.flutter.embedding.engine.f.a aVar) {
        a aVar2 = new a();
        this.f442c = aVar2;
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/platform_views", q.f220b);
        this.f440a = iVar;
        iVar.e(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void d(int i) {
        c.a.c.a.i iVar = this.f440a;
        if (iVar == null) {
            return;
        }
        iVar.c("viewFocused", Integer.valueOf(i));
    }

    public void e(e eVar) {
        this.f441b = eVar;
    }
}
