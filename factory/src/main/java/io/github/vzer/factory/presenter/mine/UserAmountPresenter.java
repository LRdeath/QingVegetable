package io.github.vzer.factory.presenter.mine;

import io.github.vzer.common.factory.presenter.BasePresenter;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class UserAmountPresenter extends BasePresenter<UserAmountContract.View>
        implements UserAmountContract.Presenter {

    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public UserAmountPresenter(UserAmountContract.View mView) {
        super(mView);
    }
}
