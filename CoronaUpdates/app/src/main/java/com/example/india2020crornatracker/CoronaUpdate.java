package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.*;

public class CoronaUpdate extends AppCompatActivity {
Button statewisebtn,districtwisebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_corona_update);

        statewisebtn=findViewById(R.id.statewisebtn);
        districtwisebtn=findViewById(R.id.districtwisebtn);
    }

    public void onClickStatewise(View v)
    {
        Intent intent =new Intent(CoronaUpdate.this,CoronaCaseActivityState.class);
        startActivity(intent);
    }
    public void onClickCountrytwise(View v)
    {
        Intent intentdis=new Intent(CoronaUpdate.this, CoronaCaseActivityCountry.class);
        startActivity(intentdis);
    }
    public void onClickCitytwise(View v)
    {
        Intent intentcity=new Intent(CoronaUpdate.this, CoronaCaseCityWise.class);
        startActivity(intentcity);}
}