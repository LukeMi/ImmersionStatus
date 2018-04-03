package com.lukemi.statubarapp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chenmz
 * on 2017/12/27 0027.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        excuteStatuBar();
    }

    /**
     * 处理状态栏
     */
    protected void excuteStatuBar() {

    }

}
