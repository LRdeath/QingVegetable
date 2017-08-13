package io.github.vzer.sharevegetable.shopping.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.presenter.shopping.ShoppingContract;
import io.github.vzer.factory.presenter.shopping.ShoppingPresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.OnAmountChangeListener;
import io.github.vzer.sharevegetable.shopping.adapter.ShoppingContentAdapter;
import io.github.vzer.sharevegetable.vegetable.ShoppingManager;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class ShoppingActivity extends ToolbarActivity
        implements OnAmountChangeListener {

    public static OnAmountChangeListener onAmountChangeListener;
    public static String FIRM_ORDER = "firmOrder";

    @BindView(R.id.rec_shopping)
    RecyclerView recShopping;
    @BindView(R.id.txt_price_all)
    TextView txtPriceAll;
    @BindView(R.id.btn_checked_to_pay)
    Button btnCheckedToPay;
    @BindView(R.id.layl_shoppint_empty)
    LinearLayout emptyLayl;
    private ArrayList<VegetableModel> shoppingList;
    private double price = 0.0;
    private ShoppingContentAdapter adapter;



    @Override
    protected void initData() {
        shoppingList = (ArrayList<VegetableModel>) ShoppingManager.getInstance().getShoppingList();
        onAmountChangeListener = this;
    }

    @Override
    public void initWidget() {
        setActivityTitle(getResources().getString(R.string.title_shopping));
        adapter = new ShoppingContentAdapter(this, shoppingList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recShopping.setAdapter(adapter);
        recShopping.setLayoutManager(layoutManager);
        onAmountChange();
        if (shoppingList.isEmpty()) emptyLayl.setVisibility(View.VISIBLE);

    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shopping;
    }


    /**
     * 跳转订单确认界面
     */
    @OnClick(R.id.btn_checked_to_pay)
    public void onViewClicked() {
        if(shoppingList==null ||shoppingList.isEmpty()){
            ToastUtil.showToast(R.string.shopping_empty);
            return;
        }
        Intent intent = new Intent(this, FirmOrderActivity.class);
        ShoppingManager.modelList = shoppingList;
        startActivity(intent);
        finish();
        // TODO: 17/8/6 清空购物车

    }

    /**
     * 更新总金额
     */
    @Override
    public void onAmountChange() {
        double priceAll = 0.0;
        if (shoppingList!=null){
            Iterator<VegetableModel> iterator = shoppingList.iterator();
            while (iterator.hasNext()) {
                VegetableModel shoppingModel = iterator.next();
                priceAll += shoppingModel.getCount() * shoppingModel.getPrice();
            }
        }
        price = priceAll;
        txtPriceAll.setText(String.valueOf(price));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.refresh();
    }

}
