package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import io.flutter.embedding.engine.j.i;
import java.io.FileNotFoundException;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f566a;

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.j.i f567b;

    /* renamed from: c  reason: collision with root package name */
    private final d f568c;

    /* renamed from: d  reason: collision with root package name */
    private i.j f569d;
    private int e;
    final i.h f;

    /* loaded from: classes.dex */
    class a implements i.h {
        a() {
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void d() {
            e.this.r();
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void e() {
            e.this.v();
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void f(int i) {
            e.this.y(i);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void g(i.c cVar) {
            e.this.u(cVar);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void h(i.g gVar) {
            e.this.B(gVar);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void i(List<i.l> list) {
            e.this.x(list);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void j() {
            e.this.s();
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void k(String str) {
            e.this.t(str);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public boolean l() {
            return e.this.n();
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void m(i.EnumC0030i enumC0030i) {
            e.this.q(enumC0030i);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public CharSequence n(i.e eVar) {
            return e.this.p(eVar);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void o(i.j jVar) {
            e.this.z(jVar);
        }

        @Override // io.flutter.embedding.engine.j.i.h
        public void p(i.k kVar) {
            e.this.w(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnSystemUiVisibilityChangeListener {
        b() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            io.flutter.embedding.engine.j.i iVar;
            boolean z;
            if ((i & 4) == 0) {
                iVar = e.this.f567b;
                z = false;
            } else {
                iVar = e.this.f567b;
                z = true;
            }
            iVar.m(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f572a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f573b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f574c;

        static {
            int[] iArr = new int[i.d.values().length];
            f574c = iArr;
            try {
                iArr[i.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f574c[i.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[i.l.values().length];
            f573b = iArr2;
            try {
                iArr2[i.l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f573b[i.l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[i.g.values().length];
            f572a = iArr3;
            try {
                iArr3[i.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f572a[i.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f572a[i.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f572a[i.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f572a[i.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean d();
    }

    public e(Activity activity, io.flutter.embedding.engine.j.i iVar, d dVar) {
        a aVar = new a();
        this.f = aVar;
        this.f566a = activity;
        this.f567b = iVar;
        iVar.l(aVar);
        this.f568c = dVar;
        this.e = 1280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f566a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence p(i.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f566a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip()) {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (eVar != null && eVar != i.e.PLAIN_TEXT) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt.getUri() != null) {
                    this.f566a.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
                }
                return itemAt.coerceToText(this.f566a);
            } catch (FileNotFoundException unused) {
                return null;
            } catch (SecurityException e) {
                c.a.b.g("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(i.EnumC0030i enumC0030i) {
        if (enumC0030i == i.EnumC0030i.CLICK) {
            this.f566a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        d dVar = this.f568c;
        if (dVar == null || !dVar.d()) {
            Activity activity = this.f566a;
            if (activity instanceof androidx.activity.d) {
                ((androidx.activity.d) activity).i().b();
                throw null;
            } else {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        ((ClipboardManager) this.f566a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(i.c cVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        if (i < 28 && i > 21) {
            this.f566a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f408b, (Bitmap) null, cVar.f407a));
        }
        if (i >= 28) {
            this.f566a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f408b, 0, cVar.f407a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f566a.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(i.k kVar) {
        int i = Build.VERSION.SDK_INT;
        int i2 = 1798;
        if (kVar != i.k.LEAN_BACK || i < 16) {
            if (kVar == i.k.IMMERSIVE && i >= 19) {
                i2 = 3846;
            } else if (kVar == i.k.IMMERSIVE_STICKY && i >= 19) {
                i2 = 5894;
            } else if (kVar == i.k.EDGE_TO_EDGE && i >= 16) {
                i2 = 1792;
            }
        }
        this.e = i2;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(List<i.l> list) {
        int i = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = c.f573b[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i = i & (-513) & (-3);
            }
        }
        this.e = i;
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i) {
        this.f566a.setRequestedOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(i.j jVar) {
        Window window = this.f566a.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            i.d dVar = jVar.f429b;
            if (dVar != null) {
                int i2 = c.f574c[dVar.ordinal()];
                if (i2 == 1) {
                    systemUiVisibility |= 8192;
                } else if (i2 == 2) {
                    systemUiVisibility &= -8193;
                }
            }
            Integer num = jVar.f428a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        boolean z = jVar.f430c;
        if (!z && i >= 29) {
            window.setStatusBarContrastEnforced(z);
        }
        if (i >= 26) {
            i.d dVar2 = jVar.e;
            if (dVar2 != null) {
                int i3 = c.f574c[dVar2.ordinal()];
                if (i3 == 1) {
                    systemUiVisibility |= 16;
                } else if (i3 == 2) {
                    systemUiVisibility &= -17;
                }
            }
            Integer num2 = jVar.f431d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        if (jVar.f != null && i >= 28) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(134217728);
            window.setNavigationBarDividerColor(jVar.f.intValue());
        }
        boolean z2 = jVar.g;
        if (!z2 && i >= 29) {
            window.setNavigationBarContrastEnforced(z2);
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.f569d = jVar;
    }

    public void A() {
        this.f566a.getWindow().getDecorView().setSystemUiVisibility(this.e);
        i.j jVar = this.f569d;
        if (jVar != null) {
            z(jVar);
        }
    }

    void B(i.g gVar) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        View decorView = this.f566a.getWindow().getDecorView();
        int i3 = c.f572a[gVar.ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                i4 = 3;
                if (i3 != 3) {
                    i4 = 4;
                    if (i3 != 4) {
                        if (i3 != 5 || i2 < 21) {
                            return;
                        }
                    } else if (i2 < 23) {
                        return;
                    } else {
                        i = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i4);
            return;
        }
        i = 0;
        decorView.performHapticFeedback(i);
    }

    public void o() {
        this.f567b.l(null);
    }
}
