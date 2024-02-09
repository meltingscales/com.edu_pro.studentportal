package io.flutter.embedding.engine.j;

import android.os.Build;
import c.a.c.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f391a;

    /* renamed from: b  reason: collision with root package name */
    private b f392b;

    /* renamed from: c  reason: collision with root package name */
    public final i.c f393c;

    /* loaded from: classes.dex */
    class a implements i.c {
        a() {
        }

        @Override // c.a.c.a.i.c
        public void f(c.a.c.a.h hVar, i.d dVar) {
            if (f.this.f392b == null) {
                return;
            }
            String str = hVar.f206a;
            str.hashCode();
            if (!str.equals("Localization.getStringResource")) {
                dVar.c();
                return;
            }
            JSONObject jSONObject = (JSONObject) hVar.b();
            try {
                dVar.b(f.this.f392b.a(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
            } catch (JSONException e) {
                dVar.a("error", e.getMessage(), null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        String a(String str, String str2);
    }

    public f(io.flutter.embedding.engine.f.a aVar) {
        a aVar2 = new a();
        this.f393c = aVar2;
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/localization", c.a.c.a.e.f205a);
        this.f391a = iVar;
        iVar.e(aVar2);
    }

    public void b(List<Locale> list) {
        c.a.b.e("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            c.a.b.e("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.f391a.c("setLocale", arrayList);
    }

    public void c(b bVar) {
        this.f392b = bVar;
    }
}
