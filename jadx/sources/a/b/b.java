package a.b;

/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f14a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final Object[] f15b = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i3 = i5 - 1;
            }
        }
        return i4 ^ (-1);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
