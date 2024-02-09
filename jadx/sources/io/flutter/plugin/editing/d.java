package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.m;
import io.flutter.embedding.engine.j.n;
import io.flutter.plugin.editing.c;
import io.flutter.plugin.platform.k;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private final View f533a;

    /* renamed from: b  reason: collision with root package name */
    private final InputMethodManager f534b;

    /* renamed from: c  reason: collision with root package name */
    private final AutofillManager f535c;

    /* renamed from: d  reason: collision with root package name */
    private final n f536d;
    private c e = new c(c.a.NO_TARGET, 0);
    private n.b f;
    private SparseArray<n.b> g;
    private io.flutter.plugin.editing.c h;
    private boolean i;
    private InputConnection j;
    private k k;
    private Rect l;
    private ImeSyncDeferringInsetsCallback m;
    private n.e n;
    private boolean o;

    /* loaded from: classes.dex */
    class a implements n.f {
        a() {
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void a(String str, Bundle bundle) {
            d.this.B(str, bundle);
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void b() {
            d.this.x();
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void c() {
            d.this.m();
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void d() {
            d dVar = d.this;
            dVar.F(dVar.f533a);
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void e(int i, n.b bVar) {
            d.this.D(i, bVar);
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void f(int i, boolean z) {
            d.this.C(i, z);
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void g(double d2, double d3, double[] dArr) {
            d.this.A(d2, d3, dArr);
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void h(boolean z) {
            if (Build.VERSION.SDK_INT < 26 || d.this.f535c == null) {
                return;
            }
            if (z) {
                d.this.f535c.commit();
            } else {
                d.this.f535c.cancel();
            }
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void i() {
            if (d.this.e.f541a == c.a.HC_PLATFORM_VIEW) {
                d.this.y();
                return;
            }
            d dVar = d.this;
            dVar.s(dVar.f533a);
        }

        @Override // io.flutter.embedding.engine.j.n.f
        public void j(n.e eVar) {
            d dVar = d.this;
            dVar.E(dVar.f533a, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements InterfaceC0035d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f538a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double[] f539b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ double[] f540c;

        b(d dVar, boolean z, double[] dArr, double[] dArr2) {
            this.f538a = z;
            this.f539b = dArr;
            this.f540c = dArr2;
        }

        @Override // io.flutter.plugin.editing.d.InterfaceC0035d
        public void a(double d2, double d3) {
            double d4 = 1.0d;
            if (!this.f538a) {
                double[] dArr = this.f539b;
                d4 = 1.0d / (((dArr[3] * d2) + (dArr[7] * d3)) + dArr[15]);
            }
            double[] dArr2 = this.f539b;
            double d5 = ((dArr2[0] * d2) + (dArr2[4] * d3) + dArr2[12]) * d4;
            double d6 = ((dArr2[1] * d2) + (dArr2[5] * d3) + dArr2[13]) * d4;
            double[] dArr3 = this.f540c;
            if (d5 < dArr3[0]) {
                dArr3[0] = d5;
            } else if (d5 > dArr3[1]) {
                dArr3[1] = d5;
            }
            if (d6 < dArr3[2]) {
                dArr3[2] = d6;
            } else if (d6 > dArr3[3]) {
                dArr3[3] = d6;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        a f541a;

        /* renamed from: b  reason: collision with root package name */
        int f542b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VD_PLATFORM_VIEW,
            HC_PLATFORM_VIEW
        }

        public c(a aVar, int i) {
            this.f541a = aVar;
            this.f542b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.plugin.editing.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0035d {
        void a(double d2, double d3);
    }

    @SuppressLint({"NewApi"})
    public d(View view, n nVar, k kVar) {
        this.f533a = view;
        this.f534b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i = Build.VERSION.SDK_INT;
        this.f535c = i >= 26 ? (AutofillManager) view.getContext().getSystemService(AutofillManager.class) : null;
        if (i >= 30) {
            int navigationBars = (view.getWindowSystemUiVisibility() & 2) == 0 ? 0 | WindowInsets.Type.navigationBars() : 0;
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view, (view.getWindowSystemUiVisibility() & 4) == 0 ? navigationBars | WindowInsets.Type.statusBars() : navigationBars, WindowInsets.Type.ime());
            this.m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f536d = nVar;
        nVar.l(new a());
        nVar.i();
        this.k = kVar;
        kVar.v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(double d2, double d3, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d4 = dArr[12] / dArr[15];
        dArr2[1] = d4;
        dArr2[0] = d4;
        double d5 = dArr[13] / dArr[15];
        dArr2[3] = d5;
        dArr2[2] = d5;
        b bVar = new b(this, z, dArr, dArr2);
        bVar.a(d2, 0.0d);
        bVar.a(d2, d3);
        bVar.a(0.0d, d3);
        Float valueOf = Float.valueOf(this.f533a.getContext().getResources().getDisplayMetrics().density);
        double d6 = dArr2[0];
        double floatValue = valueOf.floatValue();
        Double.isNaN(floatValue);
        double d7 = dArr2[2];
        double floatValue2 = valueOf.floatValue();
        Double.isNaN(floatValue2);
        double d8 = dArr2[1];
        double floatValue3 = valueOf.floatValue();
        Double.isNaN(floatValue3);
        double d9 = dArr2[3];
        double floatValue4 = valueOf.floatValue();
        Double.isNaN(floatValue4);
        this.l = new Rect((int) (d6 * floatValue), (int) (d7 * floatValue2), (int) Math.ceil(d8 * floatValue3), (int) Math.ceil(d9 * floatValue4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i, boolean z) {
        if (!z) {
            this.e = new c(c.a.HC_PLATFORM_VIEW, i);
            this.j = null;
            return;
        }
        this.f533a.requestFocus();
        this.e = new c(c.a.VD_PLATFORM_VIEW, i);
        this.f534b.restartInput(this.f533a);
        this.i = false;
    }

    private void H(n.b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.i == null) {
            this.g = null;
            return;
        }
        n.b[] bVarArr = bVar.j;
        SparseArray<n.b> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.i.f479a.hashCode(), bVar);
            return;
        }
        for (n.b bVar2 : bVarArr) {
            n.b.a aVar = bVar2.i;
            if (aVar != null) {
                this.g.put(aVar.f479a.hashCode(), bVar2);
                this.f535c.notifyValueChanged(this.f533a, aVar.f479a.hashCode(), AutofillValue.forText(aVar.f481c.f489a));
            }
        }
    }

    private boolean k() {
        n.c cVar;
        n.b bVar = this.f;
        return bVar == null || (cVar = bVar.f) == null || cVar.f482a != n.g.NONE;
    }

    private static boolean n(n.e eVar, n.e eVar2) {
        int i = eVar.e - eVar.f492d;
        if (i != eVar2.e - eVar2.f492d) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (eVar.f489a.charAt(eVar.f492d + i2) != eVar2.f489a.charAt(eVar2.f492d + i2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(View view) {
        y();
        this.f534b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int t(n.c cVar, boolean z, boolean z2, boolean z3, boolean z4, n.d dVar) {
        n.g gVar = cVar.f482a;
        if (gVar == n.g.DATETIME) {
            return 4;
        }
        if (gVar == n.g.NUMBER) {
            int i = cVar.f483b ? 4098 : 2;
            return cVar.f484c ? i | 8192 : i;
        } else if (gVar == n.g.PHONE) {
            return 3;
        } else {
            if (gVar == n.g.NONE) {
                return 0;
            }
            int i2 = 1;
            if (gVar == n.g.MULTILINE) {
                i2 = 131073;
            } else if (gVar == n.g.EMAIL_ADDRESS) {
                i2 = 33;
            } else if (gVar == n.g.URL) {
                i2 = 17;
            } else if (gVar == n.g.VISIBLE_PASSWORD) {
                i2 = 145;
            } else if (gVar == n.g.NAME) {
                i2 = 97;
            } else if (gVar == n.g.POSTAL_ADDRESS) {
                i2 = 113;
            }
            if (z) {
                i2 = i2 | 524288 | 128;
            } else {
                if (z2) {
                    i2 |= 32768;
                }
                if (!z3) {
                    i2 |= 524288;
                }
            }
            return dVar == n.d.CHARACTERS ? i2 | 4096 : dVar == n.d.WORDS ? i2 | 8192 : dVar == n.d.SENTENCES ? i2 | 16384 : i2;
        }
    }

    private boolean v() {
        return this.g != null;
    }

    private void w(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.f535c == null || !v()) {
            return;
        }
        this.f535c.notifyValueChanged(this.f533a, this.f.i.f479a.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (Build.VERSION.SDK_INT < 26 || this.f535c == null || !v()) {
            return;
        }
        String str = this.f.i.f479a;
        int[] iArr = new int[2];
        this.f533a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.l);
        rect.offset(iArr[0], iArr[1]);
        this.f535c.notifyViewEntered(this.f533a, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        n.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.f535c == null || (bVar = this.f) == null || bVar.i == null || !v()) {
            return;
        }
        this.f535c.notifyViewExited(this.f533a, this.f.i.f479a.hashCode());
    }

    public void B(String str, Bundle bundle) {
        this.f534b.sendAppPrivateCommand(this.f533a, str, bundle);
    }

    void D(int i, n.b bVar) {
        y();
        this.f = bVar;
        this.e = k() ? new c(c.a.FRAMEWORK_CLIENT, i) : new c(c.a.NO_TARGET, i);
        io.flutter.plugin.editing.c cVar = this.h;
        if (cVar != null) {
            cVar.j(this);
        }
        n.b.a aVar = bVar.i;
        this.h = new io.flutter.plugin.editing.c(aVar != null ? aVar.f481c : null, this.f533a);
        H(bVar);
        this.i = true;
        G();
        this.l = null;
        this.h.a(this);
    }

    void E(View view, n.e eVar) {
        n.e eVar2;
        if (!this.i && (eVar2 = this.n) != null && eVar2.b()) {
            boolean n = n(this.n, eVar);
            this.i = n;
            if (n) {
                c.a.b.d("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.n = eVar;
        this.h.l(eVar);
        if (this.i) {
            this.f534b.restartInput(view);
            this.i = false;
        }
    }

    void F(View view) {
        if (!k()) {
            s(view);
            return;
        }
        view.requestFocus();
        this.f534b.showSoftInput(view, 0);
    }

    public void G() {
        this.o = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r7 == r0.e) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // io.flutter.plugin.editing.c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.c r9 = r8.h
            java.lang.String r9 = r9.toString()
            r8.w(r9)
        Lb:
            io.flutter.plugin.editing.c r9 = r8.h
            int r9 = r9.g()
            io.flutter.plugin.editing.c r10 = r8.h
            int r10 = r10.f()
            io.flutter.plugin.editing.c r11 = r8.h
            int r11 = r11.e()
            io.flutter.plugin.editing.c r0 = r8.h
            int r7 = r0.d()
            io.flutter.embedding.engine.j.n$e r0 = r8.n
            if (r0 == 0) goto L4c
            io.flutter.plugin.editing.c r0 = r8.h
            java.lang.String r0 = r0.toString()
            io.flutter.embedding.engine.j.n$e r1 = r8.n
            java.lang.String r1 = r1.f489a
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4a
            io.flutter.embedding.engine.j.n$e r0 = r8.n
            int r1 = r0.f490b
            if (r9 != r1) goto L4a
            int r1 = r0.f491c
            if (r10 != r1) goto L4a
            int r1 = r0.f492d
            if (r11 != r1) goto L4a
            int r0 = r0.e
            if (r7 != r0) goto L4a
            goto L4c
        L4a:
            r0 = 0
            goto L4d
        L4c:
            r0 = 1
        L4d:
            if (r0 != 0) goto L90
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "send EditingState to flutter: "
            r0.append(r1)
            io.flutter.plugin.editing.c r1 = r8.h
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TextInputPlugin"
            c.a.b.e(r1, r0)
            io.flutter.embedding.engine.j.n r0 = r8.f536d
            io.flutter.plugin.editing.d$c r1 = r8.e
            int r1 = r1.f542b
            io.flutter.plugin.editing.c r2 = r8.h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.n(r1, r2, r3, r4, r5, r6)
            io.flutter.embedding.engine.j.n$e r6 = new io.flutter.embedding.engine.j.n$e
            io.flutter.plugin.editing.c r0 = r8.h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.n = r6
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.d.a(boolean, boolean, boolean):void");
    }

    public void j(SparseArray<AutofillValue> sparseArray) {
        n.b.a aVar;
        n.b.a aVar2;
        if (Build.VERSION.SDK_INT >= 26 && (aVar = this.f.i) != null) {
            HashMap<String, n.e> hashMap = new HashMap<>();
            for (int i = 0; i < sparseArray.size(); i++) {
                n.b bVar = this.g.get(sparseArray.keyAt(i));
                if (bVar != null && (aVar2 = bVar.i) != null) {
                    String charSequence = sparseArray.valueAt(i).getTextValue().toString();
                    n.e eVar = new n.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                    if (aVar2.f479a.equals(aVar.f479a)) {
                        this.h.l(eVar);
                    } else {
                        hashMap.put(aVar2.f479a, eVar);
                    }
                }
            }
            this.f536d.o(this.e.f542b, hashMap);
        }
    }

    public void l(int i) {
        c cVar = this.e;
        c.a aVar = cVar.f541a;
        if ((aVar == c.a.VD_PLATFORM_VIEW || aVar == c.a.HC_PLATFORM_VIEW) && cVar.f542b == i) {
            this.e = new c(c.a.NO_TARGET, 0);
            y();
            this.f534b.hideSoftInputFromWindow(this.f533a.getApplicationWindowToken(), 0);
            this.f534b.restartInput(this.f533a);
            this.i = false;
        }
    }

    void m() {
        if (this.e.f541a == c.a.VD_PLATFORM_VIEW) {
            return;
        }
        this.h.j(this);
        y();
        H(null);
        this.e = new c(c.a.NO_TARGET, 0);
        G();
        this.l = null;
    }

    public InputConnection o(View view, m mVar, EditorInfo editorInfo) {
        c cVar = this.e;
        c.a aVar = cVar.f541a;
        if (aVar == c.a.NO_TARGET) {
            this.j = null;
            return null;
        } else if (aVar == c.a.HC_PLATFORM_VIEW) {
            return null;
        } else {
            if (aVar == c.a.VD_PLATFORM_VIEW) {
                if (this.o) {
                    return this.j;
                }
                InputConnection onCreateInputConnection = this.k.a(Integer.valueOf(cVar.f542b)).onCreateInputConnection(editorInfo);
                this.j = onCreateInputConnection;
                return onCreateInputConnection;
            }
            n.b bVar = this.f;
            int t = t(bVar.f, bVar.f475a, bVar.f476b, bVar.f477c, bVar.f478d, bVar.e);
            editorInfo.inputType = t;
            editorInfo.imeOptions = 33554432;
            if (Build.VERSION.SDK_INT >= 26 && !this.f.f478d) {
                editorInfo.imeOptions = 33554432 | 16777216;
            }
            Integer num = this.f.g;
            int intValue = num == null ? (t & 131072) != 0 ? 1 : 6 : num.intValue();
            String str = this.f.h;
            if (str != null) {
                editorInfo.actionLabel = str;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions = intValue | editorInfo.imeOptions;
            io.flutter.plugin.editing.b bVar2 = new io.flutter.plugin.editing.b(view, this.e.f542b, this.f536d, mVar, this.h, editorInfo);
            editorInfo.initialSelStart = this.h.g();
            editorInfo.initialSelEnd = this.h.f();
            this.j = bVar2;
            return bVar2;
        }
    }

    @SuppressLint({"NewApi"})
    public void p() {
        this.k.E();
        this.f536d.l(null);
        y();
        io.flutter.plugin.editing.c cVar = this.h;
        if (cVar != null) {
            cVar.j(this);
        }
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager q() {
        return this.f534b;
    }

    public boolean r(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!q().isAcceptingText() || (inputConnection = this.j) == null) {
            return false;
        }
        return inputConnection instanceof io.flutter.plugin.editing.b ? ((io.flutter.plugin.editing.b) inputConnection).f(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void u() {
        if (this.e.f541a == c.a.VD_PLATFORM_VIEW) {
            this.o = true;
        }
    }

    public void z(ViewStructure viewStructure, int i) {
        ViewStructure viewStructure2;
        CharSequence charSequence;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !v()) {
            return;
        }
        String str = this.f.i.f479a;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            int keyAt = this.g.keyAt(i2);
            n.b.a aVar = this.g.valueAt(i2).i;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i2);
                newChild.setAutofillId(autofillId, keyAt);
                newChild.setAutofillHints(aVar.f480b);
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                if (str.hashCode() != keyAt || (rect = this.l) == null) {
                    viewStructure2 = newChild;
                    viewStructure2.setDimens(0, 0, 0, 0, 1, 1);
                    charSequence = aVar.f481c.f489a;
                } else {
                    viewStructure2 = newChild;
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.l.height());
                    charSequence = this.h;
                }
                viewStructure2.setAutofillValue(AutofillValue.forText(charSequence));
            }
        }
    }
}
