package com.assignment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {

    EditText username, emailid, name, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.username);
        emailid = (EditText) findViewById(R.id.mailid);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.number);
        password = (EditText) findViewById(R.id.password);
    }

    public void Reset(View view) {
        username.setText("");
        emailid.setText("");
        name.setText("");
        phone.setText("");
        password.setText("");

    }

    @SuppressLint("Range")
    public void submit(View view) {
        String strUsername, strEmailid, strName, strPhone, strPassword;

        strUsername = username.getText().toString();
        strEmailid = emailid.getText().toString();
        strName = name.getText().toString();
        strPhone = phone.getText().toString();
        strPassword = password.getText().toString();

        boolean noError = true;


        final Pattern name = Pattern.compile("^[A-Za-z]*$");
        final Pattern uname = Pattern.compile("^([A-Za-z]*)$");
        final Pattern email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        final Pattern phonenumber = Pattern.compile("^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?");
        final Pattern password = Pattern.compile("[a-zA-Z0-9\\_\\@\\#\\$]{8,24}");

        Matcher usernamematcher = uname.matcher(strUsername);
        Matcher emailmematcher = email.matcher(strEmailid);
        Matcher namematcher = name.matcher(strName);
        Matcher phonematcher = phonenumber.matcher(strPhone);
        Matcher passwordmatcher = password.matcher(strPassword);


        if(!usernamematcher.find())
        {
            Toast.makeText(this, "Invalid username!", Toast.LENGTH_SHORT).show();
            noError = false;
            Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
        }
        else if(!namematcher.find())
        {
            Toast.makeText(this, "Invalid name", Toast.LENGTH_SHORT).show();
            noError = false;
            Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
        }

        else if(!emailmematcher.find())
        {
            Toast.makeText(this, "Invalid Email id", Toast.LENGTH_SHORT).show();
            noError = false;
            Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
        }
        else if(!phonematcher.find())
        {
            Toast.makeText(this, "Invalid Email id", Toast.LENGTH_SHORT).show();
            noError = false;
            Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
        }
        else if(!passwordmatcher.find())
        {
            Toast.makeText(this, "Password Must Be Of 8 to 24 Characters, Must Contain One Capital, One Small Alphabet, And At least One Number.", Toast.LENGTH_SHORT).show();
            noError = false;
            Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
        }

        if(noError)
        {
            DatabaseHelper db = new DatabaseHelper(this);
            ContentValues data = new ContentValues();
            data.put("name", strName);
            data.put("username", strUsername);
            data.put("email", strEmailid);
            data.put("password", strPassword);
            data.put("phone_number", strPhone);

            if (db.createRecord(DatabaseHelper.table_student,data) > 0) {
                Cursor c = db.ReadRecord(DatabaseHelper.table_student,"*", "username IS '"+this.username.getText().toString()+"'", "1");

                if (c.moveToFirst()) {

                    Toast.makeText(this, "Registration has been successfully completed.", Toast.LENGTH_SHORT).show();

                    SharedPreferences sp = getSharedPreferences("userlogin", MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putString("user_id", c.getString(c.getColumnIndex("id")).toString());
                    ed.putString("session_start_at", new Date().toString());
                    ed.commit();
                    startActivity(new Intent(this, Home.class));
                    finish();
                } else {
                    Toast.makeText(this, "Unable to retrieve the registration details at the moment. Please try again after some time.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

        }

    }
}