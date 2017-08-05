package io.github.vzer.sharevegetable.lock;

import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.presenter.lock.UnlockContract;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/3.
 * email yangcihang@hrsoft.net
 */

public class UnlockActivity extends ToolbarActivityPresenter<UnlockContract.Presenter>
        implements UnlockContract.View{
    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public UnlockContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle("奥特曼");
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_unlock;
    }
}