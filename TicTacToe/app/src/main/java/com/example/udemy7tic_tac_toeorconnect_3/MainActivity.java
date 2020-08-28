package com.example.udemy7tic_tac_toeorconnect_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
     EditText ed1,ed2;
     int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.edplayer1);
        ed2=findViewById(R.id.edplayer2);
        btn1=findViewById(R.id.button);
        i=getIntent().getIntExtra("i",i);
        if(i!=0)
        {
        String player1=getIntent().getStringExtra("player1");
        String player2=getIntent().getStringExtra("player2");


            ed1.setText(player1);
            ed2.setText(player2);
        }


    }

    public void Play(View v)
    {
        Intent newact= new Intent(this, contgame.class);
        newact.putExtra("player1",ed1.getText().toString());
        newact.putExtra("player2",ed2.getText().toString());
        newact.putExtra("i",i);
        startActivity(newact);
    }

}

