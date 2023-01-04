package com.example.sliderimage;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class viewPager2DialogFragment extends DialogFragment {

    View view;
    ViewPager2 viewPager2;
    List<Integer> listImage = new ArrayList<>();
    ViewPager2Adapter viewPagerAdapter;
    CircleIndicator3 indicator;

    public static viewPager2DialogFragment newInstance() {
        return new viewPager2DialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_slider_image, container, false);
        addDataToList();
        initView();
        setupAdapter();
//        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.DialogStyle);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme_Dialog_Custom);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    private void setupAdapter() {
        viewPagerAdapter = new ViewPager2Adapter(getContext(), listImage);
        viewPager2.setAdapter(viewPagerAdapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        indicator.setViewPager(viewPager2);
    }

    private void addDataToList() {
        listImage.add(R.drawable.thiep123);
        listImage.add(R.drawable.thiep124);
        listImage.add(R.drawable.thiep125);
    }

    private void initView() {
        viewPager2 = view.findViewById(R.id.viewpager2);
        indicator =view.findViewById(R.id.indicator);
    }
}
