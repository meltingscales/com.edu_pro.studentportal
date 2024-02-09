package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements e, a {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.lifecycle.d f68a;

        /* renamed from: b  reason: collision with root package name */
        private final c f69b;

        /* renamed from: c  reason: collision with root package name */
        private a f70c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ OnBackPressedDispatcher f71d;

        @Override // androidx.activity.a
        public void cancel() {
            this.f68a.c(this);
            this.f69b.a(this);
            a aVar = this.f70c;
            if (aVar != null) {
                aVar.cancel();
                this.f70c = null;
            }
        }

        @Override // androidx.lifecycle.e
        public void g(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                this.f71d.a(this.f69b);
                throw null;
            } else if (aVar != d.a.ON_STOP) {
                if (aVar == d.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                a aVar2 = this.f70c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    a a(c cVar) {
        throw null;
    }

    public void b() {
        throw null;
    }
}
