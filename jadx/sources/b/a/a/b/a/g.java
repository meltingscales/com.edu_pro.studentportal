package b.a.a.b.a;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private String f178a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f179b = null;

    /* renamed from: c  reason: collision with root package name */
    private Integer f180c = null;

    /* renamed from: d  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f181d = null;
    private ThreadFactory e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ThreadFactory f182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f183b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f184c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Boolean f185d;
        final /* synthetic */ Integer e;
        final /* synthetic */ Thread.UncaughtExceptionHandler f;

        a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f182a = threadFactory;
            this.f183b = str;
            this.f184c = atomicLong;
            this.f185d = bool;
            this.e = num;
            this.f = uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = this.f182a.newThread(runnable);
            String str = this.f183b;
            if (str != null) {
                newThread.setName(g.d(str, Long.valueOf(this.f184c.getAndIncrement())));
            }
            Boolean bool = this.f185d;
            if (bool != null) {
                newThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.e;
            if (num != null) {
                newThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f;
            if (uncaughtExceptionHandler != null) {
                newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return newThread;
        }
    }

    private static ThreadFactory c(g gVar) {
        String str = gVar.f178a;
        Boolean bool = gVar.f179b;
        Integer num = gVar.f180c;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = gVar.f181d;
        ThreadFactory threadFactory = gVar.e;
        if (threadFactory == null) {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new a(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public ThreadFactory b() {
        return c(this);
    }

    public g e(String str) {
        d(str, 0);
        this.f178a = str;
        return this;
    }

    public g f(int i) {
        b.a.a.a.b.a(i >= 1, "Thread priority (%s) must be >= %s", i, 1);
        b.a.a.a.b.a(i <= 10, "Thread priority (%s) must be <= %s", i, 10);
        this.f180c = Integer.valueOf(i);
        return this;
    }
}
