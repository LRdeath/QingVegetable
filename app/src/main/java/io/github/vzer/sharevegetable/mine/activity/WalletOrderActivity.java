package io.github.vzer.sharevegetable.mine.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindInt;
import butterknife.BindView;
import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.recycler.RecyclerScrollListener;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.presenter.mine.UserAmountContract;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.factory.utils.Utility;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.WalletOrderAdapter;
import io.github.vzer.sharevegetable.mine.adapter.WalletOrderPagerAdapter;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletOrderActivity extends ToolbarActivity {
    @BindView(R.id.tabs_wallet_order)
    TabLayout tabLayout;
    @BindView(R.id.pager_wallet_order)
    ViewPager orderPager;
    private WalletOrderPagerAdapter pagerAdapter;
    @Override
    protected void initData() {
        pagerAdapter = new WalletOrderPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void initWidget() {
        setActivityTitle("交易明细");
        orderPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(orderPager);
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_wallet_order;
    }

}
