package a.d.a;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class a {
    private static final byte[] A;
    private static final byte[] B;
    private static final byte[] C;
    private static final byte[] D;
    private static final byte[] E;
    private static final byte[] F;
    private static final byte[] G;
    private static final byte[] H;
    private static final byte[] I;
    private static final byte[] J;
    private static final byte[] K;
    private static final byte[] L;
    private static final byte[] M;
    private static final byte[] N;
    private static final byte[] O;
    private static SimpleDateFormat P;
    static final String[] Q;
    static final int[] R;
    static final byte[] S;
    private static final e[] T;
    private static final e[] U;
    private static final e[] V;
    private static final e[] W;
    private static final e[] X;
    private static final e Y;
    private static final e[] Z;
    private static final e[] a0;
    private static final e[] b0;
    private static final e[] c0;
    static final e[][] d0;
    private static final e[] e0;
    private static final e f0;
    private static final e g0;
    private static final HashMap<Integer, e>[] h0;
    private static final HashMap<String, e>[] i0;
    private static final HashSet<String> j0;
    private static final HashMap<Integer, Integer> k0;
    static final Charset l0;
    static final byte[] m0;
    private static final byte[] n0;
    private static final Pattern o0;
    private static final boolean t = Log.isLoggable("ExifInterface", 3);
    public static final int[] u;
    public static final int[] v;
    static final byte[] w;
    private static final byte[] x;
    private static final byte[] y;
    private static final byte[] z;

    /* renamed from: a  reason: collision with root package name */
    private String f40a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f41b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f42c;

    /* renamed from: d  reason: collision with root package name */
    private int f43d;
    private boolean e;
    private final HashMap<String, d>[] f;
    private Set<Integer> g;
    private ByteOrder h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private byte[] m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0004a extends MediaDataSource {

        /* renamed from: a  reason: collision with root package name */
        long f44a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f45b;

        C0004a(a aVar, b bVar) {
            this.f45b = bVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.f44a;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + this.f45b.available()) {
                        return -1;
                    }
                    this.f45b.d(j);
                    this.f44a = j;
                }
                if (i2 > this.f45b.available()) {
                    i2 = this.f45b.available();
                }
                int read = this.f45b.read(bArr, i, i2);
                if (read >= 0) {
                    this.f44a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f44a = -1L;
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends InputStream implements DataInput {
        private static final ByteOrder e = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        private DataInputStream f46a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f47b;

        /* renamed from: c  reason: collision with root package name */
        final int f48c;

        /* renamed from: d  reason: collision with root package name */
        int f49d;

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) {
            this.f47b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f46a = dataInputStream;
            int available = dataInputStream.available();
            this.f48c = available;
            this.f49d = 0;
            this.f46a.mark(available);
            this.f47b = byteOrder;
        }

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public int a() {
            return this.f48c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f46a.available();
        }

        public int b() {
            return this.f49d;
        }

        public long c() {
            return readInt() & 4294967295L;
        }

        public void d(long j) {
            int i = this.f49d;
            if (i > j) {
                this.f49d = 0;
                this.f46a.reset();
                this.f46a.mark(this.f48c);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void e(ByteOrder byteOrder) {
            this.f47b = byteOrder;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.f46a.mark(i);
        }

        @Override // java.io.InputStream
        public int read() {
            this.f49d++;
            return this.f46a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = this.f46a.read(bArr, i, i2);
            this.f49d += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f49d++;
            return this.f46a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            int i = this.f49d + 1;
            this.f49d = i;
            if (i <= this.f48c) {
                int read = this.f46a.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f49d += 2;
            return this.f46a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            int length = this.f49d + bArr.length;
            this.f49d = length;
            if (length > this.f48c) {
                throw new EOFException();
            }
            if (this.f46a.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            int i3 = this.f49d + i2;
            this.f49d = i3;
            if (i3 > this.f48c) {
                throw new EOFException();
            }
            if (this.f46a.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() {
            int i = this.f49d + 4;
            this.f49d = i;
            if (i <= this.f48c) {
                int read = this.f46a.read();
                int read2 = this.f46a.read();
                int read3 = this.f46a.read();
                int read4 = this.f46a.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f47b;
                    if (byteOrder == e) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f47b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            int i = this.f49d + 8;
            this.f49d = i;
            if (i <= this.f48c) {
                int read = this.f46a.read();
                int read2 = this.f46a.read();
                int read3 = this.f46a.read();
                int read4 = this.f46a.read();
                int read5 = this.f46a.read();
                int read6 = this.f46a.read();
                int read7 = this.f46a.read();
                int read8 = this.f46a.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f47b;
                    if (byteOrder == e) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    throw new IOException("Invalid byte order: " + this.f47b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            int i = this.f49d + 2;
            this.f49d = i;
            if (i <= this.f48c) {
                int read = this.f46a.read();
                int read2 = this.f46a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f47b;
                    if (byteOrder == e) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f47b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f49d += 2;
            return this.f46a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f49d++;
            return this.f46a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            int i = this.f49d + 2;
            this.f49d = i;
            if (i <= this.f48c) {
                int read = this.f46a.read();
                int read2 = this.f46a.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f47b;
                    if (byteOrder == e) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f47b);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int min = Math.min(i, this.f48c - this.f49d);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f46a.skipBytes(min - i2);
            }
            this.f49d += i2;
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        final OutputStream f50a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f51b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f50a = outputStream;
            this.f51b = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f51b = byteOrder;
        }

        public void b(int i) {
            this.f50a.write(i);
        }

        public void c(int i) {
            OutputStream outputStream;
            int i2;
            ByteOrder byteOrder = this.f51b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f50a.write((i >>> 0) & 255);
                this.f50a.write((i >>> 8) & 255);
                this.f50a.write((i >>> 16) & 255);
                outputStream = this.f50a;
                i2 = i >>> 24;
            } else if (byteOrder != ByteOrder.BIG_ENDIAN) {
                return;
            } else {
                this.f50a.write((i >>> 24) & 255);
                this.f50a.write((i >>> 16) & 255);
                this.f50a.write((i >>> 8) & 255);
                outputStream = this.f50a;
                i2 = i >>> 0;
            }
            outputStream.write(i2 & 255);
        }

        public void d(short s) {
            OutputStream outputStream;
            int i;
            ByteOrder byteOrder = this.f51b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f50a.write((s >>> 0) & 255);
                outputStream = this.f50a;
                i = s >>> 8;
            } else if (byteOrder != ByteOrder.BIG_ENDIAN) {
                return;
            } else {
                this.f50a.write((s >>> 8) & 255);
                outputStream = this.f50a;
                i = s >>> 0;
            }
            outputStream.write(i & 255);
        }

        public void e(long j) {
            c((int) j);
        }

        public void f(int i) {
            d((short) i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) {
            this.f50a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f50a.write(bArr, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f52a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53b;

        /* renamed from: c  reason: collision with root package name */
        public final long f54c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f55d;

        d(int i, int i2, long j, byte[] bArr) {
            this.f52a = i;
            this.f53b = i2;
            this.f54c = j;
            this.f55d = bArr;
        }

        d(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(a.l0);
                return new d(1, bytes.length, bytes);
            }
            return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.R[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d2 : dArr) {
                wrap.putDouble(d2);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.R[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putInt(i);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.R[10] * fVarArr.length]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f60a);
                wrap.putInt((int) fVar.f61b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.l0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j, ByteOrder byteOrder) {
            return g(new long[]{j}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.R[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.R[5] * fVarArr.length]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f60a);
                wrap.putInt((int) fVar.f61b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i, ByteOrder byteOrder) {
            return k(new int[]{i}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.R[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o = o(byteOrder);
            if (o != null) {
                if (o instanceof String) {
                    return Double.parseDouble((String) o);
                }
                if (o instanceof long[]) {
                    long[] jArr = (long[]) o;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o instanceof int[]) {
                    int[] iArr = (int[]) o;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o instanceof double[]) {
                    double[] dArr = (double[]) o;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o instanceof f[]) {
                    f[] fVarArr = (f[]) o;
                    if (fVarArr.length == 1) {
                        return fVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int m(ByteOrder byteOrder) {
            Object o = o(byteOrder);
            if (o != null) {
                if (o instanceof String) {
                    return Integer.parseInt((String) o);
                }
                if (o instanceof long[]) {
                    long[] jArr = (long[]) o;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o instanceof int[]) {
                    int[] iArr = (int[]) o;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String n(ByteOrder byteOrder) {
            Object o = o(byteOrder);
            if (o == null) {
                return null;
            }
            if (o instanceof String) {
                return (String) o;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (o instanceof long[]) {
                long[] jArr = (long[]) o;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o instanceof int[]) {
                int[] iArr = (int[]) o;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o instanceof double[]) {
                double[] dArr = (double[]) o;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (o instanceof f[]) {
                f[] fVarArr = (f[]) o;
                while (i < fVarArr.length) {
                    sb.append(fVarArr[i].f60a);
                    sb.append('/');
                    sb.append(fVarArr[i].f61b);
                    i++;
                    if (i != fVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a0: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:152:0x01a0 */
        /* JADX WARN: Removed duplicated region for block: B:172:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object o(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return a.R[this.f52a] * this.f53b;
        }

        public String toString() {
            return "(" + a.Q[this.f52a] + ", data length:" + this.f55d.length + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f56a;

        /* renamed from: b  reason: collision with root package name */
        public final String f57b;

        /* renamed from: c  reason: collision with root package name */
        public final int f58c;

        /* renamed from: d  reason: collision with root package name */
        public final int f59d;

        e(String str, int i, int i2) {
            this.f57b = str;
            this.f56a = i;
            this.f58c = i2;
            this.f59d = -1;
        }

        e(String str, int i, int i2, int i3) {
            this.f57b = str;
            this.f56a = i;
            this.f58c = i2;
            this.f59d = i3;
        }

        boolean a(int i) {
            int i2;
            int i3 = this.f58c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.f59d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final long f60a;

        /* renamed from: b  reason: collision with root package name */
        public final long f61b;

        f(double d2) {
            this((long) (d2 * 10000.0d), 10000L);
        }

        f(long j, long j2) {
            if (j2 == 0) {
                this.f60a = 0L;
                this.f61b = 1L;
                return;
            }
            this.f60a = j;
            this.f61b = j2;
        }

        public double a() {
            double d2 = this.f60a;
            double d3 = this.f61b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.f60a + "/" + this.f61b;
        }
    }

    static {
        e[] eVarArr;
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        u = new int[]{8, 8, 8};
        v = new int[]{8};
        w = new byte[]{-1, -40, -1};
        x = new byte[]{102, 116, 121, 112};
        y = new byte[]{109, 105, 102, 49};
        z = new byte[]{104, 101, 105, 99};
        A = new byte[]{79, 76, 89, 77, 80, 0};
        B = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        C = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        D = new byte[]{101, 88, 73, 102};
        E = new byte[]{73, 72, 68, 82};
        F = new byte[]{73, 69, 78, 68};
        G = new byte[]{82, 73, 70, 70};
        H = new byte[]{87, 69, 66, 80};
        I = new byte[]{69, 88, 73, 70};
        J = new byte[]{-99, 1, 42};
        K = "VP8X".getBytes(Charset.defaultCharset());
        L = "VP8L".getBytes(Charset.defaultCharset());
        M = "VP8 ".getBytes(Charset.defaultCharset());
        N = "ANIM".getBytes(Charset.defaultCharset());
        O = "ANMF".getBytes(Charset.defaultCharset());
        Q = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        R = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        S = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        e[] eVarArr2 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        T = eVarArr2;
        e[] eVarArr3 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        U = eVarArr3;
        e[] eVarArr4 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        V = eVarArr4;
        e[] eVarArr5 = {new e("InteroperabilityIndex", 1, 2)};
        W = eVarArr5;
        e[] eVarArr6 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        X = eVarArr6;
        Y = new e("StripOffsets", 273, 3);
        e[] eVarArr7 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        Z = eVarArr7;
        e[] eVarArr8 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        a0 = eVarArr8;
        e[] eVarArr9 = {new e("AspectFrame", 4371, 3)};
        b0 = eVarArr9;
        e[] eVarArr10 = {new e("ColorSpace", 55, 3)};
        c0 = eVarArr10;
        e[][] eVarArr11 = {eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr6, eVarArr2, eVarArr7, eVarArr8, eVarArr9, eVarArr10};
        d0 = eVarArr11;
        e0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        f0 = new e("JPEGInterchangeFormat", 513, 4);
        g0 = new e("JPEGInterchangeFormatLength", 514, 4);
        h0 = new HashMap[eVarArr11.length];
        i0 = new HashMap[eVarArr11.length];
        j0 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        k0 = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        l0 = forName;
        m0 = "Exif\u0000\u0000".getBytes(forName);
        n0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        P = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            e[][] eVarArr12 = d0;
            if (i >= eVarArr12.length) {
                HashMap<Integer, Integer> hashMap = k0;
                e[] eVarArr13 = e0;
                hashMap.put(Integer.valueOf(eVarArr13[0].f56a), 5);
                hashMap.put(Integer.valueOf(eVarArr13[1].f56a), 1);
                hashMap.put(Integer.valueOf(eVarArr13[2].f56a), 2);
                hashMap.put(Integer.valueOf(eVarArr13[3].f56a), 3);
                hashMap.put(Integer.valueOf(eVarArr13[4].f56a), 7);
                hashMap.put(Integer.valueOf(eVarArr13[5].f56a), 8);
                Pattern.compile(".*[1-9].*");
                o0 = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            h0[i] = new HashMap<>();
            i0[i] = new HashMap<>();
            for (e eVar : eVarArr12[i]) {
                h0[i].put(Integer.valueOf(eVar.f56a), eVar);
                i0[i].put(eVar.f57b, eVar);
            }
            i++;
        }
    }

    public a(String str) {
        e[][] eVarArr = d0;
        this.f = new HashMap[eVarArr.length];
        this.g = new HashSet(eVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        A(str);
    }

    private void A(String str) {
        FileInputStream fileInputStream;
        Objects.requireNonNull(str, "filename cannot be null");
        FileInputStream fileInputStream2 = null;
        this.f42c = null;
        this.f40a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (H(fileInputStream.getFD())) {
                this.f41b = fileInputStream.getFD();
            } else {
                this.f41b = null;
            }
            M(fileInputStream);
            d(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d(fileInputStream2);
            throw th;
        }
    }

    private boolean B(byte[] bArr) {
        b bVar;
        long readInt;
        byte[] bArr2;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
                try {
                    readInt = bVar.readInt();
                    bArr2 = new byte[4];
                    bVar.read(bArr2);
                } catch (Exception e2) {
                    e = e2;
                    bVar2 = bVar;
                    if (t) {
                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                    }
                    if (bVar2 != null) {
                        bVar2.close();
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        if (!Arrays.equals(bArr2, x)) {
            bVar.close();
            return false;
        }
        long j = 16;
        if (readInt == 1) {
            readInt = bVar.readLong();
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j2 = readInt - j;
        if (j2 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z2 = false;
        boolean z3 = false;
        for (long j3 = 0; j3 < j2 / 4; j3++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j3 != 1) {
                if (Arrays.equals(bArr3, y)) {
                    z2 = true;
                } else if (Arrays.equals(bArr3, z)) {
                    z3 = true;
                }
                if (z2 && z3) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    private static boolean C(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = w;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean D(byte[] bArr) {
        b bVar;
        boolean z2 = false;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteOrder P2 = P(bVar);
            this.h = P2;
            bVar.e(P2);
            short readShort = bVar.readShort();
            z2 = (readShort == 20306 || readShort == 21330) ? true : true;
            bVar.close();
            return z2;
        } catch (Exception unused2) {
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
    }

    private boolean E(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = C;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean F(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean G(byte[] bArr) {
        b bVar;
        b bVar2 = null;
        try {
            bVar = new b(bArr);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            ByteOrder P2 = P(bVar);
            this.h = P2;
            bVar.e(P2);
            boolean z2 = bVar.readShort() == 85;
            bVar.close();
            return z2;
        } catch (Exception unused2) {
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th;
        }
    }

    private static boolean H(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                if (t) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
            }
        }
        return false;
    }

    private boolean I(HashMap hashMap) {
        d dVar;
        int m;
        d dVar2 = (d) hashMap.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.h);
            int[] iArr2 = u;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f43d == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((m = dVar.m(this.h)) == 1 && Arrays.equals(iArr, v)) || (m == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (t) {
            Log.d("ExifInterface", "Unsupported data type value");
            return false;
        }
        return false;
    }

    private boolean J() {
        int i = this.f43d;
        return i == 4 || i == 13 || i == 14;
    }

    private boolean K(HashMap hashMap) {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.h) <= 512 && dVar2.m(this.h) <= 512;
    }

    private boolean L(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = H;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[G.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else if (bArr[i] != bArr2[i]) {
                return false;
            } else {
                i++;
            }
        }
    }

    private void M(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        for (int i = 0; i < d0.length; i++) {
            try {
                try {
                    this.f[i] = new HashMap<>();
                } catch (IOException e2) {
                    boolean z2 = t;
                    if (z2) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                    }
                    a();
                    if (!z2) {
                        return;
                    }
                }
            } finally {
                a();
                if (t) {
                    O();
                }
            }
        }
        if (!this.e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f43d = n(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        b bVar = new b(inputStream);
        if (this.e) {
            t(bVar);
        } else {
            switch (this.f43d) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    r(bVar);
                    break;
                case 4:
                    m(bVar, 0, 0);
                    a();
                    if (t) {
                        O();
                        return;
                    }
                    return;
                case 7:
                    o(bVar);
                    break;
                case 9:
                    q(bVar);
                    a();
                    if (t) {
                        O();
                        return;
                    }
                    return;
                case 10:
                    s(bVar);
                    a();
                    if (t) {
                        O();
                        return;
                    }
                    return;
                case 12:
                    l(bVar);
                    break;
                case 13:
                    p(bVar);
                    a();
                    if (t) {
                        O();
                        return;
                    }
                    return;
                case 14:
                    w(bVar);
                    a();
                    if (t) {
                        O();
                        return;
                    }
                    return;
            }
        }
        bVar.d(this.o);
        Z(bVar);
    }

    private void N(b bVar, int i) {
        ByteOrder P2 = P(bVar);
        this.h = P2;
        bVar.e(P2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i2 = this.f43d;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = bVar.readInt();
        if (readInt < 8 || readInt >= i) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i3 = readInt - 8;
        if (i3 <= 0 || bVar.skipBytes(i3) == i3) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i3);
    }

    private void O() {
        for (int i = 0; i < this.f.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.f[i].size());
            for (Map.Entry<String, d> entry : this.f[i].entrySet()) {
                d value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.n(this.h) + "'");
            }
        }
    }

    private ByteOrder P(b bVar) {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (t) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (t) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void Q(byte[] bArr, int i) {
        b bVar = new b(bArr);
        N(bVar, bArr.length);
        R(bVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void R(a.d.a.a.b r30, int r31) {
        /*
            Method dump skipped, instructions count: 995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.R(a.d.a.a$b, int):void");
    }

    private void S(String str) {
        for (int i = 0; i < d0.length; i++) {
            this.f[i].remove(str);
        }
    }

    private void T(b bVar, int i) {
        d dVar = this.f[i].get("ImageLength");
        d dVar2 = this.f[i].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f[i].get("JPEGInterchangeFormat");
            d dVar4 = this.f[i].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int m = dVar3.m(this.h);
            int m2 = dVar3.m(this.h);
            bVar.d(m);
            byte[] bArr = new byte[m2];
            bVar.read(bArr);
            m(new b(bArr), m, i);
        }
    }

    private void V(InputStream inputStream, OutputStream outputStream) {
        if (t) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.b(-1);
        if (dataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.b(-40);
        d dVar = null;
        if (j("Xmp") != null && this.s) {
            dVar = this.f[0].remove("Xmp");
        }
        cVar.b(-1);
        cVar.b(-31);
        e0(cVar);
        if (dVar != null) {
            this.f[0].put("Xmp", dVar);
        }
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte readByte = dataInputStream.readByte();
            if (readByte == -39 || readByte == -38) {
                cVar.b(-1);
                cVar.b(readByte);
                f(dataInputStream, cVar);
                return;
            } else if (readByte != -31) {
                cVar.b(-1);
                cVar.b(readByte);
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                cVar.f(readUnsignedShort);
                int i = readUnsignedShort - 2;
                if (i < 0) {
                    throw new IOException("Invalid length");
                }
                while (i > 0) {
                    int read = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                    if (read >= 0) {
                        cVar.write(bArr, 0, read);
                        i -= read;
                    }
                }
            } else {
                int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                if (readUnsignedShort2 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (readUnsignedShort2 >= 6) {
                    if (dataInputStream.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, m0)) {
                        int i2 = readUnsignedShort2 - 6;
                        if (dataInputStream.skipBytes(i2) != i2) {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                cVar.b(-1);
                cVar.b(readByte);
                cVar.f(readUnsignedShort2 + 2);
                if (readUnsignedShort2 >= 6) {
                    readUnsignedShort2 -= 6;
                    cVar.write(bArr2);
                }
                while (readUnsignedShort2 > 0) {
                    int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                    if (read2 >= 0) {
                        cVar.write(bArr, 0, read2);
                        readUnsignedShort2 -= read2;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    private void W(InputStream inputStream, OutputStream outputStream) {
        if (t) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = C;
        g(dataInputStream, cVar, bArr.length);
        int i = this.o;
        if (i == 0) {
            int readInt = dataInputStream.readInt();
            cVar.c(readInt);
            g(dataInputStream, cVar, readInt + 4 + 4);
        } else {
            g(dataInputStream, cVar, ((i - bArr.length) - 4) - 4);
            dataInputStream.skipBytes(dataInputStream.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                e0(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f50a).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.c((int) crc32.getValue());
                d(byteArrayOutputStream2);
                f(dataInputStream, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                d(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x01a3 A[Catch: all -> 0x01e2, Exception -> 0x01e5, TryCatch #4 {Exception -> 0x01e5, all -> 0x01e2, blocks: (B:7:0x004d, B:9:0x0056, B:10:0x006a, B:65:0x01c2, B:11:0x006f, B:13:0x0077, B:15:0x0083, B:17:0x008b, B:19:0x008f, B:23:0x00a2, B:25:0x00ad, B:26:0x00b2, B:29:0x00c0, B:30:0x00c4, B:31:0x00cc, B:33:0x00d4, B:35:0x00dc, B:37:0x00e4, B:39:0x00e8, B:41:0x00f3, B:43:0x00fe, B:45:0x0106, B:57:0x0151, B:59:0x01a3, B:60:0x01ab, B:64:0x01bd, B:61:0x01af, B:63:0x01b7, B:46:0x0115, B:47:0x011c, B:48:0x011d, B:50:0x0125, B:52:0x012b, B:53:0x0144, B:54:0x014b, B:68:0x01da, B:69:0x01e1), top: B:85:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01af A[Catch: all -> 0x01e2, Exception -> 0x01e5, TryCatch #4 {Exception -> 0x01e5, all -> 0x01e2, blocks: (B:7:0x004d, B:9:0x0056, B:10:0x006a, B:65:0x01c2, B:11:0x006f, B:13:0x0077, B:15:0x0083, B:17:0x008b, B:19:0x008f, B:23:0x00a2, B:25:0x00ad, B:26:0x00b2, B:29:0x00c0, B:30:0x00c4, B:31:0x00cc, B:33:0x00d4, B:35:0x00dc, B:37:0x00e4, B:39:0x00e8, B:41:0x00f3, B:43:0x00fe, B:45:0x0106, B:57:0x0151, B:59:0x01a3, B:60:0x01ab, B:64:0x01bd, B:61:0x01af, B:63:0x01b7, B:46:0x0115, B:47:0x011c, B:48:0x011d, B:50:0x0125, B:52:0x012b, B:53:0x0144, B:54:0x014b, B:68:0x01da, B:69:0x01e1), top: B:85:0x004d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void X(java.io.InputStream r21, java.io.OutputStream r22) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.X(java.io.InputStream, java.io.OutputStream):void");
    }

    private void Z(b bVar) {
        HashMap<String, d> hashMap = this.f[4];
        d dVar = hashMap.get("Compression");
        if (dVar != null) {
            int m = dVar.m(this.h);
            this.n = m;
            if (m != 1) {
                if (m != 6) {
                    if (m != 7) {
                        return;
                    }
                }
            }
            if (I(hashMap)) {
                z(bVar, hashMap);
                return;
            }
            return;
        }
        this.n = 6;
        y(bVar, hashMap);
    }

    private void a() {
        String j = j("DateTimeOriginal");
        if (j != null && j("DateTime") == null) {
            this.f[0].put("DateTime", d.e(j));
        }
        if (j("ImageWidth") == null) {
            this.f[0].put("ImageWidth", d.f(0L, this.h));
        }
        if (j("ImageLength") == null) {
            this.f[0].put("ImageLength", d.f(0L, this.h));
        }
        if (j("Orientation") == null) {
            this.f[0].put("Orientation", d.f(0L, this.h));
        }
        if (j("LightSource") == null) {
            this.f[1].put("LightSource", d.f(0L, this.h));
        }
    }

    private static boolean a0(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }

    private void b0(int i, int i2) {
        String str;
        if (this.f[i].isEmpty() || this.f[i2].isEmpty()) {
            if (t) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = this.f[i].get("ImageLength");
        d dVar2 = this.f[i].get("ImageWidth");
        d dVar3 = this.f[i2].get("ImageLength");
        d dVar4 = this.f[i2].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (!t) {
                return;
            }
            str = "First image does not contain valid size information";
        } else if (dVar3 != null && dVar4 != null) {
            int m = dVar.m(this.h);
            int m2 = dVar2.m(this.h);
            int m3 = dVar3.m(this.h);
            int m4 = dVar4.m(this.h);
            if (m >= m3 || m2 >= m4) {
                return;
            }
            HashMap<String, d>[] hashMapArr = this.f;
            HashMap<String, d> hashMap = hashMapArr[i];
            hashMapArr[i] = hashMapArr[i2];
            hashMapArr[i2] = hashMap;
            return;
        } else if (!t) {
            return;
        } else {
            str = "Second image does not contain valid size information";
        }
        Log.d("ExifInterface", str);
    }

    private static void c(FileDescriptor fileDescriptor) {
        String str;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.close(fileDescriptor);
                return;
            } catch (Exception unused) {
                str = "Error closing fd.";
            }
        } else {
            str = "closeFileDescriptor is called in API < 21, which must be wrong.";
        }
        Log.e("ExifInterface", str);
    }

    private void c0(b bVar, int i) {
        StringBuilder sb;
        String arrays;
        d j;
        d j2;
        d dVar = this.f[i].get("DefaultCropSize");
        d dVar2 = this.f[i].get("SensorTopBorder");
        d dVar3 = this.f[i].get("SensorLeftBorder");
        d dVar4 = this.f[i].get("SensorBottomBorder");
        d dVar5 = this.f[i].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                T(bVar, i);
                return;
            }
            int m = dVar2.m(this.h);
            int m2 = dVar4.m(this.h);
            int m3 = dVar5.m(this.h);
            int m4 = dVar3.m(this.h);
            if (m2 <= m || m3 <= m4) {
                return;
            }
            d j3 = d.j(m2 - m, this.h);
            d j4 = d.j(m3 - m4, this.h);
            this.f[i].put("ImageLength", j3);
            this.f[i].put("ImageWidth", j4);
        } else if (dVar.f52a == 5) {
            f[] fVarArr = (f[]) dVar.o(this.h);
            if (fVarArr != null && fVarArr.length == 2) {
                j = d.h(fVarArr[0], this.h);
                j2 = d.h(fVarArr[1], this.h);
                this.f[i].put("ImageWidth", j);
                this.f[i].put("ImageLength", j2);
                return;
            }
            sb = new StringBuilder();
            sb.append("Invalid crop size values. cropSize=");
            arrays = Arrays.toString(fVarArr);
            sb.append(arrays);
            Log.w("ExifInterface", sb.toString());
        } else {
            int[] iArr = (int[]) dVar.o(this.h);
            if (iArr != null && iArr.length == 2) {
                j = d.j(iArr[0], this.h);
                j2 = d.j(iArr[1], this.h);
                this.f[i].put("ImageWidth", j);
                this.f[i].put("ImageLength", j2);
                return;
            }
            sb = new StringBuilder();
            sb.append("Invalid crop size values. cropSize=");
            arrays = Arrays.toString(iArr);
            sb.append(arrays);
            Log.w("ExifInterface", sb.toString());
        }
    }

    private static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private void d0() {
        b0(0, 5);
        b0(0, 4);
        b0(5, 4);
        d dVar = this.f[1].get("PixelXDimension");
        d dVar2 = this.f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f[0].put("ImageWidth", dVar);
            this.f[0].put("ImageLength", dVar2);
        }
        if (this.f[4].isEmpty() && K(this.f[5])) {
            HashMap<String, d>[] hashMapArr = this.f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (K(this.f[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private static long[] e(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    private int e0(c cVar) {
        e[][] eVarArr = d0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : e0) {
            S(eVar.f57b);
        }
        S(f0.f57b);
        S(g0.f57b);
        for (int i = 0; i < d0.length; i++) {
            for (Object obj : this.f[i].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f[i].remove(entry.getKey());
                }
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(e0[1].f57b, d.f(0L, this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(e0[2].f57b, d.f(0L, this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(e0[3].f57b, d.f(0L, this.h));
        }
        if (this.i) {
            this.f[4].put(f0.f57b, d.f(0L, this.h));
            this.f[4].put(g0.f57b, d.f(this.l, this.h));
        }
        for (int i2 = 0; i2 < d0.length; i2++) {
            int i3 = 0;
            for (Map.Entry<String, d> entry2 : this.f[i2].entrySet()) {
                int p = entry2.getValue().p();
                if (p > 4) {
                    i3 += p;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int i4 = 8;
        for (int i5 = 0; i5 < d0.length; i5++) {
            if (!this.f[i5].isEmpty()) {
                iArr[i5] = i4;
                i4 += (this.f[i5].size() * 12) + 2 + 4 + iArr2[i5];
            }
        }
        if (this.i) {
            this.f[4].put(f0.f57b, d.f(i4, this.h));
            this.k = i4;
            i4 += this.l;
        }
        if (this.f43d == 4) {
            i4 += 8;
        }
        if (t) {
            for (int i6 = 0; i6 < d0.length; i6++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i6), Integer.valueOf(iArr[i6]), Integer.valueOf(this.f[i6].size()), Integer.valueOf(iArr2[i6]), Integer.valueOf(i4)));
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(e0[1].f57b, d.f(iArr[1], this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(e0[2].f57b, d.f(iArr[2], this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(e0[3].f57b, d.f(iArr[3], this.h));
        }
        int i7 = this.f43d;
        if (i7 == 4) {
            cVar.f(i4);
            cVar.write(m0);
        } else if (i7 == 13) {
            cVar.c(i4);
            cVar.write(D);
        } else if (i7 == 14) {
            cVar.write(I);
            cVar.c(i4);
        }
        cVar.d(this.h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.a(this.h);
        cVar.f(42);
        cVar.e(8L);
        for (int i8 = 0; i8 < d0.length; i8++) {
            if (!this.f[i8].isEmpty()) {
                cVar.f(this.f[i8].size());
                int size = iArr[i8] + 2 + (this.f[i8].size() * 12) + 4;
                for (Map.Entry<String, d> entry3 : this.f[i8].entrySet()) {
                    int i9 = i0[i8].get(entry3.getKey()).f56a;
                    d value = entry3.getValue();
                    int p2 = value.p();
                    cVar.f(i9);
                    cVar.f(value.f52a);
                    cVar.c(value.f53b);
                    if (p2 > 4) {
                        cVar.e(size);
                        size += p2;
                    } else {
                        cVar.write(value.f55d);
                        if (p2 < 4) {
                            while (p2 < 4) {
                                cVar.b(0);
                                p2++;
                            }
                        }
                    }
                }
                if (i8 != 0 || this.f[4].isEmpty()) {
                    cVar.e(0L);
                } else {
                    cVar.e(iArr[4]);
                }
                for (Map.Entry<String, d> entry4 : this.f[i8].entrySet()) {
                    byte[] bArr = entry4.getValue().f55d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.i) {
            cVar.write(v());
        }
        if (this.f43d == 14 && i4 % 2 == 1) {
            cVar.b(0);
        }
        cVar.a(ByteOrder.BIG_ENDIAN);
        return i4;
    }

    private static int f(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private static void g(InputStream inputStream, OutputStream outputStream, int i) {
        byte[] bArr = new byte[8192];
        while (i > 0) {
            int min = Math.min(i, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read != min) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i -= read;
            outputStream.write(bArr, 0, read);
        }
    }

    private void h(b bVar, c cVar, byte[] bArr, byte[] bArr2) {
        Charset charset;
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                sb.append(new String(bArr, l0));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            i(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void i(b bVar, c cVar, byte[] bArr) {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.c(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        g(bVar, cVar, readInt);
    }

    private d k(String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(str)) {
            if (t) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < d0.length; i++) {
            d dVar = this.f[i].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    private void l(b bVar) {
        String str;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                mediaMetadataRetriever.setDataSource(new C0004a(this, bVar));
            } else {
                FileDescriptor fileDescriptor = this.f41b;
                if (fileDescriptor != null) {
                    mediaMetadataRetriever.setDataSource(fileDescriptor);
                } else {
                    String str3 = this.f40a;
                    if (str3 == null) {
                        return;
                    }
                    mediaMetadataRetriever.setDataSource(str3);
                }
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            String str4 = null;
            if ("yes".equals(extractMetadata3)) {
                str4 = mediaMetadataRetriever.extractMetadata(29);
                str = mediaMetadataRetriever.extractMetadata(30);
                str2 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str4 = mediaMetadataRetriever.extractMetadata(18);
                str = mediaMetadataRetriever.extractMetadata(19);
                str2 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str = null;
                str2 = null;
            }
            if (str4 != null) {
                this.f[0].put("ImageWidth", d.j(Integer.parseInt(str4), this.h));
            }
            if (str != null) {
                this.f[0].put("ImageLength", d.j(Integer.parseInt(str), this.h));
            }
            if (str2 != null) {
                int i = 1;
                int parseInt = Integer.parseInt(str2);
                if (parseInt == 90) {
                    i = 6;
                } else if (parseInt == 180) {
                    i = 3;
                } else if (parseInt == 270) {
                    i = 8;
                }
                this.f[0].put("Orientation", d.j(i, this.h));
            }
            if (extractMetadata != null && extractMetadata2 != null) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 <= 6) {
                    throw new IOException("Invalid exif length");
                }
                bVar.d(parseInt2);
                byte[] bArr = new byte[6];
                if (bVar.read(bArr) != 6) {
                    throw new IOException("Can't read identifier");
                }
                int i2 = parseInt2 + 6;
                int i3 = parseInt3 - 6;
                if (!Arrays.equals(bArr, m0)) {
                    throw new IOException("Invalid identifier");
                }
                byte[] bArr2 = new byte[i3];
                if (bVar.read(bArr2) != i3) {
                    throw new IOException("Can't read exif");
                }
                this.o = i2;
                Q(bArr2, 0);
            }
            if (t) {
                Log.d("ExifInterface", "Heif meta: " + str4 + "x" + str + ", rotation " + str2);
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x01a8, code lost:
        r22.e(r21.h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ad, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m(a.d.a.a.b r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.m(a.d.a.a$b, int, int):void");
    }

    private int n(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (C(bArr)) {
            return 4;
        }
        if (F(bArr)) {
            return 9;
        }
        if (B(bArr)) {
            return 12;
        }
        if (D(bArr)) {
            return 7;
        }
        if (G(bArr)) {
            return 10;
        }
        if (E(bArr)) {
            return 13;
        }
        return L(bArr) ? 14 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void o(a.d.a.a.b r7) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.o(a.d.a.a$b):void");
    }

    private void p(b bVar) {
        if (t) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.mark(0);
        bVar.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr = C;
        bVar.skipBytes(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = i + 4;
                if (i2 == 16 && !Arrays.equals(bArr2, E)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, F)) {
                    return;
                }
                if (Arrays.equals(bArr2, D)) {
                    byte[] bArr3 = new byte[readInt];
                    if (bVar.read(bArr3) != readInt) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr2));
                    }
                    int readInt2 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == readInt2) {
                        this.o = i2;
                        Q(bArr3, 0);
                        d0();
                        Z(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                }
                int i3 = readInt + 4;
                bVar.skipBytes(i3);
                length = i2 + i3;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void q(b bVar) {
        boolean z2 = t;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.mark(0);
        bVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        bVar.d(i);
        bVar.read(bArr4);
        m(new b(bArr4), i, 5);
        bVar.d(i3);
        bVar.e(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == Y.f56a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j = d.j(readShort, this.h);
                d j2 = d.j(readShort2, this.h);
                this.f[0].put("ImageLength", j);
                this.f[0].put("ImageWidth", j2);
                if (t) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.skipBytes(readUnsignedShort2);
        }
    }

    private void r(b bVar) {
        d dVar;
        N(bVar, bVar.available());
        R(bVar, 0);
        c0(bVar, 0);
        c0(bVar, 5);
        c0(bVar, 4);
        d0();
        if (this.f43d != 8 || (dVar = this.f[1].get("MakerNote")) == null) {
            return;
        }
        b bVar2 = new b(dVar.f55d);
        bVar2.e(this.h);
        bVar2.d(6L);
        R(bVar2, 9);
        d dVar2 = this.f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f[1].put("ColorSpace", dVar2);
        }
    }

    private void s(b bVar) {
        if (t) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + bVar);
        }
        r(bVar);
        d dVar = this.f[0].get("JpgFromRaw");
        if (dVar != null) {
            m(new b(dVar.f55d), (int) dVar.f54c, 5);
        }
        d dVar2 = this.f[0].get("ISO");
        d dVar3 = this.f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f[1].put("PhotographicSensitivity", dVar2);
    }

    private void t(b bVar) {
        byte[] bArr = m0;
        bVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[bVar.available()];
        bVar.readFully(bArr2);
        this.o = bArr.length;
        Q(bArr2, 0);
    }

    private void w(b bVar) {
        if (t) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.mark(0);
        bVar.e(ByteOrder.LITTLE_ENDIAN);
        bVar.skipBytes(G.length);
        int readInt = bVar.readInt() + 8;
        int skipBytes = bVar.skipBytes(H.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (bVar.read(bArr) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int readInt2 = bVar.readInt();
                int i = skipBytes + 4 + 4;
                if (Arrays.equals(I, bArr)) {
                    byte[] bArr2 = new byte[readInt2];
                    if (bVar.read(bArr2) == readInt2) {
                        this.o = i;
                        Q(bArr2, 0);
                        Z(new b(bArr2));
                        return;
                    }
                    throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr));
                }
                if (readInt2 % 2 == 1) {
                    readInt2++;
                }
                int i2 = i + readInt2;
                if (i2 == readInt) {
                    return;
                }
                if (i2 > readInt) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                int skipBytes2 = bVar.skipBytes(readInt2);
                if (skipBytes2 != readInt2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                skipBytes = i + skipBytes2;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair<Integer, Integer> x(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> x2 = x(split[0]);
            if (((Integer) x2.first).intValue() == 2) {
                return x2;
            }
            for (int i = 1; i < split.length; i++) {
                Pair<Integer, Integer> x3 = x(split[i]);
                int intValue = (((Integer) x3.first).equals(x2.first) || ((Integer) x3.second).equals(x2.first)) ? ((Integer) x2.first).intValue() : -1;
                int intValue2 = (((Integer) x2.second).intValue() == -1 || !(((Integer) x3.first).equals(x2.second) || ((Integer) x3.second).equals(x2.second))) ? -1 : ((Integer) x2.second).intValue();
                if (intValue == -1 && intValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (intValue == -1) {
                    x2 = new Pair<>(Integer.valueOf(intValue2), -1);
                } else if (intValue2 == -1) {
                    x2 = new Pair<>(Integer.valueOf(intValue), -1);
                }
            }
            return x2;
        } else if (!str.contains("/")) {
            try {
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(str));
                    return (valueOf.longValue() < 0 || valueOf.longValue() > 65535) ? valueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                } catch (NumberFormatException unused) {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                }
            } catch (NumberFormatException unused2) {
                return new Pair<>(2, -1);
            }
        } else {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0 && parseDouble2 >= 0) {
                        if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                            return new Pair<>(10, 5);
                        }
                        return new Pair<>(5, -1);
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused3) {
                }
            }
            return new Pair<>(2, -1);
        }
    }

    private void y(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int m = dVar.m(this.h);
        int m2 = dVar2.m(this.h);
        if (this.f43d == 7) {
            m += this.p;
        }
        int min = Math.min(m2, bVar.a() - m);
        if (m > 0 && min > 0) {
            this.i = true;
            if (this.f40a == null && this.f42c == null && this.f41b == null) {
                byte[] bArr = new byte[min];
                bVar.skip(m);
                bVar.read(bArr);
                this.m = bArr;
            }
            this.k = m;
            this.l = min;
        }
        if (t) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m + ", length: " + min);
        }
    }

    private void z(b bVar, HashMap hashMap) {
        d dVar = (d) hashMap.get("StripOffsets");
        d dVar2 = (d) hashMap.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] e2 = e(dVar.o(this.h));
        long[] e3 = e(dVar2.o(this.h));
        if (e2 == null || e2.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
        } else if (e3 == null || e3.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
        } else if (e2.length != e3.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
        } else {
            long j = 0;
            for (long j2 : e3) {
                j += j2;
            }
            int i = (int) j;
            byte[] bArr = new byte[i];
            int i2 = 1;
            this.j = true;
            this.i = true;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < e2.length) {
                int i6 = (int) e2[i3];
                int i7 = (int) e3[i3];
                if (i3 < e2.length - i2 && i6 + i7 != e2[i3 + 1]) {
                    this.j = false;
                }
                int i8 = i6 - i4;
                if (i8 < 0) {
                    Log.d("ExifInterface", "Invalid strip offset value");
                    return;
                }
                long j3 = i8;
                if (bVar.skip(j3) != j3) {
                    Log.d("ExifInterface", "Failed to skip " + i8 + " bytes.");
                    return;
                }
                int i9 = i4 + i8;
                byte[] bArr2 = new byte[i7];
                if (bVar.read(bArr2) != i7) {
                    Log.d("ExifInterface", "Failed to read " + i7 + " bytes.");
                    return;
                }
                i4 = i9 + i7;
                System.arraycopy(bArr2, 0, bArr, i5, i7);
                i5 += i7;
                i3++;
                i2 = 1;
            }
            this.m = bArr;
            if (this.j) {
                this.k = (int) e2[0];
                this.l = i;
            }
        }
    }

    public void U() {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        File file;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream2;
        FileDescriptor fileDescriptor;
        int i = Build.VERSION.SDK_INT;
        if (!J()) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
        }
        if (this.f41b == null && this.f40a == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        this.m = u();
        BufferedInputStream bufferedInputStream = null;
        File file2 = this.f40a != null ? new File(this.f40a) : null;
        try {
            if (this.f40a != null) {
                String str = UUID.randomUUID().toString() + "_";
                file = new File(file2.getParent(), str + file2.getName());
                if (!file2.renameTo(file)) {
                    throw new IOException("Couldn't rename to " + file.getAbsolutePath());
                }
                fileInputStream = null;
                fileOutputStream = null;
            } else if (i < 21 || this.f41b == null) {
                fileInputStream = null;
                fileOutputStream = null;
                file = null;
            } else {
                file = File.createTempFile("temp", "tmp");
                Os.lseek(this.f41b, 0L, OsConstants.SEEK_SET);
                fileInputStream = new FileInputStream(this.f41b);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    f(fileInputStream, fileOutputStream);
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = fileInputStream;
                    try {
                        throw new IOException("Failed to copy original file to temp file", e);
                    } catch (Throwable th2) {
                        th = th2;
                        d(bufferedInputStream);
                        d(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = fileInputStream;
                    d(bufferedInputStream);
                    d(fileOutputStream);
                    throw th;
                }
            }
            d(fileInputStream);
            d(fileOutputStream);
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                if (this.f40a != null) {
                    fileOutputStream2 = new FileOutputStream(this.f40a);
                } else if (i < 21 || (fileDescriptor = this.f41b) == null) {
                    fileOutputStream2 = null;
                } else {
                    Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_SET);
                    fileOutputStream2 = new FileOutputStream(this.f41b);
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    try {
                        int i2 = this.f43d;
                        if (i2 == 4) {
                            V(bufferedInputStream2, bufferedOutputStream);
                        } else if (i2 == 13) {
                            W(bufferedInputStream2, bufferedOutputStream);
                        } else if (i2 == 14) {
                            X(bufferedInputStream2, bufferedOutputStream);
                        }
                        d(bufferedInputStream2);
                        d(bufferedOutputStream);
                        file.delete();
                        this.m = null;
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            if (this.f40a == null || file.renameTo(file2)) {
                                throw new IOException("Failed to save new file", e);
                            }
                            throw new IOException("Couldn't restore original file: " + file2.getAbsolutePath());
                        } catch (Throwable th4) {
                            th = th4;
                            d(bufferedInputStream);
                            d(bufferedOutputStream);
                            file.delete();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        d(bufferedInputStream);
                        d(bufferedOutputStream);
                        file.delete();
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream = null;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedOutputStream = null;
            } catch (Throwable th7) {
                th = th7;
                bufferedOutputStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public void Y(String str, String str2) {
        e eVar;
        int i;
        String str3;
        HashMap<String, d> hashMap;
        d a2;
        String str4;
        HashMap<String, d> hashMap2;
        d c2;
        StringBuilder sb;
        Matcher matcher;
        String str5 = str;
        String str6 = str2;
        Objects.requireNonNull(str5, "tag shouldn't be null");
        String str7 = "ExifInterface";
        if ("ISOSpeedRatings".equals(str5)) {
            if (t) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str5 = "PhotographicSensitivity";
        }
        int i2 = 2;
        int i3 = 1;
        if (str6 != null && j0.contains(str5)) {
            if (str5.equals("GPSTimeStamp")) {
                if (!o0.matcher(str6).find()) {
                    sb = new StringBuilder();
                    sb.append("Invalid value for ");
                    sb.append(str5);
                    sb.append(" : ");
                    sb.append(str6);
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                str6 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str6 = new f(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                }
            }
        }
        char c3 = 0;
        int i4 = 0;
        while (i4 < d0.length) {
            if ((i4 != 4 || this.i) && (eVar = i0[i4].get(str5)) != null) {
                if (str6 == null) {
                    this.f[i4].remove(str5);
                } else {
                    Pair<Integer, Integer> x2 = x(str6);
                    int i5 = -1;
                    if (eVar.f58c == ((Integer) x2.first).intValue() || eVar.f58c == ((Integer) x2.second).intValue()) {
                        i = eVar.f58c;
                    } else {
                        int i6 = eVar.f59d;
                        if (i6 == -1 || !(i6 == ((Integer) x2.first).intValue() || eVar.f59d == ((Integer) x2.second).intValue())) {
                            int i7 = eVar.f58c;
                            if (i7 == i3 || i7 == 7 || i7 == i2) {
                                i = i7;
                            } else if (t) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Given tag (");
                                sb2.append(str5);
                                sb2.append(") value didn't match with one of expected formats: ");
                                String[] strArr = Q;
                                sb2.append(strArr[eVar.f58c]);
                                sb2.append(eVar.f59d == -1 ? "" : ", " + strArr[eVar.f59d]);
                                sb2.append(" (guess: ");
                                sb2.append(strArr[((Integer) x2.first).intValue()]);
                                sb2.append(((Integer) x2.second).intValue() != -1 ? ", " + strArr[((Integer) x2.second).intValue()] : "");
                                sb2.append(")");
                                Log.d(str7, sb2.toString());
                            }
                        } else {
                            i = eVar.f59d;
                        }
                    }
                    switch (i) {
                        case 1:
                            str3 = str7;
                            hashMap = this.f[i4];
                            a2 = d.a(str6);
                            hashMap.put(str5, a2);
                            str7 = str3;
                            break;
                        case 2:
                        case 7:
                            str3 = str7;
                            hashMap = this.f[i4];
                            a2 = d.e(str6);
                            hashMap.put(str5, a2);
                            str7 = str3;
                            break;
                        case 3:
                            str3 = str7;
                            String[] split = str6.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i8 = 0; i8 < split.length; i8++) {
                                iArr[i8] = Integer.parseInt(split[i8]);
                            }
                            hashMap = this.f[i4];
                            a2 = d.k(iArr, this.h);
                            hashMap.put(str5, a2);
                            str7 = str3;
                            break;
                        case 4:
                            str3 = str7;
                            String[] split2 = str6.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i9 = 0; i9 < split2.length; i9++) {
                                jArr[i9] = Long.parseLong(split2[i9]);
                            }
                            hashMap = this.f[i4];
                            a2 = d.g(jArr, this.h);
                            hashMap.put(str5, a2);
                            str7 = str3;
                            break;
                        case 5:
                            str3 = str7;
                            String[] split3 = str6.split(",", -1);
                            f[] fVarArr = new f[split3.length];
                            int i10 = 0;
                            while (i10 < split3.length) {
                                String[] split4 = split3[i10].split("/", i5);
                                fVarArr[i10] = new f((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                i10++;
                                i5 = -1;
                            }
                            hashMap = this.f[i4];
                            a2 = d.i(fVarArr, this.h);
                            hashMap.put(str5, a2);
                            str7 = str3;
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            str3 = str7;
                            if (t) {
                                str7 = str3;
                                Log.d(str7, "Data format isn't one of expected formats: " + i);
                                break;
                            }
                            str7 = str3;
                            break;
                        case 9:
                            str4 = str7;
                            String[] split5 = str6.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i11 = 0; i11 < split5.length; i11++) {
                                iArr2[i11] = Integer.parseInt(split5[i11]);
                            }
                            hashMap2 = this.f[i4];
                            c2 = d.c(iArr2, this.h);
                            hashMap2.put(str5, c2);
                            str7 = str4;
                            break;
                        case 10:
                            String[] split6 = str6.split(",", -1);
                            f[] fVarArr2 = new f[split6.length];
                            int i12 = 0;
                            while (i12 < split6.length) {
                                String[] split7 = split6[i12].split("/", -1);
                                fVarArr2[i12] = new f((long) Double.parseDouble(split7[c3]), (long) Double.parseDouble(split7[i3]));
                                i12++;
                                str7 = str7;
                                i3 = 1;
                                c3 = 0;
                            }
                            str4 = str7;
                            hashMap2 = this.f[i4];
                            c2 = d.d(fVarArr2, this.h);
                            hashMap2.put(str5, c2);
                            str7 = str4;
                            break;
                        case 12:
                            String[] split8 = str6.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i13 = 0; i13 < split8.length; i13++) {
                                dArr[i13] = Double.parseDouble(split8[i13]);
                            }
                            this.f[i4].put(str5, d.b(dArr, this.h));
                            break;
                    }
                    i4++;
                    i2 = 2;
                    i3 = 1;
                    c3 = 0;
                }
            }
            i4++;
            i2 = 2;
            i3 = 1;
            c3 = 0;
        }
    }

    public String j(String str) {
        String str2;
        Objects.requireNonNull(str, "tag shouldn't be null");
        d k = k(str);
        if (k != null) {
            if (!j0.contains(str)) {
                return k.n(this.h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = k.f52a;
                if (i == 5 || i == 10) {
                    f[] fVarArr = (f[]) k.o(this.h);
                    if (fVarArr != null && fVarArr.length == 3) {
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) fVarArr[0].f60a) / ((float) fVarArr[0].f61b))), Integer.valueOf((int) (((float) fVarArr[1].f60a) / ((float) fVarArr[1].f61b))), Integer.valueOf((int) (((float) fVarArr[2].f60a) / ((float) fVarArr[2].f61b))));
                    }
                    str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr);
                } else {
                    str2 = "GPS Timestamp format is not rational. format=" + k.f52a;
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(k.l(this.h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public byte[] u() {
        int i = this.n;
        if (i == 6 || i == 7) {
            return v();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065 A[Catch: Exception -> 0x009e, all -> 0x00bb, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x009e, blocks: (B:38:0x0065, B:41:0x007b, B:43:0x0087, B:48:0x0092, B:49:0x0097, B:50:0x0098, B:51:0x009d, B:54:0x00a0, B:55:0x00a5), top: B:73:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0 A[Catch: Exception -> 0x009e, all -> 0x00bb, TryCatch #0 {Exception -> 0x009e, blocks: (B:38:0x0065, B:41:0x007b, B:43:0x0087, B:48:0x0092, B:49:0x0097, B:50:0x0098, B:51:0x009d, B:54:0x00a0, B:55:0x00a5), top: B:73:0x0063 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] v() {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d.a.a.v():byte[]");
    }
}
