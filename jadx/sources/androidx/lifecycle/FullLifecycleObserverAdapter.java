package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements e {

    /* renamed from: a  reason: collision with root package name */
    private final b f87a;

    /* renamed from: b  reason: collision with root package name */
    private final e f88b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f89a;

        static {
            int[] iArr = new int[d.a.values().length];
            f89a = iArr;
            try {
                iArr[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f89a[d.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f89a[d.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f89a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f89a[d.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f89a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f89a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(b bVar, e eVar) {
        this.f87a = bVar;
        this.f88b = eVar;
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        switch (a.f89a[aVar.ordinal()]) {
            case 1:
                this.f87a.e(gVar);
                break;
            case 2:
                this.f87a.f(gVar);
                break;
            case 3:
                this.f87a.a(gVar);
                break;
            case 4:
                this.f87a.b(gVar);
                break;
            case 5:
                this.f87a.d(gVar);
                break;
            case 6:
                this.f87a.c(gVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f88b;
        if (eVar != null) {
            eVar.g(gVar, aVar);
        }
    }
}
