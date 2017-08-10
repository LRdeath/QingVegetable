package io.github.vzer.factory.presenter.order;

import java.util.List;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.order.DiscussModel;
import io.github.vzer.factory.model.order.OrderDetailModel;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public interface OrderContract {
    interface View extends BaseContract.View<Presenter>{
        void loadOrderDetailListSuccess(List<OrderDetailModel> orderDetailModelList);
    }
    interface Presenter extends BaseContract.Presenter{
        // TODO: 17/8/4 发送请求订单信息 
        void loadOrderDetails();

        void sendDiscussRequest(DiscussModel discussModel);

    }
}
