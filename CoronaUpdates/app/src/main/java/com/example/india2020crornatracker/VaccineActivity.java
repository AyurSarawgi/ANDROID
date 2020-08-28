package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class VaccineActivity extends AppCompatActivity {
WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        getSupportActionBar().hide();
        Toast.makeText(this, "Your Connection Speed May Be Low", Toast.LENGTH_SHORT).show();

        ConnectivityManager cm =  (ConnectivityManager) VaccineActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(!isConnected) {
            Toast.makeText(this, "Please Check Your Internet Connection!", Toast.LENGTH_LONG).show();}



        webView=findViewById(R.id.webview);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
      webView.loadUrl("https://transformingindia.mygov.in/covid-19/" );
        Toast.makeText(this, "Loading...Please Wait....", Toast.LENGTH_LONG).show();
      webView.setVisibility(View.VISIBLE);
    }
    public void onBackPressed()
    {
        if(webView.canGoBack())
        {
            webView.goBack();
        }else {super.onBackPressed();}
    }

}