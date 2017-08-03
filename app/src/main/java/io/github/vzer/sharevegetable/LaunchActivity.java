package io.github.vzer.sharevegetable;

import android.os.Handler;

import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.sharevegetable.account.AccountActivity;
import io.github.vzer.sharevegetable.main.MainActivity;

public class LaunchActivity extends BaseActivity {

    private boolean isLogin = true;//是否登录了


    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isLogin) {
                    AccountActivity.show(LaunchActivity.this);
                } else MainActivity.show(LaunchActivity.this);

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
