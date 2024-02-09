package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import io.flutter.embedding.engine.j.n;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends SpannableStringBuilder {

    /* renamed from: a  reason: collision with root package name */
    private int f528a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f529b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<b> f530c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<b> f531d = new ArrayList<>();
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private BaseInputConnection k;

    /* loaded from: classes.dex */
    class a extends BaseInputConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Editable f532a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar, View view, boolean z, Editable editable) {
            super(view, z);
            this.f532a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f532a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z, boolean z2, boolean z3);
    }

    public c(n.e eVar, View view) {
        if (eVar != null) {
            l(eVar);
        }
        this.k = new a(this, view, true, this);
    }

    private void h(b bVar, boolean z, boolean z2, boolean z3) {
        this.f529b++;
        bVar.a(z, z2, z3);
        this.f529b--;
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            Iterator<b> it = this.f530c.iterator();
            while (it.hasNext()) {
                h(it.next(), z, z2, z3);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.f529b > 0) {
            c.a.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f528a > 0) {
            c.a.b.f("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.f531d;
        } else {
            arrayList = this.f530c;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f528a++;
        if (this.f529b > 0) {
            c.a.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f528a != 1 || this.f530c.isEmpty()) {
            return;
        }
        this.f = toString();
        this.g = g();
        this.h = f();
        this.i = e();
        this.j = d();
    }

    public void c() {
        int i = this.f528a;
        if (i == 0) {
            c.a.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i == 1) {
            Iterator<b> it = this.f531d.iterator();
            while (it.hasNext()) {
                h(it.next(), true, true, true);
            }
            if (!this.f530c.isEmpty()) {
                c.a.b.e("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.f530c.size()) + " listener(s)");
                boolean z = false;
                i(!toString().equals(this.f), (this.g == g() && this.h == f()) ? false : true, (this.i == e() && this.j == d()) ? true : true);
            }
        }
        this.f530c.addAll(this.f531d);
        this.f531d.clear();
        this.f528a--;
    }

    public final int d() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int e() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int f() {
        return Selection.getSelectionEnd(this);
    }

    public final int g() {
        return Selection.getSelectionStart(this);
    }

    public void j(b bVar) {
        if (this.f529b > 0) {
            c.a.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.f530c.remove(bVar);
        if (this.f528a > 0) {
            this.f531d.remove(bVar);
        }
    }

    public void k(int i, int i2) {
        if (i < 0 || i >= i2) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.k.setComposingRegion(i, i2);
        }
    }

    public void l(n.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f489a);
        if (eVar.c()) {
            Selection.setSelection(this, eVar.f490b, eVar.f491c);
        } else {
            Selection.removeSelection(this);
        }
        k(eVar.f492d, eVar.e);
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (this.f529b > 0) {
            c.a.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        int i5 = i2 - i;
        boolean z = true;
        boolean z2 = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z2; i6++) {
            z2 |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        if (z2) {
            this.e = null;
        }
        int g = g();
        int f = f();
        int e = e();
        int d2 = d();
        SpannableStringBuilder replace = super.replace(i, i2, charSequence, i3, i4);
        if (this.f528a > 0) {
            return replace;
        }
        boolean z3 = (g() == g && f() == f) ? false : true;
        if (e() == e && d() == d2) {
            z = false;
        }
        i(z2, z3, z);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.e = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
