package io.github.vzer.factory.presenter.mine;

import java.util.List;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public interface UserAmountContract {
    interface View extends BaseContract.View<Presenter> {
        void onLoadSuccess(List<UserWalletOrderModel> tradeList, boolean isLastPage);

        void onLoadFailed();
    }

    interface Presenter extends BaseContract.Presenter {
        /**
         * 所有账户明细的请求
         *
         * @param page page
         * @param rows rows
         */
        @SuppressWarnings("unchecked")
        void requestAllAccount(int page, int rows);

        /**
         * 获取退款详情
         *
         * @param page
         * @param rows
         */
        void requestRefundsAccount(int page, int rows);

        void requestWithdrawAccount(int page, int rows);
    }
}
