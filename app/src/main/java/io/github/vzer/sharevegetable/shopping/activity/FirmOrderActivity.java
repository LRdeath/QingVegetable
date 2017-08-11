package io.github.vzer.sharevegetable.shopping.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.widget.ScreenUtil;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.model.shopping.ShoppingOrderModel;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.persistence.Account;
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
    NoTouchRecyclerView recFirmOrder; //蔬菜列表RecyclerView
    @BindView(R.id.txt_price_in_all)
    TextView txtPriceInAll; //显示 蔬菜金额合计
    @BindView(R.id.txt_firm_payment)
    TextView txtPayment;  //显示 底部应付金额
    @BindView(R.id.txt_remark)
    TextView remarkTxt; //显示 备注txt
    @BindView(R.id.txt_firm_pickup_name)
    TextView namePickupTxt; //显示收货人姓名
    @BindView(R.id.txt_firm_phone)
    TextView phoneTxt; //显示收货人电话
    @BindView(R.id.txt_firm_place)
    TextView placeTxt; //显示收货地点
    @BindView(R.id.txt_firm_balance)
    TextView balanceTxt; //显示账户余额
    @BindView(R.id.txt_firm_price_real)
    TextView realPriceTxt; //显示应付金额
    @BindView(R.id.txt_firm_type)
    TextView selectTypeTxt; //显示 选择的支付方式
    @BindView(R.id.txt_firm_discount)
    TextView discountTxt; //显示 优惠券信息
    @BindView(R.id.txt_firm_gift)
    TextView giftTxt; //显示 礼品卡信息
    @BindView(R.id.txt_firm_credits)
    TextView creditsTxt; //显示积分
    @BindView(R.id.txt_firm_credits_money)
    TextView creditsMoneyTxt; // 显示积分抵钱金额
    @BindView(R.id.cb_firm_balance)
    CheckBox balanceCBox; //是否使用余额支付
    @BindView(R.id.cb_firm_credits)
    CheckBox creditsCBox; //是否使用积分


    private List<io.github.vzer.factory.model.vegetable.VegetableModel> orderList;
    private double mPrice = 0.0;//商品总价
    public static String REMARK_CODE = "remark";
    public static String PAY_ORDER = "PayOrder";
    private List<ShoppingModel> list = new ArrayList<>();//商品列表
    private String remarkStr = "";//商品备注
    private int curPayType = SelectPayActivity.WECHAT_PAY;


    /**
     * 跳转选择收货地点
     */
    @OnClick(R.id.firm_location)
    void goLocation() {

    }

    /**
     * 跳转选择优惠券
     */
    @OnClick(R.id.firm_discount)
    void goDiscount() {

    }

    /**
     * 跳转选择礼品卡
     */
    @OnClick(R.id.firm_gift)
    void goGift() {

    }

    /**
     * 跳转选择支付方式
     */
    @OnClick(R.id.firm_pay_type)
    void goPayType() {
        Intent intent = new Intent(this, SelectPayActivity.class);
        intent.putExtra(SelectPayActivity.PAY_TYPE, curPayType);
        startActivityForResult(intent, 2);

    }
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
        setActivityTitle("结算中心");
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
