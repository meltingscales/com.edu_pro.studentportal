package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import c.a.c.a.k;
import c.a.c.a.l;
import c.a.c.a.n;
import c.a.c.a.o;
import io.flutter.embedding.engine.i.a;
import io.flutter.embedding.engine.i.c.c;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements io.flutter.embedding.engine.i.b, io.flutter.embedding.engine.i.c.b {

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.b f332b;

    /* renamed from: c  reason: collision with root package name */
    private final a.b f333c;
    @Deprecated
    private Activity e;
    private io.flutter.embedding.android.d<Activity> f;
    private c g;
    private Service j;
    private f k;
    private BroadcastReceiver m;
    private C0024d n;
    private ContentProvider p;
    private e q;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends io.flutter.embedding.engine.i.a>, io.flutter.embedding.engine.i.a> f331a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<? extends io.flutter.embedding.engine.i.a>, io.flutter.embedding.engine.i.c.a> f334d = new HashMap();
    private boolean h = false;
    private final Map<Class<? extends io.flutter.embedding.engine.i.a>, io.flutter.embedding.engine.i.f.a> i = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.i.a>, io.flutter.embedding.engine.i.d.a> l = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.i.a>, io.flutter.embedding.engine.i.e.a> o = new HashMap();

    /* loaded from: classes.dex */
    private static class b implements a.InterfaceC0028a {
        private b(io.flutter.embedding.engine.h.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements io.flutter.embedding.engine.i.c.c {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f335a;

        /* renamed from: b  reason: collision with root package name */
        private final HiddenLifecycleReference f336b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<n> f337c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private final Set<k> f338d = new HashSet();
        private final Set<l> e = new HashSet();
        private final Set<o> f = new HashSet();
        private final Set<c.a> g = new HashSet();

        public c(Activity activity, androidx.lifecycle.d dVar) {
            this.f335a = activity;
            this.f336b = new HiddenLifecycleReference(dVar);
        }

        @Override // io.flutter.embedding.engine.i.c.c
        public Object a() {
            return this.f336b;
        }

        @Override // io.flutter.embedding.engine.i.c.c
        public Activity b() {
            return this.f335a;
        }

        @Override // io.flutter.embedding.engine.i.c.c
        public void c(k kVar) {
            this.f338d.add(kVar);
        }

        @Override // io.flutter.embedding.engine.i.c.c
        public void d(n nVar) {
            this.f337c.add(nVar);
        }

        @Override // io.flutter.embedding.engine.i.c.c
        public void e(n nVar) {
            this.f337c.remove(nVar);
        }

        @Override // io.flutter.embedding.engine.i.c.c
        public void f(k kVar) {
            this.f338d.remove(kVar);
        }

        boolean g(int i, int i2, Intent intent) {
            boolean z;
            Iterator it = new HashSet(this.f338d).iterator();
            while (true) {
                while (it.hasNext()) {
                    z = ((k) it.next()).c(i, i2, intent) || z;
                }
                return z;
            }
        }

        void h(Intent intent) {
            for (l lVar : this.e) {
                lVar.d(intent);
            }
        }

        boolean i(int i, String[] strArr, int[] iArr) {
            boolean z;
            while (true) {
                for (n nVar : this.f337c) {
                    z = nVar.a(i, strArr, iArr) || z;
                }
                return z;
            }
        }

        void j(Bundle bundle) {
            for (c.a aVar : this.g) {
                aVar.b(bundle);
            }
        }

        void k(Bundle bundle) {
            for (c.a aVar : this.g) {
                aVar.e(bundle);
            }
        }

        void l() {
            for (o oVar : this.f) {
                oVar.f();
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0024d implements io.flutter.embedding.engine.i.d.b {
    }

    /* loaded from: classes.dex */
    private static class e implements io.flutter.embedding.engine.i.e.b {
    }

    /* loaded from: classes.dex */
    private static class f implements io.flutter.embedding.engine.i.f.b {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, io.flutter.embedding.engine.b bVar, io.flutter.embedding.engine.h.c cVar) {
        this.f332b = bVar;
        this.f333c = new a.b(context, bVar, bVar.h(), bVar.q(), bVar.o().I(), new b(cVar));
    }

    private void k(Activity activity, androidx.lifecycle.d dVar) {
        this.g = new c(activity, dVar);
        this.f332b.o().u(activity, this.f332b.q(), this.f332b.h());
        for (io.flutter.embedding.engine.i.c.a aVar : this.f334d.values()) {
            if (this.h) {
                aVar.c(this.g);
            } else {
                aVar.b(this.g);
            }
        }
        this.h = false;
    }

    private Activity l() {
        io.flutter.embedding.android.d<Activity> dVar = this.f;
        return dVar != null ? dVar.d() : this.e;
    }

    private void n() {
        this.f332b.o().C();
        this.f = null;
        this.e = null;
        this.g = null;
    }

    private void o() {
        if (t()) {
            h();
        } else if (w()) {
            r();
        } else if (u()) {
            p();
        } else if (v()) {
            q();
        }
    }

    private boolean t() {
        return (this.e == null && this.f == null) ? false : true;
    }

    private boolean u() {
        return this.m != null;
    }

    private boolean v() {
        return this.p != null;
    }

    private boolean w() {
        return this.j != null;
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public boolean a(int i, String[] strArr, int[] iArr) {
        c.a.b.e("FlutterEngineCxnRegstry", "Forwarding onRequestPermissionsResult() to plugins.");
        if (t()) {
            return this.g.i(i, strArr, iArr);
        }
        c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void b(Bundle bundle) {
        c.a.b.e("FlutterEngineCxnRegstry", "Forwarding onRestoreInstanceState() to plugins.");
        if (t()) {
            this.g.j(bundle);
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public boolean c(int i, int i2, Intent intent) {
        c.a.b.e("FlutterEngineCxnRegstry", "Forwarding onActivityResult() to plugins.");
        if (t()) {
            return this.g.g(i, i2, intent);
        }
        c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void d(Intent intent) {
        c.a.b.e("FlutterEngineCxnRegstry", "Forwarding onNewIntent() to plugins.");
        if (t()) {
            this.g.h(intent);
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void e(Bundle bundle) {
        c.a.b.e("FlutterEngineCxnRegstry", "Forwarding onSaveInstanceState() to plugins.");
        if (t()) {
            this.g.k(bundle);
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void f() {
        c.a.b.e("FlutterEngineCxnRegstry", "Forwarding onUserLeaveHint() to plugins.");
        if (t()) {
            this.g.l();
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void g(io.flutter.embedding.android.d<Activity> dVar, androidx.lifecycle.d dVar2) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Attaching to an exclusive Activity: ");
        sb.append(dVar.d());
        if (t()) {
            str = " evicting previous activity " + l();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(".");
        sb.append(this.h ? " This is after a config change." : "");
        c.a.b.e("FlutterEngineCxnRegstry", sb.toString());
        io.flutter.embedding.android.d<Activity> dVar3 = this.f;
        if (dVar3 != null) {
            dVar3.c();
        }
        o();
        if (this.e != null) {
            throw new AssertionError("Only activity or exclusiveActivity should be set");
        }
        this.f = dVar;
        k(dVar.d(), dVar2);
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void h() {
        if (!t()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        c.a.b.e("FlutterEngineCxnRegstry", "Detaching from an Activity: " + l());
        for (io.flutter.embedding.engine.i.c.a aVar : this.f334d.values()) {
            aVar.a();
        }
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.embedding.engine.i.b
    public void i(io.flutter.embedding.engine.i.a aVar) {
        if (s(aVar.getClass())) {
            c.a.b.f("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar + ") but it was already registered with this FlutterEngine (" + this.f332b + ").");
            return;
        }
        c.a.b.e("FlutterEngineCxnRegstry", "Adding plugin: " + aVar);
        this.f331a.put(aVar.getClass(), aVar);
        aVar.g(this.f333c);
        if (aVar instanceof io.flutter.embedding.engine.i.c.a) {
            io.flutter.embedding.engine.i.c.a aVar2 = (io.flutter.embedding.engine.i.c.a) aVar;
            this.f334d.put(aVar.getClass(), aVar2);
            if (t()) {
                aVar2.b(this.g);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.i.f.a) {
            io.flutter.embedding.engine.i.f.a aVar3 = (io.flutter.embedding.engine.i.f.a) aVar;
            this.i.put(aVar.getClass(), aVar3);
            if (w()) {
                aVar3.a(this.k);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.i.d.a) {
            io.flutter.embedding.engine.i.d.a aVar4 = (io.flutter.embedding.engine.i.d.a) aVar;
            this.l.put(aVar.getClass(), aVar4);
            if (u()) {
                aVar4.a(this.n);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.i.e.a) {
            io.flutter.embedding.engine.i.e.a aVar5 = (io.flutter.embedding.engine.i.e.a) aVar;
            this.o.put(aVar.getClass(), aVar5);
            if (v()) {
                aVar5.a(this.q);
            }
        }
    }

    @Override // io.flutter.embedding.engine.i.c.b
    public void j() {
        if (!t()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        c.a.b.e("FlutterEngineCxnRegstry", "Detaching from an Activity for config changes: " + l());
        this.h = true;
        for (io.flutter.embedding.engine.i.c.a aVar : this.f334d.values()) {
            aVar.e();
        }
        n();
    }

    public void m() {
        c.a.b.e("FlutterEngineCxnRegstry", "Destroying.");
        o();
        z();
    }

    public void p() {
        if (!u()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        c.a.b.e("FlutterEngineCxnRegstry", "Detaching from BroadcastReceiver: " + this.m);
        for (io.flutter.embedding.engine.i.d.a aVar : this.l.values()) {
            aVar.b();
        }
    }

    public void q() {
        if (!v()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        c.a.b.e("FlutterEngineCxnRegstry", "Detaching from ContentProvider: " + this.p);
        for (io.flutter.embedding.engine.i.e.a aVar : this.o.values()) {
            aVar.b();
        }
    }

    public void r() {
        if (!w()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        c.a.b.e("FlutterEngineCxnRegstry", "Detaching from a Service: " + this.j);
        for (io.flutter.embedding.engine.i.f.a aVar : this.i.values()) {
            aVar.b();
        }
        this.j = null;
    }

    public boolean s(Class<? extends io.flutter.embedding.engine.i.a> cls) {
        return this.f331a.containsKey(cls);
    }

    public void x(Class<? extends io.flutter.embedding.engine.i.a> cls) {
        io.flutter.embedding.engine.i.a aVar = this.f331a.get(cls);
        if (aVar != null) {
            c.a.b.e("FlutterEngineCxnRegstry", "Removing plugin: " + aVar);
            if (aVar instanceof io.flutter.embedding.engine.i.c.a) {
                if (t()) {
                    ((io.flutter.embedding.engine.i.c.a) aVar).a();
                }
                this.f334d.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.i.f.a) {
                if (w()) {
                    ((io.flutter.embedding.engine.i.f.a) aVar).b();
                }
                this.i.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.i.d.a) {
                if (u()) {
                    ((io.flutter.embedding.engine.i.d.a) aVar).b();
                }
                this.l.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.i.e.a) {
                if (v()) {
                    ((io.flutter.embedding.engine.i.e.a) aVar).b();
                }
                this.o.remove(cls);
            }
            aVar.d(this.f333c);
            this.f331a.remove(cls);
        }
    }

    public void y(Set<Class<? extends io.flutter.embedding.engine.i.a>> set) {
        for (Class<? extends io.flutter.embedding.engine.i.a> cls : set) {
            x(cls);
        }
    }

    public void z() {
        y(new HashSet(this.f331a.keySet()));
        this.f331a.clear();
    }
}
