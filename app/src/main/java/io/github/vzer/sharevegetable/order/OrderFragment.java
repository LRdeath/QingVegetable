package io.github.vzer.sharevegetable.order;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.presenter.order.OrderContract;
import io.github.vzer.factory.presenter.order.OrderPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.adapter.OrderViewPagerAdapter;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class OrderFragment extends FragmentPresenter<OrderContract.Presenter> implements OrderContract.View {
    public static final int PAGER_SUM = 5;
    public static final int PAGER_ALL = 0;
    public static final int PAGER_NO_PAYMENT = 1;
    public static final int PAGER_NO_DISTRIBUTE = 2;
    public static final int PAGER_NO_PICK_UP = 3;
    public static final int PAGER_NO_COMPLETE = 4;
    @BindView(R.id.vp_order)
    ViewPager orderVp;
    @BindView(R.id.tab_order)
    TabLayout orderTab;
    private OrderViewPagerAdapter adapter;

    @Override
    public void showLoading() {

    }

    @Override
    protected OrderContract.Presenter initPresenter() {
        return new OrderPresenter(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        adapter = new OrderViewPagerAdapter(getFragmentManager());
        orderVp.setAdapter(adapter);
        orderTab.setupWithViewPager(orderVp);
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order;
    }
}
