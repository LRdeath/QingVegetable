package io.github.vzer.sharevegetable;

import android.os.Handler;

import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.sharevegetable.account.AccountActivity;

public class LaunchActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AccountActivity.show(LaunchActivity.this);
                finish();
            }
        }, 1000);
    }

    @Override
    protected void initWindows() {
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_launch;
    }

}
