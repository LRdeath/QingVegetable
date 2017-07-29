package io.github.vzer.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * @author: Vzer.
 * @date: 2017/7/29. 13:36
 * @email: vzer@qq.com
 */

public abstract class ToolbarActivityPresenter<Presenter extends BaseContract.Presenter> extends ToolbarActivity implements BaseContract.View<Presenter> {
    protected Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //创建时就绑定P层
        initPresenter();
        super.onCreate(savedInstanceState);
    }

    /**
     * V层创建 与之绑定的P层对象
     *
     * @return 与之绑定的P层对象
     */
    public abstract Presenter initPresenter();

    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }
}
