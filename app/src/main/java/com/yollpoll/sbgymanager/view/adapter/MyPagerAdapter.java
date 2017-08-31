package com.yollpoll.sbgymanager.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 鹏祺 on 2017/8/16.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> titles;
    private int mChildCount = 0;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> mFragments, List<String> titles) {
        super(fm);
        this.titles = titles;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {//必须实现
        return mFragments.get(position);
    }

    @Override
    public int getCount() {//必须实现
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {//选择性实现
        return titles.get(position);
    }

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        if ( mChildCount > 0) {
            mChildCount --;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
}

