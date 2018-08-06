package com.rsb.rezervojeadmin.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.rsb.rezervojeadmin.Activities.MainActivity;
import com.rsb.rezervojeadmin.Adapters.ViewPagers.CompanyInfoPagerAdapter;
import com.rsb.rezervojeadmin.R;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfoFragment extends Fragment {

    private MaterialViewPager materialViewPager;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private GeneralInfoFragment generalInfoFragment;
    private CompanyLocationFragment  locationFragment;
    private List<Fragment> fragments ;
    private List<String> titles;
    private CompanyInfoPagerAdapter companyInfoPagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        titles.add("General Info");
        titles.add("Location");
        generalInfoFragment= new GeneralInfoFragment();
        locationFragment = new CompanyLocationFragment();
        fragments.add(generalInfoFragment);
        fragments.add(locationFragment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_company_info,container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        materialViewPager = view.findViewById(R.id.materialViewPager);

        viewPager = materialViewPager.getViewPager();
        companyInfoPagerAdapter = new CompanyInfoPagerAdapter(getChildFragmentManager(), fragments , titles );
        viewPager.setAdapter(companyInfoPagerAdapter);

        //((MainActivity)getActivity()).setToolbarGone();

        ((MainActivity)getActivity()).updateDrawerToolbar(materialViewPager.getToolbar());
        //materialViewPager.setToolbar(((MainActivity)getActivity()).getToolbar());


      //  materialViewPager.getPagerTitleStrip().setTextColor(getResources().getColor(R.color.md_white_1000));
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());
        materialViewPager.getPagerTitleStrip().setTextColor(getResources().getColor(R.color.md_white_1000));

        materialViewPager.getViewPager().setOffscreenPageLimit(2);
        materialViewPager.setImageUrl("http://nebula.wsimg.com/b4adf88019b6ce878f4a0f548e153091?AccessKeyId=1AEB153493F70C64C02E&disposition=0&alloworigin=1", 150);
        // recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
       // recyclerView.setAdapter();
    }
}
