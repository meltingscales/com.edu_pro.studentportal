package io.flutter.plugins.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import c.a.c.a.h;
import c.a.c.a.i;
import c.a.c.a.k;
import c.a.c.a.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public class e implements k, n {

    /* renamed from: a  reason: collision with root package name */
    final String f642a;

    /* renamed from: b  reason: collision with root package name */
    private final Activity f643b;

    /* renamed from: c  reason: collision with root package name */
    final File f644c;

    /* renamed from: d  reason: collision with root package name */
    private final io.flutter.plugins.imagepicker.g f645d;
    private final io.flutter.plugins.imagepicker.d e;
    private final g f;
    private final InterfaceC0041e g;
    private final io.flutter.plugins.imagepicker.c h;
    private io.flutter.plugins.imagepicker.a i;
    private Uri j;
    private i.d k;
    private h l;

    /* loaded from: classes.dex */
    class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f646a;

        a(Activity activity) {
            this.f646a = activity;
        }

        @Override // io.flutter.plugins.imagepicker.e.g
        public boolean a(String str) {
            return a.c.a.a.a(this.f646a, str) == 0;
        }

        @Override // io.flutter.plugins.imagepicker.e.g
        public boolean b() {
            return io.flutter.plugins.imagepicker.f.b(this.f646a);
        }

        @Override // io.flutter.plugins.imagepicker.e.g
        public void c(String str, int i) {
            androidx.core.app.a.d(this.f646a, new String[]{str}, i);
        }
    }

    /* loaded from: classes.dex */
    class b implements InterfaceC0041e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f647a;

        /* loaded from: classes.dex */
        class a implements MediaScannerConnection.OnScanCompletedListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f f648a;

            a(b bVar, f fVar) {
                this.f648a = fVar;
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                this.f648a.a(str);
            }
        }

        b(Activity activity) {
            this.f647a = activity;
        }

        @Override // io.flutter.plugins.imagepicker.e.InterfaceC0041e
        public Uri a(String str, File file) {
            return a.c.a.b.e(this.f647a, str, file);
        }

        @Override // io.flutter.plugins.imagepicker.e.InterfaceC0041e
        public void b(Uri uri, f fVar) {
            Activity activity = this.f647a;
            String[] strArr = new String[1];
            strArr[0] = uri != null ? uri.getPath() : "";
            MediaScannerConnection.scanFile(activity, strArr, null, new a(this, fVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements f {
        c() {
        }

        @Override // io.flutter.plugins.imagepicker.e.f
        public void a(String str) {
            e.this.w(str, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements f {
        d() {
        }

        @Override // io.flutter.plugins.imagepicker.e.f
        public void a(String str) {
            e.this.y(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.imagepicker.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0041e {
        Uri a(String str, File file);

        void b(Uri uri, f fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        boolean a(String str);

        boolean b();

        void c(String str, int i);
    }

    e(Activity activity, File file, io.flutter.plugins.imagepicker.g gVar, i.d dVar, h hVar, io.flutter.plugins.imagepicker.d dVar2, g gVar2, InterfaceC0041e interfaceC0041e, io.flutter.plugins.imagepicker.c cVar) {
        this.f643b = activity;
        this.f644c = file;
        this.f645d = gVar;
        this.f642a = activity.getPackageName() + ".flutter.image_provider";
        this.k = dVar;
        this.l = hVar;
        this.f = gVar2;
        this.g = interfaceC0041e;
        this.h = cVar;
        this.e = dVar2;
    }

    public e(Activity activity, File file, io.flutter.plugins.imagepicker.g gVar, io.flutter.plugins.imagepicker.d dVar) {
        this(activity, file, gVar, null, null, dVar, new a(activity), new b(activity), new io.flutter.plugins.imagepicker.c());
    }

    private void A() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        this.f643b.startActivityForResult(intent, 2342);
    }

    private void B() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("video/*");
        this.f643b.startActivityForResult(intent, 2352);
    }

    private void C() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.i == io.flutter.plugins.imagepicker.a.FRONT) {
            L(intent);
        }
        File j = j();
        this.j = Uri.parse("file:" + j.getAbsolutePath());
        Uri a2 = this.g.a(this.f642a, j);
        intent.putExtra("output", a2);
        q(intent, a2);
        try {
            try {
                this.f643b.startActivityForResult(intent, 2343);
            } catch (SecurityException e) {
                e.printStackTrace();
                m("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (ActivityNotFoundException unused) {
            j.delete();
            m("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private void D() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        h hVar = this.l;
        if (hVar != null && hVar.a("maxDuration") != null) {
            intent.putExtra("android.intent.extra.durationLimit", ((Integer) this.l.a("maxDuration")).intValue());
        }
        if (this.i == io.flutter.plugins.imagepicker.a.FRONT) {
            L(intent);
        }
        File k = k();
        this.j = Uri.parse("file:" + k.getAbsolutePath());
        Uri a2 = this.g.a(this.f642a, k);
        intent.putExtra("output", a2);
        q(intent, a2);
        try {
            try {
                this.f643b.startActivityForResult(intent, 2353);
            } catch (SecurityException e) {
                e.printStackTrace();
                m("no_available_camera", "No cameras available for taking pictures.");
            }
        } catch (ActivityNotFoundException unused) {
            k.delete();
            m("no_available_camera", "No cameras available for taking pictures.");
        }
    }

    private boolean E() {
        g gVar = this.f;
        if (gVar == null) {
            return false;
        }
        return gVar.b();
    }

    private boolean I(h hVar, i.d dVar) {
        if (this.k != null) {
            return false;
        }
        this.l = hVar;
        this.k = dVar;
        this.e.a();
        return true;
    }

    private void L(Intent intent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            return;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
        if (i >= 26) {
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
        }
    }

    private void h() {
        this.l = null;
        this.k = null;
    }

    private File i(String str) {
        String uuid = UUID.randomUUID().toString();
        try {
            this.f644c.mkdirs();
            return File.createTempFile(uuid, str, this.f644c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File j() {
        return i(".jpg");
    }

    private File k() {
        return i(".mp4");
    }

    private void l(i.d dVar) {
        dVar.a("already_active", "Image picker is already active", null);
    }

    private void m(String str, String str2) {
        i.d dVar = this.k;
        if (dVar == null) {
            this.e.f(null, str, str2);
            return;
        }
        dVar.a(str, str2, null);
        h();
    }

    private void n(ArrayList<String> arrayList) {
        i.d dVar = this.k;
        if (dVar == null) {
            this.e.f(arrayList, null, null);
            return;
        }
        dVar.b(arrayList);
        h();
    }

    private void o(String str) {
        i.d dVar = this.k;
        if (dVar != null) {
            dVar.b(str);
            h();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.e.f(arrayList, null, null);
    }

    private String p(String str) {
        return this.f645d.h(str, (Double) this.l.a("maxWidth"), (Double) this.l.a("maxHeight"), (Integer) this.l.a("imageQuality"));
    }

    private void q(Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : this.f643b.getPackageManager().queryIntentActivities(intent, 65536)) {
            this.f643b.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 3);
        }
    }

    private void r(int i) {
        if (i != -1) {
            o(null);
            return;
        }
        InterfaceC0041e interfaceC0041e = this.g;
        Uri uri = this.j;
        if (uri == null) {
            uri = Uri.parse(this.e.c());
        }
        interfaceC0041e.b(uri, new c());
    }

    private void s(int i) {
        if (i != -1) {
            o(null);
            return;
        }
        InterfaceC0041e interfaceC0041e = this.g;
        Uri uri = this.j;
        if (uri == null) {
            uri = Uri.parse(this.e.c());
        }
        interfaceC0041e.b(uri, new d());
    }

    private void t(int i, Intent intent) {
        if (i != -1 || intent == null) {
            o(null);
        } else {
            w(this.h.c(this.f643b, intent.getData()), false);
        }
    }

    private void u(int i, Intent intent) {
        if (i != -1 || intent == null) {
            o(null);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (intent.getClipData() != null) {
            for (int i2 = 0; i2 < intent.getClipData().getItemCount(); i2++) {
                arrayList.add(this.h.c(this.f643b, intent.getClipData().getItemAt(i2).getUri()));
            }
        } else {
            arrayList.add(this.h.c(this.f643b, intent.getData()));
        }
        x(arrayList, false);
    }

    private void v(int i, Intent intent) {
        if (i != -1 || intent == null) {
            o(null);
        } else {
            y(this.h.c(this.f643b, intent.getData()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        if (this.l == null) {
            o(str);
            return;
        }
        String p = p(str);
        if (p != null && !p.equals(str) && z) {
            new File(str).delete();
        }
        o(p);
    }

    private void x(ArrayList<String> arrayList, boolean z) {
        if (this.l == null) {
            n(arrayList);
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            String p = p(arrayList.get(i));
            if (p != null && !p.equals(arrayList.get(i)) && z) {
                new File(arrayList.get(i)).delete();
            }
            arrayList2.add(i, p);
        }
        n(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) {
        o(str);
    }

    private void z() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (Build.VERSION.SDK_INT >= 18) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        intent.setType("image/*");
        this.f643b.startActivityForResult(intent, 2346);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(i.d dVar) {
        Map<String, Object> b2 = this.e.b();
        ArrayList arrayList = (ArrayList) b2.get("pathList");
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(this.f645d.h((String) it.next(), (Double) b2.get("maxWidth"), (Double) b2.get("maxHeight"), Integer.valueOf(b2.get("imageQuality") == null ? 100 : ((Integer) b2.get("imageQuality")).intValue())));
            }
            b2.put("pathList", arrayList2);
            b2.put("path", arrayList2.get(arrayList2.size() - 1));
        }
        if (b2.isEmpty()) {
            b2 = null;
        }
        dVar.b(b2);
        this.e.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        h hVar = this.l;
        if (hVar == null) {
            return;
        }
        this.e.g(hVar.f206a);
        this.e.d(this.l);
        Uri uri = this.j;
        if (uri != null) {
            this.e.e(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(io.flutter.plugins.imagepicker.a aVar) {
        this.i = aVar;
    }

    public void J(h hVar, i.d dVar) {
        if (!I(hVar, dVar)) {
            l(dVar);
        } else if (!E() || this.f.a("android.permission.CAMERA")) {
            C();
        } else {
            this.f.c("android.permission.CAMERA", 2345);
        }
    }

    public void K(h hVar, i.d dVar) {
        if (!I(hVar, dVar)) {
            l(dVar);
        } else if (!E() || this.f.a("android.permission.CAMERA")) {
            D();
        } else {
            this.f.c("android.permission.CAMERA", 2355);
        }
    }

    @Override // c.a.c.a.n
    public boolean a(int i, String[] strArr, int[] iArr) {
        boolean z = iArr.length > 0 && iArr[0] == 0;
        if (i != 2345) {
            if (i != 2355) {
                return false;
            }
            if (z) {
                D();
            }
        } else if (z) {
            C();
        }
        if (!z && (i == 2345 || i == 2355)) {
            m("camera_access_denied", "The user did not allow camera access.");
        }
        return true;
    }

    @Override // c.a.c.a.k
    public boolean c(int i, int i2, Intent intent) {
        if (i == 2342) {
            t(i2, intent);
            return true;
        } else if (i == 2343) {
            r(i2);
            return true;
        } else if (i == 2346) {
            u(i2, intent);
            return true;
        } else if (i == 2352) {
            v(i2, intent);
            return true;
        } else if (i != 2353) {
            return false;
        } else {
            s(i2);
            return true;
        }
    }

    public void e(h hVar, i.d dVar) {
        if (I(hVar, dVar)) {
            A();
        } else {
            l(dVar);
        }
    }

    public void f(h hVar, i.d dVar) {
        if (I(hVar, dVar)) {
            z();
        } else {
            l(dVar);
        }
    }

    public void g(h hVar, i.d dVar) {
        if (I(hVar, dVar)) {
            B();
        } else {
            l(dVar);
        }
    }
}
