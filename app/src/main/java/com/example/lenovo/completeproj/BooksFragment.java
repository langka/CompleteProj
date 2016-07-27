package com.example.lenovo.completeproj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/7/25.
 */
public class BooksFragment extends Fragment{
    List<Fragment> fragments;
    FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            v = inflater.inflate(R.layout.bookinfo, null);
            viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        final List<String> titleList = new ArrayList<String>();
        titleList.add("数学");
        titleList.add("英语");
        titleList.add("物理");
            fragments = new ArrayList<Fragment>();
            fragments.add(TaggedBooks.newInstance(1));
            fragments.add(TaggedBooks.newInstance(2));
            fragments.add(TaggedBooks.newInstance(3));
            fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragments.get(position);
                }

                @Override
                public int getCount() {
                    return fragments.size();
                }

                @Override
                public CharSequence getPageTitle(int position) {
                    return titleList.get(position);
                }
            };

        if(viewPager ==null)
            Log.d("hhhh","null");

            viewPager.setAdapter(fragmentPagerAdapter);
            viewPager.setCurrentItem(0);

        return v;
    }

}
