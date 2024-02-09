package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Object f96a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0006a f97b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f96a = obj;
        this.f97b = a.f99c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        this.f97b.a(gVar, aVar, this.f96a);
    }
}
