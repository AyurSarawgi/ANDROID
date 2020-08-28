package com.example.transactiontrial;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    TextView textView;
    static final int PERMISSION_REQUEST_READCONTACTS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView2);



        int checkpermission= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);

        if(checkpermission== PackageManager.PERMISSION_GRANTED)
        {startFragment();

        }else ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_SMS}, PERMISSION_REQUEST_READCONTACTS);

        //checking for the sms reading permission from user

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==PERMISSION_REQUEST_READCONTACTS)
        {
            startFragment();
        }else {
            Toast.makeText(this, "Can't fetch your sms details until you grant permission", Toast.LENGTH_SHORT).show();
        }

    }

      //requesting to give sms reading permission

    private void startFragment()
    {
        FragmentManager fragmentManager= getSupportFragmentManager(); //FragmentManager instance
        fragmentManager.beginTransaction().replace(R.id.fragmentholder,new FragmentCredit()).addToBackStack(null).commit(); // By default FragmentCredit will starts

        bottomNavigation = findViewById(R.id.bottomnavigation);
        // Creating and declaring bottom navigation with on click menu items
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                if(item.getItemId()==R.id.creditfragment)
                {
                    Log.i("fragment","Credit Fragment start");
                    textView.setText("Credit SMS");
                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new FragmentCredit()).addToBackStack(null).commit();

                    //starting FragmentCredit
                }
                if(item.getItemId()==R.id.debitfragment)
                {
                    Log.i("fragment","Debit Fragment start");
                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new FragmentDebit()).addToBackStack(null).commit();
                    textView.setText("Debit SMS");

                    //starting FragmentDebit
                }
                if(item.getItemId()==R.id.piechartactivity)
                {
                    Log.i("fragment","TransactionDetail Fragment start");
                   Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                   startActivity(intent);

                    //starting MainActivity2
                }
                return false;
            }


        });
    }
}
















