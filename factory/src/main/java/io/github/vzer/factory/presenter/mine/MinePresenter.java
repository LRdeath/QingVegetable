package io.github.vzer.factory.presenter.mine;

import io.github.vzer.common.factory.data.DataCallback;
import io.github.vzer.common.factory.presenter.BasePresenter;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class MinePresenter extends BasePresenter<MineContract.View>
        implements MineContract.Presenter,DataCallback{
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public MinePresenter(MineContract.View mView) {
        super(mView);
    }
}
