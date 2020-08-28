package com.example.udemy7tic_tac_toeorconnect_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class contgame extends AppCompatActivity {
    Button btn,btn1,btn6;
    LinearLayout ly;
    GridLayout gridLayout;
    RelativeLayout relativeLayout;
    MediaPlayer mp;
    String player1,player2;

    TextView tv,tv2,tv3,tv11;
    int player= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_contgame);

        mp=MediaPlayer.create(this,R.raw.backgroundmusic);
        mp.start();

        btn=findViewById(R.id.button2);
        btn1=findViewById(R.id.button);
        tv=findViewById(R.id.textView3);
        ly=findViewById(R.id.layt);
        tv11= findViewById(R.id.textView2);

        int i=getIntent().getIntExtra("i",1);
        i++;
        player1=getIntent().getStringExtra("player1");
        player2=getIntent().getStringExtra("player2");
        tv11.setText(player1+"'s TURN");

    }
    int i=2;



    int [] onplayer={2,2,2,2,2,2,2,2,2};
boolean gameisactive=true;

    public void onClickg1(View v) {
        ImageView counter = (ImageView) v;


        int box = Integer.parseInt(counter.getTag().toString());
        if (onplayer[box] == 2 && gameisactive) {
            onplayer[box] = player;
            counter.setTranslationY(-1500f);


            if (i % 2 == 0) {
                tv11.setText(player2+"'s TURN");
                i++;
            } else {
                tv11.setText(player1+"'s TURN");
                i++;
            }

            if (player == 0) {

                counter.setImageResource(R.drawable.cross);
                counter.animate().translationYBy(1500f).scaleY(0.8f).scaleX(0.8f).rotation(720f).setDuration(500);
                player = 1;
                onplayer[box] = 0;
            } else {

                counter.setImageResource(R.drawable.circle);
                counter.animate().translationYBy(1500f).scaleY(0.8f).scaleX(0.8f).rotationY(1080f).setDuration(500);
                player = 0;
                onplayer[box] = 1;
            }

            if (
                    (onplayer[0] == 0 && onplayer[1] == 0 && onplayer[2] == 0) ||
                            (onplayer[3] == 0 && onplayer[4] == 0 && onplayer[5] == 0) ||
                            (onplayer[6] == 0 && onplayer[7] == 0 && onplayer[8] == 0) ||
                            (onplayer[0] == 0 && onplayer[3] == 0 && onplayer[6] == 0) ||
                            (onplayer[1] == 0 && onplayer[4] == 0 && onplayer[7] == 0) ||
                            (onplayer[2] == 0 && onplayer[5] == 0 && onplayer[8] == 0) ||
                            (onplayer[0] == 0 && onplayer[4] == 0 && onplayer[8] == 0) ||
                            (onplayer[2] == 0 && onplayer[4] == 0 && onplayer[6] == 0)) {
                tv.setText("CROSS ONE WON THE MATCH");
                tv11.setText("WINNER :"+player1);
                gameisactive = false;



                ImageView im1 = findViewById(R.id.imageView);
                im1.animate().alpha(0.2f).setDuration(500);

                ImageView im2 = findViewById(R.id.imageView10);
                im2.animate().alpha(0.2f).setDuration(500);

                ImageView im3 = findViewById(R.id.imageView11);
                im3.animate().alpha(0.2f).setDuration(500);

                ImageView im4 = findViewById(R.id.imageView12);
                im4.animate().alpha(0.2f).setDuration(500);

                ImageView im5 = findViewById(R.id.imageView13);
                im5.animate().alpha(0.2f).setDuration(500);

                ImageView im6 = findViewById(R.id.imageView14);
                im6.animate().alpha(0.2f).setDuration(500);

                ImageView im7 = findViewById(R.id.imageView15);
                im7.animate().alpha(0.2f).setDuration(500);

                ImageView im8 = findViewById(R.id.imageView16);
                im8.animate().alpha(0.2f).setDuration(500);

                ImageView im9 = findViewById(R.id.imageView17);
                im9.animate().alpha(0.2f).setDuration(500);

                ly.setVisibility(View.VISIBLE);
                ly.animate().alpha(0f);
                ly.animate().alpha(1f).setDuration(5000);
                btn1.animate().alpha(0f);

            } else if (


                    (onplayer[0] == 1 && onplayer[1] == 1 && onplayer[2] == 1) ||
                            (onplayer[3] == 1 && onplayer[4] == 1 && onplayer[5] == 1) ||
                            (onplayer[6] == 1 && onplayer[7] == 1 && onplayer[8] == 1) ||
                            (onplayer[0] == 1 && onplayer[3] == 1 && onplayer[6] == 1) ||
                            (onplayer[1] == 1 && onplayer[4] == 1 && onplayer[7] == 1) ||
                            (onplayer[2] == 1 && onplayer[5] == 1 && onplayer[8] == 1) ||
                            (onplayer[0] == 1 && onplayer[4] == 1 && onplayer[8] == 1) ||
                            (onplayer[2] == 1 && onplayer[4] == 1 && onplayer[6] == 1)) {

                ly.setVisibility(View.VISIBLE);
                ly.animate().alpha(0f);
                ly.animate().alpha(1f).setDuration(5000);
                btn1.animate().alpha(0f);

                tv.setText("CIRCULAR ONE WON THE MATCH");
                tv11.setText("WINNER :"+player2);
                gameisactive = false;



                ImageView im1 = findViewById(R.id.imageView);
                im1.animate().alpha(0.2f).setDuration(500);

                ImageView im2 = findViewById(R.id.imageView10);
                im2.animate().alpha(0.2f).setDuration(500);

                ImageView im3 = findViewById(R.id.imageView11);
                im3.animate().alpha(0.2f).setDuration(500);

                ImageView im4 = findViewById(R.id.imageView12);
                im4.animate().alpha(0.2f).setDuration(500);

                ImageView im5 = findViewById(R.id.imageView13);
                im5.animate().alpha(0.2f).setDuration(500);

                ImageView im6 = findViewById(R.id.imageView14);
                im6.animate().alpha(0.2f).setDuration(500);

                ImageView im7 = findViewById(R.id.imageView15);
                im7.animate().alpha(0.2f).setDuration(500);

                ImageView im8 = findViewById(R.id.imageView16);
                im8.animate().alpha(0.2f).setDuration(500);

                ImageView im9 = findViewById(R.id.imageView17);
                im9.animate().alpha(0.2f).setDuration(500);


            } else if (onplayer[0]!=2 && onplayer[1]!=2 && onplayer[2]!=2 && onplayer[3]!=2 && onplayer[4]!=2 && onplayer[5]!=2 && onplayer[6]!=2 && onplayer[7]!=2 && onplayer[8]!=2  ) {
                tv11.setText("MATCH DRAW");
            }
        }
    }

    public void onPlay(View v)
    {    gameisactive=true;
        mp.pause();
        Intent again= new Intent(this, MainActivity.class);
        again.putExtra("player1",player1);
        again.putExtra("player2",player2);
        again.putExtra("i",i);
        startActivity(again);

    }
}
