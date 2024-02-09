package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class c implements q {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f249a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView.ScaleType f250b;

    /* renamed from: c  reason: collision with root package name */
    private final long f251c;

    /* renamed from: d  reason: collision with root package name */
    private b f252d;

    /* loaded from: classes.dex */
    class a implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f253a;

        a(c cVar, Runnable runnable) {
            this.f253a = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f253a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f253a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ImageView {
        public b(Context context) {
            this(context, null, 0);
        }

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public void a(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }

        public void setSplashDrawable(Drawable drawable) {
            a(drawable, ImageView.ScaleType.FIT_XY);
        }
    }

    public c(Drawable drawable) {
        this(drawable, ImageView.ScaleType.FIT_XY, 500L);
    }

    public c(Drawable drawable, ImageView.ScaleType scaleType, long j) {
        this.f249a = drawable;
        this.f250b = scaleType;
        this.f251c = j;
    }

    @Override // io.flutter.embedding.android.q
    public void a(Runnable runnable) {
        b bVar = this.f252d;
        if (bVar == null) {
            runnable.run();
        } else {
            bVar.animate().alpha(0.0f).setDuration(this.f251c).setListener(new a(this, runnable));
        }
    }

    @Override // io.flutter.embedding.android.q
    public /* synthetic */ boolean b() {
        return p.a(this);
    }

    @Override // io.flutter.embedding.android.q
    public View c(Context context, Bundle bundle) {
        b bVar = new b(context);
        this.f252d = bVar;
        bVar.a(this.f249a, this.f250b);
        return this.f252d;
    }

    @Override // io.flutter.embedding.android.q
    public /* synthetic */ Bundle d() {
        return p.b(this);
    }
}
