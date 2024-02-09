package io.flutter.embedding.engine.f;

import c.a.c.a.b;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements c.a.c.a.b, c {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f349a;

    /* renamed from: d  reason: collision with root package name */
    private int f352d = 1;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b.a> f350b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, b.InterfaceC0018b> f351c = new HashMap();

    /* loaded from: classes.dex */
    static class a implements b.InterfaceC0018b {

        /* renamed from: a  reason: collision with root package name */
        private final FlutterJNI f353a;

        /* renamed from: b  reason: collision with root package name */
        private final int f354b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f355c = new AtomicBoolean(false);

        a(FlutterJNI flutterJNI, int i) {
            this.f353a = flutterJNI;
            this.f354b = i;
        }

        @Override // c.a.c.a.b.InterfaceC0018b
        public void a(ByteBuffer byteBuffer) {
            if (this.f355c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f353a.invokePlatformMessageEmptyResponseCallback(this.f354b);
            } else {
                this.f353a.invokePlatformMessageResponseCallback(this.f354b, byteBuffer, byteBuffer.position());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FlutterJNI flutterJNI) {
        this.f349a = flutterJNI;
    }

    private static void e(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    @Override // c.a.c.a.b
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0018b interfaceC0018b) {
        int i;
        c.a.b.e("DartMessenger", "Sending message with callback over channel '" + str + "'");
        if (interfaceC0018b != null) {
            i = this.f352d;
            this.f352d = i + 1;
            this.f351c.put(Integer.valueOf(i), interfaceC0018b);
        } else {
            i = 0;
        }
        if (byteBuffer == null) {
            this.f349a.dispatchEmptyPlatformMessage(str, i);
        } else {
            this.f349a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
        }
    }

    @Override // io.flutter.embedding.engine.f.c
    public void b(String str, ByteBuffer byteBuffer, int i) {
        c.a.b.e("DartMessenger", "Received message from Dart over channel '" + str + "'");
        b.a aVar = this.f350b.get(str);
        if (aVar != null) {
            try {
                c.a.b.e("DartMessenger", "Deferring to registered handler to process message.");
                aVar.a(byteBuffer, new a(this.f349a, i));
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
                return;
            } catch (Error e) {
                e(e);
                return;
            } catch (Exception e2) {
                c.a.b.c("DartMessenger", "Uncaught exception in binary message listener", e2);
            }
        } else {
            c.a.b.e("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f349a.invokePlatformMessageEmptyResponseCallback(i);
    }

    @Override // c.a.c.a.b
    public void c(String str, b.a aVar) {
        if (aVar == null) {
            c.a.b.e("DartMessenger", "Removing handler for channel '" + str + "'");
            this.f350b.remove(str);
            return;
        }
        c.a.b.e("DartMessenger", "Setting handler for channel '" + str + "'");
        this.f350b.put(str, aVar);
    }

    @Override // io.flutter.embedding.engine.f.c
    public void d(int i, ByteBuffer byteBuffer) {
        c.a.b.e("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0018b remove = this.f351c.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                c.a.b.e("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e) {
                e(e);
            } catch (Exception e2) {
                c.a.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e2);
            }
        }
    }
}
