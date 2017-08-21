package io.github.vzer.sharevegetable.mine.activity;

import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.presenter.mine.UserAmountContract;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class RechargeActivity extends ToolbarActivityPresenter<UserAmountContract.Presenter>
        implements UserAmountContract.View {
    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public UserAmountContract.Presenter initPresenter() {
        return new UserAmountPresenter(this);
    }

    @Override
    protected void initWidget() {
        setActivityTitle("充值");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_recharge;
    }
}
