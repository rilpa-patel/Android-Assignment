package com.assignment_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Period;

public class Dialog_Agecalculation extends AppCompatActivity {

    EditText date;
    TextView displayAge;
    Button pickDob, calculateAge;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_agecalculation);

        date = (EditText) findViewById(R.id.edtDate);
        displayAge = (TextView) findViewById(R.id.txtAge);

        pickDob = (Button) findViewById(R.id.btnPickDate);
        calculateAge = (Button) findViewById(R.id.btnCalculate);

        day = 1;
        month = 1;
        year = 2001;

        pickDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Dialog_Agecalculation.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        day = dayOfMonth;
                        month = month+1;
                        year = year;
                        date.setText(day+"/"+month+"/"+year);
                    }
                } , day, (month-1), year);
                datePickerDialog.show();


            }
        });
        calculateAge.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                displayAge.setText(getAge(year, month, day));
            }
        });



    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getAge(int year, int month, int dayOfMonth) {
        Period p =  Period.between(
                LocalDate.of(year, month, dayOfMonth),
                LocalDate.now()
        );
        return "Years: "+p.getYears()+" Month: "+p.getMonths()+" Days: "+p.getDays();
    }
}