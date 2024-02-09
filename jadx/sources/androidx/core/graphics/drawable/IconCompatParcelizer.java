package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f80a = aVar.p(iconCompat.f80a, 1);
        iconCompat.f82c = aVar.j(iconCompat.f82c, 2);
        iconCompat.f83d = aVar.r(iconCompat.f83d, 3);
        iconCompat.e = aVar.p(iconCompat.e, 4);
        iconCompat.f = aVar.p(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.r(iconCompat.g, 6);
        iconCompat.i = aVar.t(iconCompat.i, 7);
        iconCompat.e();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.f(aVar.f());
        int i = iconCompat.f80a;
        if (-1 != i) {
            aVar.F(i, 1);
        }
        byte[] bArr = iconCompat.f82c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f83d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            aVar.F(i2, 4);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            aVar.F(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            aVar.J(str, 7);
        }
    }
}
