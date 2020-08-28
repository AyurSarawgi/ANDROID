package com.example.instagramclonefull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class RegisterActivity extends AppCompatActivity {
    EditText edname,edemail,edpassword,cnfpass;
    TextView tvphone;
    Button btn,btn2;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    boolean Chkphone;
    String phone,Password,Email,Name,Chkemail;
    RegistrationDetails registrationDetails;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edname = findViewById(R.id.edname);
        edemail = findViewById(R.id.edemail);
        tvphone = findViewById(R.id.tvphone);
        edpassword = findViewById(R.id.edpassword);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.loginbtn);
        cnfpass = findViewById(R.id.edcpass);

        phone = getIntent().getStringExtra("Phone");
        tvphone.setText(phone);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("USERS");


        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





         Name= edname.getText().toString();
         Email=edemail.getText().toString();
         Password=edpassword.getText().toString();
        registrationDetails=new RegistrationDetails(Name,Email,Password,phone);




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Chkphone= snapshot.child(phone).child(phone).exists();



                if(Password.equals(cnfpass.getText().toString())){


                if(Chkphone)
                {
                    Toast.makeText(RegisterActivity.this, "Phone Already Registered, Use different Phone Number or Click LogIn", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                    databaseReference.child(phone).setValue(registrationDetails);

                }

            }else cnfpass.setError("Password not match");}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



       }});}}