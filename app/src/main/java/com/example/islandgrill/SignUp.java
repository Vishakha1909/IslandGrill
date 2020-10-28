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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    EditText iemail,ipassword,name,number;
    Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        iemail = findViewById(R.id.addEmail);
        ipassword = findViewById(R.id.addPass);
        name = findViewById(R.id.addName);
        number = findViewById(R.id.addPhone);
        reg = findViewById(R.id.regbutton);

        if(mAuth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = iemail.getText().toString().trim();
                String pw = ipassword.getText().toString().trim();

                if(TextUtils.isEmpty(em))
                {
                    iemail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(pw))
                {
                    ipassword.setError("Password is required");
                    return;
                }

                if(pw.length() < 8)
                {
                    ipassword.setError("Password should be longer than 8 characters");
                }

                mAuth.createUserWithEmailAndPassword(em, pw)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(SignUp.this,"User Created!",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Login.class));
                                } else {
                                    // If sign in fails, display a message to the user.
                                    FirebaseAuthException authException = (FirebaseAuthException) task.getException();
                                    Toast.makeText(SignUp.this, "ERROR " + authException.getMessage(),
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


}