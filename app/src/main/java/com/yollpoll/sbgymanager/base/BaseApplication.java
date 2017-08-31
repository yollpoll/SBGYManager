package com.yollpoll.sbgymanager.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by 鹏祺 on 2017/8/15.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"ioMzCo0O5hhtz3cT1vYWHtSB-gzGzoHsz","lwGGwzcXSh0eXcSrLQvUszUC");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);
    }
}
