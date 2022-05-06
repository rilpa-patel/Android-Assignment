package com.assignment_app;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FregmentAddepter extends FragmentPagerAdapter {

    private Context c;
    int tabCount;

    public FregmentAddepter(Context C, @NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.c = c;
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Chat();
            case 1:
                return new Dialog();
            case 2:
                return new Trip_Survey_List();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
