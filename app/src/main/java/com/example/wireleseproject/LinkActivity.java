package com.example.wireleseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LinkActivity extends AppCompatActivity {
    WebView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        w=(WebView)findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());
        w.loadUrl("https://realfood.tesco.com/recipes.html\n");
        WebSettings webSettings=w.getSettings();
        webSettings.setJavaScriptEnabled(true);}}

