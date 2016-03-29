package com.example.esteban.legalmovil;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Esteban on 22/03/2016.
 */
public class Adapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public Adapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

}
