package com.example.islandgrill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    EditText email,password;
    Button loginb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        loginb = findViewById(R.id.login);

        if(mAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),Menu.class));
            finish();
        }

        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString().trim();
                String pw = password.getText().toString().trim();

                if(TextUtils.isEmpty(em))
                {
                    email.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(pw))
                {
                    password.setError("Password is required");
                    return;
                }

                if(pw.length() < 8)
                {
                    password.setError("Password should be longer than 8 characters");
                }

                mAuth.signInWithEmailAndPassword(em, pw)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Menu.class));

                                } else {
                                    // If sign in fails, display a message to the user.
                                    FirebaseAuthException authException = (FirebaseAuthException) task.getException();
                                    Toast.makeText(Login.this, "ERROR " + authException.getMessage(),
                                            Toast.LENGTH_SHORT).show();

                                    // ...
                                }

                                // ...
                            }
                        });

            }
        });


    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

}