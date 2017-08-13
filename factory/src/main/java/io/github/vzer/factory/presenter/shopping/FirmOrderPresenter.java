package io.github.vzer.factory.presenter.shopping;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;

/**
 * @author: Vzer.
 * @date: 2017/8/13. 20:09
 * @email: vzer@qq.com
 */

public class FirmOrderPresenter extends BasePresenter<FirmOrderContract.View> implements FirmOrderContract.Presenter {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public FirmOrderPresenter(FirmOrderContract.View mView) {
        super(mView);
    }

    @Override
    public void submitOrder(ShoppingOrderModel orderModel) {

    }
}
