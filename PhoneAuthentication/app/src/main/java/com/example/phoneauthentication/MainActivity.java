package com.example.phoneauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
Button bt1,bt2,bt3;
TextView tv1;
EditText ed1,ed2;
FirebaseAuth fAuth;
String codesent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= findViewById(R.id.btn1);
        bt2= findViewById(R.id.btn2);
        bt3= findViewById(R.id.btn3);
        tv1= findViewById(R.id.tv1);
        ed1= findViewById(R.id.ed1);
        ed2= findViewById(R.id.ed2);
        fAuth=FirebaseAuth.getInstance();
        sendVerificationCode();

    }
    public void onBtnClick1(View v)
    {  String phone= ed1.getText().toString();
        if(phone.length()!=10)
        { ed1.setError("Please Enter 10 digits");
        }
        else if(phone.isEmpty())
        { ed1.setError("Field is empty");
        }
        else
        { sendVerificationCode();

        }}

        private void sendVerificationCode()
        { String phone=ed1.getText().toString();
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phone,        // Phone number to verify
                    60,                 // Timeout duration
                    TimeUnit.SECONDS,   // Unit of timeout
                    this,               // Activity (for callback binding)
                    mCallbacks);

        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                codesent=s;
            }

            @Override


            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

            }

};
    public void onBtnClick2(View v)
    {   String code= ed2.getText().toString();
        PhoneAuthCredential credentials= PhoneAuthProvider.getCredential(codesent, code);
        signInWithPhoneAuthCredential(credentials);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        fAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"login suceessful",Toast.LENGTH_LONG);
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(MainActivity.this,"invalid otp",Toast.LENGTH_LONG);
                            }}
                        }
                    });

    }
}
