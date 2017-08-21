package io.github.vzer.factory.presenter.mine;

import io.github.vzer.common.factory.presenter.BasePresenter;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletPresenter extends BasePresenter<WalletContract.View>
        implements WalletContract.Presenter {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public WalletPresenter(WalletContract.View mView) {
        super(mView);
    }
}
