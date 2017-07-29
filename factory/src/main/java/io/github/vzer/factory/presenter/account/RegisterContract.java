package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * 注册V层与P层的契约
 * @author: Vzer.
 * @date: 2017/7/25. 18:55
 * @email: vzer@qq.com
 */

public interface RegisterContract {

    interface Presenter extends BaseContract.Presenter{
        //进行注册
        void register(String phone, String password, String rePassword, String code);

        //获取验证码
        void postVerify(String phone);
    }
    interface View extends BaseContract.View<Presenter>{
        //注册成功
        void registerSuccess();
    }
}
