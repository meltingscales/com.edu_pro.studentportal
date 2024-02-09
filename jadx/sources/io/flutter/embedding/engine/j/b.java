package io.flutter.embedding.engine.j;

import c.a.c.a.a;
import c.a.c.a.p;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.c;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f377a;

    /* renamed from: b  reason: collision with root package name */
    public final FlutterJNI f378b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0029b f379c;

    /* renamed from: d  reason: collision with root package name */
    private final a.d<Object> f380d;

    /* loaded from: classes.dex */
    class a implements a.d<Object> {
        a() {
        }

        @Override // c.a.c.a.a.d
        public void a(Object obj, a.e<Object> eVar) {
            if (b.this.f379c == null) {
                return;
            }
            HashMap hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            HashMap hashMap2 = (HashMap) hashMap.get("data");
            c.a.b.e("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1140076541:
                    if (str.equals("tooltip")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -649620375:
                    if (str.equals("announce")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 114595:
                    if (str.equals("tap")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 114203431:
                    if (str.equals("longPress")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        b.this.f379c.c(str2);
                        break;
                    }
                    break;
                case 1:
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        b.this.f379c.f(str3);
                        break;
                    }
                    break;
                case 2:
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        b.this.f379c.e(num.intValue());
                        break;
                    }
                    break;
                case 3:
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        b.this.f379c.d(num2.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    /* renamed from: io.flutter.embedding.engine.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0029b extends FlutterJNI.a {
        void c(String str);

        void d(int i);

        void e(int i);

        void f(String str);
    }

    public b(io.flutter.embedding.engine.f.a aVar, FlutterJNI flutterJNI) {
        a aVar2 = new a();
        this.f380d = aVar2;
        c.a.c.a.a<Object> aVar3 = new c.a.c.a.a<>(aVar, "flutter/accessibility", p.f217a);
        this.f377a = aVar3;
        aVar3.e(aVar2);
        this.f378b = flutterJNI;
    }

    public void b(int i, c.g gVar) {
        this.f378b.dispatchSemanticsAction(i, gVar);
    }

    public void c(int i, c.g gVar, Object obj) {
        this.f378b.dispatchSemanticsAction(i, gVar, obj);
    }

    public void d() {
        this.f378b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f378b.setSemanticsEnabled(true);
    }

    public void f(int i) {
        this.f378b.setAccessibilityFeatures(i);
    }

    public void g(InterfaceC0029b interfaceC0029b) {
        this.f379c = interfaceC0029b;
        this.f378b.setAccessibilityDelegate(interfaceC0029b);
    }
}
