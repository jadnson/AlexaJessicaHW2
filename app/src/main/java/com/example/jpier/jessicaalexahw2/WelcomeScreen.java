package com.example.jpier.jessicaalexahw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeScreen extends Activity implements View.OnClickListener {

    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogin;
    Button buttonRegister;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        mAuth = FirebaseAuth.getInstance();
        
        buttonLogin.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v == buttonLogin){

            mAuth.signInWithEmailAndPassword(editTextUsername.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(WelcomeScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();

                                Intent intentHome = new Intent(WelcomeScreen.this, HomeScreen.class);
                                startActivity(intentHome);

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(WelcomeScreen.this, "Access Denied", Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });
        }else if (v == buttonRegister) {

            mAuth.createUserWithEmailAndPassword(editTextUsername.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(WelcomeScreen.this, "Welcome to the App", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();


                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(WelcomeScreen.this, "Access Denied", Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });

        }
    }
}
