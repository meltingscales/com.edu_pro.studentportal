package io.flutter.embedding.engine.j;

import c.a.c.a.i;
import c.a.c.a.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.i f382a;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.engine.g.a f383b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<i.d>> f384c;

    /* renamed from: d  reason: collision with root package name */
    final i.c f385d;

    /* loaded from: classes.dex */
    class a implements i.c {
        a() {
        }

        @Override // c.a.c.a.i.c
        public void f(c.a.c.a.h hVar, i.d dVar) {
            String str;
            if (c.this.f383b == null) {
                return;
            }
            String str2 = hVar.f206a;
            Map map = (Map) hVar.b();
            c.a.b.e("DeferredComponentChannel", "Received '" + str2 + "' message.");
            int intValue = ((Integer) map.get("loadingUnitId")).intValue();
            String str3 = (String) map.get("componentName");
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1004447972:
                    if (str2.equals("uninstallDeferredComponent")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 399701758:
                    if (str2.equals("getDeferredComponentInstallState")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 520962947:
                    if (str2.equals("installDeferredComponent")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    c.this.f383b.c(intValue, str3);
                    str = null;
                    break;
                case 1:
                    str = c.this.f383b.a(intValue, str3);
                    break;
                case 2:
                    c.this.f383b.b(intValue, str3);
                    if (!c.this.f384c.containsKey(str3)) {
                        c.this.f384c.put(str3, new ArrayList());
                    }
                    ((List) c.this.f384c.get(str3)).add(dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
            dVar.b(str);
        }
    }

    public c(io.flutter.embedding.engine.f.a aVar) {
        a aVar2 = new a();
        this.f385d = aVar2;
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/deferredcomponent", q.f220b);
        this.f382a = iVar;
        iVar.e(aVar2);
        this.f383b = c.a.a.d().a();
        this.f384c = new HashMap();
    }

    public void c(io.flutter.embedding.engine.g.a aVar) {
        this.f383b = aVar;
    }
}
