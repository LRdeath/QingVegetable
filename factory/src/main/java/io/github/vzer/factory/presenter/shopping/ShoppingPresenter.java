package io.github.vzer.factory.presenter.shopping;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class ShoppingPresenter extends BasePresenter<ShoppingContract.View>
        implements ShoppingContract.Presenter, DataCallback {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public ShoppingPresenter(ShoppingContract.View mView) {
        super(mView);
    }
}
