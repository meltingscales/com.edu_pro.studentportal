package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class ComponentActivity$3 implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f63a;

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        if (aVar != d.a.ON_DESTROY || this.f63a.isChangingConfigurations()) {
            return;
        }
        this.f63a.b().a();
    }
}
