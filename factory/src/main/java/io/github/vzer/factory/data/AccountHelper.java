package io.github.vzer.factory.data;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.factory.model.RspModel;
import io.github.vzer.factory.model.account.AccountRspModel;
import io.github.vzer.factory.model.db.User;
import io.github.vzer.factory.model.account.LoginModel;
import io.github.vzer.factory.model.account.RegisterModel;
import io.github.vzer.factory.network.NetWork;
import io.github.vzer.factory.network.RemoteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Vzer.
 * @date: 2017/7/25. 17:05
 * @email: vzer@qq.com
 */

public class AccountHelper {

    public static void login(LoginModel model, DataCallback.Callback<User> callback) {
        // TODO: 2017/7/25 网络请求加载
        RemoteService service = NetWork.getService();
        Call<RspModel<AccountRspModel>> call = service.login(model);
        call.enqueue(new Callback<RspModel<AccountRspModel>>() {
            @Override
            public void onResponse(Call<RspModel<AccountRspModel>> call, Response<RspModel<AccountRspModel>> response) {
                RspModel<AccountRspModel> rspModel = response.body();//拿到实体
                int code = rspModel.getCode();//得到返回码;
            }

            @Override
            public void onFailure(Call<RspModel<AccountRspModel>> call, Throwable t) {

            }
        });
        //如果数据加载成功,
        if (callback != null)
            callback.onDataLoaded(null);
    }
}
