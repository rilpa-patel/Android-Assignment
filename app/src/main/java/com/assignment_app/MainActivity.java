package com.assignment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        SharedPreferences sp = getSharedPreferences("userlogin", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sp.contains("user_id"))
                {
                    if(!sp.getString("user_id", "").toString().equals("")) {
                        intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                        finish();
                    }

                    else
                        Toast.makeText(MainActivity.this, "Session has not valid user.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }}, 4000);
    }
}