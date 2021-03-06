package com.rsb.rezervojeadmin.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rsb.rezervojeadmin.Fragments.WelcomeFragment;
import com.rsb.rezervojeadmin.PicassoImageLoadingService;
import com.rsb.rezervojeadmin.R;

import ss.com.bannerslider.Slider;

public class LoginRegisterActivity extends AppCompatActivity {

    //fragmentPlaceHolder
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        Slider.init(new PicassoImageLoadingService(this));
        initLoginFragment();
    }

    private void initLoginFragment(){
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        fragmentTransaction.replace(R.id.fragmentPlaceHolder, welcomeFragment,"login");
        fragmentTransaction.commitAllowingStateLoss();
    }
}
