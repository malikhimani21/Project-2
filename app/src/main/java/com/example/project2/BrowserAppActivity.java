package com.example.project2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BrowserAppActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUrl;
    private WebView webView;
    private Button go, forward, back, refresh, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_app);

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.setWebViewClient(new newWebViewClientCls());

        try {
            webView.loadUrl("https://www.google.co.in/");
        } catch (Exception e) {
            e.printStackTrace();
        }

        editTextUrl = (EditText) findViewById(R.id.edieTextURL);
        go = (Button) findViewById(R.id.buttonGo);
        forward = (Button) findViewById(R.id.buttonForward);
        back = (Button) findViewById(R.id.buttonBack);
        refresh = (Button) findViewById(R.id.buttonRefresh);
        // history = (Button) findViewById(R.id.buttonHistory);

        go.setOnClickListener(this);
        forward.setOnClickListener(this);
        back.setOnClickListener(this);
        refresh.setOnClickListener(this);
//        history.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonGo:
                String stringUrl = editTextUrl.getText().toString();
                webView.loadUrl("https://www." + stringUrl);

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editTextUrl.getWindowToken(), 0);
                break;

            case R.id.buttonForward:
                if (webView.canGoForward()) {
                    webView.goForward();
                }
                break;

            case R.id.buttonBack:
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                break;

            case R.id.buttonRefresh:
                webView.reload();
                Toast.makeText(getApplicationContext(), "Page Refreshing", Toast.LENGTH_SHORT).show();

                break;

//            case R.id.buttonHistory:
//                webView.clearHistory();
//                Toast.makeText(getApplicationContext(),"History Cleared",Toast.LENGTH_SHORT).show();
//                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.browser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clearHistory:
                webView.clearHistory();
                Toast.makeText(getApplicationContext(), "History Cleared", Toast.LENGTH_SHORT).show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
