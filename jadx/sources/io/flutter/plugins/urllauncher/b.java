package io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f662a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f663b;

    /* loaded from: classes.dex */
    enum a {
        OK,
        NO_ACTIVITY,
        ACTIVITY_NOT_FOUND
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Activity activity) {
        this.f662a = context;
        this.f663b = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName resolveActivity = intent.resolveActivity(this.f662a.getPackageManager());
        if (resolveActivity == null) {
            Log.i("UrlLauncher", "component name for " + str + " is null");
            return false;
        }
        Log.i("UrlLauncher", "component name for " + str + " is " + resolveActivity.toShortString());
        return !"{com.android.fallback/com.android.fallback.Fallback}".equals(resolveActivity.toShortString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f662a.sendBroadcast(new Intent(WebViewActivity.e));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c(String str, Bundle bundle, boolean z, boolean z2, boolean z3) {
        Activity activity = this.f663b;
        if (activity == null) {
            return a.NO_ACTIVITY;
        }
        try {
            this.f663b.startActivity(z ? WebViewActivity.b(activity, str, z2, z3, bundle) : new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", bundle));
            return a.OK;
        } catch (ActivityNotFoundException unused) {
            return a.ACTIVITY_NOT_FOUND;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Activity activity) {
        this.f663b = activity;
    }
}
