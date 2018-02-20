package com.example.simonhsieh.ddcharactersheet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

/**
 * Created by simonhsieh on 2/19/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }
}