package io.github.vzer.sharevegetable.account;

import android.os.Bundle;
import android.view.View;

import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.presenter.account.LoginContract;
import io.github.vzer.factory.presenter.account.LoginPresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 17.01
 * @email: vzer@qq.com
 */
public class LoginFragment extends FragmentPresenter<LoginContract.Presenter> implements LoginContract.View {


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
        return R.layout.fragment_login;
    }

    /**
     * 登陆成功后
     */
    @Override
    public void loginSuccess() {

    }

    @Override
    protected LoginContract.Presenter initPresenter() {
        //创建P层
        return new LoginPresenter(this);
    }
}
