package com.yollpoll.sbgymanager.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseFragment;
import com.yollpoll.sbgymanager.base.Constant;
import com.yollpoll.sbgymanager.view.Utils;
import com.yollpoll.sbgymanager.view.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鹏祺 on 2017/8/16.
 */

public class TaskFragment extends BaseFragment {
    private View rootView;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyPagerAdapter mAdapter;
    private List<Fragment> listFragment = new ArrayList<>();
    private List<String> listTitle = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("spq","TaskFragmentCreateView");
        return Utils.initRootView(rootView, R.layout.fragment_task, inflater);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("spq","TaskFragmentViewCreated");
        initView(view);
        initData();
    }

    private void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.vp_task);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("spq","position>>>>"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        mAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(), listFragment, listTitle);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        AVQuery<AVObject> query = new AVQuery<>(Constant.PART);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                listFragment.clear();
                if (null != e)
                    return;
                for (AVObject avObject : list) {
                    String content = (String) avObject.get("content");
                    String partId = avObject.getString("partId");
                    listTitle.add(content);
                    TaskPagerFragment taskPagerFragment = new TaskPagerFragment();
                    Bundle arg = new Bundle();
                    arg.putInt("partId", Integer.parseInt(partId));
                    taskPagerFragment.setArguments(arg);
                    listFragment.add(taskPagerFragment);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }

}
