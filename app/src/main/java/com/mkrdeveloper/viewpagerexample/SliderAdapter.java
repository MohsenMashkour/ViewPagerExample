package com.mkrdeveloper.viewpagerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;

    }
    public int[] slide_images = {
            R.drawable.e1,
            R.drawable.e2,
            R.drawable.e3,
            R.drawable.e4,
            R.drawable.e5,
            R.drawable.e6
    };
    public String[] slide_headers = {
            "title 1",
            "title 2",
            "title 3",
            "title 4",
            "title 5",
            "title 6",

    };


    public String[] slide_desc = {
            "text 1",
            "text 2",
            "text 3",
            "text 4",
            "text 5",
            "text 6"
    };


    @Override
    public int getCount() {
        return slide_desc.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;

    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_resources, container, false);

        ImageView imageView =  view.findViewById(R.id.imageView);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView = view.findViewById(R.id.textView);

        imageView.setImageResource(slide_images[position]);
        textView.setText(slide_headers[position]);
        textView2.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }

}
