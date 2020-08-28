package com.example.udemy22haikerswatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    LocationManager locationManager;
    LocationListener locationListener;

    public  void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }}
    }

    public void updateLocation(Location location)
    {
        Log.i("Location", String.valueOf(location));

        double s1 = location.getLatitude();
        tv1.setText("Latitude : " + s1);



        double s2 = location.getLongitude();
        tv2.setText("Longitude : " + s2);



        double s3 = location.getAccuracy();
        tv3.setText("Accuracy : " + s3);


        double s4 = location.getAltitude();
        tv4.setText("Altitude : " + s4);




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.textView1);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView4);
        tv5=findViewById(R.id.textView);


        locationManager= (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                updateLocation(location);


                Geocoder geocoder= new Geocoder(MainActivity.this,Locale.getDefault());

                try {
                    List<Address> list= geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(list.get(0)!= null && list.size()>0)
                    {
                        String d = list.get(0).getCountryName();
                        tv5.setText("Country : "+d);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION},1);

        }



else {locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

Location location= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            updateLocation(location);
}




    }
}