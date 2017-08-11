package io.github.vzer.sharevegetable.shopping.activity;

import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.sharevegetable.R;

/**
 * @author abtion.
 * @since 17/8/6 17:15.
 * email caiheng@hrsoft.net
 */

public class PayOnlineActivity extends ToolbarActivityPresenter<VegetableContract.Presenter> {

    private ShoppingOrderModel orderModel;
    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public VegetableContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        orderModel = (ShoppingOrderModel) getIntent().getSerializableExtra(FirmOrderActivity.PAY_ORDER);
    }

    @Override
    public void initWidget() {
        setActivityTitle("在线支付");
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_pay_online;
    }

}
