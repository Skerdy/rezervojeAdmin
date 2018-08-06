package com.rsb.rezervojeadmin.Adapters.ViewPagers;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rsb.rezervojeadmin.Fragments.CompanyInfoFragment;

import java.util.List;

public class CompanyInfoPagerAdapter extends FragmentStatePagerAdapter {

    private List<String> titles;
    private List<Fragment> fragments;

    public CompanyInfoPagerAdapter (FragmentManager fragmentManager, List<Fragment> fragments, List<String> titles){
        super(fragmentManager);
        this.fragments = fragments;
        this.titles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }
}
