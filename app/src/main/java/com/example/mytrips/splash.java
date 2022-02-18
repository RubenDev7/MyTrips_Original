package com.example.mytrips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Splash);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences login = getSharedPreferences(getString(R.string.preferencia), Context.MODE_PRIVATE);
        boolean inicio = login.getBoolean("logueado",false);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (inicio) {
                    Intent i = new Intent(splash.this,MainActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(splash.this,login.class);
                    startActivity(i);
                }


                finish();
            }
        },1250);

    }
}