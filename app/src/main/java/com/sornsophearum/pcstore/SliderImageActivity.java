// SliderImageActivity.java
package com.sornsophearum.pcstore;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class SliderImageActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; // Add your image resources here

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_image);

        viewPager = findViewById(R.id.view_pager_slider); // Change the id to match your layout
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        viewPager.setAdapter(adapter);
    }
}
