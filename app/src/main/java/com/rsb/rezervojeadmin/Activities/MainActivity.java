package com.rsb.rezervojeadmin.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.rsb.rezervojeadmin.R;
import com.rsb.rezervojeadmin.Retrofit.RetrofitClient;
import com.rsb.rezervojeadmin.Utils.MySharedPref;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Drawer result;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private MySharedPref mySharedPref;
    private String memberEmail;
    private AccountHeader headerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setTitle("Home");
        setTitle("Home");
        setupNavigationDrawer();
    }


    private void setupNavigationDrawer(){
        PrimaryDrawerItem appointments = new PrimaryDrawerItem().withIdentifier(0).withName("Appointments").withIcon(R.drawable.ic_icons_appointments_normal).withSelectedIcon(R.drawable.ic_icons_appointments_clicked);


        ExpandableDrawerItem expandableDrawerItem = new ExpandableDrawerItem().withName("Business Profile").withIcon(R.drawable.ic_icons_bussiness_profile_normal).withSelectedIcon(R.drawable.ic_icons_bussiness_profile_clicked).withIdentifier(19).withSelectable(true).withSubItems(
                new SecondaryDrawerItem().withName("Company Info").withLevel(2).withIcon(R.drawable.ic_icons_company_info_normal).withSelectedIcon(R.drawable.ic_icons_company_info_clicked).withIdentifier(2002),
                new SecondaryDrawerItem().withName("Categories").withLevel(2).withIcon(R.drawable.ic_icons_category_normal).withSelectedIcon(R.drawable.ic_icons_category_clicked).withIdentifier(2003),
                new SecondaryDrawerItem().withName("Gallery").withLevel(2).withIcon(R.drawable.ic_icons_photos_normal).withSelectedIcon(R.drawable.ic_icons_photos_clicked).withIdentifier(2002),
                new SecondaryDrawerItem().withName("Working Hours").withLevel(2).withIcon(R.drawable.ic_icons_working_hours_normal).withSelectedIcon(R.drawable.ic_icons_working_hours_clicked).withIdentifier(2003),
                new SecondaryDrawerItem().withName("Staff").withLevel(2).withIcon(R.drawable.ic_icons_staff_normal).withSelectedIcon(R.drawable.ic_icons_staff_clicked).withIdentifier(2002),
                new SecondaryDrawerItem().withName("Services").withLevel(2).withIcon(R.drawable.ic_icons_services_normal).withSelectedIcon(R.drawable.ic_icons_services_clicked).withIdentifier(2003),
                new SecondaryDrawerItem().withName("Products").withLevel(2).withIcon(R.drawable.ic_icons_products_normal).withSelectedIcon(R.drawable.ic_icons_products_clicked).withIdentifier(2003)
        );
        PrimaryDrawerItem reviews = new PrimaryDrawerItem().withIdentifier(1).withName("Reviews & Ratings").withIcon(R.drawable.ic_icons_reviews_normal).withSelectedIcon(R.drawable.ic_icons_reviews_clicked);
        PrimaryDrawerItem statistics = new PrimaryDrawerItem().withIdentifier(3).withName("Statistics").withIcon(R.drawable.ic_icons_statistics_normal).withSelectedIcon(R.drawable.ic_icons_statistics_clicked);
        SecondaryDrawerItem logout = new SecondaryDrawerItem().withIdentifier(4).withName("Logout").withIcon(R.drawable.ic_icons_logout_normal);
        SecondaryDrawerItem settings = new SecondaryDrawerItem().withIdentifier(5).withName("Settings").withIcon(R.drawable.ic_icons_settings_normal).withSelectedIcon(R.drawable.ic_icons_settings_clicked);


        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.nav_header)
                .addProfiles(new ProfileDrawerItem().withName("Skerdjan Gurabardhi").withEmail("Skerdi@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile)))
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();


        result= new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        appointments, expandableDrawerItem ,reviews,statistics,
                        new DividerDrawerItem(),
                        settings, logout
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, final int position, IDrawerItem drawerItem) {

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                switch (position){
                                    case 1:

                                        break;
                                    case 2:

                                        break;
                                    case 3:

                                        break;
                                    case 4:

                                        break;
                                    case 5 :
                                        break;
                                    case 7 :
                                        break;
                                    case -1:
                                        break;
                                }
                            }
                        }, 200);
                        Log.d("position", " "+position);
                        return false;
                    }
                }).withAccountHeader(headerResult)
                .build();
    }
}
