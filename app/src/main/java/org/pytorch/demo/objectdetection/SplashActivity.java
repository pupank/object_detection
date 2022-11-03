package org.pytorch.demo.objectdetection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //menghilangkan toolbar
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sp = getSharedPreferences("kaganga",MODE_PRIVATE);
                move(sp);
            }
        }, 3000);
    }

    private void move(SharedPreferences sp) {
//        Boolean first = sp.getBoolean("first",true);
        Boolean first = true;
        if (first){
            sp.edit().putBoolean("first",false).apply();
            startActivity(new Intent(SplashActivity.this,BerandaActivity.class));
        }
        else{
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }
    }
}