package io.github.vzer.sharevegetable.shopping.activity;

import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.ToolbarActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.sharevegetable.R;

/**
 * 选择礼品卡Activity
 *
 * @author: Vzer.
 * @date: 2017/8/10. 22:57
 * @email: vzer@qq.com
 */

public class GiftActivity extends ToolbarActivityPresenter {


    @Override
    protected void initData() {

    }

    @Override
    public void initWidget() {
        setActivityTitle("选择礼品卡");
    }

    @Override
    protected void initWindows() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_firm_gift;
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
