package com.example.tehtava10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView web;
    EditText searchBar;
    Button refresh;
    Button butJava;
    Button butOrgi;
    Button forward;
    Button backward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webview);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        searchBar = findViewById(R.id.searchBar);
        refresh = findViewById(R.id.refresh);
        butJava = findViewById(R.id.butJava);
        butOrgi = findViewById(R.id.butOrgi);
        forward = findViewById(R.id.forward);
        backward = findViewById(R.id.backward);

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoBack()) {
                    web.goBack();
                }
            }
        });
        forward.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoForward()){
                    web.goForward();
                }
            }
        }));

        butJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.evaluateJavascript("javascript:shoutOut()",null);
            }
        });
        butOrgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.evaluateJavascript("javascript:initialize()",null);
            }
        });
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webSite = searchBar.getText().toString();
                if (webSite.equals("index.html")) {
                    web.loadUrl("file:///android_asset/index.html");
                } else {
                    web.loadUrl("http://" + webSite);
                    refresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            web.reload();
                        }
                    });
                }
            }
        });
    }


}