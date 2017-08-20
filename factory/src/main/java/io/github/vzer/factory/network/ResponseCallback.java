package io.github.vzer.factory.network;

import io.github.vzer.factory.R;
import io.github.vzer.factory.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 统一的响应回调
 *
 * @author YangCihang
 * @since 17/8/20.
 * email yangcihang@hrsoft.net
 */

public class ResponseCallback<T> implements Callback<RspModel<T>> {
    private DataCallback<T> onDataCallback;

    public ResponseCallback(DataCallback callback) {
        this.onDataCallback = callback;
    }

    //成功时回调
    @Override
    public void onResponse(Call<RspModel<T>> call, Response<RspModel<T>> response) {
        if (response.raw().code() < HttpStateCode.REQUEST_SUCCESS) {
            if (response.body().getCode() == RspCode.SUCCEED) {
                if (onDataCallback != null) {
                    onDataCallback.onDataSuccess(response.body().getData());
                }
            } else {
                GlobalAPIErrorHandler.handle(response.body().getCode());
                onDataCallback.onDataFailed(response.body().getCode());
            }
        } else {
            onDataCallback.onDataFailed(response.raw().code());
            GlobalAPIErrorHandler.handle(response.raw().code());
        }
    }

    //失败时回调
    @Override
    public void onFailure(Call<RspModel<T>> call, Throwable t) {
        onDataCallback.onDataFailed(-1);
        ToastUtil.showToast(R.string.data_network_error);
    }

    /**
     * 内部获取model的接口
     */
    public interface DataCallback<T> {
        //数据加载成功时回调
        void onDataSuccess(T data);

        //数据加载失败时回调
        void onDataFailed(int errorCode);
    }
}


