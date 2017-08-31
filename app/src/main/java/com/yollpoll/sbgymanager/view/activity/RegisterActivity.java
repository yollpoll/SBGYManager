package com.yollpoll.sbgymanager.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.yollpoll.sbgymanager.R;
import com.yollpoll.sbgymanager.base.BaseActivity;

/**
 * Created by 鹏祺 on 2017/8/23.
 */

public class RegisterActivity extends BaseActivity {
    private TextInputEditText edtUsername, edtPassword, edtName, edtNumber;
    private Button btnRegister;

    public static void gotoRegisterActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        edtUsername = (TextInputEditText) findViewById(R.id.edt_username);
        edtName = (TextInputEditText) findViewById(R.id.edt_name);
        edtNumber = (TextInputEditText) findViewById(R.id.edt_number);
        edtPassword = (TextInputEditText) findViewById(R.id.edt_password);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
    }

    private void register() {
        if (check()) {
            AVUser avUser = new AVUser();
            avUser.setUsername(edtUsername.getText().toString());
            avUser.setPassword(edtPassword.getText().toString());
            avUser.put("number", edtNumber.getText().toString());
            avUser.put("name", edtName.getText().toString());
            avUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(AVException e) {
                    if (null == e) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        RegisterActivity.this.finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
        if (TextUtils.isEmpty(edtName.getText().toString())) {
            Toast.makeText(this, "请输入姓名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edtNumber.getText().toString())) {
            Toast.makeText(this, "请输入编号", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_register:
                register();
                break;
        }
    }
}
