package com.rrbofficial.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MyLoginActivity extends AppCompatActivity {
        private TextInputEditText editTextEmail, editTextPassword;
        private Button buttonSignin, buttonSignup;
        private TextView textviewForget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignin = findViewById(R.id.buttonSingin);
        buttonSignup = findViewById(R.id.buttonSingup);
        textviewForget = findViewById(R.id.textViewForget);
    }
}