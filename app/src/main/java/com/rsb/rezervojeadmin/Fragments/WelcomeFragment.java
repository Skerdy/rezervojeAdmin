package com.rsb.rezervojeadmin.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rsb.rezervojeadmin.Activities.LoginActivity;
import com.rsb.rezervojeadmin.LayoutSliderAdapter;
import com.rsb.rezervojeadmin.MainSliderAdapter;
import com.rsb.rezervojeadmin.PicassoImageLoadingService;
import com.rsb.rezervojeadmin.R;

import ss.com.bannerslider.Slider;

public class WelcomeFragment extends Fragment {
    private Slider slider;
    private Button signInButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Slider.init(new PicassoImageLoadingService(getActivity()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_final, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViews(view);
        slider.setSliderLayoutAdapter(new LayoutSliderAdapter(getActivity()));
        slider.notifyDataSetChanged();
        slider.setLoopSlides(true);
        slider.setInterval(3000);

        //slider.setAdapter(new MainSliderAdapter());
    }

    private void setupViews(View v){
        slider = v.findViewById(R.id.banner_slider1);
        signInButton = v.findViewById(R.id.signInButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
