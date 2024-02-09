package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements e {

    /* renamed from: a  reason: collision with root package name */
    private final c[] f86a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f86a = cVarArr;
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        j jVar = new j();
        for (c cVar : this.f86a) {
            cVar.a(gVar, aVar, false, jVar);
        }
        for (c cVar2 : this.f86a) {
            cVar2.a(gVar, aVar, true, jVar);
        }
    }
}
