package com.prantomondal.loginsignupfb;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText emailID;
    EditText PasswordT;
    Button signUpBtn;
    Button askLoginBtn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailID = findViewById(R.id.emailText);
        PasswordT = findViewById(R.id.passwordText);
        signUpBtn = findViewById(R.id.signupBtn);
        askLoginBtn = findViewById(R.id.askLogin);


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailID.getText().toString();
                String password = PasswordT.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();

                if(email.isEmpty()){
                    emailID.setError("Please Enter Your Email ID");
                    emailID.requestFocus();
                }else if(password.isEmpty()){
                    PasswordT.setError("Please Enter Your Password");
                    PasswordT.requestFocus();
                }else if(!email.isEmpty() && !password.isEmpty()){
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Signup failed", Toast.LENGTH_SHORT).show();
                            }else{
                                startActivity(new Intent(MainActivity.this,HomeActivity.class));

                            }

                        }
                    });

                }

            }
        });

    }
}