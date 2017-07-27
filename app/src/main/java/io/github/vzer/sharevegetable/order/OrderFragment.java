package io.github.vzer.sharevegetable.order;

import android.os.Bundle;

import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.presenter.order.OrderContract;
import io.github.vzer.factory.presenter.order.OrderPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class OrderFragment extends FragmentPresenter<OrderContract.Presenter> implements OrderContract.View {

    @Override
    public void showLoading() {

    }

    @Override
    protected OrderContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order;
    }
}
