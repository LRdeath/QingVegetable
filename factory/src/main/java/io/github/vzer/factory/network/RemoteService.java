package io.github.vzer.factory.network;

import io.github.vzer.factory.model.account.AccountRspModel;
import io.github.vzer.factory.model.account.LoginModel;
import io.github.vzer.factory.model.mine.coupon.CouponModel;
import io.github.vzer.factory.model.mine.coupon.CouponResponse;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * 网络接口请求类
 *
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

    @GET("user/trade/list")
    Call<RspModel<UserWalletOrderResponse>> requestAllWalletOrder(@Query("page") int pageId, @Query("rows") int rowsId);

    @GET("user/trade/withdraw/request")
    Call<RspModel<UserWalletOrderResponse>> requestWithdrawWalletOrder(@Query("page") int pageId, @Query("rows") int rowsId);

    @GET("user/trade/back/request")
    Call<RspModel<UserWalletOrderResponse>> requestRefundsWalletOrder(@Query("page") int pageId, @Query("rows") int rowsId);

    @GET("user/coupons")
    Call<RspModel<CouponResponse>> requestCoupon();

}
