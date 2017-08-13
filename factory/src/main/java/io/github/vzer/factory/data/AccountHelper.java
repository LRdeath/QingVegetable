package io.github.vzer.factory.data;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.factory.R;
import io.github.vzer.factory.model.RspModel;
import io.github.vzer.factory.model.account.AccountRspModel;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.model.account.LoginModel;
import io.github.vzer.factory.model.account.RegisterModel;
import io.github.vzer.factory.network.NetWork;
import io.github.vzer.factory.network.RemoteService;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.presenter.account.RegisterPresenter;
import io.github.vzer.factory.presenter.account.RetrivePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 17:05
 * @email: vzer@qq.com
 */

public class AccountHelper {

    public static void login(LoginModel model, final DataCallback.Callback<User> callback) {
        // TODO: 2017/7/25 网络请求加载

       /* NetWork.getService()
                .login(model)
                .enqueue(new Callback<RspModel<AccountRspModel>>() {
                    @Override
                    public void onResponse(Call<RspModel<AccountRspModel>> call, Response<RspModel<AccountRspModel>> response) {
                        RspModel<AccountRspModel> rspModel = response.body();//拿到实体
                        int code = rspModel.getCode();//得到返回码;

                        //如果数据加载成功,
                        if (callback != null)
                            callback.onDataLoaded(null);
                    }

                    @Override
                    public void onFailure(Call<RspModel<AccountRspModel>> call, Throwable t) {
                       if (callback!=null){
                           //网络请求失败
                           callback.onFailedLoaded(R.string.data_network_error);
                       }
                    }
                });*/
        User user = new User();
        user.setuId(1234567890);
        user.setBind(true);
        user.setMobile(model.getPhone());
        user.setName("未设置");
        user.setRealName(null);
        user.setToken("u5fjgh9f6hfd21bduik8723d8ty");
        Account.login(user);
        callback.onDataLoaded(user);

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
