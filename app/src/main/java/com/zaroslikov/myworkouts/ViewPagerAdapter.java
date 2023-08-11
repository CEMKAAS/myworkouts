package com.zaroslikov.myworkouts;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new MeFragment();
            case 1: return new WorkoutFragment();
            case 2: return new StatisticFragment();
            default: return new MeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
