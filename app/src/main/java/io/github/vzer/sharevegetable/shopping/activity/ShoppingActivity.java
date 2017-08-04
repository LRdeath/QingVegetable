package io.github.vzer.sharevegetable.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.presenter.shopping.ShoppingContract;
import io.github.vzer.factory.presenter.shopping.ShoppingPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.Adapter.ShoppingContentAdapter;
import io.github.vzer.sharevegetable.vegetable.VegetableFragment;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class ShoppingActivity extends ToolbarActivityPresenter<ShoppingContract.Presenter>
        implements ShoppingContract.View {

    @BindView(R.id.rec_shopping)
    RecyclerView recShopping;
    private ArrayList<ShoppingModel> shoppingList;

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
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        shoppingList = (ArrayList<ShoppingModel>) bundle.get(VegetableFragment.VEGETABLE_SHOPPING);
        Log.d("tag", String.valueOf(shoppingList.get(0).getName()));
        ShoppingContentAdapter adapter = new ShoppingContentAdapter(this,shoppingList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recShopping.setAdapter(adapter);
        recShopping.setLayoutManager(layoutManager);
    }

    @Override
    public void initWidget() {
        setActivityTitle(getResources().getString(R.string.title_shopping));

    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shopping;
    }



}
