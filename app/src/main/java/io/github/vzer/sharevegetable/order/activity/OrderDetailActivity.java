package io.github.vzer.sharevegetable.order.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.widget.ScreenUtil;
import io.github.vzer.factory.model.db.Vegetable;
import io.github.vzer.factory.model.order.OrderDetailModel;
import io.github.vzer.factory.presenter.order.OrderContract;
import io.github.vzer.factory.presenter.order.OrderPresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.adapter.OrderDetailListAdapter;
import io.github.vzer.sharevegetable.widget.NoTouchRecyclerView;

public class OrderDetailActivity extends ToolbarActivityPresenter<OrderContract.Presenter>
        implements OrderContract.View {

    @BindView(R.id.rec_order_detail)
    NoTouchRecyclerView orderDetailRec;
    @BindView(R.id.txt_payment_state)
    TextView paymentStateTxt;
    @BindView(R.id.txt_order_state_describe)
    TextView describeStateTxt;
    @BindView(R.id.txt_contract)
    TextView contractTxt;
    @BindView(R.id.txt_order_money)
    TextView orderMoneyTxt;
    @BindView(R.id.txt_order_describe)
    TextView describeTxt;
    @BindView(R.id.txt_order_time)
    TextView orderTimeTxt;
    @BindView(R.id.txt_order_number)
    TextView orderNumTxt;
    @BindView(R.id.txt_copy)
    TextView copyTxt;
    @BindView(R.id.btn_to_discuss)
    Button toDiscussBtn;
    @BindView(R.id.scroll_order_detail)
    ScrollView orderDetailScroll;
    private OrderDetailListAdapter adapter;
    private List<Vegetable> list;
    private OrderDetailModel orderDetailModel; //订单
    private LinearLayoutManager manager;

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle(getResources().getString(R.string.title_order_detail));
        initList();
        // TODO: 17/8/9 其他控件的内容初始化 
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_order_detail;
    }

    /**
     * 初始化list
     */
    private void initList() {
        // TODO: 17/8/4 从intent获取订单信息
//        orderDetailModel = (OrderDetailModel) getIntent().getSerializableExtra(KeyConstant.KEY_ORDER_DETAIL);
//        list = orderDetailModel.getpList();
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Vegetable());
        }
        adapter = new OrderDetailListAdapter(this, list);
        orderDetailRec.setAdapter(adapter);
        manager = new LinearLayoutManager(this);

        orderDetailRec.setLayoutManager(manager);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) orderDetailRec.getLayoutParams();
        params.height = ScreenUtil.dip2px(56) * adapter.getItemCount(); //计算rec高度，避免滑动
        orderDetailRec.setLayoutParams(params);
        orderDetailRec.setFocusable(false);
    }

    /**
     * 点击联系商家
     */
    @OnClick(R.id.txt_contract)
    void onContract() {
        String phoneNum = getResources().getString(R.string.text_phone_num);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 点击去评价
     */
    @OnClick(R.id.btn_to_discuss)
    void toDiscuss() {
        if (toDiscussBtn.getVisibility() == View.VISIBLE) {
            // TODO: 17/8/7 跳转到去评价界面
        }
    }

    /**
     * 点击复制文本
     */
    @OnClick(R.id.txt_copy)
    void copyOrderNum() {
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", orderNumTxt.getText());
        if (cm != null) {
            cm.setPrimaryClip(mClipData);
            ToastUtil.showToast(R.string.toast_copy_success);
        } else {
            ToastUtil.showToast(R.string.toast_copy_error);
        }

    }


    @Override
    public OrderContract.Presenter initPresenter() {
        return new OrderPresenter(this);
    }

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void loadOrderDetailListSuccess(List<OrderDetailModel> orderDetailModelList) {

    }

}
