package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    int f91a;

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements Object {

        /* renamed from: d  reason: collision with root package name */
        final g f92d;
        final /* synthetic */ LiveData e;

        public void g(g gVar, d.a aVar) {
            if (this.f92d.a().b() == d.b.DESTROYED) {
                this.e.d(this.f93a);
            } else {
                h(i());
            }
        }

        boolean i() {
            return this.f92d.a().b().a(d.b.STARTED);
        }
    }

    /* loaded from: classes.dex */
    private abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final k<? super T> f93a;

        /* renamed from: b  reason: collision with root package name */
        boolean f94b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LiveData f95c;

        void h(boolean z) {
            if (z == this.f94b) {
                return;
            }
            this.f94b = z;
            LiveData liveData = this.f95c;
            int i = liveData.f91a;
            boolean z2 = i == 0;
            liveData.f91a = i + (z ? 1 : -1);
            if (z2 && z) {
                liveData.b();
            }
            LiveData liveData2 = this.f95c;
            if (liveData2.f91a == 0 && !this.f94b) {
                liveData2.c();
            }
            if (this.f94b) {
                this.f95c.a(this);
            }
        }
    }

    abstract void a(LiveData<T>.a aVar);

    protected abstract void b();

    protected abstract void c();

    public abstract void d(k<? super T> kVar);
}
