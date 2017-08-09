package io.github.vzer.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * Activity的基本封装
 *
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在界面未初始化之前调用初始化窗口
        initWindows();
        if (initArgs(getIntent().getExtras())){
            int layId = getContentLayoutId();
            setContentView(layId);
            ButterKnife.bind(this);
            initData();
            initWidget();
        }else {
            finish();
        }

        //为第三方自定义推送服务
    }

    /**
     * 初始化相关参数Bundle
     *
     * @param extras 参数Bundle
     * @return 如果参数正确返回true，错误返回false
     */
    protected  boolean initArgs(Bundle extras){
        return true;
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件
     */
    public abstract void initWidget();

    /**
     * 初始化窗口
     */
    protected abstract void initWindows();

    /**
     * 获取当前界面资源id
     *
     */
    protected abstract int getContentLayoutId();

}
