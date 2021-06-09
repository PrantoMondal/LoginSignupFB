package com.prantomondal.loginsignupfb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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



    }
}