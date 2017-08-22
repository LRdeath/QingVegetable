package io.github.vzer.factory.model.mine.coupon;

import java.io.Serializable;
import java.util.List;

import io.github.vzer.factory.model.vegetable.ProductModel;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class CouponModel implements Serializable {

    private CouponItemModel couponsItem;
    private List<ProductModel> productsList;

    public void setProductsList(List<ProductModel> productsList) {
        this.productsList = productsList;
    }

    public void setCouponsItem(CouponItemModel couponsItem) {
        this.couponsItem = couponsItem;
    }

    public CouponItemModel getCouponsItem() {
        return couponsItem;
    }

    public List<ProductModel> getProductsList() {
        return productsList;
    }
}
