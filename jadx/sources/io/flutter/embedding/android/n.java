package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: c  reason: collision with root package name */
    private static n f311c;

    /* renamed from: a  reason: collision with root package name */
    private final LongSparseArray<MotionEvent> f312a = new LongSparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Long> f313b = new PriorityQueue<>();

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: b  reason: collision with root package name */
        private static final AtomicLong f314b = new AtomicLong(0);

        /* renamed from: a  reason: collision with root package name */
        private final long f315a;

        private a(long j) {
            this.f315a = j;
        }

        public static a b() {
            return c(f314b.incrementAndGet());
        }

        public static a c(long j) {
            return new a(j);
        }

        public long d() {
            return this.f315a;
        }
    }

    private n() {
    }

    public static n a() {
        if (f311c == null) {
            f311c = new n();
        }
        return f311c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f313b.isEmpty() && this.f313b.peek().longValue() < aVar.f315a) {
            this.f312a.remove(this.f313b.poll().longValue());
        }
        if (!this.f313b.isEmpty() && this.f313b.peek().longValue() == aVar.f315a) {
            this.f313b.poll();
        }
        MotionEvent motionEvent = this.f312a.get(aVar.f315a);
        this.f312a.remove(aVar.f315a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b2 = a.b();
        this.f312a.put(b2.f315a, MotionEvent.obtain(motionEvent));
        this.f313b.add(Long.valueOf(b2.f315a));
        return b2;
    }
}
