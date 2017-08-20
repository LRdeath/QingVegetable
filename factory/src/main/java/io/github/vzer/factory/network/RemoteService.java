package io.github.vzer.factory.network;

import io.github.vzer.factory.model.account.AccountRspModel;
import io.github.vzer.factory.model.account.LoginModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * 网络接口请求类
 * @author: Vzer.
 * @date: 2017/7/25. 15:54
 * @email: vzer@qq.com
 */

public interface RemoteService {

    /**
     * 登录接口
     *
     * @param model 出入LoginModel
     * @return 返回 <RspModel<AccountRspModel>>
     */
    // TODO: 2017/7/26 后端给接口
    @POST("user/login")
    Call<RspModel<AccountRspModel>> login(@Body LoginModel model);


}
