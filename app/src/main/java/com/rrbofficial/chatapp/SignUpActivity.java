package com.rrbofficial.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {


        private CircleImageView imageViewCircle;
        private TextInputEditText editTextEmailSignup, editTextPasswordSignup, editTextUserNameSingup;
        private Button buttonRegister;
        boolean imageControl = false;

        FirebaseAuth auth;
        FirebaseDatabase database;
        DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        imageViewCircle = findViewById(R.id.ImageViewCircle);
        editTextEmailSignup= findViewById(R.id.editTextEmail);
        editTextPasswordSignup= findViewById(R.id.editTextPassword);
        editTextUserNameSingup= findViewById(R.id.editTextUsername);
        buttonRegister = findViewById(R.id.buttonRegister);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        imageViewCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String email = editTextEmailSignup.getText().toString();
                    String password = editTextPasswordSignup.getText().toString();
                String userName = editTextUserNameSingup.getText().toString();

                if(!email.equals("") && password.equals("")&& !userName.equals(""))
                {
                    signup(email,password,userName);
                }
            }
        });


    }
    public  void imageChooser(){
        Intent intent = new Intent();
        intent.setType("images/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && requestCode == RESULT_OK && data!= null)
        {
          Uri imageUrl =  data.getData();
            Picasso.get().load(imageUrl).into(imageViewCircle);
            imageControl = true;
        }else {
            imageControl = false;
        }

    }

    public void signup (String email, String password, String userName){
    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful()){
                reference.child("Users").child(auth.getUid()).child("userName").setValue(userName);

                if(imageControl){

                }else {
                    reference.child("users").child(auth.getUid()).child("image").setValue("null");

                }
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                intent.putExtra("userName", userName);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(SignUpActivity.this, "There is problem", Toast.LENGTH_SHORT).show();
            }
        }
    });
    }
}

