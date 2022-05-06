package com.assignment_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {

    TabLayout menu;
    ViewPager page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        menu = (TabLayout)findViewById(R.id.menu);
        page = (ViewPager)findViewById(R.id.page);

        menu.addTab(menu.newTab().setText("Chet"));
        menu.addTab(menu.newTab().setText("Dialog"));
        menu.addTab(menu.newTab().setText("Trip Survey List"));

        FregmentAddepter f = new FregmentAddepter(this,getSupportFragmentManager(),3);

        page.setAdapter(f);

        page.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(menu));

        menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle().toString().equals("logout")){
            SharedPreferences sharedPreferences = getSharedPreferences("userlogin", MODE_PRIVATE);
            SharedPreferences.Editor sedit = sharedPreferences.edit();
            sedit.clear();
            sedit.commit();
            Intent i = new Intent(Home.this, Login.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(this, Update_Profile.class);
            startActivity(i);
        }
        return true;
    }

}