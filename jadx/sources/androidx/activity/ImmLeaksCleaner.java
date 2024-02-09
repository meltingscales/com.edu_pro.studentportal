package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements e {

    /* renamed from: b  reason: collision with root package name */
    private static int f64b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f65c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f66d;
    private static Field e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f67a;

    private static void h() {
        try {
            f64b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f66d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f65c = declaredField3;
            declaredField3.setAccessible(true);
            f64b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.e
    public void g(g gVar, d.a aVar) {
        if (aVar != d.a.ON_DESTROY) {
            return;
        }
        if (f64b == 0) {
            h();
        }
        if (f64b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f67a.getSystemService("input_method");
            try {
                Object obj = f65c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f66d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
