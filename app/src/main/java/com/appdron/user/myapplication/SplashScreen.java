package com.appdron.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity


                try {

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);


                    overridePendingTransition(R.animator.fade_out, R.animator.fade_in);

                    startActivity(i);


                } catch (Exception e) {


                }


            }
        }, SPLASH_TIME_OUT);




    }
}
