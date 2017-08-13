package io.github.vzer.sharevegetable.shopping.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/8/10. 23:04
 * @email: vzer@qq.com
 */

public class SelectPayActivity extends ToolbarActivity {
    public static final int WECHAT_PAY = 1; //微信支付
    public static final int ALI_PAY = 2;//支付宝支付
    public static String PAY_TYPE = "select_payType";

    private int curPay;//当前支付方式

    @BindView(R.id.img_select_pay_wechat)
    ImageView wechatImg; //选择微信支付
    @BindView(R.id.img_select_pay_alipay)
    ImageView alipayImg; //选择支付宝支付


    @OnClick(R.id.layl_select_pay_wechat)
    void selectWechat() {
        setResult(4, getIntent().putExtra(PAY_TYPE, WECHAT_PAY));
        finish();
    }

    @OnClick(R.id.layl_select_pay_alipay)
    void selectAlipay() {
        setResult(4, getIntent().putExtra(PAY_TYPE, ALI_PAY));
        finish();
    }
    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle("选择支付方式");
        switch (curPay) {
            case WECHAT_PAY:
                wechatImg.setVisibility(View.VISIBLE);
                break;
            case ALI_PAY:
                alipayImg.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void initWindows() {
    }

    @Override
    protected boolean initArgs(Bundle extras) {
        curPay = extras.getInt(PAY_TYPE);
        return super.initArgs(extras);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_firm_select_pay;
    }
}
