package io.flutter.plugins.urllauncher;

import android.os.Bundle;
import android.util.Log;
import c.a.c.a.h;
import c.a.c.a.i;
import io.flutter.plugins.urllauncher.b;
import java.util.Map;

/* loaded from: classes.dex */
final class a implements i.c {

    /* renamed from: a  reason: collision with root package name */
    private final b f660a;

    /* renamed from: b  reason: collision with root package name */
    private i f661b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f660a = bVar;
    }

    private static Bundle a(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    private void b(i.d dVar, String str) {
        dVar.b(Boolean.valueOf(this.f660a.a(str)));
    }

    private void c(i.d dVar) {
        this.f660a.b();
        dVar.b(null);
    }

    private void d(h hVar, i.d dVar, String str) {
        b.a c2 = this.f660a.c(str, a((Map) hVar.a("headers")), ((Boolean) hVar.a("useWebView")).booleanValue(), ((Boolean) hVar.a("enableJavaScript")).booleanValue(), ((Boolean) hVar.a("enableDomStorage")).booleanValue());
        if (c2 == b.a.NO_ACTIVITY) {
            dVar.a("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        } else if (c2 == b.a.ACTIVITY_NOT_FOUND) {
            dVar.a("ACTIVITY_NOT_FOUND", String.format("No Activity found to handle intent { %s }", str), null);
        } else {
            dVar.b(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(c.a.c.a.b bVar) {
        if (this.f661b != null) {
            Log.wtf("MethodCallHandlerImpl", "Setting a method call handler before the last was disposed.");
            g();
        }
        i iVar = new i(bVar, "plugins.flutter.io/url_launcher");
        this.f661b = iVar;
        iVar.e(this);
    }

    @Override // c.a.c.a.i.c
    public void f(h hVar, i.d dVar) {
        String str = (String) hVar.a("url");
        String str2 = hVar.f206a;
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1109843021:
                if (str2.equals("launch")) {
                    c2 = 0;
                    break;
                }
                break;
            case -185306205:
                if (str2.equals("canLaunch")) {
                    c2 = 1;
                    break;
                }
                break;
            case -121617663:
                if (str2.equals("closeWebView")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                d(hVar, dVar, str);
                return;
            case 1:
                b(dVar, str);
                return;
            case 2:
                c(dVar);
                return;
            default:
                dVar.c();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        i iVar = this.f661b;
        if (iVar == null) {
            Log.d("MethodCallHandlerImpl", "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        iVar.e(null);
        this.f661b = null;
    }
}
