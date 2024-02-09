package io.flutter.plugins.imagepicker;

import android.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
class b {
    private static void b(a.d.a.a aVar, a.d.a.a aVar2, String str) {
        if (aVar.j(str) != null) {
            aVar2.Y(str, aVar.j(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            a.d.a.a aVar = new a.d.a.a(str);
            a.d.a.a aVar2 = new a.d.a.a(str2);
            for (String str3 : Arrays.asList("FNumber", "ExposureTime", "ISOSpeedRatings", "GPSAltitude", "GPSAltitudeRef", "FocalLength", "GPSDateStamp", "WhiteBalance", "GPSProcessingMethod", "GPSTimeStamp", "DateTime", "Flash", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "Orientation")) {
                b(aVar, aVar2, str3);
            }
            aVar2.U();
        } catch (Exception e) {
            Log.e("ExifDataCopier", "Error preserving Exif data on selected image: " + e);
        }
    }
}
