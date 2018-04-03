package com.lukemi.statubarapp;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.lukemi.statubarapp.widget.IndexBar;

public class IndexActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private TextView tvSideBarHint;
    private IndexBar indexBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();

    }

    private void initView() {
        recyclerView = ((RecyclerView) findViewById(R.id.recyclerview));
        tvSideBarHint = ((TextView) findViewById(R.id.tvSideBarHint));
        indexBar = ((IndexBar) findViewById(R.id.indexBar));

        indexBar.setIndexString(R.array.ctIndext);
        indexBar.setmPressedShowTextView(tvSideBarHint);
    }

    @Override
    protected void excuteStatuBar() {
        StatusBarUtils.with(this)
                .setColorRes(R.color.mediumturquoise)
                .init();
    }


}
