package io.github.vzer.sharevegetable.find;

import android.os.Bundle;
import android.view.View;

import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.find.FindContract;
import io.github.vzer.factory.presenter.find.FindPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class FindFragment extends FragmentPresenter<FindContract.Presenter> implements FindContract.View {
    @Override
    public void showLoading() {

    }

    @Override
    protected FindContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initWidget(View root) {

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_find;
    }
}
