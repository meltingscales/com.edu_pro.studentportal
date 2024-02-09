package a.a.a.a;

import a.a.a.a.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> e = new HashMap<>();

    @Override // a.a.a.a.b
    protected b.c<K, V> c(K k) {
        return this.e.get(k);
    }

    public boolean contains(K k) {
        return this.e.containsKey(k);
    }

    @Override // a.a.a.a.b
    public V g(K k) {
        V v = (V) super.g(k);
        this.e.remove(k);
        return v;
    }

    public Map.Entry<K, V> h(K k) {
        if (contains(k)) {
            return this.e.get(k).f7d;
        }
        return null;
    }

    public V i(K k, V v) {
        b.c<K, V> c2 = c(k);
        if (c2 != null) {
            return c2.f5b;
        }
        this.e.put(k, f(k, v));
        return null;
    }
}
