package b.a.a.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f142a;

        /* renamed from: b  reason: collision with root package name */
        private final C0011a f143b;

        /* renamed from: c  reason: collision with root package name */
        private C0011a f144c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f145d;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b.a.a.a.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0011a {

            /* renamed from: a  reason: collision with root package name */
            String f146a;

            /* renamed from: b  reason: collision with root package name */
            Object f147b;

            /* renamed from: c  reason: collision with root package name */
            C0011a f148c;

            private C0011a() {
            }
        }

        private b(String str) {
            C0011a c0011a = new C0011a();
            this.f143b = c0011a;
            this.f144c = c0011a;
            this.f145d = false;
            b.a.a.a.b.b(str);
            this.f142a = str;
        }

        private C0011a a() {
            C0011a c0011a = new C0011a();
            this.f144c.f148c = c0011a;
            this.f144c = c0011a;
            return c0011a;
        }

        private b b(Object obj) {
            a().f147b = obj;
            return this;
        }

        public b c(Object obj) {
            b(obj);
            return this;
        }

        public String toString() {
            boolean z = this.f145d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f142a);
            sb.append('{');
            String str = "";
            for (C0011a c0011a = this.f143b.f148c; c0011a != null; c0011a = c0011a.f148c) {
                Object obj = c0011a.f147b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = c0011a.f146a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static b a(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
