package io.github.vzer.factory.data;

import java.util.List;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.factory.model.order.DiscussModel;
import io.github.vzer.factory.model.order.OrderDetailModel;
import io.github.vzer.factory.presenter.order.OrderPresenter;

/**
 * @author YangCihang
 * @since 17/8/4.
 * email yangcihang@hrsoft.net
 */

public class OrderDetailHelper {
    /**
     * 获取orderDetail的ModelList
     *
     * @param type     类型：全部、待付款、待配送、待取货、已完成
     * @param callback dataCallback
     */
    public static void getOrderDetailRequest(int type, DataCallback.Callback<List<OrderDetailModel>> callback) {
        // TODO: 17/8/4 发送网络请求

        //回调到P层的onDataLoaded
        //callback.onDataLoaded(new List<OrderDetailModel>());
    }

    /**
     * 发送评论的请求
     *
     * @param model    model
     * @param callback dataCallback
     */
    public static void sendDiscussRequest(DiscussModel model, OrderPresenter callback) {
        callback.onSendDiscussRequestSuccess();
    }

    /**
     * 取消订单
     *
     * @param model 被取消订单的model
     */
    public static void sendCancelOrderRequest(OrderDetailModel model, OrderPresenter callback) {
    }
}
