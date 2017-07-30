package io.github.vzer.sharevegetable.vegetable;

import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class VegetableFragment extends FragmentPresenter<VegetableContract.Presenter>implements VegetableContract.View{
    @Override
    public void showLoading() {
    }

    @Override
    protected VegetableContract.Presenter initPresenter() {
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
        return R.layout.fragment_vegetable;
    }
}
