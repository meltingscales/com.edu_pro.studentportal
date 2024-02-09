package io.flutter.embedding.engine.j;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import c.a.c.a.a;
import io.flutter.embedding.engine.j.d;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f387a;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final KeyEvent f388a;

        /* renamed from: b  reason: collision with root package name */
        public final Character f389b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f388a = keyEvent;
            this.f389b = ch;
        }
    }

    public d(c.a.c.a.b bVar) {
        this.f387a = new c.a.c.a.a<>(bVar, "flutter/keyevent", c.a.c.a.d.f204a);
    }

    private static a.e<Object> a(final a aVar) {
        return new a.e() { // from class: io.flutter.embedding.engine.j.a
            @Override // c.a.c.a.a.e
            public final void a(Object obj) {
                d.c(d.a.this, obj);
            }
        };
    }

    private Map<String, Object> b(b bVar, boolean z) {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put("type", z ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(bVar.f388a.getFlags()));
        int i2 = 0;
        hashMap.put("plainCodePoint", Integer.valueOf(bVar.f388a.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(bVar.f388a.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(bVar.f388a.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(bVar.f388a.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(bVar.f388a.getMetaState()));
        Character ch = bVar.f389b;
        if (ch != null) {
            hashMap.put("character", ch.toString());
        }
        hashMap.put("source", Integer.valueOf(bVar.f388a.getSource()));
        InputDevice device = InputDevice.getDevice(bVar.f388a.getDeviceId());
        if (device == null || Build.VERSION.SDK_INT < 19) {
            i = 0;
        } else {
            i2 = device.getVendorId();
            i = device.getProductId();
        }
        hashMap.put("vendorId", Integer.valueOf(i2));
        hashMap.put("productId", Integer.valueOf(i));
        hashMap.put("deviceId", Integer.valueOf(bVar.f388a.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(bVar.f388a.getRepeatCount()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(a aVar, Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e) {
                c.a.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e);
            }
        }
        aVar.a(z);
    }

    public void d(b bVar, boolean z, a aVar) {
        this.f387a.d(b(bVar, z), a(aVar));
    }
}
