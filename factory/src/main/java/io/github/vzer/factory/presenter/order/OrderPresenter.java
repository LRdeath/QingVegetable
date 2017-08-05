package io.github.vzer.factory.presenter.order;

import java.util.List;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.model.order.DiscussModel;
import io.github.vzer.factory.model.order.OrderDetailModel;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class OrderPresenter extends BasePresenter<OrderContract.View>
        implements OrderContract.Presenter, DataCallback.Callback<List<OrderDetailModel>> {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public OrderPresenter(OrderContract.View mView) {
        super(mView);
    }

    /**
     * 获取订单详情的数据源
     */
    @Override
    public void loadOrderDetails() {
        //开启p层方法(progressBar)
        start();
    }

    /**
     * 发送发表评价的请求
     */
    @Override
    public void sendDiscussRequest(DiscussModel discussModel) {

    }

    /**
     * M层数据失败时回调
     *
     * @param error error code
     */
    @Override
    public void onFailedLoaded(int error) {

    }

    /**
     * M层数据加载成功时
     *
     * @param orderDetailModelList dataSource
     */
    @Override
    public void onDataLoaded(List<OrderDetailModel> orderDetailModelList) {
        mView.loadDataSuccess(orderDetailModelList);
    }
}
