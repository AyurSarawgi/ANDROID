package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.*;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10;
RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10;
Button btnresult;
ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        btnresult=findViewById(R.id.buttonresult);

        img=findViewById(R.id.imageView2);
        img.animate().translationYBy(1000);

        rg1=findViewById(R.id.rg1);
        rg2=findViewById(R.id.rg2);
        rg3=findViewById(R.id.rg3);
        rg4=findViewById(R.id.rg4);
        rg5=findViewById(R.id.rg5);
        rg6=findViewById(R.id.rg6);
        rg7=findViewById(R.id.rg7);
        rg8=findViewById(R.id.rg8);
        rg9=findViewById(R.id.rg9);
        rg10=findViewById(R.id.rg10);


    }
    public void onclickgetresult(View v) {
        int marks = 0;


        try {
            int rbtnid1 = rg1.getCheckedRadioButtonId();
            rb1 = findViewById(rbtnid1);

            int rbtnid2 = rg2.getCheckedRadioButtonId();
            rb2 = findViewById(rbtnid2);

            int rbtnid3 = rg3.getCheckedRadioButtonId();
            rb3 = findViewById(rbtnid3);

            int rbtnid4 = rg4.getCheckedRadioButtonId();
            rb4 = findViewById(rbtnid4);

            int rbtnid5 = rg5.getCheckedRadioButtonId();
            rb5 = findViewById(rbtnid5);

            int rbtnid6 = rg6.getCheckedRadioButtonId();
            rb6 = findViewById(rbtnid6);

            int rbtnid7 = rg7.getCheckedRadioButtonId();
            rb7 = findViewById(rbtnid7);

            int rbtnid8 = rg8.getCheckedRadioButtonId();
            rb8 = findViewById(rbtnid8);

            int rbtnid9 = rg9.getCheckedRadioButtonId();
            rb9 = findViewById(rbtnid9);

            int rbtnid10 = rg10.getCheckedRadioButtonId();
            rb10 = findViewById(rbtnid10);


            if (rb1.getText().toString().equals("D. China")) {

                marks += 1;

            }


            if (rb2.getText().toString().equals("B. Name of the disease")) {


                marks += 1;
            }

            if (rb3.getText().toString().equals("A. SARS-CoV-2")) {


                marks += 1;
            }

            if (rb4.getText().toString().equals("D. Wash with soap and water and scrub at least for 20 seconds")) {


                marks += 1;
            }

            if (rb5.getText().toString().equals("A. Physical distancing minimum 1 meter")) {

                marks += 1;
            }

            if (rb6.getText().toString().equals("D. All the above")) {


                marks += 1;
            }

            if (rb7.getText().toString().equals("D. All the above")) {


                marks += 1;
            }

            if (rb8.getText().toString().equals("C. Both 1 and 2")) {


                marks += 1;
            }

            if (rb9.getText().toString().equals("D. All the above")) {


                marks += 1;
            }
            if (rb10.getText().toString().equals("A. Plasma Therapy")) {


                marks += 1;
            }


            Toast.makeText(this, "***** YOUR SCORE: " + marks+"/10 *****", Toast.LENGTH_LONG).show();

            if(marks==10)
            {
              img.setVisibility(View.VISIBLE);
              img.animate().alpha(1f).rotation(720f).translationYBy(-1000).setDuration(2000);

                MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.cheering);
                mediaPlayer.start();
                btnresult.setVisibility(View.GONE);
            }


        } catch (Exception e)
        {
            Toast.makeText(this, "Please Attept All Questions", Toast.LENGTH_LONG).show();
        }

    }

}