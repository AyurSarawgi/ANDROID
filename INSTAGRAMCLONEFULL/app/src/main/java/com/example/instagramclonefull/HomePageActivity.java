package com.example.instagramclonefull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePageActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    Toolbar toolbar;
    ImageView camera,igtv,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activityhomepage);

        toolbar=findViewById(R.id.toolbar);
        camera=toolbar.findViewById(R.id.camera);
        igtv=toolbar.findViewById(R.id.igtv);
        message=toolbar.findViewById(R.id.message);



        igtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePageActivity.this, "Instagram TV", Toast.LENGTH_SHORT).show();
            }
        });


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePageActivity.this, "Messages", Toast.LENGTH_SHORT).show();
            }
        });


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePageActivity.this, "Camera Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentholder,new HomeFragment()).addToBackStack(null).commit();
        bottomNavigation = findViewById(R.id.bottomnavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager= getSupportFragmentManager();
                if(item.getItemId()==R.id.homenavigation)
                {

                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new HomeFragment()).addToBackStack(null).commit();

                }
                if(item.getItemId()==R.id.searchnavigation)
                {
                    Log.i("fragment","Home Fragment start");
                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new SearchFragment()).addToBackStack(null).commit();

                }
                if(item.getItemId()==R.id.plusnavigation)
                {
                    Log.i("fragment","Home Fragment start");
                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new PlusFragment()).addToBackStack(null).commit();

                }
                if(item.getItemId()==R.id.activitynavigation)
                {
                    Log.i("fragment","Home Fragment start");
                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new ActivityFragment()).addToBackStack(null).commit();

                }
                if(item.getItemId()==R.id.profilenavigation)
                {
                    Log.i("fragment","Home Fragment start");
                    fragmentManager.beginTransaction().replace(R.id.fragmentholder,new ProfileFragment()).addToBackStack(null).commit();

                }


                return false;
            }
        });

    }


}














