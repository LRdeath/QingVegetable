package io.github.vzer.factory.presenter.shopping;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public interface ShoppingContract {
    interface View extends BaseContract.View<Presenter> {
        //创建订单成功
        void CreateOrderSuccess();
    }
    interface Presenter extends BaseContract.Presenter {
        //发送创建订单请求
        void CreateOrder(ShoppingOrderModel orderModel);
    }
}
