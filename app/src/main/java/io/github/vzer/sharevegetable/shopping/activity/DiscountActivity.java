package io.github.vzer.sharevegetable.shopping.activity;

import android.widget.LinearLayout;

import butterknife.BindView;
import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.sharevegetable.R;

/**
 * 选择优惠券Activity
 *
 * @author: Vzer.
 * @date: 2017/8/10. 22:56
 * @email: vzer@qq.com
 */

public class DiscountActivity extends ToolbarActivityPresenter {
    @BindView(R.id.layl_firm_discount_empty)
    LinearLayout emptyLayl;

    @Override
    protected void initData() {
    }

    @Override
    public void initWidget() {
        setActivityTitle("选择优惠券");
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_firm_discount;
    }

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public BaseContract.Presenter initPresenter() {
        return null;
    }
}
