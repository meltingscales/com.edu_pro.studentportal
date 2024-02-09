package d.d.a;

import d.c;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {
    private a() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        d(illegalStateException);
        throw illegalStateException;
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        g(str);
        throw null;
    }

    private static <T extends Throwable> T d(T t) {
        e(t, a.class.getName());
        return t;
    }

    static <T extends Throwable> T e(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void f() {
        d.a aVar = new d.a();
        d(aVar);
        throw aVar;
    }

    private static void g(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str);
        d(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void h(String str) {
        c cVar = new c(str);
        d(cVar);
        throw cVar;
    }

    public static void i(String str) {
        h("lateinit property " + str + " has not been initialized");
        throw null;
    }
}
