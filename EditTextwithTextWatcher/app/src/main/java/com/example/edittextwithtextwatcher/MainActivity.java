package com.example.edittextwithtextwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   ListView lv;
   EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed=findViewById(R.id.editText);
        lv=findViewById(R.id.listview);
        String prod[]= {"ayur","realme","oriflame","amazon","flipkart","acer"};
        @SuppressLint("ResourceType") final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.id.listview,R.id.editText,prod);

        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this,"before text change",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                arrayAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Toast.makeText(MainActivity.this,"after text change",Toast.LENGTH_LONG).show();
            }
        });
    }
}
