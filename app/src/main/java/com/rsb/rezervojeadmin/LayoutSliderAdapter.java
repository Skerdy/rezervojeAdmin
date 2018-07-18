package com.rsb.rezervojeadmin;

import android.content.Context;
import android.view.LayoutInflater;

import ss.com.bannerslider.adapters.SliderLayoutAdapter;
import ss.com.bannerslider.viewholder.SlideViewHolder;

public class LayoutSliderAdapter extends SliderLayoutAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public LayoutSliderAdapter (Context context){
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onBindSlide(int position, SlideViewHolder slideViewHolder) {
        switch (position) {
            case 0:
                slideViewHolder.setImageResource(context.getResources().getDrawable(R.drawable.ic_icons_welcome));
                slideViewHolder.setText("Mireseerdhet ne Rezervoje");
                break;
            case 1:
                slideViewHolder.setImageResource(context.getResources().getDrawable(R.drawable.ic_icons_login_cut_machine));
                slideViewHolder.setText("vrin vrin");
                break;
            case 2:
                slideViewHolder.setImageResource(context.getResources().getDrawable(R.drawable.ic_icons_welcome_booking));
                slideViewHolder.setText("rezervoje pra");
                break;
            case 3:
                slideViewHolder.setImageResource(context.getResources().getDrawable(R.drawable.ic_icons_login_lupe));
                slideViewHolder.setText("Kerkoni ndonje berber jqj");
                break;
            case 4:
                slideViewHolder.setImageResource(context.getResources().getDrawable(R.drawable.ic_icons_welcome_information));
                slideViewHolder.setText("Information");
                break;
            case 5:
                slideViewHolder.setImageResource(context.getResources().getDrawable(R.drawable.ic_icons_welcome_heart));
                slideViewHolder.setText("Me and Redi love you guys lawl");
                break;
        }

    }


}
