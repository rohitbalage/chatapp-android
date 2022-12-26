package com.rrbofficial.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {


        private CircleImageView imageViewCircle;
        private TextInputEditText editTextEmailSignup, editTextPasswordSignup, editTextUserNameSingup;
        private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        imageViewCircle = findViewById(R.id.ImageViewCircle);
        editTextEmailSignup= findViewById(R.id.editTextEmail);
        editTextPasswordSignup= findViewById(R.id.editTextPassword);
        editTextUserNameSingup= findViewById(R.id.editTextUsername);
        buttonRegister = findViewById(R.id.buttonRegister);

    }
}