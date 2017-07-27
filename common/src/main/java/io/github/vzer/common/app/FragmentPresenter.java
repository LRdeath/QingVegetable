package io.github.vzer.common.app;

import android.content.Context;

import io.github.vzer.common.R;
import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * MVP模式中 V层中 Fragmente
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public abstract class FragmentPresenter<Presenter extends BaseContract.Presenter> extends Fragment
        implements BaseContract.View<Presenter> {
    protected Presenter mPresenter;//V层对P层的引用


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //在界面绑定的时候就触发
        initPresenter();
    }

    /**
     * 初始化Presenter
     * @return Presenter
     */
    protected abstract Presenter initPresenter();

    /**
     * 默认Toast显示错误信息
     * @param strId 字符串资源id
     */
    @Override
    public void showError(int strId) {

    }

    /**
     * 设置对presenter的引用
     * @param presenter P层引用
     */
    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

}
