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

public class CoronaCaseActivityCountry extends AppCompatActivity {
    TableLayout tableLayout;
    ScrollView scrollView;
    TextView tvnot;
    TableRow tr,tr1;
    String myresponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_corona_case_country);



        ConnectivityManager cm =  (ConnectivityManager) CoronaCaseActivityCountry.this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if(!isConnected) {
            Toast.makeText(this, "Please Check Your Internet Connection!", Toast.LENGTH_LONG).show();
        }





        tvnot=findViewById(R.id.tvnot);
        scrollView=findViewById(R.id.scrollview);

        tableLayout=findViewById(R.id.table);








        OkHttpClient client = new OkHttpClient();
        String url = "http://api.coronatracker.com/v3/stats/worldometer/country/";
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
                    CoronaCaseActivityCountry.this.runOnUiThread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {

                        String [] CountryData= null;



                            try {

                                JSONArray jsonArray = new JSONArray(myresponse);
                                String country[] = new String[jsonArray.length()];
                                String confirmed[] = new String[jsonArray.length()];
                                String active[] = new String[jsonArray.length()];
                                String recovered[] = new String[jsonArray.length()];
                                String death[] = new String[jsonArray.length()];


                                scrollView.setVisibility(View.VISIBLE);


                                tableLayout.setStretchAllColumns(true);
                                tableLayout.bringToFront();
                                tr =  new TableRow(CoronaCaseActivityCountry.this);
                                tr1 =  new TableRow(CoronaCaseActivityCountry.this);
                                ImageView ic1 = new ImageView(CoronaCaseActivityCountry.this);
                                ImageView ic2 = new ImageView(CoronaCaseActivityCountry.this);
                                ImageView ic3 = new ImageView(CoronaCaseActivityCountry.this);
                                ImageView ic4 = new ImageView(CoronaCaseActivityCountry.this);
                                ImageView ic5 = new ImageView(CoronaCaseActivityCountry.this);
                                ic1.setImageIcon(Icon.createWithResource(CoronaCaseActivityCountry.this,R.drawable.earth));

                                ic2.setImageIcon(Icon.createWithResource(CoronaCaseActivityCountry.this,R.drawable.coronavirus));
                                ic3.setImageIcon(Icon.createWithResource(CoronaCaseActivityCountry.this,R.drawable.active));
                                ic4.setImageIcon(Icon.createWithResource(CoronaCaseActivityCountry.this,R.drawable.recovered));
                                ic5.setImageIcon(Icon.createWithResource(CoronaCaseActivityCountry.this,R.drawable.death));

                                tr.addView(ic1,100,100);
                                tr.addView(ic2,100,100);
                                tr.addView(ic3,100,100);
                                tr.addView(ic4,100,100);
                                tr.addView(ic5,100,100);



                                TextView c11 = new TextView(CoronaCaseActivityCountry.this);
                                TextView c21 = new TextView(CoronaCaseActivityCountry.this);
                                TextView c31 = new TextView(CoronaCaseActivityCountry.this);
                                TextView c41 = new TextView(CoronaCaseActivityCountry.this);
                                TextView c51 = new TextView(CoronaCaseActivityCountry.this);

                                c11.setWidth(105);
                                c11.setHeight(100);
                                c11.setTextSize(15f);
                                c11.setTextColor(Color.BLACK);
                                c11.setTypeface(Typeface.DEFAULT_BOLD);
                                c11.setGravity( Gravity.CENTER);
                                c11.setPadding(0,0,0,0);

                                c11.setText("State");

                                c21.setMaxWidth(105);
                                c21.setTextSize(15f);
                                c21.setHeight(100);
                                c21.setTextColor(Color.BLACK);
                                c21.setGravity( Gravity.CENTER_HORIZONTAL);
                                c21.setTypeface(Typeface.DEFAULT_BOLD);
                                c21.setText("Confirmed");


                                c31.setMaxWidth(105);
                                c31.setTextSize(15f);
                                c31.setHeight(100);
                                c31.setTextColor(Color.BLACK);
                                c31.setGravity( Gravity.CENTER);
                                c31.setTypeface(Typeface.DEFAULT_BOLD);
                                c31.setText("Active");

                                c41.setMaxWidth(105);
                                c41.setTextSize(15f);
                                c41.setHeight(100);
                                c41.setGravity( Gravity.CENTER);
                                c41.setTextColor(Color.BLACK);
                                c41.setTypeface(Typeface.DEFAULT_BOLD);
                                c41.setText("Recovered");

                                c51.setMaxWidth(105);
                                c51.setTextSize(15f);
                                c51.setHeight(100);
                                c51.setTextColor(Color.BLACK);
                                c51.setGravity( Gravity.CENTER);
                                c51.setTypeface(Typeface.DEFAULT_BOLD);
                                c51.setText("Death");


                                tr1.addView(c11);
                                tr1.addView(c21);
                                tr1.addView(c31);
                                tr1.addView(c41);
                                tr1.addView(c51);

                                tableLayout.addView(tr);
                                tableLayout.addView(tr1);






                                 for(int i=0; i<jsonArray.length();i++)
                                 {
                                     JSONObject jsonpart=jsonArray.getJSONObject(i);

                                     country[i]=jsonpart.getString("country");
                                     confirmed[i]=jsonpart.getString("totalConfirmed");
                                     active[i]=jsonpart.getString("activeCases");
                                     recovered[i]=jsonpart.getString("totalRecovered");
                                     death[i]=jsonpart.getString("totalDeaths");





                                     tr =  new TableRow(CoronaCaseActivityCountry.this);

                                     TextView c1 = new TextView(CoronaCaseActivityCountry.this);
                                     TextView c2 = new TextView(CoronaCaseActivityCountry.this);
                                     TextView c3 = new TextView(CoronaCaseActivityCountry.this);
                                     TextView c4 = new TextView(CoronaCaseActivityCountry.this);
                                     TextView c5 = new TextView(CoronaCaseActivityCountry.this);



                                         c1.setWidth(205);
                                         c1.setHeight(180);
                                         c1.setTextSize(15f);
                                         c1.setPadding(13, 0, 0, 0);
                                         c1.setTextColor(Color.RED);
                                         c1.setTypeface(Typeface.DEFAULT_BOLD);
                                     c1.setGravity( Gravity.CENTER);
                                         c1.setText(country[i]);

                                         if(i==31 || i==35)
                                         {c1.setHeight(280);}

                                         c2.setMaxWidth(300);
                                         c2.setTextSize(15f);
                                         c2.setPadding(0, 20, 0, 0);
                                         c2.setTextColor(Color.BLACK);
                                         c2.setGravity( Gravity.CENTER);
                                         c2.setText(confirmed[i]);


                                         c3.setMaxWidth(300);
                                         c3.setTextSize(15f);
                                         c3.setPadding(0, 20, 0, 0);
                                         c3.setTextColor(Color.BLACK);
                                         c3.setGravity( Gravity.CENTER);
                                         c3.setText(active[i]);

                                         c4.setMaxWidth(300);
                                         c4.setTextSize(15f);
                                         c4.setPadding(0, 20, 0, 0);
                                         c4.setTextColor(Color.BLACK);
                                         c4.setGravity( Gravity.CENTER);
                                         c4.setText(recovered[i]);

                                         c5.setMaxWidth(300);
                                         c5.setTextSize(15f);
                                         c5.setPadding(0, 20, 0, 0);
                                         c5.setTextColor(Color.BLACK);
                                         c5.setGravity( Gravity.CENTER);
                                         c5.setText(death[i]);

                                         tr.addView(c1);
                                         tr.addView(c2);
                                         tr.addView(c3);
                                         tr.addView(c4);
                                         tr.addView(c5);
                                         tableLayout.addView(tr);






                                     Log.i("Value","Country  "+country[i] + "     Confirmed  "+ confirmed[i]+"    Active  "+ active[i] + "    Recovered  " + recovered[i] +"    Death  "+death[i]);
                                 }

                            } catch (Exception e) {


                                e.printStackTrace();


                            }


                        }


                    });
                }
            }
        });



    }
            }






