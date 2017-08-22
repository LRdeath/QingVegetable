package io.github.vzer.sharevegetable.mine.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.presenter.mine.UserAmountContract;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.RechargePagerAdapter;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class RechargeActivity extends ToolbarActivityPresenter<UserAmountContract.Presenter>
        implements UserAmountContract.View {
    @BindView(R.id.tabs_recharge)
    TabLayout tabsRecharge;
    @BindView(R.id.pager_recharge)
    ViewPager pagerRecharge;


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
        RechargePagerAdapter rechargePagerAdapter = new RechargePagerAdapter(getSupportFragmentManager());
        pagerRecharge.setAdapter(rechargePagerAdapter);
        tabsRecharge.setupWithViewPager(pagerRecharge);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_recharge;
    }

    @Override
    public void onLoadSuccess(List<UserWalletOrderModel> tradeList, boolean isLastPage) {

    }

    @Override
    public void onLoadFailed() {

    }
}
