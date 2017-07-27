package io.github.vzer.common.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * @author: Vzer.
 * @date: 2017/7/27. 14:06
 * @email: vzer@qq.com
 */

public abstract class ActivityPresenter<Presenter extends BaseContract.Presenter> extends BaseActivity implements BaseContract.View<Presenter>{
    protected Presenter mPresenter;

    //在加载控件之前初始化Presenter
    @Override
    public void initWidget() {
        initPresenter();
    }

    /**
     * 初始化Presenter
     * @return
     */
    protected abstract Presenter initPresenter();


    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }
}
