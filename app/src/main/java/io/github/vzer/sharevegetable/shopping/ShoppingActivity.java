package io.github.vzer.sharevegetable.shopping;

import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.app.BaseActivity;
import io.github.vzer.common.app.ToolbarActivityPresenter;
import io.github.vzer.factory.presenter.shopping.ShoppingContract;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class ShoppingActivity extends ToolbarActivityPresenter<ShoppingContract.Presenter>
        implements ShoppingContract.View {


    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public ShoppingContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

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
