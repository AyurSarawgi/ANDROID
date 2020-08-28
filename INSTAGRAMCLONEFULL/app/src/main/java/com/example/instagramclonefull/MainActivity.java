package com.example.instagramclonefull;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText edphone,edotp;
    Button sendotpbtn,verifybtn;
    FirebaseAuth firebaseAuth;
    String phone,phonenum;
    String OTP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        edphone= findViewById(R.id.tvphone);
        edotp=findViewById(R.id.edotp);
        sendotpbtn= findViewById(R.id.sendotpbtn);
        verifybtn= findViewById(R.id.verifybtn);
        firebaseAuth=FirebaseAuth.getInstance();




    }

    public void onclicksendotp(View v)
    {   phone=edphone.getText().toString();
        phonenum="+91"+phone;


        if(phone=="")
        {
            edphone.setError("Phone number can't be empty");

        }
        else if(phone.length()!=10)
        {
          edphone.setError("Invalid number");
        }else {  phone=edphone.getText().toString();
            FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
            DatabaseReference databaseReference= firebaseDatabase.getReference("USERS");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    boolean chkphonenum= snapshot.child(phone).exists();

                    if(chkphonenum)
                    {
                        Toast.makeText(MainActivity.this, "You Already Have an Account with this number", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this,AfterLoginActivity.class);
                        intent.putExtra("phone",phone);
                        startActivity(intent);
                    }else {edotp.setVisibility(View.VISIBLE);
                    verifybtn.setVisibility(View.VISIBLE);
                    sendotpbtn.setVisibility(View.INVISIBLE);
                    requestotp(phonenum);}

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });










        }
    }


private  void requestotp(String phonenum)
{





    PhoneAuthProvider.getInstance().verifyPhoneNumber(phonenum, 90, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            OTP=s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(MainActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
        }
    });
}

public void onClickVerify(View V)
{




    if(edotp.getText().toString()=="" || edotp.getText().toString().length()<6)
{
    Toast.makeText(this, "Enter Valid OTP", Toast.LENGTH_SHORT).show();
}else {
    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(OTP, edotp.getText().toString());

    firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful())
            {



                Toast.makeText(MainActivity.this, "Phone Number Verified", Toast.LENGTH_SHORT).show();


                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                intent.putExtra("Phone",phone);
                startActivity(intent);




            }else Toast.makeText(MainActivity.this,"Login Failed : Invalid OTP ",Toast.LENGTH_SHORT).show();
        }
    });

}}


public  void onClickLogin(View V)
{    phone=edphone.getText().toString();
   if(phone.isEmpty())
   {edphone.setError("Enter Phone Number");}
   else{
    FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
    DatabaseReference databaseReference= firebaseDatabase.getReference("USERS");
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

            boolean chkphonenum= snapshot.child(phone).exists();

            if(chkphonenum)
            {
                Intent intent= new Intent(MainActivity.this,AfterLoginActivity.class);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }else Toast.makeText(MainActivity.this, "You Don't Have an Account with Given Number", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

}}
}