package com.assignment_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Dialog_ChangeColour extends AppCompatActivity {

    ListView lv;
    int c;
    Spinner spinColor;
    LinearLayout background;


    ArrayList<String> l = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_change_colour);

        spinColor = (Spinner) findViewById(R.id.spinColors);
        background = (LinearLayout) findViewById(R.id.background);

        l.add("Red");
        l.add("Cyan");
        l.add("Blue");
        l.add("DarkBlue");
        l.add("LightBlue");
        l.add("Purple");
        l.add("yellow");
        l.add("Lime");
        l.add("Magenta");
        l.add("Pink");

        ArrayAdapter ad = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, l);
        spinColor.setAdapter(ad);

        spinColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected_color = spinColor.getItemAtPosition(i).toString();

                TextView selected_item = (TextView) view;
                selected_item.setTextSize(40);
                selected_item.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                selected_item.setBackgroundColor(getResources().getColor(R.color.white));
                String name;
                switch (selected_color) {
                    case "Red":
                        background.setBackgroundColor(getResources().getColor(R.color.Red));
                        selected_item.setTextColor(getResources().getColor(R.color.Red));
                        break;
                    case "Cyan":
                        background.setBackgroundColor(getResources().getColor(R.color.Cyan));
                        selected_item.setTextColor(getResources().getColor(R.color.Cyan));
                        break;
                    case "White":
                        background.setBackgroundColor(getResources().getColor(R.color.white));
                        selected_item.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case "DarkBlue":
                        background.setBackgroundColor(getResources().getColor(R.color.DarkBlue));
                        selected_item.setTextColor(getResources().getColor(R.color.DarkBlue));
                        break;
                    case "Blue":
                        background.setBackgroundColor(getResources().getColor(R.color.Blue));
                        selected_item.setTextColor(getResources().getColor(R.color.Blue));
                        break;
                    case "LightBlue":
                        background.setBackgroundColor(getResources().getColor(R.color.LightBlue));
                        selected_item.setTextColor(getResources().getColor(R.color.LightBlue));
                        break;
                    case "Pink":
                        background.setBackgroundColor(getResources().getColor(R.color.Pink));
                        selected_item.setTextColor(getResources().getColor(R.color.Pink));
                        break;
                    case "Magenta":
                        background.setBackgroundColor(getResources().getColor(R.color.Magenta));
                        selected_item.setTextColor(getResources().getColor(R.color.Magenta));
                        break;
                    case "Lime":
                        background.setBackgroundColor(getResources().getColor(R.color.Lime));
                        selected_item.setTextColor(getResources().getColor(R.color.Lime));
                        break;
                    case "Yellow":
                        background.setBackgroundColor(getResources().getColor(R.color.Yellow));
                        selected_item.setTextColor(getResources().getColor(R.color.Yellow));
                        break;
                    case "Purple":
                        background.setBackgroundColor(getResources().getColor(R.color.Purple));
                        selected_item.setTextColor(getResources().getColor(R.color.Purple));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}