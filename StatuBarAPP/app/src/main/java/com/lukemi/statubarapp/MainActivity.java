package com.lukemi.statubarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_drawlayout).setOnClickListener(mOnClickListener);
        findViewById(R.id.btn_IndexActivity).setOnClickListener(mOnClickListener);
        findViewById(R.id.btn_Dialogfragment).setOnClickListener(mOnClickListener);
        findViewById(R.id.btn_MenuActivity).setOnClickListener(mOnClickListener);

    }

    @Override
    protected void excuteStatuBar() {
        StatusBarUtils
                .with(this)
                .setColor(getResources().getColor(R.color.orange_yellow))
                .init();
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_drawlayout:
                    intent = new Intent(MainActivity.this, DrawlayoutActivity.class);
                    break;
                case R.id.btn_IndexActivity:
                    intent = new Intent(MainActivity.this, IndexActivity.class);
                    break;
                case R.id.btn_Dialogfragment:
                    TestImmmeFragment t = TestImmmeFragment.newInstance("", "");
                    t.show(getSupportFragmentManager(), "TestImmmeFragment");
                    break;
                case R.id.btn_MenuActivity:
                    intent = new Intent(MainActivity.this, MenuActivity.class);

                    break;
                default:
                    break;
            }
            if (intent != null) {
                startActivity(intent);
            }
        }
    };


}
