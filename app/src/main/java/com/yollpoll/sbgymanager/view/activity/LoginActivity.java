package com.yollpoll.sbgymanager.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseActivity;

/**
 * Created by 鹏祺 on 2017/8/23.
 */

public class LoginActivity extends BaseActivity {
    private TextInputEditText edtUsername, edtPassword;
    private Button btnLogin;

    public static void gotoLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        edtUsername = (TextInputEditText) findViewById(R.id.edt_username);
        edtPassword = (TextInputEditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    private void login() {
        if (check()) {
            AVUser.logInInBackground(edtUsername.getText().toString(),
                    edtPassword.getText().toString(), new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            if (null == e) {
                                //登陆成功
                                LoginActivity.this.finish();
                            } else {
                                Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private boolean check() {
        if (TextUtils.isEmpty(edtUsername.getText().toString())) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtPassword.getText().toString())) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
        }
    }
}
