package io.github.vzer.factory.presenter.shopping;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.data.ShoppingHelper;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class ShoppingPresenter extends BasePresenter<ShoppingContract.View>
        implements ShoppingContract.Presenter, DataCallback.Callback<Integer> {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public ShoppingPresenter(ShoppingContract.View mView) {
        super(mView);
    }

    @Override
    public void CreateOrder(ShoppingOrderModel orderModel) {
        start();
        // TODO: 2017/8/8 对model进行封装处理 发送给后端
        //传递M层进行处理
        ShoppingHelper.CreateOrder(orderModel, this);
    }

    /**
     * 订单创建成功,
     *
     * @param integer 订单号
     */
    @Override
    public void onDataLoaded(Integer integer) {
        mView.CreateOrderSuccess();
    }

    @Override
    public void onFailedLoaded(int error) {
        ToastUtil.showToast(error);
        mView.showError(error);
    }
}
