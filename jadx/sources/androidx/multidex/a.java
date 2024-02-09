package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<File> f120a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f121b = m(System.getProperty("java.vm.version"));

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.multidex.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0007a {

        /* renamed from: b  reason: collision with root package name */
        private static final int f122b = 4;

        /* renamed from: a  reason: collision with root package name */
        private final InterfaceC0008a f123a;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: androidx.multidex.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0008a {
            Object a(File file, DexFile dexFile);
        }

        /* renamed from: androidx.multidex.a$a$b */
        /* loaded from: classes.dex */
        private static class b implements InterfaceC0008a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f124a;

            b(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f124a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.a.C0007a.InterfaceC0008a
            public Object a(File file, DexFile dexFile) {
                return this.f124a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        /* renamed from: androidx.multidex.a$a$c */
        /* loaded from: classes.dex */
        private static class c implements InterfaceC0008a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f125a;

            c(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f125a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.a.C0007a.InterfaceC0008a
            public Object a(File file, DexFile dexFile) {
                return this.f125a.newInstance(file, file, dexFile);
            }
        }

        /* renamed from: androidx.multidex.a$a$d */
        /* loaded from: classes.dex */
        private static class d implements InterfaceC0008a {

            /* renamed from: a  reason: collision with root package name */
            private final Constructor<?> f126a;

            d(Class<?> cls) {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f126a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.a.C0007a.InterfaceC0008a
            public Object a(File file, DexFile dexFile) {
                return this.f126a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        private C0007a() {
            InterfaceC0008a dVar;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    dVar = new b(cls);
                } catch (NoSuchMethodException unused) {
                    dVar = new d(cls);
                }
            } catch (NoSuchMethodException unused2) {
                dVar = new c(cls);
            }
            this.f123a = dVar;
        }

        static void a(ClassLoader classLoader, List<? extends File> list) {
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            Object[] b2 = new C0007a().b(list);
            try {
                a.f(obj, "dexElements", b2);
            } catch (NoSuchFieldException e) {
                Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", e);
                a.f(obj, "pathElements", b2);
            }
        }

        private Object[] b(List<? extends File> list) {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i = 0; i < size; i++) {
                File file = list.get(i);
                objArr[i] = this.f123a.a(file, DexFile.loadDex(file.getPath(), c(file), 0));
            }
            return objArr;
        }

        private static String c(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f122b) + ".dex").getPath();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {
        static void a(ClassLoader classLoader, List<? extends File> list, File file) {
            IOException[] iOExceptionArr;
            Object obj = a.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            a.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field g = a.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) g.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                g.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            return (Object[]) a.h(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {
        static void a(ClassLoader classLoader, List<? extends File> list) {
            int size = list.size();
            Field g = a.g(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) g.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = next;
                zipFileArr[previousIndex] = new ZipFile(next);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            g.set(classLoader, sb.toString());
            a.f(classLoader, "mPaths", strArr);
            a.f(classLoader, "mFiles", fileArr);
            a.f(classLoader, "mZips", zipFileArr);
            a.f(classLoader, "mDexs", dexFileArr);
        }
    }

    private static void d(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
                return;
            }
            Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
        }
    }

    private static void e(Context context, File file, File file2, String str, String str2, boolean z) {
        Set<File> set = f120a;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            int i = Build.VERSION.SDK_INT;
            if (i > 20) {
                Log.w("MultiDex", "MultiDex is not guaranteed to work in SDK version " + i + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
            }
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (classLoader == null) {
                    Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
                    return;
                }
                d(context);
                File j = j(context, file2, str);
                androidx.multidex.b bVar = new androidx.multidex.b(file, j);
                IOException e = null;
                try {
                    l(classLoader, j, bVar.h(context, str2, false));
                } catch (IOException e2) {
                    if (!z) {
                        throw e2;
                    }
                    Log.w("MultiDex", "Failed to install extracted secondary dex files, retrying with forced extraction", e2);
                    l(classLoader, j, bVar.h(context, str2, true));
                }
                try {
                    bVar.close();
                } catch (IOException e3) {
                    e = e3;
                }
                if (e != null) {
                    throw e;
                }
            } catch (RuntimeException e4) {
                Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Object obj, String str, Object[] objArr) {
        Field g = g(obj, str);
        Object[] objArr2 = (Object[]) g.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        g.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field g(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method h(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    private static File j(Context context, File file, String str) {
        File file2 = new File(file, "code_cache");
        try {
            n(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), "code_cache");
            n(file2);
        }
        File file3 = new File(file2, str);
        n(file3);
        return file3;
    }

    public static void k(Context context) {
        String str;
        Log.i("MultiDex", "Installing application");
        if (f121b) {
            str = "VM has multidex support, MultiDex support library is disabled.";
        } else {
            int i = Build.VERSION.SDK_INT;
            if (i < 4) {
                throw new RuntimeException("MultiDex installation failed. SDK " + i + " is unsupported. Min SDK version is 4.");
            }
            try {
                ApplicationInfo i2 = i(context);
                if (i2 == null) {
                    Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                    return;
                } else {
                    e(context, new File(i2.sourceDir), new File(i2.dataDir), "secondary-dexes", "", true);
                    str = "install done";
                }
            } catch (Exception e) {
                Log.e("MultiDex", "MultiDex installation failure", e);
                throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
            }
        }
        Log.i("MultiDex", str);
    }

    private static void l(ClassLoader classLoader, File file, List<? extends File> list) {
        if (list.isEmpty()) {
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            b.a(classLoader, list, file);
        } else if (i >= 14) {
            C0007a.a(classLoader, list);
        } else {
            c.a(classLoader, list);
        }
    }

    static boolean m(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z ? " has multidex support" : " does not have multidex support");
        Log.i("MultiDex", sb.toString());
        return z;
    }

    private static void n(File file) {
        File parentFile;
        String str;
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        if (file.getParentFile() == null) {
            str = "Failed to create dir " + file.getPath() + ". Parent file is null.";
        } else {
            str = "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite();
        }
        Log.e("MultiDex", str);
        throw new IOException("Failed to create directory " + file.getPath());
    }
}
