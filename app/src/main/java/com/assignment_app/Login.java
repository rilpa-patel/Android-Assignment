package com.assignment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Login extends AppCompatActivity {
    EditText userName, password ;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


    }


    public void ForgetPassword(View view) {
    }

    public void Signup(View view) {

            Intent i = new Intent(this, Signup.class);
            startActivity(i);


    }

    public void login(View view) {
        DatabaseHelper db = new DatabaseHelper(Login.this);
        Cursor c = db.ReadRecord(DatabaseHelper.table_student, "password", "username IS '"+userName.getText().toString()+"'", "1");
        if(c.moveToFirst())
        {
            if(c.getString(0).toString().equals(this.password.getText().toString()))
            {
                SharedPreferences sp = getSharedPreferences("userlogin", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                String user_id = null;
                Cursor c2 = db.ReadRecord(DatabaseHelper.table_student, "id", "username IS '"+userName.getText().toString()+"'", "1");
                if(c2.moveToFirst())
                    user_id = c2.getString(0).toString();
                else
                    Toast.makeText(Login.this, "Unable to verify login data. Please contact developer.", Toast.LENGTH_SHORT).show();
                if(!user_id.equals(null)) {
                    ed.putString("user_id", user_id);
                    ed.putString("session_start_at", new Date().toString());
                    ed.commit();
                }
                Intent i = new Intent(Login.this, Home.class);
                startActivity(i);
                finish();
            }
            else
                Toast.makeText(Login.this, "Password doesn't match.", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(Login.this, "Username doesn't match.", Toast.LENGTH_SHORT).show();

    }
}