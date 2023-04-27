package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreenActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag",false); //default value (if user opens the app for first time.

                Intent iNext;

                if(check){ // true for loggedin user

                    iNext = new Intent(splashscreenActivity.this, HomeActivity.class);

                }else{  //false for logged out user

                    iNext = new Intent(splashscreenActivity.this,loginActivity.class);
                }
                startActivity(iNext);
                finish();
            }
        },2500);
    }
}