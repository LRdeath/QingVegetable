package io.github.vzer.factory.model.mine.coupon;

import java.io.Serializable;
import java.util.List;

/**
 * @author YangCihang
 * @since 17/8/22.
 * email yangcihang@hrsoft.net
 */

public class CouponResponse implements Serializable {
    private List<CouponModel> coupons;

    public void setCoupons(List<CouponModel> coupons) {
        this.coupons = coupons;
    }

    public List<CouponModel> getCoupons() {
        return coupons;
    }
}
