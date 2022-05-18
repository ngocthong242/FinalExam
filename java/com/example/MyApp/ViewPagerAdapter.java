package com.example.MyApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MoneyFragment();
            case 1:
                return new TemperatureFragment();
            case 2:
                return new BMIFragment();
            case 3:
                return new SpeedFragment();
            case 4:
                return new LenghtFragment();

            default:
                return new MoneyFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}