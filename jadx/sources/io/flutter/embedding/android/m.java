package io.flutter.embedding.android;

import android.view.KeyEvent;
import android.view.View;
import java.util.HashSet;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    protected final c[] f301a;

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<KeyEvent> f302b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final io.flutter.plugin.editing.d f303c;

    /* renamed from: d  reason: collision with root package name */
    private final View f304d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        final KeyEvent f305a;

        /* renamed from: b  reason: collision with root package name */
        int f306b;

        /* renamed from: c  reason: collision with root package name */
        boolean f307c = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a implements c.a {

            /* renamed from: a  reason: collision with root package name */
            boolean f309a;

            private a() {
                this.f309a = false;
            }

            @Override // io.flutter.embedding.android.m.c.a
            public void a(Boolean bool) {
                if (this.f309a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f309a = true;
                b bVar = b.this;
                bVar.f306b--;
                bVar.f307c = bool.booleanValue() | bVar.f307c;
                b bVar2 = b.this;
                if (bVar2.f306b != 0 || bVar2.f307c) {
                    return;
                }
                m.this.d(bVar2.f305a);
            }
        }

        b(KeyEvent keyEvent) {
            this.f306b = m.this.f301a.length;
            this.f305a = keyEvent;
        }

        public c.a a() {
            return new a();
        }
    }

    /* loaded from: classes.dex */
    interface c {

        /* loaded from: classes.dex */
        public interface a {
            void a(Boolean bool);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public m(View view, io.flutter.plugin.editing.d dVar, c[] cVarArr) {
        this.f304d = view;
        this.f303c = dVar;
        this.f301a = cVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(KeyEvent keyEvent) {
        if (this.f303c.r(keyEvent) || this.f304d == null) {
            return;
        }
        this.f302b.add(keyEvent);
        this.f304d.getRootView().dispatchKeyEvent(keyEvent);
        if (this.f302b.remove(keyEvent)) {
            c.a.b.f("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    public void b() {
        int size = this.f302b.size();
        if (size > 0) {
            c.a.b.f("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    public boolean c(KeyEvent keyEvent) {
        if (this.f302b.remove(keyEvent)) {
            return false;
        }
        if (this.f301a.length <= 0) {
            d(keyEvent);
            return true;
        }
        b bVar = new b(keyEvent);
        for (c cVar : this.f301a) {
            cVar.a(keyEvent, bVar.a());
        }
        return true;
    }
}
