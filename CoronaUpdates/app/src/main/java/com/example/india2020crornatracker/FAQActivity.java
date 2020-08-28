package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class FAQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_a_q);

        PDFView pdffaq;

        pdffaq=findViewById(R.id.pdffaq);

        pdffaq.fromAsset("FAQ.pdf").load();
    }
}