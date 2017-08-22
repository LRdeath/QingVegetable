package io.github.vzer.sharevegetable.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.recycler.RecyclerFooterAdapter;
import io.github.vzer.factory.model.mine.wallet.UserWalletOrderModel;
import io.github.vzer.factory.utils.TimeUtil;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;

import static android.view.View.GONE;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletOrderAdapter extends RecyclerFooterAdapter<UserWalletOrderModel> {
    private FooterItemHolder footerHolder;

    public WalletOrderAdapter(Context context, List<UserWalletOrderModel> userWalletOrderModels) {
        super(context, userWalletOrderModels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == DATA_ITEM) {
            view = inflater.inflate(R.layout.item_wallet_order, parent, false);
            return new ItemHolder(view);
        } else {
            view = inflater.inflate(R.layout.view_rec_footer, parent, false);
            footerHolder = new FooterItemHolder(view);
            return footerHolder;
        }
    }

    class ItemHolder extends ViewHolder<UserWalletOrderModel> {
        @BindView(R.id.txt_wallet_order_create_time)
        TextView createTimeTxt;
        @BindView(R.id.txt_wallet_order_description)
        TextView descriptionTxt;
        @BindView(R.id.txt_wallet_order_id)
        TextView orderIdTxt;
        @BindView(R.id.txt_wallet_order_type)
        TextView orderTypeTxt;
        @BindView(R.id.txt_wallet_order_id_title)
        TextView orderIdTxtTitleTxt;
        @BindView(R.id.txt_wallet_order_update_time)
        TextView updateTimeTxt;
        @BindView(R.id.txt_wallet_order_state)
        TextView stateTxt;
        @BindView(R.id.txt_wallet_order_money)
        TextView moneyTxt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(UserWalletOrderModel userWalletOrderModel) {
            String createTime;
            String updateTime;
            //时间
            createTime = TimeUtil.setStampToString(userWalletOrderModel.getCreatedAt(), TimeUtil.DATE_DEFAULT_FORMAT);
            updateTime = TimeUtil.setStampToString(userWalletOrderModel.getUpdatedAt(), TimeUtil.DATE_DEFAULT_FORMAT);
            createTimeTxt.setText(createTime);
            updateTimeTxt.setText(updateTime);
            descriptionTxt.setText(userWalletOrderModel.getDescription());
            moneyTxt.setText(String.valueOf(userWalletOrderModel.getAmount()));
            //类型
            switch (userWalletOrderModel.getType()) {
                case UserWalletOrderModel.SHOPPING_TYPE:
                    orderTypeTxt.setText(R.string.text_wallet_order_type_shopping);
                    break;
                case UserWalletOrderModel.RECHARGE_TYPE:
                    orderTypeTxt.setText(R.string.text_wallet_order_type_recharge);
                    break;
                case UserWalletOrderModel.WITHDRAW_TYPE:
                    orderTypeTxt.setText(R.string.text_wallet_order_type_withdraw);
                    break;
                case UserWalletOrderModel.REFUNDS_TYPE:
                    orderTypeTxt.setText(R.string.text_wallet_order_type_refunds);
                    break;
                case UserWalletOrderModel.GIFT_TYPE:
                    orderTypeTxt.setText(R.string.text_wallet_order_type_gift_recharge);
                    break;
                default:
                    ToastUtil.showToast(R.string.toast_logic_error);
                    break;

            }
            //是否完成
            if (userWalletOrderModel.isChecked()) {
                stateTxt.setText(R.string.text_wallet_order_state_finished);
            } else {
                stateTxt.setText(R.string.text_wallet_order_state_unfinished);
            }
            //orderId（有则显示，无则隐藏）
            if (TextUtils.isEmpty(String.valueOf(userWalletOrderModel.getOrderId()))) {
                orderIdTxt.setVisibility(GONE);
                orderIdTxtTitleTxt.setVisibility(GONE);
            } else {
                orderIdTxtTitleTxt.setVisibility(View.VISIBLE);
                orderIdTxt.setVisibility(View.VISIBLE);
                orderIdTxt.setText(userWalletOrderModel.getOrderId());
            }


        }
    }

    class FooterItemHolder extends FooterHolder {
        @BindView(R.id.txt_load_more)
        TextView loadTxt;
        @BindView(R.id.progress_footer)
        ProgressBar footerProgress;

        public FooterItemHolder(View itemView) {
            super(itemView);
        }
    }

    public void setToRefresh(boolean toRefresh) {
        if (footerHolder != null) {
            if (toRefresh) {
                footerHolder.footerProgress.setVisibility(View.VISIBLE);
                footerHolder.loadTxt.setText("正在加载");
            } else {
                footerHolder.footerProgress.setVisibility(GONE);
                footerHolder.loadTxt.setText("已经加载完啦");
            }
        }

    }
}
