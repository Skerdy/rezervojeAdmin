package ss.com.bannerslider.viewholder;

import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import ss.com.bannerslider.Slider;

public class SlideViewHolder extends RecyclerView.ViewHolder {

    public View slide;

    public SlideViewHolder(View itemView) {
        super(itemView);
        this.slide =  itemView;
    }
}
