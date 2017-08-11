package io.github.vzer.sharevegetable.shopping.activity;

import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/8/10. 23:04
 * @email: vzer@qq.com
 */

public class SelectPayActivity extends ToolbarActivity {
    public static int WECHAT_PAY = 1; //微信支付
    public static String PAY_TYPE = "select_payType";

    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle("选择支付方式");
    }

    @Override
    protected void initWindows() {
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_firm_select_pay;
    }
}
