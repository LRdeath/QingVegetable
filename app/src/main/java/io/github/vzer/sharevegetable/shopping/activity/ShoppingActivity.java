package io.github.vzer.sharevegetable.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.presenter.shopping.ShoppingContract;
import io.github.vzer.factory.presenter.shopping.ShoppingPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.Adapter.ShoppingContentAdapter;
import io.github.vzer.sharevegetable.shopping.OnAmountChangeListener;
import io.github.vzer.sharevegetable.vegetable.ShoppingData;
import io.github.vzer.sharevegetable.vegetable.VegetableFragment;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class ShoppingActivity extends ToolbarActivityPresenter<ShoppingContract.Presenter>
        implements ShoppingContract.View, OnAmountChangeListener {

    public static OnAmountChangeListener onAmountChangeListener;
    public static String FIRM_ORDER = "firmOrder";

    @BindView(R.id.rec_shopping)
    RecyclerView recShopping;
    @BindView(R.id.txt_price_all)
    TextView txtPriceAll;
    @BindView(R.id.btn_checked_to_pay)
    Button btnCheckedToPay;
    private ArrayList<ShoppingModel> shoppingList;
    private double price = 0.0;

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public ShoppingContract.Presenter initPresenter() {
        return new ShoppingPresenter(this);
    }

    @Override
    protected void initData() {
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        shoppingList = (ArrayList<ShoppingModel>) ShoppingData.getInstance().getShoppingList();
        onAmountChangeListener = this;
    }

    @Override
    public void initWidget() {
        setActivityTitle(getResources().getString(R.string.title_shopping));
        ShoppingContentAdapter adapter = new ShoppingContentAdapter(this, shoppingList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recShopping.setAdapter(adapter);
        recShopping.setLayoutManager(layoutManager);
        onAmountChange();
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shopping;
    }


    @OnClick(R.id.btn_checked_to_pay)
    public void onViewClicked() {
        Intent intent = new Intent(this, FirmOrderActivity.class);
        List<ShoppingModel> list = shoppingList;
        intent.putExtra(FIRM_ORDER, (Serializable) list);
        startActivity(intent);
    }


    @Override
    public void onAmountChange() {
        double priceAll = 0.0;
        Iterator<ShoppingModel> iterator = shoppingList.iterator();
        while (iterator.hasNext()) {
            ShoppingModel shoppingModel = iterator.next();
            priceAll += shoppingModel.getAmount() * shoppingModel.getPrice();
        }
        price = priceAll;
        txtPriceAll.setText(String.valueOf(price));
    }
}
