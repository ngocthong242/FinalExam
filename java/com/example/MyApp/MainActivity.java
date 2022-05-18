package com.example.MyApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;

import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager2 mViewpager;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tabLayout);
        mViewpager = findViewById(R.id.view_pager);
        mViewPagerAdapter  = new ViewPagerAdapter(this);
        mViewpager.setAdapter(mViewPagerAdapter);
        new TabLayoutMediator(mTabLayout, mViewpager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Money");
                    break;
                case 1:
                    tab.setText("Temperature");
                    break;
                case 2:
                    tab.setText("BMI");
                    break;
                case 3:
                    tab.setText("Speed");
                    break;
                case 4:
                    tab.setText("Length");
                    break;

            }
        }).attach();


    }
}