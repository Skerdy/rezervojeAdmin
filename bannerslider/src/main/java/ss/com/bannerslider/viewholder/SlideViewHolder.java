package ss.com.bannerslider.viewholder;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ss.com.bannerslider.R;
import ss.com.bannerslider.Slider;

public class SlideViewHolder extends RecyclerView.ViewHolder {

    public View slide;
    private ViewGroup viewGroup;
    private ImageView imageView;
    private TextView textView;

    public SlideViewHolder(View itemView, ViewGroup viewGroup) {
        super(itemView);
        this.slide =  itemView;
        this.viewGroup = viewGroup;
        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
    }

    public void setText(String text){
        this.textView.setText(text);
    }

    public void setImageResource(Drawable image){
        this.imageView.setImageDrawable(image);
    }


    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public void setViewGroup(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }
}
