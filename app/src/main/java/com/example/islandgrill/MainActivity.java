package com.example.islandgrill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    public void login_fun(View view)
    {
        Button button =  findViewById(R.id.loginbutton);
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void signup(View view)
    {
        Button button =  findViewById(R.id.signupbutton);
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }

    Animation rtol,alphaAppear;
    ImageView t,l1,l2,l3,l4,l5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.trunk);
        l1 = findViewById(R.id.leaf1);
        l2 = findViewById(R.id.leaf2);
        l3 = findViewById(R.id.leaf3);
        l4 = findViewById(R.id.leaf4);
        l5 = findViewById(R.id.leaf5);

        rtol = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        alphaAppear = AnimationUtils.loadAnimation(this,R.anim.alphaappear);

        t.startAnimation(rtol);
        l1.startAnimation(alphaAppear);
        l2.startAnimation(alphaAppear);
        l3.startAnimation(alphaAppear);
        l4.startAnimation(alphaAppear);
        l5.startAnimation(alphaAppear);
    }
}