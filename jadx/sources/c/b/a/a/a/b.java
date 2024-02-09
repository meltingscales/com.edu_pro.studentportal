package c.b.a.a.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import c.a.c.a.i;

/* loaded from: classes.dex */
public final class b implements i.c {

    /* renamed from: a  reason: collision with root package name */
    private Toast f233a;

    /* renamed from: b  reason: collision with root package name */
    private Context f234b;

    /* loaded from: classes.dex */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.a(b.this).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c.b.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class RunnableC0022b implements Runnable {
        RunnableC0022b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.b();
        }
    }

    public b(Context context) {
        d.d.a.a.c(context, "context");
        this.f234b = context;
    }

    public static final /* synthetic */ Toast a(b bVar) {
        Toast toast = bVar.f233a;
        if (toast != null) {
            return toast;
        }
        d.d.a.a.i("mToast");
        throw null;
    }

    public final void b() {
        Toast toast = this.f233a;
        if (toast != null) {
            if (toast == null) {
                d.d.a.a.i("mToast");
                throw null;
            } else if (toast != null) {
                if (toast == null) {
                    d.d.a.a.i("mToast");
                    throw null;
                }
                View view = toast.getView();
                if (view != null && view.getVisibility() == 0) {
                    new Handler().postDelayed(new RunnableC0022b(), 1000L);
                } else if (this.f233a != null) {
                } else {
                    d.d.a.a.i("mToast");
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca  */
    @Override // c.a.c.a.i.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(c.a.c.a.h r17, c.a.c.a.i.d r18) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.a.a.a.b.f(c.a.c.a.h, c.a.c.a.i$d):void");
    }
}
