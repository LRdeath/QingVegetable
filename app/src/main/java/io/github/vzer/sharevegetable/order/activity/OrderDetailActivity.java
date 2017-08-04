package io.github.vzer.sharevegetable.order.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.order.OrderVegetableModel;
import io.github.vzer.factory.presenter.order.OrderContract;
import io.github.vzer.factory.presenter.order.OrderPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.adapter.OrderDetailListAdapter;

public class OrderDetailActivity extends ToolbarActivityPresenter<OrderContract.Presenter>
        implements OrderContract.View {

    @BindView(R.id.rec_order_detail)
    RecyclerView orderDetailRec;
    private OrderDetailListAdapter adapter;
    private List<OrderVegetableModel> list;

    @Override
    protected void initData() {
    }

    @Override
    public void initWidget() {
        setActivityTitle(getResources().getString(R.string.title_order_detail));
        list = new ArrayList<>();
        for (int i =0 ;i<10;i++) {
            list.add(new OrderVegetableModel());
        }
        adapter = new OrderDetailListAdapter(this,list);
        orderDetailRec.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        orderDetailRec.setLayoutManager(manager);
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public OrderContract.Presenter initPresenter() {
        return new OrderPresenter(this);
    }
}
