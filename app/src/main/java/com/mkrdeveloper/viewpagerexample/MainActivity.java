package com.mkrdeveloper.viewpagerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout linear;
    TextView[] dots;
    Button btn_next, btn_back;

    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        linear = findViewById(R.id.linear);
        btn_back = findViewById(R.id.button2);
        btn_next = findViewById(R.id.button);

        //adapter
        SliderAdapter sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //dots
        addDot(0);
        viewPager.addOnPageChangeListener(viewListener);

        //buttons
        btn_next.setOnClickListener(v ->

                viewPager.setCurrentItem(currentPage + 1)


        );

        btn_back.setOnClickListener(v ->

                viewPager.setCurrentItem(currentPage - 1)
        );

    }

    public void addDot(int posi) {
        dots = new TextView[6];
        linear.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(getResources().getColor(R.color.teal_200));

            linear.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[posi].setTextColor(getResources().getColor(R.color.teal_700));
        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDot(position);
            currentPage = position;
            if (currentPage == 0) {
                btn_back.setEnabled(false);
                btn_next.setEnabled(true);
                btn_back.setVisibility(View.INVISIBLE);


            } else if (currentPage == dots.length - 1) {
                btn_back.setEnabled(true);
                btn_next.setEnabled(true);
                btn_back.setVisibility(View.VISIBLE);
                btn_next.setVisibility(View.INVISIBLE);

            } else {
                btn_back.setEnabled(true);
                btn_next.setEnabled(true);
                btn_back.setVisibility(View.VISIBLE);
                btn_next.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}