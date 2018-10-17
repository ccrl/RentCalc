package com.sample.projects.myrentcalculator.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/9/18.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    //region VARIABLES
    private List<Fragment> fragmentList;
    private List<String> stringList;
    //endregion

    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        stringList = new ArrayList<>();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        stringList.add(title);
    }


    //region GETTERS AND SETTERS
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
    //endregion
}
