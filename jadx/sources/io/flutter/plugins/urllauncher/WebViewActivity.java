package io.flutter.plugins.urllauncher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WebViewActivity extends Activity {
    public static String e = "close action";
    private static String f = "url";
    private static String g = "enableJavaScript";
    private static String h = "enableDomStorage";

    /* renamed from: c  reason: collision with root package name */
    private WebView f655c;

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f653a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final WebViewClient f654b = new b(this);

    /* renamed from: d  reason: collision with root package name */
    private IntentFilter f656d = new IntentFilter(e);

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (WebViewActivity.e.equals(intent.getAction())) {
                WebViewActivity.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends WebViewClient {
        b(WebViewActivity webViewActivity) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                webView.loadUrl(webResourceRequest.getUrl().toString());
                return false;
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (Build.VERSION.SDK_INT < 21) {
                webView.loadUrl(str);
                return false;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* loaded from: classes.dex */
    private class c extends WebChromeClient {

        /* loaded from: classes.dex */
        class a extends WebViewClient {
            a() {
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                WebViewActivity.this.f655c.loadUrl(webResourceRequest.getUrl().toString());
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WebViewActivity.this.f655c.loadUrl(str);
                return true;
            }
        }

        private c() {
        }

        /* synthetic */ c(WebViewActivity webViewActivity, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            a aVar = new a();
            WebView webView2 = new WebView(WebViewActivity.this.f655c.getContext());
            webView2.setWebViewClient(aVar);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    public static Intent b(Context context, String str, boolean z, boolean z2, Bundle bundle) {
        return new Intent(context, WebViewActivity.class).putExtra(f, str).putExtra(g, z).putExtra(h, z2).putExtra("com.android.browser.headers", bundle);
    }

    public static Map<String, String> c(Bundle bundle) {
        if (bundle == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f655c = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(f);
        boolean booleanExtra = intent.getBooleanExtra(g, false);
        boolean booleanExtra2 = intent.getBooleanExtra(h, false);
        this.f655c.loadUrl(stringExtra, c(intent.getBundleExtra("com.android.browser.headers")));
        this.f655c.getSettings().setJavaScriptEnabled(booleanExtra);
        this.f655c.getSettings().setDomStorageEnabled(booleanExtra2);
        this.f655c.setWebViewClient(this.f654b);
        this.f655c.getSettings().setSupportMultipleWindows(true);
        this.f655c.setWebChromeClient(new c(this, null));
        registerReceiver(this.f653a, this.f656d);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f653a);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f655c.canGoBack()) {
            this.f655c.goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
