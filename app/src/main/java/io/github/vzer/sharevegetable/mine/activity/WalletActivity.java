package io.github.vzer.sharevegetable.mine.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.recycler.RecyclerScrollListener;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.presenter.mine.WalletContract;
import io.github.vzer.factory.presenter.mine.WalletPresenter;
import io.github.vzer.factory.utils.Utility;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.WalletOrderAdapter;

/**
 * 钱包详情
 *
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletActivity extends ActivityPresenter<WalletContract.Presenter>
        implements WalletContract.View {
    @BindView(R.id.img_back)
    ImageView backImg;
    @BindView(R.id.ly_recharge)
    RelativeLayout rechargeLy;
    @BindView(R.id.ly_withdraw)
    RelativeLayout withdrawLy;
    @BindView(R.id.ly_wallet_order)
    RelativeLayout orderLy;

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public WalletContract.Presenter initPresenter() {
        return new WalletPresenter(this);
    }

    @Override
    public void initWidget() {
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_wallet;
    }


    /**
     * 点击返回
     */
    @OnClick(R.id.img_back)
    void onBackClicked() {
        this.finish();
    }

    /**
     * 点击提现
     */
    @OnClick(R.id.ly_withdraw)
    void onWithdraw() {
        startActivity(new Intent(this, WithdrawActivity.class));
    }

    /**
     * 点击充值
     */
    @OnClick(R.id.ly_recharge)
    void onRecharge() {
        startActivity(new Intent(this, RechargeActivity.class));
    }

    /**
     * 点击查看交易详情
     */
    @OnClick(R.id.ly_wallet_order)
    void onOrder() {
        startActivity(new Intent(this, WalletOrderActivity.class));
    }
}
