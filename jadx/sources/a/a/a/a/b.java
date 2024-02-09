package a.a.a.a;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f0a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f1b;

    /* renamed from: c  reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2c = new WeakHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f3d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.a.a.a.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f7d;
        }

        @Override // a.a.a.a.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f6c;
        }
    }

    /* renamed from: a.a.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // a.a.a.a.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f6c;
        }

        @Override // a.a.a.a.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f7d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f4a;

        /* renamed from: b  reason: collision with root package name */
        final V f5b;

        /* renamed from: c  reason: collision with root package name */
        c<K, V> f6c;

        /* renamed from: d  reason: collision with root package name */
        c<K, V> f7d;

        c(K k, V v) {
            this.f4a = k;
            this.f5b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.f4a.equals(cVar.f4a) && this.f5b.equals(cVar.f5b);
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f5b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f4a.hashCode() ^ this.f5b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f4a + "=" + this.f5b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f8a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9b = true;

        d() {
        }

        @Override // a.a.a.a.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f8a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f7d;
                this.f8a = cVar3;
                this.f9b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f9b) {
                this.f9b = false;
                cVar = b.this.f0a;
            } else {
                c<K, V> cVar2 = this.f8a;
                cVar = cVar2 != null ? cVar2.f6c : null;
            }
            this.f8a = cVar;
            return this.f8a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9b) {
                return b.this.f0a != null;
            }
            c<K, V> cVar = this.f8a;
            return (cVar == null || cVar.f6c == null) ? false : true;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f11a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f12b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f11a = cVar2;
            this.f12b = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f12b;
            c<K, V> cVar2 = this.f11a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // a.a.a.a.b.f
        public void a(c<K, V> cVar) {
            if (this.f11a == cVar && cVar == this.f12b) {
                this.f12b = null;
                this.f11a = null;
            }
            c<K, V> cVar2 = this.f11a;
            if (cVar2 == cVar) {
                this.f11a = b(cVar2);
            }
            if (this.f12b == cVar) {
                this.f12b = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f12b;
            this.f12b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12b != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> a() {
        C0000b c0000b = new C0000b(this.f1b, this.f0a);
        this.f2c.put(c0000b, Boolean.FALSE);
        return c0000b;
    }

    public Map.Entry<K, V> b() {
        return this.f0a;
    }

    protected c<K, V> c(K k) {
        c<K, V> cVar = this.f0a;
        while (cVar != null && !cVar.f4a.equals(k)) {
            cVar = cVar.f6c;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f2c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> e() {
        return this.f1b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() != bVar.size()) {
                return false;
            }
            Iterator<Map.Entry<K, V>> it = iterator();
            Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry<K, V> next = it.next();
                Map.Entry<K, V> next2 = it2.next();
                if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> f(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f3d++;
        c<K, V> cVar2 = this.f1b;
        if (cVar2 == null) {
            this.f0a = cVar;
        } else {
            cVar2.f6c = cVar;
            cVar.f7d = cVar2;
        }
        this.f1b = cVar;
        return cVar;
    }

    public V g(K k) {
        c<K, V> c2 = c(k);
        if (c2 == null) {
            return null;
        }
        this.f3d--;
        if (!this.f2c.isEmpty()) {
            for (f<K, V> fVar : this.f2c.keySet()) {
                fVar.a(c2);
            }
        }
        c<K, V> cVar = c2.f7d;
        c<K, V> cVar2 = c2.f6c;
        if (cVar != null) {
            cVar.f6c = cVar2;
        } else {
            this.f0a = cVar2;
        }
        c<K, V> cVar3 = c2.f6c;
        if (cVar3 != null) {
            cVar3.f7d = cVar;
        } else {
            this.f1b = cVar;
        }
        c2.f6c = null;
        c2.f7d = null;
        return c2.f5b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f0a, this.f1b);
        this.f2c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f3d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
