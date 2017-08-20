//package io.github.vzer.sharevegetable.order;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import io.github.vzer.common.app.FragmentPresenter;
//import io.github.vzer.common.widget.RecyclerViewAdapter;
//import io.github.vzer.factory.constant.KeyConstant;
//import io.github.vzer.factory.model.order.OrderDetailModel;
//import io.github.vzer.factory.presenter.order.OrderContract;
//import io.github.vzer.factory.presenter.order.OrderPresenter;
//import io.github.vzer.factory.utils.ToastUtil;
//import io.github.vzer.factory.utils.Utility;
//import io.github.vzer.sharevegetable.R;
//import io.github.vzer.sharevegetable.order.activity.OrderDetailActivity;
//import io.github.vzer.sharevegetable.order.adapter.OrderContentListAdapter;
//
///**
// * @author YangCihang
// * @since 17/7/27.
// * email yangcihang@hrsoft.net
// */
//
//public class OrderFragment extends FragmentPresenter<OrderContract.Presenter> implements OrderContract.View {
//
//    @BindView(R.id.rec_order_content)
//    RecyclerView recyclerView;
//    @BindView(R.id.refresh_ly)
//    SwipeRefreshLayout refreshLayout;
//
//    private OrderContentListAdapter adapter;
//    private List<OrderDetailModel> contentList;
//
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    protected void initWidget(View root) {
//        initList();
//        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Utility.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // TODO: 17/8/4 下拉刷新数据源
//                        ToastUtil.showToast("测试中");
//                        refreshLayout.setRefreshing(false);
//                    }
//                });
//            }
//        });
//    }
//
//    @Override
//    protected void initArgs(Bundle arguments) {
//
//    }
//
//    @Override
//    protected int getContentLayoutId() {
//        return R.layout.fragment_order;
//    }
//
//    @Override
//    public void showLoading() {
//
//    }
//
//    /**
//     * 从网络请求获取数据成功时回调
//     *
//     * @param orderDetailModelList dataSource
//     */
//    @Override
//    public void loadOrderDetailListSuccess(List<OrderDetailModel> orderDetailModelList) {
//        // TODO: 17/8/4 加载adapter，刷新数据源
//    }
//
//    @Override
//    protected OrderContract.Presenter initPresenter() {
//        return new OrderPresenter(this);
//    }
//
//    private void initList() {
//        contentList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            contentList.add(new OrderDetailModel());
//        }
//        adapter = new OrderContentListAdapter(getActivity(), contentList);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClicked<OrderDetailModel>() {
//            @Override
//            public void onItemClicked(OrderDetailModel orderDetailModel, RecyclerViewAdapter.ViewHolder holder) {
//                Intent intent = new Intent(getContext(), OrderDetailActivity.class);
//                intent.putExtra(KeyConstant.KEY_ORDER_DETAIL, orderDetailModel);
//                startActivity(new Intent(getContext(), OrderDetailActivity.class));
//            }
//        });
//    }
//
//}

package io.github.vzer.sharevegetable.order;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.model.order.OrderDetailModel;
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
    public static final int PAGER_SUM = 4;
    public static final int PAGER_ALL = 0;
    public static final int PAGER_NO_PAYMENT = 1;
    public static final int PAGER_NO_PICK_UP = 2;
    public static final int PAGER_COMPLETE = 3;
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

    @Override
    public void loadOrderDetailListSuccess(List<OrderDetailModel> orderDetailModelList) {

    }
}
