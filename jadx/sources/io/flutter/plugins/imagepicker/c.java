package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
class c {
    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static String b(Context context, Uri uri) {
        String str;
        try {
            uri.getPath();
            str = uri.getScheme().equals("content") ? MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri)) : MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
        } catch (Exception unused) {
            str = null;
        }
        str = (str == null || str.isEmpty()) ? "jpg" : "jpg";
        return "." + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0034 -> B:50:0x005d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(android.content.Context r5, android.net.Uri r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = b(r5, r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L4e
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L4e
            java.io.InputStream r6 = r3.openInputStream(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L4e
            java.lang.String r3 = "image_picker"
            java.io.File r5 = r5.getCacheDir()     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            java.io.File r5 = java.io.File.createTempFile(r3, r2, r5)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3c
            r5.deleteOnExit()     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L38
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L38
            r2.<init>(r5)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L38
            if (r6 == 0) goto L29
            a(r6, r2)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L51
            r3 = 1
            goto L2a
        L27:
            r5 = move-exception
            goto L3a
        L29:
            r3 = 0
        L2a:
            if (r6 == 0) goto L2f
            r6.close()     // Catch: java.io.IOException -> L2f
        L2f:
            r2.close()     // Catch: java.io.IOException -> L34
            r0 = r3
            goto L5d
        L34:
            goto L5d
        L36:
            r2 = r1
            goto L51
        L38:
            r5 = move-exception
            r2 = r1
        L3a:
            r1 = r6
            goto L41
        L3c:
            r5 = r1
            r2 = r5
            goto L51
        L3f:
            r5 = move-exception
            r2 = r1
        L41:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.io.IOException -> L47
            goto L48
        L47:
        L48:
            if (r2 == 0) goto L4d
            r2.close()     // Catch: java.io.IOException -> L4d
        L4d:
            throw r5
        L4e:
            r5 = r1
            r6 = r5
            r2 = r6
        L51:
            if (r6 == 0) goto L58
            r6.close()     // Catch: java.io.IOException -> L57
            goto L58
        L57:
        L58:
            if (r2 == 0) goto L5d
            r2.close()     // Catch: java.io.IOException -> L34
        L5d:
            if (r0 == 0) goto L63
            java.lang.String r1 = r5.getPath()
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.imagepicker.c.c(android.content.Context, android.net.Uri):java.lang.String");
    }
}
