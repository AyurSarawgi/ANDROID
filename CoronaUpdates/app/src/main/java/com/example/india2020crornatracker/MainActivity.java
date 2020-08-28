package com.example.india2020crornatracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportMenuInflater;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.*;
import android.os.Bundle;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imageviewupdate,imageviewvaccinenews,imageviewawarenessvideo,imageviewquiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageviewupdate=findViewById(R.id.imageViewupdate);
        imageviewvaccinenews=findViewById(R.id.imageViewvaccinenews);
        imageviewquiz=findViewById(R.id.imageViewquiz);
        imageviewawarenessvideo=findViewById(R.id.imageViewawarenessvideo);



    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SupportMenuInflater menuInflater= (SupportMenuInflater) getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.facility) {
            Intent intentfacility = new Intent(MainActivity.this, FacilityActivity.class);
            intentfacility.putExtra("ItemID", "FACILITY");
            startActivity(intentfacility);

        }
        if(item.getItemId()==R.id.faq)
        {
            Intent intentfaq = new Intent(MainActivity.this, FAQActivity.class);
            intentfaq.putExtra("ItemID", "FAQ");
            startActivity(intentfaq);

        }
        return super.onOptionsItemSelected(item);

    }


    public void onClickUpdate(View v)
    {
Intent intentCoronaCases=new Intent(MainActivity.this, CoronaUpdate.class);
startActivity(intentCoronaCases);
    }

    public void onClickVaccine(View v)
    {
        Intent intentvaccine=new Intent(MainActivity.this,VaccineActivity.class);
        startActivity(intentvaccine);
    }

    public void onClickQuiz(View v)
    {
      Intent intentquiz=new Intent(MainActivity.this,QuizActivity.class);
      startActivity(intentquiz);
    }

    public void onClickVideo(View v)
    {
     Intent intentvid=new Intent(MainActivity.this,VideoActivity.class);
     startActivity(intentvid);
    }



}