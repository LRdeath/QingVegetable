package io.github.vzer.sharevegetable.shopping.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.presenter.shopping.ShoppingContract;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.Adapter.OrderAdapter;

/**
 * @author abtion.
 * @since 17/8/5 19:17.
 * email caiheng@hrsoft.net
 */

public class FirmOrderActivity extends ToolbarActivityPresenter<ShoppingContract.Presenter> {
    @BindView(R.id.txt_address)
    TextView txtAddress;
    @BindView(R.id.rec_firm_order)
    RecyclerView recFirmOrder;
    @BindView(R.id.txt_price_in_all)
    TextView txtPriceInAll;
    @BindView(R.id.txt_payment)
    TextView txtPayment;
    private List<ShoppingModel> orderList;
    private double price = 0.0;

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }


    @Override
    protected void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        orderList = (List<ShoppingModel>) bundle.get(ShoppingActivity.FIRM_ORDER);
    }

    @Override
    public void initWidget() {
        setActivityTitle("确认订单信息");
        OrderAdapter adapter = new OrderAdapter(this,orderList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recFirmOrder.setAdapter(adapter);
        recFirmOrder.setLayoutManager(layoutManager);
        caclulatePayment();
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_firm_order;
    }

    @Override
    public ShoppingContract.Presenter initPresenter() {
        return null;
    }

    private void caclulatePayment(){
        double priceAll = 0.0;
        Iterator<ShoppingModel> iterator = orderList.iterator();
        while (iterator.hasNext()) {
            ShoppingModel shoppingModel = iterator.next();
            priceAll += shoppingModel.getAmount() * shoppingModel.getPrice();
        }
        price = priceAll;
        txtPayment.setText(String.valueOf(price));
        txtPriceInAll.setText(String.valueOf(price));
    }
}
