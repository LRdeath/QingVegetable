package io.github.vzer.factory.data;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.factory.model.account.AccountRspModel;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.model.account.LoginModel;
import io.github.vzer.factory.model.account.RegisterModel;
import io.github.vzer.factory.network.NetWork;
import io.github.vzer.factory.network.ResponseCallback;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.presenter.account.RegisterPresenter;
import io.github.vzer.factory.presenter.account.RetrivePresenter;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 17:05
 * @email: vzer@qq.com
 */

public class AccountHelper {

    public static void login(LoginModel model, final DataCallback.Callback<User> callback) {
        // TODO: 2017/7/25 网络请求加载
        NetWork.getService().login(model).enqueue(new ResponseCallback<AccountRspModel>(new ResponseCallback.DataCallback() {
            @Override
            public void onDataSuccess(Object data) {
                AccountRspModel accountRspModel = (AccountRspModel) data;
                User user = accountRspModel.getUser();
                user.setToken(accountRspModel.getToken());
//                user.setId(1234567890);
//                user.setBind(true);
//                user.setMobile(model.getMobile());
//                user.setName("未设置");
//                user.setRealName(null);
//                user.setToken("u5fjgh9f6hfd21bduik8723d8ty");
                Account.login(user);
                callback.onDataLoaded(user);
            }

            @Override
            public void onDataFailed(int errorCode) {
                callback.onFailedLoaded(errorCode);
            }
        }));
    }

    /**
     * 注册
     */
    public static void register(RegisterModel model, RegisterPresenter registerPresenter) {

    }

    /**
     * 重置密码 网络请求
     */
    public static void resetPassword(RegisterModel model, RetrivePresenter retrivePresenter) {

    }

    /**
     * 获取验证码 网络请求
     */
    public static void postVerify(String phone) {

    }
}
