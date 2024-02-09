package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class a {

    /* renamed from: c  reason: collision with root package name */
    static a f99c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, C0006a> f100a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f101b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006a {

        /* renamed from: a  reason: collision with root package name */
        final Map<d.a, List<b>> f102a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, d.a> f103b;

        C0006a(Map<b, d.a> map) {
            this.f103b = map;
            for (Map.Entry<b, d.a> entry : map.entrySet()) {
                d.a value = entry.getValue();
                List<b> list = this.f102a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f102a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, g gVar, d.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(gVar, aVar, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(g gVar, d.a aVar, Object obj) {
            b(this.f102a.get(aVar), gVar, aVar, obj);
            b(this.f102a.get(d.a.ON_ANY), gVar, aVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f104a;

        /* renamed from: b  reason: collision with root package name */
        final Method f105b;

        b(int i, Method method) {
            this.f104a = i;
            this.f105b = method;
            method.setAccessible(true);
        }

        void a(g gVar, d.a aVar, Object obj) {
            try {
                int i = this.f104a;
                if (i == 0) {
                    this.f105b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f105b.invoke(obj, gVar);
                } else if (i != 2) {
                } else {
                    this.f105b.invoke(obj, gVar, aVar);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f104a == bVar.f104a && this.f105b.getName().equals(bVar.f105b.getName());
        }

        public int hashCode() {
            return (this.f104a * 31) + this.f105b.getName().hashCode();
        }
    }

    a() {
    }

    private C0006a a(Class<?> cls, Method[] methodArr) {
        int i;
        C0006a c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c2 = c(superclass)) != null) {
            hashMap.putAll(c2.f103b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, d.a> entry : c(cls2).f103b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            l lVar = (l) method.getAnnotation(l.class);
            if (lVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(g.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                d.a value = lVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != d.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i, method), value, cls);
                z = true;
            }
        }
        C0006a c0006a = new C0006a(hashMap);
        this.f100a.put(cls, c0006a);
        this.f101b.put(cls, Boolean.valueOf(z));
        return c0006a;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    private void e(Map<b, d.a> map, b bVar, d.a aVar, Class<?> cls) {
        d.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        Method method = bVar.f105b;
        throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0006a c(Class<?> cls) {
        C0006a c0006a = this.f100a.get(cls);
        return c0006a != null ? c0006a : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f101b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((l) method.getAnnotation(l.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f101b.put(cls, Boolean.FALSE);
        return false;
    }
}
