package com.atiqrs.my_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView aa = findViewById(R.id.url);
        aa.loadUrl("http://facebook.com/atiqrs");
        aa.setWebViewClient(new WebViewClient());
        WebSettings javascript_permission = aa.getSettings();
        javascript_permission.setJavaScriptEnabled(true);
    }
}