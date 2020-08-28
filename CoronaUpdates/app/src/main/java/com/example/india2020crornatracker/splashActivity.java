package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        final ImageView imageView;
        imageView=findViewById(R.id.imageView);
        imageView.animate().rotation(360).setDuration(2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {




                Intent intent=new Intent(splashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },2000);






    }
}