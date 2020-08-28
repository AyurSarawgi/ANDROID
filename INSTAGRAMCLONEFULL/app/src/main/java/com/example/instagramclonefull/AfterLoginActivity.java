package com.example.instagramclonefull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


public class AfterLoginActivity extends AppCompatActivity {

String phone;
TextView tvphone;
    String chkpassword;
EditText password;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        tvphone=findViewById(R.id.tvphone);
        btn=findViewById(R.id.loginbtn);
        phone=getIntent().getStringExtra("phone");
        tvphone.setText(phone);
        password=findViewById(R.id.editTextTextPassword);
    }

    public void onclickLoginInsta(View View)
    {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference= firebaseDatabase.getReference("USERS");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                chkpassword=String.valueOf(snapshot.child(phone).child("password").getValue());
if (chkpassword.equals(password.getText().toString()))
{
    Toast.makeText(AfterLoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

    Intent intent= new Intent(AfterLoginActivity.this,HomePageActivity.class);
    startActivity(intent);
}else {
    Toast.makeText(AfterLoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}