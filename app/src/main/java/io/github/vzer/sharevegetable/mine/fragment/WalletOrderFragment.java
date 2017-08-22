package io.github.vzer.sharevegetable.mine.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.recycler.RecyclerScrollListener;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.presenter.mine.UserAmountContract;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.factory.utils.Utility;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.mine.adapter.WalletOrderAdapter;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

@SuppressLint("ValidFragment")
public class WalletOrderFragment extends FragmentPresenter<UserAmountContract.Presenter>
        implements UserAmountContract.View {

    @BindView(R.id.rec_wallet_order_detail)
    RecyclerView walletOrderRec;
    public static final int PAGER_ALL = 0;
    public static final int PAGER_WITHDRAW = 1;
    public static final int PAGER_REFUNDS = 2;
    public static int PAGER_SUM = 3;
    //页面类型
    private int type;
    //是否是最后一页
    private boolean isLastItem = false;
    //通用的adapter
    private WalletOrderAdapter adapter;
    //modelList
    private ArrayList<UserWalletOrderModel> list;
    //滑动监听
    private RecyclerScrollListener scrollListener;
    //页数,默认从第一页起
    private int pager = 1;
    //条数,默认一页8条
    private static final int rows = 8;

    @Override
    public void showLoading() {

    }

    public WalletOrderFragment(int type) {
        this.type = type;
    }

    @Override
    protected UserAmountContract.Presenter initPresenter() {
        return new UserAmountPresenter(this);
    }


    @Override
    protected void initData() {
        loadNetData();
    }

    @Override
    protected void initWidget(View root) {
        initList();
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_wallet_order;
    }

    /**
     * 从网络加载数据
     */
    private void loadNetData() {
        switch (type) {
            case PAGER_ALL:
                mPresenter.requestAllAccount(pager, rows);
                break;
            case PAGER_WITHDRAW:
                mPresenter.requestWithdrawAccount(pager, rows);
                break;
            case PAGER_REFUNDS:
                mPresenter.requestRefundsAccount(pager, rows);
                break;
            default:
                ToastUtil.showToast(R.string.toast_logic_error);
                break;
        }
    }

    /**
     * 初始化list
     */
    private void initList() {
        list = new ArrayList<>();
        scrollListener = new RecyclerScrollListener();
        adapter = new WalletOrderAdapter(getContext(), list);
        walletOrderRec.setLayoutManager(new LinearLayoutManager(getContext()));
        walletOrderRec.setAdapter(adapter);
        walletOrderRec.setOnScrollListener(scrollListener);
        scrollListener.setScrolledToLastListener(new RecyclerScrollListener.OnScrolledToLast() {
            @Override
            public void onScrolledToLast(int position) {
                Utility.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isLastItem) {
                            adapter.setToRefresh(false);
                        } else {
                            adapter.setToRefresh(true);
                            loadNetData();
                        }
                    }
                });
            }
        });
    }

    /**
     * 数据请求成功时的回调
     *
     * @param tradeList tradeList
     */
    @Override
    public void onLoadSuccess(List<UserWalletOrderModel> tradeList, boolean isLastPage) {
        adapter.addAll(tradeList);
        pager += 1; // 页数增加1
        isLastItem = isLastPage;
        if (isLastPage) {
            adapter.setToRefresh(false);
        }
    }

    @Override
    public void onLoadFailed() {
        // TODO: 17/8/22 数据加载失败时
        adapter.setToRefresh(false);
    }
}
