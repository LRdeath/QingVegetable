package io.github.vzer.factory.presenter.account;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * @author: Vzer.
 * @date: 2017/7/29. 13:24
 * @email: vzer@qq.com
 */

public interface RetriveContract {
    interface View extends BaseContract.View<Presenter> {
        void resetSuccess();
    }

    interface Presenter extends BaseContract.Presenter {
        void postVerify(String phone);

        void resetPassword(String phone, String password, String rePassword, String code);
    }
}
