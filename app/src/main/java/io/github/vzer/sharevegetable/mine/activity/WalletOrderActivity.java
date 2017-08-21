package io.github.vzer.sharevegetable.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.recycler.RecyclerScrollListener;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.presenter.mine.UserAmountContract;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.factory.utils.Utility;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.WalletOrderAdapter;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletOrderActivity extends ToolbarActivityPresenter<UserAmountContract.Presenter>
        implements UserAmountContract.View {
    @BindView(R.id.rec_wallet_order_detail)
    RecyclerView walletOrderRec;

    private WalletOrderAdapter adapter;
    private ArrayList<UserWalletOrderModel> list;
    private RecyclerScrollListener scrollListener;

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
    protected void initData() {
        list = new ArrayList<>();
    }

    @Override
    public void initWidget() {
        setActivityTitle("交易明细");
        initList();
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_wallet_order;
    }

    /**
     * 初始化list
     */
    private void initList() {
        scrollListener = new RecyclerScrollListener();
        adapter = new WalletOrderAdapter(this, list);
        walletOrderRec.setLayoutManager(new LinearLayoutManager(this));
        walletOrderRec.setAdapter(adapter);
        walletOrderRec.setOnScrollListener(scrollListener);
        scrollListener.setScrolledToLastListener(new RecyclerScrollListener.OnScrolledToLast() {
            @Override
            public void onScrolledToLast(int position) {
                Utility.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setToRefresh(false);
                    }
                }, 300);
            }
        });
    }
}
