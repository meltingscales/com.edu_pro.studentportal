package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class Fragment$2 implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f84a;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        View view;
        if (aVar != d.a.ON_STOP || (view = this.f84a.f85a) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
