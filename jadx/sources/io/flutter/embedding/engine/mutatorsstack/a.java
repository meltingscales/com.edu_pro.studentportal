package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import io.flutter.embedding.android.b;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private FlutterMutatorsStack f502a;

    /* renamed from: b  reason: collision with root package name */
    private float f503b;

    /* renamed from: c  reason: collision with root package name */
    private int f504c;

    /* renamed from: d  reason: collision with root package name */
    private int f505d;
    private int e;
    private int f;
    private final b g;
    ViewTreeObserver.OnGlobalFocusChangeListener h;

    /* renamed from: io.flutter.embedding.engine.mutatorsstack.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewTreeObserver$OnGlobalFocusChangeListenerC0032a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f506a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f507b;

        ViewTreeObserver$OnGlobalFocusChangeListenerC0032a(a aVar, View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f506a = onFocusChangeListener;
            this.f507b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f506a;
            View view3 = this.f507b;
            onFocusChangeListener.onFocusChange(view3, a.a(view3));
        }
    }

    public a(Context context, float f, b bVar) {
        super(context, null);
        this.f503b = f;
        this.g = bVar;
    }

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        if (view.hasFocus()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f502a.getFinalMatrix());
        float f = this.f503b;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate(-this.f504c, -this.f505d);
        return matrix;
    }

    public void b(FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.f502a = flutterMutatorsStack;
        this.f504c = i;
        this.f505d = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void c() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.h) == null) {
            return;
        }
        this.h = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.f502a.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset(-this.f504c, -this.f505d);
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float f;
        if (this.g == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i2 = this.f504c;
            this.e = i2;
            i = this.f505d;
            this.f = i;
            f = i2;
        } else if (action == 2) {
            matrix.postTranslate(this.e, this.f);
            this.e = this.f504c;
            this.f = this.f505d;
            return this.g.f(motionEvent, matrix);
        } else {
            f = this.f504c;
            i = this.f505d;
        }
        matrix.postTranslate(f, i);
        return this.g.f(motionEvent, matrix);
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.h == null) {
            ViewTreeObserver$OnGlobalFocusChangeListenerC0032a viewTreeObserver$OnGlobalFocusChangeListenerC0032a = new ViewTreeObserver$OnGlobalFocusChangeListenerC0032a(this, onFocusChangeListener, this);
            this.h = viewTreeObserver$OnGlobalFocusChangeListenerC0032a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserver$OnGlobalFocusChangeListenerC0032a);
        }
    }
}
