package ss.com.bannerslider.adapters;

import ss.com.bannerslider.SlideType;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;
import ss.com.bannerslider.viewholder.SlideViewHolder;

public abstract class SliderLayoutAdapter  {

    public abstract int getItemCount();

    public final SlideType getSlideType(int position) {
        return SlideType.SLIDER;
    }

    public abstract void onBindSlide(int position, SlideViewHolder slideViewHolder);
}
