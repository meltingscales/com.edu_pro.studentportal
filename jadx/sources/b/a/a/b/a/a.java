package b.a.a.b.a;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class a<V> extends b.a.a.b.a.i.a implements b.a.a.b.a.e<V> {

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f150d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(a.class.getName());
    private static final b f;
    private static final Object g;

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f151a;

    /* renamed from: b  reason: collision with root package name */
    private volatile e f152b;

    /* renamed from: c  reason: collision with root package name */
    private volatile l f153c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, l lVar, l lVar2);

        abstract void d(l lVar, l lVar2);

        abstract void e(l lVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f154c;

        /* renamed from: d  reason: collision with root package name */
        static final c f155d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f156a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f157b;

        static {
            if (a.f150d) {
                f155d = null;
                f154c = null;
                return;
            }
            f155d = new c(false, null);
            f154c = new c(true, null);
        }

        c(boolean z, Throwable th) {
            this.f156a = z;
            this.f157b = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        final Throwable f158a;

        /* renamed from: b.a.a.b.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0013a extends Throwable {
            C0013a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new d(new C0013a("Failure occurred while trying to finish a future."));
        }

        d(Throwable th) {
            b.a.a.a.b.b(th);
            this.f158a = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        static final e f159d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f160a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f161b;

        /* renamed from: c  reason: collision with root package name */
        e f162c;

        e(Runnable runnable, Executor executor) {
            this.f160a = runnable;
            this.f161b = executor;
        }
    }

    /* loaded from: classes.dex */
    private static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, Thread> f163a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, l> f164b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, l> f165c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f166d;
        final AtomicReferenceFieldUpdater<a, Object> e;

        f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f163a = atomicReferenceFieldUpdater;
            this.f164b = atomicReferenceFieldUpdater2;
            this.f165c = atomicReferenceFieldUpdater3;
            this.f166d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // b.a.a.b.a.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f166d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // b.a.a.b.a.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.e.compareAndSet(aVar, obj, obj2);
        }

        @Override // b.a.a.b.a.a.b
        boolean c(a<?> aVar, l lVar, l lVar2) {
            return this.f165c.compareAndSet(aVar, lVar, lVar2);
        }

        @Override // b.a.a.b.a.a.b
        void d(l lVar, l lVar2) {
            this.f164b.lazySet(lVar, lVar2);
        }

        @Override // b.a.a.b.a.a.b
        void e(l lVar, Thread thread) {
            this.f163a.lazySet(lVar, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f167a;

        /* renamed from: b  reason: collision with root package name */
        final b.a.a.b.a.e<? extends V> f168b;

        @Override // java.lang.Runnable
        public void run() {
            if (((a) this.f167a).f151a != this) {
                return;
            }
            if (a.f.b(this.f167a, this, a.t(this.f168b))) {
                a.q(this.f167a);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class h extends b {
        private h() {
            super();
        }

        @Override // b.a.a.b.a.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (((a) aVar).f152b == eVar) {
                    ((a) aVar).f152b = eVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // b.a.a.b.a.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (((a) aVar).f151a == obj) {
                    ((a) aVar).f151a = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // b.a.a.b.a.a.b
        boolean c(a<?> aVar, l lVar, l lVar2) {
            synchronized (aVar) {
                if (((a) aVar).f153c == lVar) {
                    ((a) aVar).f153c = lVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // b.a.a.b.a.a.b
        void d(l lVar, l lVar2) {
            lVar.f175b = lVar2;
        }

        @Override // b.a.a.b.a.a.b
        void e(l lVar, Thread thread) {
            lVar.f174a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface i<V> extends b.a.a.b.a.e<V> {
    }

    /* loaded from: classes.dex */
    static abstract class j<V> extends a<V> implements i<V> {
        @Override // b.a.a.b.a.a, b.a.a.b.a.e
        public final void a(Runnable runnable, Executor executor) {
            super.a(runnable, executor);
        }

        @Override // b.a.a.b.a.a, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // b.a.a.b.a.a, java.util.concurrent.Future
        public final V get() {
            return (V) super.get();
        }

        @Override // b.a.a.b.a.a, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) {
            return (V) super.get(j, timeUnit);
        }

        @Override // b.a.a.b.a.a, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // b.a.a.b.a.a, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    /* loaded from: classes.dex */
    private static final class k extends b {

        /* renamed from: a  reason: collision with root package name */
        static final Unsafe f169a;

        /* renamed from: b  reason: collision with root package name */
        static final long f170b;

        /* renamed from: c  reason: collision with root package name */
        static final long f171c;

        /* renamed from: d  reason: collision with root package name */
        static final long f172d;
        static final long e;
        static final long f;

        /* renamed from: b.a.a.b.a.a$k$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0014a implements PrivilegedExceptionAction<Unsafe> {
            C0014a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a */
            public Unsafe run() {
                Field[] declaredFields;
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new C0014a());
                }
                try {
                    f171c = unsafe.objectFieldOffset(a.class.getDeclaredField("c"));
                    f170b = unsafe.objectFieldOffset(a.class.getDeclaredField("b"));
                    f172d = unsafe.objectFieldOffset(a.class.getDeclaredField("a"));
                    e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                    f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                    f169a = unsafe;
                } catch (Exception e2) {
                    b.a.a.a.d.e(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        private k() {
            super();
        }

        @Override // b.a.a.b.a.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return f169a.compareAndSwapObject(aVar, f170b, eVar, eVar2);
        }

        @Override // b.a.a.b.a.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return f169a.compareAndSwapObject(aVar, f172d, obj, obj2);
        }

        @Override // b.a.a.b.a.a.b
        boolean c(a<?> aVar, l lVar, l lVar2) {
            return f169a.compareAndSwapObject(aVar, f171c, lVar, lVar2);
        }

        @Override // b.a.a.b.a.a.b
        void d(l lVar, l lVar2) {
            f169a.putObject(lVar, f, lVar2);
        }

        @Override // b.a.a.b.a.a.b
        void e(l lVar, Thread thread) {
            f169a.putObject(lVar, e, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class l {

        /* renamed from: c  reason: collision with root package name */
        static final l f173c = new l(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f174a;

        /* renamed from: b  reason: collision with root package name */
        volatile l f175b;

        l() {
            a.f.e(this, Thread.currentThread());
        }

        l(boolean z) {
        }

        void a(l lVar) {
            a.f.d(this, lVar);
        }

        void b() {
            Thread thread = this.f174a;
            if (thread != null) {
                this.f174a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        b hVar;
        Throwable th = null;
        try {
            hVar = new k();
            th = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                hVar = new f(AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, l.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            } catch (Throwable th3) {
                hVar = new h();
                th = th3;
            }
        }
        f = hVar;
        if (th != null) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "UnsafeAtomicHelper is broken!", th);
            logger.log(level, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    protected a() {
    }

    private String B(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private void m(StringBuilder sb) {
        String str = "]";
        try {
            Object u = u(this);
            sb.append("SUCCESS, result=[");
            sb.append(B(u));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append(str);
        }
    }

    private static CancellationException o(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e p(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f152b;
        } while (!f.a(this, eVar2, e.f159d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f162c;
            eVar4.f162c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [b.a.a.b.a.a$b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [b.a.a.b.a.a<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [b.a.a.b.a.a] */
    /* JADX WARN: Type inference failed for: r4v6, types: [b.a.a.b.a.a<V>, b.a.a.b.a.a] */
    public static void q(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.x();
            aVar.n();
            e p = aVar.p(eVar);
            while (p != null) {
                eVar = p.f162c;
                Runnable runnable = p.f160a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f167a;
                    if (((a) aVar).f151a == gVar) {
                        if (f.b(aVar, gVar, t(gVar.f168b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    r(runnable, p.f161b);
                }
                p = eVar;
            }
            return;
        }
    }

    private static void r(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V s(Object obj) {
        if (obj instanceof c) {
            throw o("Task was cancelled.", ((c) obj).f157b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f158a);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object t(b.a.a.b.a.e<?> eVar) {
        Throwable a2;
        if (eVar instanceof i) {
            Object obj = ((a) eVar).f151a;
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.f156a ? cVar.f157b != null ? new c(false, cVar.f157b) : c.f155d : obj;
            }
            return obj;
        } else if (!(eVar instanceof b.a.a.b.a.i.a) || (a2 = b.a.a.b.a.i.b.a((b.a.a.b.a.i.a) eVar)) == null) {
            boolean isCancelled = eVar.isCancelled();
            if ((!f150d) && isCancelled) {
                return c.f155d;
            }
            try {
                Object u = u(eVar);
                if (!isCancelled) {
                    return u == null ? g : u;
                }
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + eVar));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new c(false, e2);
                }
                return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + eVar, e2));
            } catch (ExecutionException e3) {
                if (isCancelled) {
                    return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + eVar, e3));
                }
                return new d(e3.getCause());
            } catch (Throwable th) {
                return new d(th);
            }
        } else {
            return new d(a2);
        }
    }

    private static <V> V u(Future<V> future) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private void x() {
        l lVar;
        do {
            lVar = this.f153c;
        } while (!f.c(this, lVar, l.f173c));
        while (lVar != null) {
            lVar.b();
            lVar = lVar.f175b;
        }
    }

    private void y(l lVar) {
        lVar.f174a = null;
        while (true) {
            l lVar2 = this.f153c;
            if (lVar2 == l.f173c) {
                return;
            }
            l lVar3 = null;
            while (lVar2 != null) {
                l lVar4 = lVar2.f175b;
                if (lVar2.f174a != null) {
                    lVar3 = lVar2;
                } else if (lVar3 != null) {
                    lVar3.f175b = lVar4;
                    if (lVar3.f174a == null) {
                        break;
                    }
                } else if (!f.c(this, lVar2, lVar4)) {
                    break;
                }
                lVar2 = lVar4;
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean A(Throwable th) {
        b.a.a.a.b.b(th);
        if (f.b(this, null, new d(th))) {
            q(this);
            return true;
        }
        return false;
    }

    @Override // b.a.a.b.a.e
    public void a(Runnable runnable, Executor executor) {
        e eVar;
        b.a.a.a.b.c(runnable, "Runnable was null.");
        b.a.a.a.b.c(executor, "Executor was null.");
        if (isDone() || (eVar = this.f152b) == e.f159d) {
            r(runnable, executor);
        }
        e eVar2 = new e(runnable, executor);
        do {
            eVar2.f162c = eVar;
            if (f.a(this, eVar, eVar2)) {
                return;
            }
            eVar = this.f152b;
        } while (eVar != e.f159d);
        r(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.b.a.i.a
    public final Throwable b() {
        if (this instanceof i) {
            Object obj = this.f151a;
            if (obj instanceof d) {
                return ((d) obj).f158a;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.f151a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f150d ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f154c : c.f155d;
        boolean z2 = false;
        a<V> aVar = this;
        while (true) {
            if (f.b(aVar, obj, cVar)) {
                if (z) {
                    aVar.v();
                }
                q(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                b.a.a.b.a.e<? extends V> eVar = ((g) obj).f168b;
                if (!(eVar instanceof i)) {
                    eVar.cancel(z);
                    return true;
                }
                aVar = (a) eVar;
                obj = aVar.f151a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = aVar.f151a;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get() {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f151a;
        if ((obj2 != null) && (!(obj2 instanceof g))) {
            return s(obj2);
        }
        l lVar = this.f153c;
        if (lVar != l.f173c) {
            l lVar2 = new l();
            do {
                lVar2.a(lVar);
                if (f.c(this, lVar, lVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            y(lVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f151a;
                    } while (!((obj != null) & (!(obj instanceof g))));
                    return s(obj);
                }
                lVar = this.f153c;
            } while (lVar != l.f173c);
            return s(this.f151a);
        }
        return s(this.f151a);
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) {
        Locale locale;
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f151a;
        if ((obj != null) && (!(obj instanceof g))) {
            return s(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            l lVar = this.f153c;
            if (lVar != l.f173c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                y(lVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f151a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return s(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        y(lVar2);
                    } else {
                        lVar = this.f153c;
                    }
                } while (lVar != l.f173c);
                return s(this.f151a);
            }
            return s(this.f151a);
        }
        while (nanos > 0) {
            Object obj3 = this.f151a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return s(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j3 = -nanos;
            long convert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(convert);
            boolean z = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f151a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f151a;
        return (!(obj instanceof g)) & (obj != null);
    }

    protected void n() {
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (!isDone()) {
                try {
                    str = w();
                } catch (RuntimeException e2) {
                    str = "Exception thrown from implementation: " + e2.getClass();
                }
                if (str != null && !str.isEmpty()) {
                    sb.append("PENDING, info=[");
                    sb.append(str);
                    sb.append("]");
                    sb.append("]");
                    return sb.toString();
                }
                str2 = isDone() ? "PENDING" : "PENDING";
            }
            m(sb);
            sb.append("]");
            return sb.toString();
        }
        str2 = "CANCELLED";
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }

    protected void v() {
    }

    protected String w() {
        Object obj = this.f151a;
        if (obj instanceof g) {
            return "setFuture=[" + B(((g) obj).f168b) + "]";
        } else if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(V v) {
        if (v == null) {
            v = (V) g;
        }
        if (f.b(this, null, v)) {
            q(this);
            return true;
        }
        return false;
    }
}
