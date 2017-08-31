package com.yollpoll.sbgymanager.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseFragment;
import com.yollpoll.sbgymanager.base.Constant;
import com.yollpoll.sbgymanager.view.Utils;
import com.yollpoll.sbgymanager.view.adapter.TaskAdapter;
import com.yollpoll.sbgymanager.view.bean.TaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鹏祺 on 2017/8/16.
 */

public class TaskPagerFragment extends BaseFragment {
    private View rootView;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeView;
    private TaskAdapter mAdapter;
    private List<TaskBean> listTask = new ArrayList<>();
    private int partId = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("spq","TaskPageFragmentCreateView");
        return Utils.initRootView(rootView, R.layout.fragment_task_pager, inflater);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("spq","TaskPageFragmentViewCreated");
        initView(view);
        initData();
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_task);
        mSwipeView = (SwipeRefreshLayout) view.findViewById(R.id.swipe_task);

        mSwipeView.setOnRefreshListener(this);
    }

    private void initData() {
        partId = getArguments().getInt("partId");
        mAdapter = new TaskAdapter(listTask);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        getData();
    }

    private void getData() {
        if (partId == -1)
            return;
        AVQuery<AVObject> query = new AVQuery<>(Constant.TASK);
        query.include("addOilStandard");
        query.include("changeOilStandard");
        query.whereEqualTo("partId", partId + "");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                mSwipeView.setRefreshing(false);
                if (null != e)
                    return;
                listTask.clear();
                listTask.addAll(TaskBean.getList(list));
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        getData();
    }
}
