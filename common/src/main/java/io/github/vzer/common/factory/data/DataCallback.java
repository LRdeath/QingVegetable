package io.github.vzer.common.factory.data;

import android.support.annotation.StringRes;

/**
 * 数据加载回调接口
 * @author: Vzer.
 * @date: 2017/7/25. 17:09
 * @email: vzer@qq.com
 */

public interface DataCallback {

    /**
     * 数据加载失败和成功都关注
     * @param <T> 返回数据类型
     */
    interface Callback<T> extends SuccessCallback<T>,FailedCallback{
    }
    /**
     * 只关注数据加载成功的接口
     * @param <T>
     */
    interface SuccessCallback<T>{
        void onDataLoaded(T t);
    }

    /**
     * 只关注数据加载失败的接口
     *
     */
    interface FailedCallback{
        void onFailedLoaded(@StringRes int error);
    }
}
