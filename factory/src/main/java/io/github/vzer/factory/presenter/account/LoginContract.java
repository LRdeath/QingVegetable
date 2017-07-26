package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 16:55
 * @email: vzer@qq.com
 */

public interface LoginContract {
    interface View extends BaseContract.View<Presenter>{

        void loginSuccess();//登陆成功回调
    }
    interface Presenter extends BaseContract.Presenter{

        void login(String phone,String password);//登陆时调用
    }
}
