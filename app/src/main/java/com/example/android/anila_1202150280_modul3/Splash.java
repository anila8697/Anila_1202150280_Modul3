package com.example.android.anila_1202150280_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 5000;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this,Login.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
                Toast.makeText(Splash.this,"ANILA SUKMA_1202150280",Toast.LENGTH_LONG).show();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}