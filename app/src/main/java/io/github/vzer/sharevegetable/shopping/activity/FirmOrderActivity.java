package io.github.vzer.sharevegetable.shopping.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.ScreenUtil;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.presenter.shopping.ShoppingContract;
import io.github.vzer.factory.presenter.shopping.ShoppingPresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.adapter.OrderAdapter;
import io.github.vzer.sharevegetable.vegetable.ShoppingManager;
import io.github.vzer.sharevegetable.widget.NoTouchRecyclerView;

/**
 * 确认订单页面
 *
 * @author abtion.
 * @since 17/8/5 19:17.
 * email caiheng@hrsoft.net
 */

public class FirmOrderActivity extends ToolbarActivity {

    @BindView(R.id.rec_firm_order)
    NoTouchRecyclerView recFirmOrder;
    @BindView(R.id.txt_price_in_all)
    TextView txtPriceInAll;
    @BindView(R.id.txt_payment)
    TextView txtPayment;
    @BindView(R.id.txt_remark)
    TextView remarkTxt;

    private List<io.github.vzer.factory.model.vegetable.VegetableModel> orderList;
    private double mPrice = 0.0;//商品总价
    public static String REMARK_CODE = "remark";
    public static String PAY_ORDER = "PayOrder";
    private List<ShoppingModel> list = new ArrayList<>();//商品列表
    private String remarkStr = "";//商品备注

    /**
     * 跳转备注页面
     */
    @OnClick(R.id.go_shopping_remark)
    void goRemark() {
        Intent intent = new Intent(this, RemarkActivity.class);
        intent.putExtra(REMARK_CODE, remarkStr);
        startActivityForResult(intent, 1);
    }

    /**
     * 发送创建订单请求
     */
    @OnClick(R.id.txt_pay)
    public void onViewClicked() {
        //拿到用户id
        // TODO: 2017/8/8
        int uId = 0;
        ShoppingOrderModel orderModel = new ShoppingOrderModel(uId, list, mPrice, remarkStr);
        Intent intent = new Intent(this, PayOnlineActivity.class);
        intent.putExtra(PAY_ORDER, orderModel);
        startActivity(intent);

    }

    /**
     * 备注页面回传备注内容
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 3) {
            remarkStr = data.getExtras().getString(REMARK_CODE);
            if (!TextUtils.isEmpty(remarkStr)) {
                remarkTxt.setText(remarkStr);
            } else {
                remarkTxt.setText(getResources().getString(R.string.remark));
            }
        }
    }

    @Override
    protected void initData() {
        orderList = ShoppingManager.getInstance().getShoppingList();
        ShoppingManager.modelList = null;
        for (VegetableModel vegetableModel :
                orderList) {
            double price = vegetableModel.getCount() * vegetableModel.getPrice();
            mPrice += price;
            ShoppingModel model = new ShoppingModel(vegetableModel.getpId(), vegetableModel.getCount(), price);
            list.add(model);
        }

    }

    @Override
    public void initWidget() {
        setActivityTitle("订单预计送到");
        OrderAdapter adapter = new OrderAdapter(this, orderList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recFirmOrder.setAdapter(adapter);
        recFirmOrder.setLayoutManager(layoutManager);
        txtPayment.setText(String.valueOf(mPrice));
        txtPriceInAll.setText(String.valueOf(mPrice));

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) recFirmOrder.getLayoutParams();
        layoutParams.height = orderList.size() * ScreenUtil.dip2px(48);
        recFirmOrder.setLayoutParams(layoutParams);
        recFirmOrder.setFocusable(false);
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_firm_order;
    }



}
