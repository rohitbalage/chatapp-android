package com.rrbofficial.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MyLoginActivity extends AppCompatActivity {
        private TextInputEditText editTextEmail, editTextPassword;
        private Button buttonSignin, buttonSignup;
        private TextView textviewForget;

        FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);


        auth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignin = findViewById(R.id.buttonSingin);
        buttonSignup = findViewById(R.id.buttonSingup);
        textviewForget = findViewById(R.id.textViewForget);


        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
             if(!email.equals("") && !password.equals("")){
                    signin(email, password);
                } else {
                 Toast.makeText(MyLoginActivity.this, "Please enter an email and password", Toast.LENGTH_SHORT).show();
                }

            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyLoginActivity.this,SignUpActivity.class);
            }
        });

        textviewForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyLoginActivity.this, ForgetActivity.class);
            }
        });
    }

    public  void signin(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent intent = new Intent(MyLoginActivity.this, MainActivity.class);
                    Toast.makeText(MyLoginActivity.this, "Sign in is successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MyLoginActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}