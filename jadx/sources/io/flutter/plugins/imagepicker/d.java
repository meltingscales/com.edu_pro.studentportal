package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import c.a.c.a.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.f641a = context.getSharedPreferences("flutter_image_picker_shared_preference", 0);
    }

    private void h(Double d2, Double d3, int i) {
        SharedPreferences.Editor edit = this.f641a.edit();
        if (d2 != null) {
            edit.putLong("flutter_image_picker_max_width", Double.doubleToRawLongBits(d2.doubleValue()));
        }
        if (d3 != null) {
            edit.putLong("flutter_image_picker_max_height", Double.doubleToRawLongBits(d3.doubleValue()));
        }
        if (i <= -1 || i >= 101) {
            edit.putInt("flutter_image_picker_image_quality", 100);
        } else {
            edit.putInt("flutter_image_picker_image_quality", i);
        }
        edit.apply();
    }

    private void i(String str) {
        this.f641a.edit().putString("flutter_image_picker_type", str).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f641a.edit().clear().apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> b() {
        boolean z;
        Set<String> stringSet;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        if (!this.f641a.contains("flutter_image_picker_image_path") || (stringSet = this.f641a.getStringSet("flutter_image_picker_image_path", null)) == null) {
            z = false;
        } else {
            arrayList.addAll(stringSet);
            hashMap.put("pathList", arrayList);
            z = true;
        }
        if (this.f641a.contains("flutter_image_picker_error_code")) {
            hashMap.put("errorCode", this.f641a.getString("flutter_image_picker_error_code", ""));
            if (this.f641a.contains("flutter_image_picker_error_message")) {
                hashMap.put("errorMessage", this.f641a.getString("flutter_image_picker_error_message", ""));
            }
        } else {
            z2 = z;
        }
        if (z2) {
            if (this.f641a.contains("flutter_image_picker_type")) {
                hashMap.put("type", this.f641a.getString("flutter_image_picker_type", ""));
            }
            if (this.f641a.contains("flutter_image_picker_max_width")) {
                hashMap.put("maxWidth", Double.valueOf(Double.longBitsToDouble(this.f641a.getLong("flutter_image_picker_max_width", 0L))));
            }
            if (this.f641a.contains("flutter_image_picker_max_height")) {
                hashMap.put("maxHeight", Double.valueOf(Double.longBitsToDouble(this.f641a.getLong("flutter_image_picker_max_height", 0L))));
            }
            hashMap.put("imageQuality", this.f641a.contains("flutter_image_picker_image_quality") ? Integer.valueOf(this.f641a.getInt("flutter_image_picker_image_quality", 100)) : 100);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f641a.getString("flutter_image_picker_pending_image_uri", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(h hVar) {
        h((Double) hVar.a("maxWidth"), (Double) hVar.a("maxHeight"), hVar.a("imageQuality") == null ? 100 : ((Integer) hVar.a("imageQuality")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Uri uri) {
        this.f641a.edit().putString("flutter_image_picker_pending_image_uri", uri.getPath()).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ArrayList<String> arrayList, String str, String str2) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        SharedPreferences.Editor edit = this.f641a.edit();
        if (arrayList != null) {
            edit.putStringSet("flutter_image_picker_image_path", hashSet);
        }
        if (str != null) {
            edit.putString("flutter_image_picker_error_code", str);
        }
        if (str2 != null) {
            edit.putString("flutter_image_picker_error_message", str2);
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str) {
        String str2;
        if (str.equals("pickImage") || str.equals("pickMultiImage")) {
            str2 = "image";
        } else if (!str.equals("pickVideo")) {
            return;
        } else {
            str2 = "video";
        }
        i(str2);
    }
}
