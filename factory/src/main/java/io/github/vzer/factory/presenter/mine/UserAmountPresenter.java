package io.github.vzer.factory.presenter.mine;

import java.util.List;

import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.data.MineHelper;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class UserAmountPresenter extends BasePresenter<UserAmountContract.View>
        implements UserAmountContract.Presenter {

    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public UserAmountPresenter(UserAmountContract.View mView) {
        super(mView);
    }

    /**
     * 请求所有明细
     */
    @Override
    public void requestAllAccount(int page, int rows) {
        MineHelper.requestAllAccount(page, rows, this);
    }

    /**
     * 请求退款明细
     */
    @Override
    public void requestRefundsAccount(int page, int rows) {
        MineHelper.requestRefundsAccount(page, rows, this);
    }

    /**
     * 请求提现明细
     */
    @Override
    public void requestWithdrawAccount(int page, int rows) {
        MineHelper.requestWithdrawAccount(page, rows, this);

    }

    /**
     * 数据加载成功
     */
    public void onDataLoadedSuccess(List<UserWalletOrderModel> tradeList, boolean isLastPage) {
        if (mView != null) {
            mView.onLoadSuccess(tradeList, isLastPage);
        }
    }

    public void onDataLoadedFailed() {
        if (mView != null) {
            mView.onLoadFailed();
        }
    }
}
