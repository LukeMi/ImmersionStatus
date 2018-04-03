package com.lukemi.statubarapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 菜单
 * Created by chenmz
 * on 2017/12/29
 */
public class MenuActivity extends BaseActivity {

    @BindView(R.id.iv_menu)
    ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

    }

    @Override
    protected void excuteStatuBar() {
        StatusBarUtils
                .with(this)
                .setColorRes(R.color.mediumturquoise)
                .init();
    }

    @OnClick({R.id.iv_back, R.id.iv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_menu:
                openOptionsMenu();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return false;
    }
}
