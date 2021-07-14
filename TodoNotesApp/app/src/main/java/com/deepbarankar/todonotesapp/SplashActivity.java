package com.deepbarankar.todonotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setupSharedPreferences();
        
        checkLoginStatus();
    }

    private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
    }

    private void checkLoginStatus() {
        //if user is logged in -> MyNotesActivity
        //else -> LoginActivity

        //SharedPreferences
        boolean isLoggedIn = sharedPreferences.getBoolean(PrefConstant.IS_LOGGED_IN, false); //key (Which will give the stored value), default value (if no key-value is set)
        Intent intent;
        if(isLoggedIn) {
            //MyNotesActivity
            intent = new Intent(this,MyNotesActivity.class);
        } else {
            //LoginActivity
            intent = new Intent(this,LoginActivity.class);
        }
        startActivity(intent);
    }
}