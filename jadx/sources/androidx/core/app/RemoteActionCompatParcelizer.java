package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f72a = (IconCompat) aVar.v(remoteActionCompat.f72a, 1);
        remoteActionCompat.f73b = aVar.l(remoteActionCompat.f73b, 2);
        remoteActionCompat.f74c = aVar.l(remoteActionCompat.f74c, 3);
        remoteActionCompat.f75d = (PendingIntent) aVar.r(remoteActionCompat.f75d, 4);
        remoteActionCompat.e = aVar.h(remoteActionCompat.e, 5);
        remoteActionCompat.f = aVar.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f72a, 1);
        aVar.D(remoteActionCompat.f73b, 2);
        aVar.D(remoteActionCompat.f74c, 3);
        aVar.H(remoteActionCompat.f75d, 4);
        aVar.z(remoteActionCompat.e, 5);
        aVar.z(remoteActionCompat.f, 6);
    }
}
