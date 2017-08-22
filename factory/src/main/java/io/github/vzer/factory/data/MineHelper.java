package io.github.vzer.factory.data;

import android.text.TextUtils;
import android.util.Log;

import io.github.vzer.factory.Factory;
import io.github.vzer.factory.model.mine.coupon.CouponResponse;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderResponse;
import io.github.vzer.factory.network.NetWork;
import io.github.vzer.factory.network.ResponseCallback;
import io.github.vzer.factory.network.UploadHelper;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.presenter.mine.CouponPresenter;
import io.github.vzer.factory.presenter.mine.MinePresenter;
import io.github.vzer.factory.presenter.mine.UserAmountPresenter;
import io.github.vzer.factory.utils.ToastUtil;

/**
 * @author YangCihang
 * @since 17/8/7.
 * email yangcihang@hrsoft.net
 */

public class MineHelper {

    /**
     * 修改用户图像
     */
    public static boolean updateAvatarRequest(final String uri, MinePresenter callback) {

        Factory.runOnAsync(new Runnable() {
            @Override
            public void run() {
                String url = UploadHelper.uploadPortrait(uri);//得到图片云端地址
                if (!TextUtils.isEmpty(url)) {
                    Log.d("TAG", url);
                    Account.setPortrait(uri);
                    // TODO: 2017/8/14 头像url 上传给服务端
                }
            }
        });
        return true;
    }

    /**
     * 修改用户性别
     */
    public static boolean updateSexRequest(MinePresenter callback) {
        return true;

    }

    /**
     * 修改用户名
     */
    public static boolean updateUserNameRequest(MinePresenter callback) {
        return true;

    }

    /**
     * 修改用户真实姓名
     */
    public static boolean updateUserTrueNameRequest(MinePresenter callback) {
        return true;

    }

    /**
     * 请求所有交易的明细
     */
    public static void requestAllAccount(int page, int rows, final UserAmountPresenter callback) {
        NetWork.getService().
                requestAllWalletOrder(page, rows).
                enqueue(new ResponseCallback<UserWalletOrderResponse>(new ResponseCallback.DataCallback() {
                    @Override
                    public void onDataSuccess(Object data) {
                        UserWalletOrderResponse response = (UserWalletOrderResponse) data;
                        callback.onDataLoadedSuccess(response.getList(), response.isLastPage());
                    }

                    @Override
                    public void onDataFailed(int errorCode) {
                        callback.onDataLoadedFailed();
                    }
                }));
    }

    /**
     * 请求退款交易明细
     */
    public static void requestRefundsAccount(int page, int rows, final UserAmountPresenter callback) {
        NetWork.getService().
                requestRefundsWalletOrder(page, rows).
                enqueue(new ResponseCallback<UserWalletOrderResponse>(new ResponseCallback.DataCallback() {
                    @Override
                    public void onDataSuccess(Object data) {
                        UserWalletOrderResponse response = (UserWalletOrderResponse) data;
                        callback.onDataLoadedSuccess(response.getList(), response.isLastPage());
                    }

                    @Override
                    public void onDataFailed(int errorCode) {

                    }
                }));
    }

    /**
     * 请求提现明细
     */
    public static void requestWithdrawAccount(int page, int rows, final UserAmountPresenter callback) {
        NetWork.getService().
                requestWithdrawWalletOrder(page, rows).
                enqueue(new ResponseCallback<UserWalletOrderResponse>(new ResponseCallback.DataCallback() {
                    @Override
                    public void onDataSuccess(Object data) {
                        UserWalletOrderResponse response = (UserWalletOrderResponse) data;
                        callback.onDataLoadedSuccess(response.getList(), response.isLastPage());
                    }

                    @Override
                    public void onDataFailed(int errorCode) {

                    }
                }));
    }

    /**
     * 获取优惠券的请求
     */
    public static void requestCoupon(final CouponPresenter callback) {
        NetWork.getService()
                .requestCoupon()
                .enqueue(new ResponseCallback<CouponResponse>(new ResponseCallback.DataCallback() {
                    @Override
                    public void onDataSuccess(Object data) {
                        CouponResponse response = (CouponResponse) data;
                        callback.onDataLoadSuccess(response.getCoupons());
                    }

                    @Override
                    public void onDataFailed(int errorCode) {
                        callback.onDataLoadFailed();
                    }
                }));
    }
}
