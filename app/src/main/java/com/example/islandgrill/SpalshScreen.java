package com.example.islandgrill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SpalshScreen extends AppCompatActivity
{
    Handler handler;
    TextView textView;
    ImageView top,bottom,logoimage;
    Animation fromTop,fromDown,logoAppear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        top=findViewById(R.id.bluetop);
        textView=findViewById(R.id.welcomeText);
        bottom = findViewById(R.id.sanddown);
        logoimage=findViewById(R.id.logo);

        fromTop= AnimationUtils.loadAnimation(this,R.anim.translatefromtop);
        fromDown = AnimationUtils.loadAnimation(this,R.anim.translatefromdown);
        logoAppear = AnimationUtils.loadAnimation(this,R.anim.alphaappear);

        top.startAnimation(fromTop);
        bottom.startAnimation(fromDown);
        textView.startAnimation(logoAppear);
        logoimage.startAnimation(logoAppear);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SpalshScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}