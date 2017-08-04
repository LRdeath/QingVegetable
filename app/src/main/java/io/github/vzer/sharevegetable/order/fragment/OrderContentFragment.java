package io.github.vzer.sharevegetable.order.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
<<<<<<< Updated upstream
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
=======
import io.github.vzer.common.app.Fragment;
>>>>>>> Stashed changes
import io.github.vzer.factory.model.order.OrderModel;
import io.github.vzer.factory.presenter.order.OrderContract;
import io.github.vzer.factory.presenter.order.OrderPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.activity.OrderDetailActivity;
import io.github.vzer.sharevegetable.order.adapter.OrderContentListAdapter;

/**
 * @author YangCihang
 * @since 17/7/29.
 * email yangcihang@hrsoft.net
 */

@SuppressLint("ValidFragment")
public class OrderContentFragment extends FragmentPresenter<OrderContract.Presenter>
        implements OrderContract.View {

    public static final int PAGER_ALL = 0;
    public static final int PAGER_NO_PAYMENT = 1;
    public static final int PAGER_NO_DISTRIBUTE = 2;
    public static final int PAGER_NO_PICK_UP = 3;
    public static final int PAGER_COMPLETE = 4;
    private int pagerType = -1; //页面类型，根据不同类型发送不同请求
    @BindView(R.id.rec_order_content)
    RecyclerView recyclerView;

    private OrderContentListAdapter adapter;
    private List<OrderModel> contentList;

    public OrderContentFragment(int pagerType) {
        this.pagerType = pagerType;
    }

    @Override
    protected void initData() {
        // TODO: 17/8/3 根据不同页面来请求不同数据
        switch (pagerType) {
            case PAGER_ALL:
                break;
            case PAGER_NO_PAYMENT:
                break;
            case PAGER_NO_DISTRIBUTE:
                break;
            case PAGER_NO_PICK_UP:
                break;
            case PAGER_COMPLETE:
                break;
            default:
                break;
        }
    }

    @Override
    protected void initWidget(View root) {
        // TODO: 17/8/1 暂做测试
        initList();

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_content;
    }

    @Override
    public void showLoading() {

    }

    @Override
    protected OrderContract.Presenter initPresenter() {
        return new OrderPresenter(this);
    }

    private void initList() {
        contentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            contentList.add(new OrderModel());
        }
        adapter = new OrderContentListAdapter(getActivity(), contentList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClicked<OrderModel>() {
            @Override
            public void onItemClicked(OrderModel orderModel, RecyclerViewAdapter.ViewHolder holder) {
                startActivity(new Intent(getContext(),OrderDetailActivity.class));
            }
        });
    }

}
