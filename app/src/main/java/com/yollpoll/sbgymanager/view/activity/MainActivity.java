package com.yollpoll.sbgymanager.view.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseActivity;
import com.yollpoll.sbgymanager.view.fragment.MineFragment;
import com.yollpoll.sbgymanager.view.fragment.PeopleFragment;
import com.yollpoll.sbgymanager.view.fragment.TaskFragment;

public class MainActivity extends BaseActivity {
    private RelativeLayout rlContent;
    private TaskFragment mTaskFragment;
    private PeopleFragment mPeopleFragment;
    private MineFragment mMineFragment;
    private TextView tvTask, tvPeople, tvMine;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mTaskFragment = new TaskFragment();
        mMineFragment =new MineFragment();
        mPeopleFragment=new PeopleFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.rl_content, mTaskFragment);
        fragmentTransaction.commit();

    }

    private void initView() {
        rlContent = (RelativeLayout) findViewById(R.id.rl_content);
        tvTask = (TextView) findViewById(R.id.tv_task);
        tvPeople = (TextView) findViewById(R.id.tv_people);
        tvMine = (TextView) findViewById(R.id.tv_mine);

        tvTask.setOnClickListener(this);
        tvPeople.setOnClickListener(this);
        tvMine.setOnClickListener(this);
    }

    private void initTab() {
        Drawable drawableTask = getResources().getDrawable(R.mipmap.icon_task);
        tvTask.setCompoundDrawablesWithIntrinsicBounds(null, drawableTask, null, null);
        Drawable drawablePeople = getResources().getDrawable(R.mipmap.icon_people);
        tvPeople.setCompoundDrawablesWithIntrinsicBounds(null, drawablePeople, null, null);
        Drawable drawableMine = getResources().getDrawable(R.mipmap.icon_mine);
        tvMine.setCompoundDrawablesWithIntrinsicBounds(null, drawableMine, null, null);

        tvTask.setTextColor(getResources().getColor(R.color.colorAccent));
        tvPeople.setTextColor(getResources().getColor(R.color.colorAccent));
        tvMine.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_task:
                fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_content, mTaskFragment);
                fragmentTransaction.commit();

                initTab();
                Drawable drawableTask = getResources().getDrawable(R.mipmap.icon_task_blue);
                tvTask.setCompoundDrawablesWithIntrinsicBounds(null, drawableTask, null, null);
                tvTask.setTextColor(getResources().getColor(R.color.colorTabBlue));
                break;
            case R.id.tv_people:
                fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_content, mPeopleFragment);
                fragmentTransaction.commit();

                initTab();
                Drawable drawablePeople = getResources().getDrawable(R.mipmap.icon_people_blue);
                tvPeople.setCompoundDrawablesWithIntrinsicBounds(null, drawablePeople, null, null);
                tvPeople.setTextColor(getResources().getColor(R.color.colorTabBlue));
                break;
            case R.id.tv_mine:
                fragmentTransaction=getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.rl_content, mMineFragment);
                fragmentTransaction.commit();

                initTab();
                Drawable drawableMine = getResources().getDrawable(R.mipmap.icon_mine_blue);
                tvMine.setCompoundDrawablesWithIntrinsicBounds(null, drawableMine, null, null);
                tvMine.setTextColor(getResources().getColor(R.color.colorTabBlue));
                break;
        }
    }
}
