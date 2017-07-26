package io.github.vzer.sharevegetable.account;


import android.os.Bundle;
import android.view.View;

import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.account.RegisterContract;
import io.github.vzer.factory.presenter.account.RegisterPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 21.01
 * @email: vzer@qq.com
 */
public class RegisterFragment extends FragmentPresenter<RegisterContract.Presenter> implements RegisterContract.View {


    @Override
    protected void initDatas() {

    }

    @Override
    protected void initWidet(View root) {

    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_register;
    }

    /**
     * 注册成功的处理方法
     * P层回调此方法
     */
    @Override
    public void registerSuccess() {

    }

    @Override
    protected RegisterContract.Presenter initPresenter() {
        //创建P层
        return new RegisterPresenter(this);
    }
}
