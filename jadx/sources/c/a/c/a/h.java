package c.a.c.a;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f206a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f207b;

    public h(String str, Object obj) {
        this.f206a = str;
        this.f207b = obj;
    }

    public <T> T a(String str) {
        Object obj = this.f207b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public <T> T b() {
        return (T) this.f207b;
    }
}
