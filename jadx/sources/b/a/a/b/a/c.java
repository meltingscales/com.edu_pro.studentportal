package b.a.a.b.a;

import b.a.a.a.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public final class c extends d {

    /* loaded from: classes.dex */
    private static final class a<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Future<V> f176a;

        /* renamed from: b  reason: collision with root package name */
        final b<? super V> f177b;

        a(Future<V> future, b<? super V> bVar) {
            this.f176a = future;
            this.f177b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f177b.b(c.b(this.f176a));
            } catch (Error e) {
                e = e;
                this.f177b.a(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.f177b.a(e);
            } catch (ExecutionException e3) {
                this.f177b.a(e3.getCause());
            }
        }

        public String toString() {
            a.b a2 = b.a.a.a.a.a(this);
            a2.c(this.f177b);
            return a2.toString();
        }
    }

    public static <V> void a(e<V> eVar, b<? super V> bVar, Executor executor) {
        b.a.a.a.b.b(bVar);
        eVar.a(new a(eVar, bVar), executor);
    }

    public static <V> V b(Future<V> future) {
        b.a.a.a.b.d(future.isDone(), "Future was expected to be done: %s", future);
        return (V) h.a(future);
    }
}
