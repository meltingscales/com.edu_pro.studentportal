package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Keep
@TargetApi(17)
/* loaded from: classes.dex */
class SingleViewPresentation extends Presentation {
    private final io.flutter.plugin.platform.d accessibilityEventsDelegate;
    private FrameLayout container;
    private Object createParams;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private e state;
    private final g viewFactory;
    private int viewId;

    /* loaded from: classes.dex */
    private static class a extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private final io.flutter.plugin.platform.d f547a;

        /* renamed from: b  reason: collision with root package name */
        private final View f548b;

        public a(Context context, io.flutter.plugin.platform.d dVar, View view) {
            super(context);
            this.f547a = dVar;
            this.f548b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f547a.a(this.f548b, view, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f549a;

        /* renamed from: b  reason: collision with root package name */
        private final Rect f550b;

        public b(Context context) {
            super(context);
            this.f549a = new Rect();
            this.f550b = new Rect();
        }

        private static int a(int i) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), Integer.MIN_VALUE);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.f549a.set(i, i2, i3, i4);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f549a, layoutParams.x, layoutParams.y, this.f550b);
                Rect rect = this.f550b;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).measure(a(i), a(i2));
            }
            super.onMeasure(i, i2);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends ContextWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final InputMethodManager f551a;

        c(Context context) {
            this(context, null);
        }

        private c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f551a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new c(super.createDisplayContext(display), this.f551a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f551a : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    private static class d extends ContextWrapper {

        /* renamed from: a  reason: collision with root package name */
        private final f f552a;

        /* renamed from: b  reason: collision with root package name */
        private WindowManager f553b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f554c;

        d(Context context, f fVar, Context context2) {
            super(context);
            this.f552a = fVar;
            this.f554c = context2;
        }

        private WindowManager a() {
            if (this.f553b == null) {
                this.f553b = this.f552a.b();
            }
            return this.f553b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i = 0; i < stackTrace.length && i < 11; i++) {
                if (stackTrace[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f554c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    /* loaded from: classes.dex */
    static class e {

        /* renamed from: a  reason: collision with root package name */
        private io.flutter.plugin.platform.f f555a;

        /* renamed from: b  reason: collision with root package name */
        private f f556b;

        /* renamed from: c  reason: collision with root package name */
        private b f557c;

        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final WindowManager f558a;

        /* renamed from: b  reason: collision with root package name */
        b f559b;

        f(WindowManager windowManager, b bVar) {
            this.f558a = windowManager;
            this.f559b = bVar;
        }

        private void a(Object[] objArr) {
            b bVar = this.f559b;
            if (bVar == null) {
                c.a.b.f("PlatformViewsController", "Embedded view called addView while detached from presentation");
            } else {
                bVar.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        private void c(Object[] objArr) {
            b bVar = this.f559b;
            if (bVar == null) {
                c.a.b.f("PlatformViewsController", "Embedded view called removeView while detached from presentation");
            } else {
                bVar.removeView((View) objArr[0]);
            }
        }

        private void d(Object[] objArr) {
            if (this.f559b == null) {
                c.a.b.f("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.f559b.removeView(view);
        }

        private void e(Object[] objArr) {
            b bVar = this.f559b;
            if (bVar == null) {
                c.a.b.f("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
            } else {
                bVar.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        public WindowManager b() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            name.hashCode();
            char c2 = 65535;
            switch (name.hashCode()) {
                case -1148522778:
                    if (name.equals("addView")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 542766184:
                    if (name.equals("removeViewImmediate")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 931413976:
                    if (name.equals("updateViewLayout")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1098630473:
                    if (name.equals("removeView")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a(objArr);
                    return null;
                case 1:
                    d(objArr);
                    return null;
                case 2:
                    e(objArr);
                    return null;
                case 3:
                    c(objArr);
                    return null;
                default:
                    try {
                        return method.invoke(this.f558a, objArr);
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.d dVar, e eVar, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = dVar;
        this.viewFactory = null;
        this.state = eVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }

    public SingleViewPresentation(Context context, Display display, g gVar, io.flutter.plugin.platform.d dVar, int i, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        super(new c(context), display);
        this.startFocused = false;
        this.viewFactory = gVar;
        this.accessibilityEventsDelegate = dVar;
        this.viewId = i;
        this.createParams = obj;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        this.state = new e();
        getWindow().setFlags(8, 8);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().setType(2030);
        }
    }

    public e detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public io.flutter.plugin.platform.f getView() {
        if (this.state.f555a == null) {
            return null;
        }
        return this.state.f555a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f557c == null) {
            this.state.f557c = new b(getContext());
        }
        if (this.state.f556b == null) {
            e eVar = this.state;
            eVar.f556b = new f((WindowManager) getContext().getSystemService("window"), eVar.f557c);
        }
        this.container = new FrameLayout(getContext());
        d dVar = new d(getContext(), this.state.f556b, this.outerContext);
        if (this.state.f555a == null) {
            this.state.f555a = this.viewFactory.a(dVar, this.viewId, this.createParams);
        }
        View f2 = this.state.f555a.f();
        this.container.addView(f2);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, f2);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f557c);
        f2.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            f2.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
