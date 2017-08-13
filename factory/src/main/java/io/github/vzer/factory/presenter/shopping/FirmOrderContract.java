package io.github.vzer.factory.presenter.shopping;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;

/**
 * @author: Vzer.
 * @date: 2017/8/13. 20:10
 * @email: vzer@qq.com
 */

public interface FirmOrderContract {
    interface Presenter extends BaseContract.Presenter {
        //请求提交订单
        void submitOrder(ShoppingOrderModel orderModel);
    }

    interface View extends BaseContract.View<Presenter> {
        //提交订单成功
        void submitSuccess(ShoppingOrderModel orderModel);
    }
}
