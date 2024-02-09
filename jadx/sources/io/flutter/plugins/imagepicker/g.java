package io.flutter.plugins.imagepicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private final File f651a;

    /* renamed from: b  reason: collision with root package name */
    private final b f652b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(File file, b bVar) {
        this.f651a = file;
        this.f652b = bVar;
    }

    private void a(String str, String str2) {
        this.f652b.a(str, str2);
    }

    private File b(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        return file2;
    }

    private File c(String str, Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean hasAlpha = bitmap.hasAlpha();
        if (hasAlpha) {
            Log.d("ImageResizer", "image_picker: compressing is not supported for type PNG. Returning the image with original quality");
        }
        bitmap.compress(hasAlpha ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        File b2 = b(this.f651a, str);
        FileOutputStream d2 = d(b2);
        d2.write(byteArrayOutputStream.toByteArray());
        d2.close();
        return b2;
    }

    private FileOutputStream d(File file) {
        return new FileOutputStream(file);
    }

    private Bitmap e(Bitmap bitmap, int i, int i2, boolean z) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, z);
    }

    private Bitmap f(String str) {
        return BitmapFactory.decodeFile(str);
    }

    private boolean g(Integer num) {
        return num != null && num.intValue() > 0 && num.intValue() < 100;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
        if (r8 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0095, code lost:
        r11 = java.lang.Double.valueOf(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
        if (r9 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        if (r5 < r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File i(android.graphics.Bitmap r21, java.lang.Double r22, java.lang.Double r23, java.lang.Integer r24, java.lang.String r25) {
        /*
            r20 = this;
            r0 = r20
            int r1 = r21.getWidth()
            double r1 = (double) r1
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r3
            int r5 = r21.getHeight()
            double r5 = (double) r5
            java.lang.Double.isNaN(r5)
            double r5 = r5 * r3
            r3 = r24
            boolean r4 = r0.g(r3)
            if (r4 != 0) goto L26
            r3 = 100
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L26:
            r4 = 1
            r7 = 0
            if (r22 == 0) goto L2c
            r8 = 1
            goto L2d
        L2c:
            r8 = 0
        L2d:
            if (r23 == 0) goto L31
            r9 = 1
            goto L32
        L31:
            r9 = 0
        L32:
            if (r8 == 0) goto L3d
            double r10 = r22.doubleValue()
            double r10 = java.lang.Math.min(r1, r10)
            goto L3e
        L3d:
            r10 = r1
        L3e:
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
            if (r9 == 0) goto L4d
            double r11 = r23.doubleValue()
            double r11 = java.lang.Math.min(r5, r11)
            goto L4e
        L4d:
            r11 = r5
        L4e:
            java.lang.Double r11 = java.lang.Double.valueOf(r11)
            if (r8 == 0) goto L5e
            double r12 = r22.doubleValue()
            int r14 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r14 >= 0) goto L5e
            r12 = 1
            goto L5f
        L5e:
            r12 = 0
        L5f:
            if (r9 == 0) goto L6b
            double r13 = r23.doubleValue()
            int r15 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r15 >= 0) goto L6b
            r13 = 1
            goto L6c
        L6b:
            r13 = 0
        L6c:
            if (r12 != 0) goto L72
            if (r13 == 0) goto L71
            goto L72
        L71:
            r4 = 0
        L72:
            if (r4 == 0) goto Lb3
            double r12 = r11.doubleValue()
            double r12 = r12 / r5
            double r12 = r12 * r1
            double r14 = r10.doubleValue()
            double r14 = r14 / r1
            double r14 = r14 * r5
            double r16 = r10.doubleValue()
            double r18 = r11.doubleValue()
            int r4 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r4 >= 0) goto L9a
            if (r8 != 0) goto L95
        L90:
            java.lang.Double r10 = java.lang.Double.valueOf(r12)
            goto Lb3
        L95:
            java.lang.Double r11 = java.lang.Double.valueOf(r14)
            goto Lb3
        L9a:
            double r16 = r11.doubleValue()
            double r18 = r10.doubleValue()
            int r4 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r4 >= 0) goto La9
            if (r9 != 0) goto L90
            goto L95
        La9:
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 >= 0) goto Lae
            goto L90
        Lae:
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto Lb3
            goto L95
        Lb3:
            int r1 = r10.intValue()
            int r2 = r11.intValue()
            r4 = r21
            android.graphics.Bitmap r1 = r0.e(r4, r1, r2, r7)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "/scaled_"
            r2.append(r4)
            r4 = r25
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            int r3 = r3.intValue()
            java.io.File r1 = r0.c(r2, r1, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.g.i(android.graphics.Bitmap, java.lang.Double, java.lang.Double, java.lang.Integer, java.lang.String):java.io.File");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h(String str, Double d2, Double d3, Integer num) {
        Bitmap f = f(str);
        if (f == null) {
            return null;
        }
        if ((d2 == null && d3 == null && !g(num)) ? false : true) {
            try {
                String[] split = str.split("/");
                File i = i(f, d2, d3, num, split[split.length - 1]);
                a(str, i.getPath());
                return i.getPath();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return str;
    }
}
