package io.github.vzer.factory.presenter.mine;

import java.util.List;

import io.github.vzer.common.factory.presenter.BaseContract;
import io.github.vzer.factory.model.mine.coupon.CouponModel;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public interface CouponContract {
    interface View extends BaseContract.View<Presenter> {
        void onDataLoadSuccess(List<CouponModel> couponModelList);

        void onDataLoadFailed();
    }

    interface Presenter extends BaseContract.Presenter {
        void requestCoupon();
    }
}
