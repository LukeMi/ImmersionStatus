package com.lukemi.statubarapp;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

public class DrawlayoutActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawlayout);
        mDrawerLayout = ((DrawerLayout) findViewById(R.id.drawlayout));
    }

    @Override
    protected void excuteStatuBar() {
        StatusBarUtils
                .with(this)
                .setDrawerLayoutContentId(true, R.id.ll_content)
                .setColorRes(R.color.red)
                .init();
    }
}
