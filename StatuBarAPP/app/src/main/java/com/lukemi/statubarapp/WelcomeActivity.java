package com.lukemi.statubarapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

public class WelcomeActivity extends BaseActivity {

    private final int MAG_DELAY_MAIN = 0x0001;
    private int count = 2;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MAG_DELAY_MAIN:
                    if (count == 0) {
                        gotoMain();
                    } else {
                        mHandler.sendEmptyMessageDelayed(MAG_DELAY_MAIN, 1000);
                    }
                    count--;
                    break;
                default:
                    break;
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mHandler.sendEmptyMessage(MAG_DELAY_MAIN);
    }

    @Override
    protected void onDestroy() {
        if (mHandler != null && mHandler.hasMessages(MAG_DELAY_MAIN)) {
            mHandler.removeMessages(MAG_DELAY_MAIN);
        }
        super.onDestroy();
    }

    private void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
