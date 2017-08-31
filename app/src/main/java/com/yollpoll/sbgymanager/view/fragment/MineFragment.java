package com.yollpoll.sbgymanager.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.avos.avoscloud.AVUser;
import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseFragment;
import com.yollpoll.sbgymanager.view.Utils;
import com.yollpoll.sbgymanager.view.activity.LoginActivity;
import com.yollpoll.sbgymanager.view.activity.RegisterActivity;

/**
 * Created by 鹏祺 on 2017/8/21.
 */

public class MineFragment extends BaseFragment {
    private View rootView;
    private Button btnRegister, btnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return Utils.initRootView(rootView, R.layout.fragment_mine, inflater);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    private void initView(View view) {
        btnRegister = (Button) view.findViewById(R.id.btn_register);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    private void initData() {
        AVUser avUser=AVUser.getCurrentUser();
        if(null==avUser){
            //还未登录
        }else {
            //已经登陆

        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_register:
                RegisterActivity.gotoRegisterActivity(getActivity());
                break;
            case R.id.btn_login:
                LoginActivity.gotoLoginActivity(getActivity());
                break;
        }
    }
}
