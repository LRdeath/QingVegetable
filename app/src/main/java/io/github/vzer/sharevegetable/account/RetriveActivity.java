package io.github.vzer.sharevegetable.account;

import android.content.Context;
import android.content.Intent;

import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/7/28. 15:56
 * @email: vzer@qq.com
 */

public class RetriveActivity extends ToolbarActivity {

    public static void show(Context context){
        context.startActivity(new Intent(context,RetriveActivity.class));
    }
    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        this.setActivityTitle(getResources().getString(R.string.label_retrive));

    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_retrive;
    }


}
