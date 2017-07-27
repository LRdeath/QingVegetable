package io.github.vzer.sharevegetable.mine;

import android.os.Bundle;

import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.mine.MineContract;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class MineFragment extends FragmentPresenter<MineContract.Presenter> implements MineContract.View{
    @Override
    public void showLoading() {

    }

    @Override
    protected MineContract.Presenter initPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_mine;
    }
}
