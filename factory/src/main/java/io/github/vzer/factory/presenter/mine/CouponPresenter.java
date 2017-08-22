package io.github.vzer.factory.presenter.mine;

import java.util.List;

import io.github.vzer.common.factory.presenter.BasePresenter;
import io.github.vzer.factory.data.MineHelper;
import io.github.vzer.factory.model.mine.coupon.CouponModel;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class CouponPresenter extends BasePresenter<CouponContract.View>
        implements CouponContract.Presenter {
    /**
     * P层构造方法;
     * 创建P层时就进行双向绑定
     *
     * @param mView V层的引用
     */
    public CouponPresenter(CouponContract.View mView) {
        super(mView);
    }

    /**
     * 请求优惠券信息
     */
    @Override
    public void requestCoupon() {
        MineHelper.requestCoupon(this);
    }

    public void onDataLoadSuccess(List<CouponModel> modelList) {
        mView.onDataLoadSuccess(modelList);
    }

    public void onDataLoadFailed() {
        mView.onDataLoadFailed();
    }
}
