package io.flutter.plugins.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import c.a.c.a.h;
import c.a.c.a.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class a implements i.c {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f613a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f614b = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: c  reason: collision with root package name */
    private final Handler f615c = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugins.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0038a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SharedPreferences.Editor f616a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i.d f617b;

        /* renamed from: io.flutter.plugins.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0039a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ boolean f619a;

            RunnableC0039a(boolean z) {
                this.f619a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0038a.this.f617b.b(Boolean.valueOf(this.f619a));
            }
        }

        RunnableC0038a(SharedPreferences.Editor editor, i.d dVar) {
            this.f616a = editor;
            this.f617b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f615c.post(new RunnableC0039a(this.f616a.commit()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f613a = context.getSharedPreferences("FlutterSharedPreferences", 0);
    }

    private void b(SharedPreferences.Editor editor, i.d dVar) {
        this.f614b.execute(new RunnableC0038a(editor, dVar));
    }

    private List<String> c(String str) {
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
                try {
                    List<String> list = (List) objectInputStream2.readObject();
                    objectInputStream2.close();
                    return list;
                } catch (ClassNotFoundException e) {
                    e = e;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th;
                }
            } catch (ClassNotFoundException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String d(List<String> list) {
        ObjectOutputStream objectOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(list);
                objectOutputStream2.flush();
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                objectOutputStream2.close();
                return encodeToString;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private Map<String, Object> e() {
        Object obj;
        Map<String, ?> all = this.f613a.getAll();
        HashMap hashMap = new HashMap();
        for (String str : all.keySet()) {
            if (str.startsWith("flutter.")) {
                Object obj2 = all.get(str);
                if (obj2 instanceof String) {
                    String str2 = (String) obj2;
                    if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                        obj2 = c(str2.substring(40));
                    } else if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                        obj = new BigInteger(str2.substring(44), 36);
                        obj2 = obj;
                    } else if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                        obj2 = Double.valueOf(str2.substring(40));
                    }
                    hashMap.put(str, obj2);
                } else {
                    if (obj2 instanceof Set) {
                        ArrayList arrayList = new ArrayList((Set) obj2);
                        SharedPreferences.Editor remove = this.f613a.edit().remove(str);
                        obj = arrayList;
                        if (!remove.putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + d(arrayList)).commit()) {
                            throw new IOException("Could not migrate set to list");
                        }
                        obj2 = obj;
                    }
                    hashMap.put(str, obj2);
                }
            }
        }
        return hashMap;
    }

    @Override // c.a.c.a.i.c
    public void f(h hVar, i.d dVar) {
        SharedPreferences.Editor putBoolean;
        String str = (String) hVar.a("key");
        try {
            String str2 = hVar.f206a;
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1354815177:
                    if (str2.equals("commit")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1249367445:
                    if (str2.equals("getAll")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1096934831:
                    if (str2.equals("setStringList")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -934610812:
                    if (str2.equals("remove")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -905809875:
                    if (str2.equals("setInt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 155439827:
                    if (str2.equals("setDouble")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 589412115:
                    if (str2.equals("setString")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1984457324:
                    if (str2.equals("setBool")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    putBoolean = this.f613a.edit().putBoolean(str, ((Boolean) hVar.a("value")).booleanValue());
                    break;
                case 1:
                    String d2 = Double.toString(((Number) hVar.a("value")).doubleValue());
                    SharedPreferences.Editor edit = this.f613a.edit();
                    putBoolean = edit.putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d2);
                    break;
                case 2:
                    Number number = (Number) hVar.a("value");
                    if (number instanceof BigInteger) {
                        SharedPreferences.Editor edit2 = this.f613a.edit();
                        putBoolean = edit2.putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy" + ((BigInteger) number).toString(36));
                        break;
                    } else {
                        putBoolean = this.f613a.edit().putLong(str, number.longValue());
                        break;
                    }
                case 3:
                    String str3 = (String) hVar.a("value");
                    if (!str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") && !str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") && !str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                        putBoolean = this.f613a.edit().putString(str, str3);
                        break;
                    }
                    dVar.a("StorageError", "This string cannot be stored as it clashes with special identifier prefixes.", null);
                    return;
                case 4:
                    SharedPreferences.Editor edit3 = this.f613a.edit();
                    putBoolean = edit3.putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + d((List) hVar.a("value")));
                    break;
                case 5:
                    dVar.b(Boolean.TRUE);
                    return;
                case 6:
                    dVar.b(e());
                    return;
                case 7:
                    putBoolean = this.f613a.edit().remove(str);
                    break;
                case '\b':
                    Set<String> keySet = e().keySet();
                    SharedPreferences.Editor edit4 = this.f613a.edit();
                    for (String str4 : keySet) {
                        edit4.remove(str4);
                    }
                    b(edit4, dVar);
                    return;
                default:
                    dVar.c();
                    return;
            }
            b(putBoolean, dVar);
        } catch (IOException e) {
            dVar.a("IOException encountered", hVar.f206a, e);
        }
    }

    public void g() {
        this.f615c.removeCallbacksAndMessages(null);
        this.f614b.shutdown();
    }
}
