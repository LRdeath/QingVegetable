package io.github.vzer.sharevegetable.order.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.Fragment;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.OrderModel;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.adapter.OrderContentAdapter;

/**
 * @author YangCihang
 * @since 17/7/29.
 * email yangcihang@hrsoft.net
 */

public class OrderContentFragment extends Fragment {
    @BindView(R.id.rec_order_content)
    RecyclerView recyclerView;
    private OrderContentAdapter adapter;
    private List<OrderModel> contentList;
    @Override
    protected void initData() {
    }

    @Override
    protected void initWidget(View root) {
        // TODO: 17/8/1 暂做测试
        contentList = new ArrayList<>();
        for(int i =0 ;i<10 ;i++) {
            contentList.add(new OrderModel());
        }
        adapter = new OrderContentAdapter(getActivity(),contentList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_order_content;
    }
}
