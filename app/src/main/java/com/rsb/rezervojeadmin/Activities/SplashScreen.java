package com.rsb.rezervojeadmin.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.viewanimator.ViewAnimator;
import com.rsb.rezervojeadmin.R;
import com.rsb.rezervojeadmin.TutorialActivity;

public class SplashScreen extends AppCompatActivity {
    private ImageView barberLogo;
    private TextView barberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        barberLogo = findViewById(R.id.barber_logo);
        barberTextView = findViewById(R.id.barber_textview);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                barberLogo.setVisibility(View.VISIBLE);
                barberTextView.setVisibility(View.VISIBLE);
                ViewAnimator
                        .animate(barberLogo)
                        .translationY(-1000, 0)
                        .alpha(0,1)
                        .andAnimate(barberTextView)
                        .dp().translationX(-20, 0)
                        .decelerate()
                        .duration(2000)
                        .thenAnimate(barberLogo)
                        .scale(1f, 0.5f, 1f)
                        .accelerate()
                        .duration(1000)
                        .start();
            }
        },1000);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, LoginRegisterActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, 3000);

    }
}
