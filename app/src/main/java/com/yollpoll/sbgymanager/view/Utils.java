package com.yollpoll.sbgymanager.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 鹏祺 on 2017/8/16.
 */

public class Utils {
    public static View initRootView(View rootView, int layoutId, LayoutInflater inflater) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(layoutId, null);
        }
        return rootView;
    }
}
