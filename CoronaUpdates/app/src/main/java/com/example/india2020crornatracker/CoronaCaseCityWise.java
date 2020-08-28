package com.example.india2020crornatracker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CoronaCaseCityWise extends AppCompatActivity {
    TableLayout tableLayout;
    ScrollView scrollView;
    TextView tvnot;
    TableRow tr,tr1;
    String myresponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_corona_case_city_wise);






        tvnot=findViewById(R.id.tvnot);
        scrollView=findViewById(R.id.scrollview);

        tableLayout=findViewById(R.id.table);








        OkHttpClient client = new OkHttpClient();
        String url = "https://api.covidindiatracker.com/state_data.json";
        Request request = new Request.Builder()
                .url(url)
                .build();


        client.newCall(request).enqueue(new Callback() {


            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();

                tvnot.setText("Your Connection Speed Is Low , This May Take Some While");

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {

                    myresponse = response.body().string();
                    CoronaCaseCityWise.this.runOnUiThread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {


                      Log.i("value",myresponse);



                        }


                    });
                }
            }
        });








        ConnectivityManager cm =  (ConnectivityManager) CoronaCaseCityWise.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(!isConnected) {
            Toast.makeText(this, "Please Check Your Internet Connection!", Toast.LENGTH_LONG).show();
        }
    }






    }
