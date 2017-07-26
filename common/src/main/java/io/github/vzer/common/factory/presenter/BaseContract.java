package io.github.vzer.common.factory.presenter;

import android.support.annotation.StringRes;

/**
 * MVP模式中 公共的基本契约
 *
 * @author: Vzer.
 * @date: 2017/7/25.
 * @email: vzer@qq.com
 */

public interface BaseContract {

    interface View<T extends Presenter>{
        /**
         * 提示错误信息
         * @param strId 字符串资源id
         */
        void showError(@StringRes int strId);

        /**
         * 显示等待进度条
         */
        void showLoading();

        /**
         * 绑定一个Presenter
         */
        void setPresenter(T presenter);

    }
    interface Presenter{

        /**
         * 初始化方法
         */
        void start();

        /**
         * 销毁时回调
         * 防止内存泄漏
         */
        void destory();
    }
}
