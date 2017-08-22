package io.github.vzer.sharevegetable.mine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.recycler.RecyclerViewAdapter;
import io.github.vzer.factory.model.mine.coupon.CouponItemModel;
import io.github.vzer.factory.model.mine.coupon.CouponModel;
import io.github.vzer.factory.model.vegetable.ProductModel;
import io.github.vzer.factory.utils.TimeUtil;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class CouponAdapter extends RecyclerViewAdapter<CouponModel> {

    public CouponAdapter(Context context, List<CouponModel> couponModels) {
        super(context, couponModels);
    }

    @Override
    public ViewHolder<CouponModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = inflater.inflate(R.layout.item_rec_coupon, parent, false);
        return new ItemHolder(view);
    }

    class ItemHolder extends ViewHolder<CouponModel> {
        @BindView(R.id.txt_coupon_account)
        TextView accountTxt;
        @BindView(R.id.txt_coupon_base)
        TextView baseTxt;
        @BindView(R.id.txt_coupon_description)
        TextView descriptionTxt;
        @BindView(R.id.txt_coupon_time)
        TextView timeTxt;
        @BindView(R.id.txt_coupon_title)
        TextView titleTxt;
        @BindView(R.id.txt_coupon_order_list)
        TextView orderTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(CouponModel couponModel) {
            String createTime;
            String expiredAt;
            StringBuilder productItem = new StringBuilder();
            String baseCount;
            String amoutCount;
            CouponItemModel couponItemModel = couponModel.getCouponsItem();
            List<ProductModel> productModel = couponModel.getProductsList();
            createTime = TimeUtil.setStampToString(couponItemModel.getCreatedAt(), TimeUtil.DATE_DEFAULT_FORMAT);
            expiredAt = TimeUtil.setStampToString(couponItemModel.getExpiredAt(), TimeUtil.DATE_DEFAULT_FORMAT);
            baseCount = String.valueOf(couponItemModel.getBase());
            amoutCount = String.valueOf(couponItemModel.getAmout());
            for (ProductModel item : productModel) {
                productItem.append(item.getName());
            }
            accountTxt.setText(amoutCount);
            baseTxt.setText("满" + baseCount);
            descriptionTxt.setText(couponItemModel.getDescrption());
            timeTxt.setText(createTime + "到" + expiredAt);
            orderTxt.setText(productItem);
            titleTxt.setText("满" + baseCount + "减" + amoutCount);
        }
    }

}
