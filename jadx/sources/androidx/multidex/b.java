package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final File f127a;

    /* renamed from: b  reason: collision with root package name */
    private final long f128b;

    /* renamed from: c  reason: collision with root package name */
    private final File f129c;

    /* renamed from: d  reason: collision with root package name */
    private final RandomAccessFile f130d;
    private final FileChannel e;
    private final FileLock f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements FileFilter {
        a(b bVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.multidex.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009b extends File {

        /* renamed from: a  reason: collision with root package name */
        public long f131a;

        public C0009b(File file, String str) {
            super(file, str);
            this.f131a = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file, File file2) {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f127a = file;
        this.f129c = file2;
        this.f128b = f(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f130d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                b(this.e);
                throw e;
            } catch (Error e2) {
                e = e2;
                b(this.e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                b(this.e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e4) {
            b(this.f130d);
            throw e4;
        }
    }

    private void a() {
        File[] listFiles = this.f129c.listFiles(new a(this));
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f129c.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (!createTempFile.setReadOnly()) {
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            }
            Log.i("MultiDex", "Renaming to " + file.getPath());
            if (createTempFile.renameTo(file)) {
                return;
            }
            throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
        } finally {
            b(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long e(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long f(File file) {
        long c2 = c.c(file);
        return c2 == -1 ? c2 - 1 : c2;
    }

    private static boolean g(Context context, File file, long j, String str) {
        SharedPreferences d2 = d(context);
        if (d2.getLong(str + "timestamp", -1L) == e(file)) {
            if (d2.getLong(str + "crc", -1L) == j) {
                return false;
            }
        }
        return true;
    }

    private List<C0009b> i(Context context, String str) {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f127a.getName() + ".classes";
        SharedPreferences d2 = d(context);
        int i = d2.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + (-1));
        int i2 = 2;
        while (i2 <= i) {
            C0009b c0009b = new C0009b(this.f129c, str2 + i2 + ".zip");
            if (!c0009b.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + c0009b.getPath() + "'");
            }
            c0009b.f131a = f(c0009b);
            long j = d2.getLong(str + "dex.crc." + i2, -1L);
            long j2 = d2.getLong(str + "dex.time." + i2, -1L);
            long lastModified = c0009b.lastModified();
            if (j2 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = d2;
                if (j == c0009b.f131a) {
                    arrayList.add(c0009b);
                    i2++;
                    d2 = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + c0009b + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + c0009b.f131a);
        }
        return arrayList;
    }

    private List<C0009b> j() {
        boolean z;
        String str = this.f127a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f127a);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i = 2;
            while (entry != null) {
                C0009b c0009b = new C0009b(this.f129c, str + i + ".zip");
                arrayList.add(c0009b);
                Log.i("MultiDex", "Extraction is needed for file " + c0009b);
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    c(zipFile, entry, c0009b, str);
                    try {
                        c0009b.f131a = f(c0009b);
                        z = true;
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to read crc from " + c0009b.getAbsolutePath(), e);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(c0009b.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0009b.length());
                    sb.append(" - crc: ");
                    sb.append(c0009b.f131a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        c0009b.delete();
                        if (c0009b.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0009b.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i2 = i3;
                }
                if (!z2) {
                    throw new IOException("Could not create zip file " + c0009b.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
                i++;
                entry = zipFile.getEntry("classes" + i + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            throw th;
        }
    }

    private static void k(Context context, String str, long j, long j2, List<C0009b> list) {
        SharedPreferences.Editor edit = d(context).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (C0009b c0009b : list) {
            edit.putLong(str + "dex.crc." + i, c0009b.f131a);
            edit.putLong(str + "dex.time." + i, c0009b.lastModified());
            i++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.release();
        this.e.close();
        this.f130d.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends File> h(Context context, String str, boolean z) {
        List<C0009b> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f127a.getPath() + ", " + z + ", " + str + ")");
        if (this.f.isValid()) {
            if (!z && !g(context, this.f127a, this.f128b, str)) {
                try {
                    list = i(context, str);
                } catch (IOException e) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            Log.i("MultiDex", z ? "Forced extraction must be performed." : "Detected that extraction must be performed.");
            List<C0009b> j = j();
            k(context, str, e(this.f127a), this.f128b, j);
            list = j;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
