package com.example.transactiontrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements OnChartValueSelectedListener{
float totalcredit,totaldebit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        PieChart pieChart = (PieChart) findViewById(R.id.piechart);


        Intent intent=getIntent();
        totalcredit=intent.getFloatExtra("TotalCredit",0);
        totaldebit=intent.getFloatExtra("TotalDebit",0);
        Log.e("main",""+totalcredit+" "+totaldebit);
        Toast.makeText(this, "Total credit:"+totalcredit +"  Total debit:"+totaldebit, Toast.LENGTH_SHORT).show();

        ArrayList<Entry> yvalues = new ArrayList<Entry>();

        yvalues.add(new Entry(437000, 0)); // have to put totalcredit in place of value
        yvalues.add(new Entry(305200, 1)); // have to put totaldebit in place of value


        PieDataSet dataSet = new PieDataSet(yvalues, "Expense and Income Results");

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("Total Expensive");
        xVals.add("Total Income");


        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        pieChart.setDescription("This Pie Chart shows the information about your Total Expensive and Total Income");
        pieChart.setCenterText("RESULT");
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(25f);
        pieChart.setHoleRadius(25f);

        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        data.setValueTextSize(18f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTextColor(Color.BLACK);
        pieChart.setOnChartValueSelectedListener(this);

        pieChart.animateXY(1400, 1400);
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

        if (e == null)
            return;
        Log.i("VALUE SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

}