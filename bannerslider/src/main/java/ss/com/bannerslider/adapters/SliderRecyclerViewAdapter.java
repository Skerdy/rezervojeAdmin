package ss.com.bannerslider.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ss.com.bannerslider.R;
import ss.com.bannerslider.SlideType;
import ss.com.bannerslider.event.OnSlideClickListener;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;
import ss.com.bannerslider.viewholder.SlideViewHolder;


/**
 * @author S.Shahini
 * @since 12/16/17
 */
public class SliderRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ViewGroup.LayoutParams imageViewLayoutParams;
    private OnSlideClickListener onSlideClickListener;
    private SliderAdapter sliderAdapter;
    private SliderLayoutAdapter sliderLayoutAdapter;
    private boolean loop;
    private View.OnTouchListener itemOnTouchListener;
    private PositionController positionController;

    public SliderRecyclerViewAdapter(SliderLayoutAdapter sliderLayoutAdapter, SliderAdapter iSliderAdapter, boolean loop, ViewGroup.LayoutParams imageViewLayoutParams, View.OnTouchListener itemOnTouchListener, PositionController positionController) {
        this.sliderAdapter = iSliderAdapter;
        this.imageViewLayoutParams = imageViewLayoutParams;
        this.loop = loop;
        this.itemOnTouchListener = itemOnTouchListener;
        this.positionController = positionController;
        this.sliderLayoutAdapter = sliderLayoutAdapter;
    }

    public void setOnSlideClickListener(OnSlideClickListener onSlideClickListener) {
        this.onSlideClickListener = onSlideClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == SlideType.IMAGE.getValue()) {
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(imageViewLayoutParams);
            imageView.setAdjustViewBounds(true);
            LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new SlideViewHolder(li.inflate(R.layout.layout_1,parent, false), parent);
        }
       else if(viewType == SlideType.SLIDER.getValue()){
            return new SlideViewHolder(View.inflate(parent.getContext(), R.layout.login_background_one,parent),parent);
        }
        else {

            return null;
        }


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (!loop) {
            if(sliderAdapter!=null)
            sliderAdapter.onBindImageSlide(position, (ImageSlideViewHolder) holder);

            else {
                sliderLayoutAdapter.onBindSlide(position,(SlideViewHolder) holder);
            }

        } else {
            if (position == 0) {
                if(sliderAdapter!=null)
                sliderAdapter.onBindImageSlide(positionController.getLastUserSlidePosition(), (ImageSlideViewHolder) holder);
                else{
                    sliderLayoutAdapter.onBindSlide(positionController.getLastUserSlidePosition(),(SlideViewHolder) holder);
                }
            } else if (position == getItemCount() - 1) {
                if(sliderAdapter!=null)
                sliderAdapter.onBindImageSlide(positionController.getFirstUserSlidePosition(), (ImageSlideViewHolder) holder);
                else{
                    sliderLayoutAdapter.onBindSlide(positionController.getFirstUserSlidePosition(), (SlideViewHolder) holder);
                }
            } else {
                if(sliderAdapter!=null)
                sliderAdapter.onBindImageSlide(position - 1, (ImageSlideViewHolder) holder);
                else{
                    sliderLayoutAdapter.onBindSlide(position-1, (SlideViewHolder) holder);
                }
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSlideClickListener != null)
                    onSlideClickListener.onSlideClick(positionController.getUserSlidePosition(holder.getAdapterPosition()));
            }
        });

        holder.itemView.setOnTouchListener(itemOnTouchListener);
    }

    @Override
    public int getItemCount() {
        if(sliderAdapter!=null)
        return sliderAdapter.getItemCount() + (loop ? 2 : 0);
        else{
            return sliderLayoutAdapter.getItemCount()+(loop?2:0);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }


}
