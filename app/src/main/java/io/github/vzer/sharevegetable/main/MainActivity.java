package io.github.vzer.sharevegetable.main;

import android.content.Context;
import android.content.Intent;

import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.sharevegetable.R;

public class MainActivity extends BaseActivity {


    public static void show(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {

    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }
}
