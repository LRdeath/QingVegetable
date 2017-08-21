package io.github.vzer.sharevegetable.mine.activity;

import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.presenter.mine.UserAmountContract;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * 提现
 *
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WithdrawActivity extends ToolbarActivityPresenter<UserAmountContract.Presenter>
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
        setActivityTitle("用户提现");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_withdraw;
    }
}
