package io.github.vzer.factory.presenter.vegetable;

import io.github.vzer.common.factory.presenter.BaseContract;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public interface VegetableContract {
    interface View extends BaseContract.View<Presenter> {
        // TODO: 17/7/27 Vegetable的view层回调方法
    }
    interface Presenter extends BaseContract.Presenter{
        // TODO: 17/7/27 Vegetable的presenter层回调方法
    }
}
