package io.github.vzer.sharevegetable.vegetable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.recycler.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.factory.presenter.vegetable.VegetablePresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.vegetable.adapter.VegetableAdapter;
import io.github.vzer.sharevegetable.vegetable.adapter.VegetableListener;
import io.github.vzer.sharevegetable.vegetable.animation.ShoppingCartAnimationView;

/**
 * 商品选购分页
 *
 * @author: Vzer.
 * @date: 2017/8/1. 18:25
 * @email: vzer@qq.com
 */

@SuppressLint("ValidFragment")
public class VegetableContentFragment extends FragmentPresenter<VegetableContract.Presenter>
        implements VegetableContract.View, RecyclerViewAdapter.OnItemClicked<VegetableModel>, SwipeRefreshLayout.OnRefreshListener, VegetableListener {
    @BindView(R.id.rcview_vegetable)
    RecyclerView vegetableRcview;
    @BindView(R.id.vegetable_refresh)
    SwipeRefreshLayout refreshLayout;

    VegetableAdapter<VegetableModel> adapter;
    List<VegetableModel> modelList = new ArrayList<>();
    private int curTabPage;
    private ShoppingChange shoppingChange;
    public static String VEGETABLE_DETAIL = "Vegetable_Detail";//商品详情页传值的key
    private ShoppingManager shoppingManager;//选购商品管理类


    @Override
    public void showLoading() {

    }

    public VegetableContentFragment(int page, @NonNull VegetableFragment vegetableFragment) {
        curTabPage = page;
        shoppingChange = vegetableFragment;
        shoppingManager = ShoppingManager.getInstance();
    }


    /**
     * 获取当前商品页数据成功
     */
    @Override
    public void LoadDatasSuccess(List<VegetableModel> vegetableModels) {
        //取消当前刷新状态
        if (refreshLayout.isRefreshing()) refreshLayout.setRefreshing(false);

        modelList = vegetableModels;
        adapter.addAll(modelList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void LoadTypeSuccess(List<VegetableTypeModel> typeModels) {

    }


    @Override
    protected VegetableContract.Presenter initPresenter() {
        return new VegetablePresenter(this);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        adapter = new VegetableAdapter<VegetableModel>(getContext(), modelList);
        adapter.setOnItemClickedListener(this);
        adapter.setVegetableListener(this);
        vegetableRcview.setAdapter(adapter);
        mPresenter.LoadType();//获取商品类型
        mPresenter.LoadDatas(curTabPage);
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initWidget(View root) {
        vegetableRcview.setLayoutManager(new LinearLayoutManager(getContext()));
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_vegetable_content;
    }

    /**
     * 商品点击,进入商品详情界面
     *
     * @param vegetableModel 点击的商品model
     */
    @Override
    public void onItemClicked(VegetableModel vegetableModel, RecyclerViewAdapter.ViewHolder holder) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        //ShoppingData model = new ShoppingData(curTabPage,holder.getAdapterPosition());
        //添加数据
        //intent.putExtra(VEGETABLE_DETAIL, vegetableModel);
        ShoppingManager.model = vegetableModel;

        startActivity(intent);
    }

    /**
     * 重启Fragment执行方法
     */
    @Override
    public void onResume() {
        super.onResume();
        adapter.refresh();
    }

    /**
     * 刷新方法
     */
    @Override
    public void onRefresh() {
        mPresenter.LoadDatas(curTabPage);
    }


    /**
     * 商品减少 逻辑
     */
    public void onClickSub(TextView txtAcount, int position, ImageView imgeSub) {

        VegetableModel model = modelList.get(position);
        int count = shoppingManager.sub(model);

        if (count > 0) {
            txtAcount.setText(String.valueOf(count));
        } else {
            txtAcount.setText("");
            imgeSub.setVisibility(View.GONE);
        }
        shoppingChange.updateSumTip();
    }

    /**
     * 商品添加 逻辑
     */
    public void onClickAdd(TextView txtAcount, View imgeAdd, ImageView imgeSub, int position) {

        VegetableModel model = modelList.get(position);
        int count = shoppingManager.add(model);

        if (count != 0) {
            imgeSub.setVisibility(View.VISIBLE);
        }

        txtAcount.setText(String.valueOf(count));
        //更新购物车提示数量
        shoppingChange.updateSumTip();
        //开始商品添加动画
        int[] cur = new int[2];
        imgeAdd.getLocationInWindow(cur);
        playAnimation(cur);
    }

    /*
     *商品添加到购物车动画
     */
    public void playAnimation(int[] position) {
        //创建一个执行动画view
        ShoppingCartAnimationView animationView = new ShoppingCartAnimationView(getContext());
        //设置动画的开始与结束坐标
        animationView.setStartPosition(new Point(position[0], position[1]));
        int[] des = shoppingChange.getShoppingCoord();
        animationView.setEndPosition(new Point(des[0], des[1]));
        //把view添加到界面中

        ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
        rootView.addView(animationView);
        //开始动画
        animationView.startBeizerAnimation();
    }

}
