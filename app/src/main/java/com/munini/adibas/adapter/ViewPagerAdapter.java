package com.munini.adibas.adapter;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.munini.adibas.CategoriesFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private Activity activity;

    public ViewPagerAdapter(@NonNull FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new CategoriesFragment(activity);
    }

    @Override
    public int getCount() {
        return 1;
    }
}
