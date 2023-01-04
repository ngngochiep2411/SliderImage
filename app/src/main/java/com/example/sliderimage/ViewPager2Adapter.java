package com.example.sliderimage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.ViewHolder> {

    private List<Integer> mData;
    String TAG = "ViewPager2Adapter.class";
    Context context;

    public ViewPager2Adapter(Context context, List<Integer> data) {
        this.context = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager2_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)

                .load(mData.get(position))
                .placeholder(R.drawable.cinema_loading_bg)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.mImageView);
//        holder.mImageView.setBackground(mData.get(position));
//        Log.d(TAG, "onBindViewHolder = position " + position);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.img_viewpager2);
        }
    }
}
