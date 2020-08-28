package com.example.india2020crornatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class FacilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility);

        PDFView pdfdacility;

        pdfdacility=findViewById(R.id.pdffacility);

        pdfdacility.fromAsset("facility.pdf").load();
    }
}