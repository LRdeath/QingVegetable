package io.github.vzer.factory.presenter.lock;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;

/**
 * @author YangCihang
 * @since 17/8/3.
 * email yangcihang@hrsoft.net
 */

public class UnlockPresenter extends BasePresenter<UnlockContract.View>
        implements UnlockContract.Presenter, DataCallback {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public UnlockPresenter(UnlockContract.View mView) {
        super(mView);
    }
}
