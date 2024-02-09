package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<g> f112c;

    /* renamed from: a  reason: collision with root package name */
    private a.a.a.a.a<f, b> f110a = new a.a.a.a.a<>();

    /* renamed from: d  reason: collision with root package name */
    private int f113d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<d.b> g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private d.b f111b = d.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f114a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f115b;

        static {
            int[] iArr = new int[d.b.values().length];
            f115b = iArr;
            try {
                iArr[d.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f115b[d.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f115b[d.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f115b[d.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f115b[d.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f114a = iArr2;
            try {
                iArr2[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f114a[d.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f114a[d.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f114a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f114a[d.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f114a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f114a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        d.b f116a;

        /* renamed from: b  reason: collision with root package name */
        e f117b;

        b(f fVar, d.b bVar) {
            this.f117b = i.f(fVar);
            this.f116a = bVar;
        }

        void a(g gVar, d.a aVar) {
            d.b h = h.h(aVar);
            this.f116a = h.k(this.f116a, h);
            this.f117b.g(gVar, aVar);
            this.f116a = h;
        }
    }

    public h(g gVar) {
        this.f112c = new WeakReference<>(gVar);
    }

    private void d(g gVar) {
        Iterator<Map.Entry<f, b>> a2 = this.f110a.a();
        while (a2.hasNext() && !this.f) {
            Map.Entry<f, b> next = a2.next();
            b value = next.getValue();
            while (value.f116a.compareTo(this.f111b) > 0 && !this.f && this.f110a.contains(next.getKey())) {
                d.a f = f(value.f116a);
                n(h(f));
                value.a(gVar, f);
                m();
            }
        }
    }

    private d.b e(f fVar) {
        Map.Entry<f, b> h = this.f110a.h(fVar);
        d.b bVar = null;
        d.b bVar2 = h != null ? h.getValue().f116a : null;
        if (!this.g.isEmpty()) {
            ArrayList<d.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return k(k(this.f111b, bVar2), bVar);
    }

    private static d.a f(d.b bVar) {
        int i = a.f115b[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + bVar);
                        }
                        throw new IllegalArgumentException();
                    }
                    return d.a.ON_PAUSE;
                }
                return d.a.ON_STOP;
            }
            return d.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(g gVar) {
        a.a.a.a.b<f, b>.d d2 = this.f110a.d();
        while (d2.hasNext() && !this.f) {
            Map.Entry next = d2.next();
            b bVar = (b) next.getValue();
            while (bVar.f116a.compareTo(this.f111b) < 0 && !this.f && this.f110a.contains(next.getKey())) {
                n(bVar.f116a);
                bVar.a(gVar, p(bVar.f116a));
                m();
            }
        }
    }

    static d.b h(d.a aVar) {
        switch (a.f114a[aVar.ordinal()]) {
            case 1:
            case 2:
                return d.b.CREATED;
            case 3:
            case 4:
                return d.b.STARTED;
            case 5:
                return d.b.RESUMED;
            case 6:
                return d.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private boolean j() {
        if (this.f110a.size() == 0) {
            return true;
        }
        d.b bVar = this.f110a.b().getValue().f116a;
        d.b bVar2 = this.f110a.e().getValue().f116a;
        return bVar == bVar2 && this.f111b == bVar2;
    }

    static d.b k(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void l(d.b bVar) {
        if (this.f111b == bVar) {
            return;
        }
        this.f111b = bVar;
        if (this.e || this.f113d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        o();
        this.e = false;
    }

    private void m() {
        ArrayList<d.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void n(d.b bVar) {
        this.g.add(bVar);
    }

    private void o() {
        g gVar = this.f112c.get();
        if (gVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean j = j();
            this.f = false;
            if (j) {
                return;
            }
            if (this.f111b.compareTo(this.f110a.b().getValue().f116a) < 0) {
                d(gVar);
            }
            Map.Entry<f, b> e = this.f110a.e();
            if (!this.f && e != null && this.f111b.compareTo(e.getValue().f116a) > 0) {
                g(gVar);
            }
        }
    }

    private static d.a p(d.b bVar) {
        int i = a.f115b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return d.a.ON_START;
            }
            if (i == 3) {
                return d.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return d.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.d
    public void a(f fVar) {
        g gVar;
        d.b bVar = this.f111b;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        b bVar3 = new b(fVar, bVar2);
        if (this.f110a.i(fVar, bVar3) == null && (gVar = this.f112c.get()) != null) {
            boolean z = this.f113d != 0 || this.e;
            d.b e = e(fVar);
            this.f113d++;
            while (bVar3.f116a.compareTo(e) < 0 && this.f110a.contains(fVar)) {
                n(bVar3.f116a);
                bVar3.a(gVar, p(bVar3.f116a));
                m();
                e = e(fVar);
            }
            if (!z) {
                o();
            }
            this.f113d--;
        }
    }

    @Override // androidx.lifecycle.d
    public d.b b() {
        return this.f111b;
    }

    @Override // androidx.lifecycle.d
    public void c(f fVar) {
        this.f110a.g(fVar);
    }

    public void i(d.a aVar) {
        l(h(aVar));
    }
}
