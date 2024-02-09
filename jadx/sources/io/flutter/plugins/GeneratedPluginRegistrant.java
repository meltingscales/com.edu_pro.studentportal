package io.flutter.plugins;

import androidx.annotation.Keep;
import io.flutter.embedding.engine.b;
import io.flutter.plugins.a.a;
import io.flutter.plugins.b.h;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.urllauncher.c;

@Keep
/* loaded from: classes.dex */
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(b bVar) {
        try {
            bVar.p().i(new a());
        } catch (Exception e) {
            c.a.b.c(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e);
        }
        try {
            bVar.p().i(new c.b.a.a.a.a());
        } catch (Exception e2) {
            c.a.b.c(TAG, "Error registering plugin fluttertoast, io.github.ponnamkarthik.toast.fluttertoast.FlutterToastPlugin", e2);
        }
        try {
            bVar.p().i(new ImagePickerPlugin());
        } catch (Exception e3) {
            c.a.b.c(TAG, "Error registering plugin image_picker, io.flutter.plugins.imagepicker.ImagePickerPlugin", e3);
        }
        try {
            bVar.p().i(new h());
        } catch (Exception e4) {
            c.a.b.c(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e4);
        }
        try {
            bVar.p().i(new io.flutter.plugins.c.b());
        } catch (Exception e5) {
            c.a.b.c(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e5);
        }
        try {
            bVar.p().i(new c());
        } catch (Exception e6) {
            c.a.b.c(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e6);
        }
    }
}
