package io.github.vzer.factory.presenter.mine;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public interface MineContract  {
    interface View extends BaseContract.View<Presenter>{

    }
    interface Presenter extends BaseContract.Presenter{
        void goLogin();

        /**
         * 修改性别，男为true，女为false
         *
         */
        boolean changeSex(boolean sex);

        boolean changeUserName(String newUserName);

        boolean changeTrueName(String newTrueName);

        boolean changeAvatar(String uri);
    }
}
