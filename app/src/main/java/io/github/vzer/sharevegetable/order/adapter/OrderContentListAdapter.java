package io.github.vzer.sharevegetable.order.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.OrderDetailModel;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.activity.DiscussActivity;
import io.github.vzer.sharevegetable.widget.DistributeView;

/**
 * @author YangCihang
 * @since 17/8/1.
 * email yangcihang@hrsoft.net
 */

public class OrderContentListAdapter extends RecyclerViewAdapter<OrderDetailModel> {

    public OrderContentListAdapter(Context context, List<OrderDetailModel> orderDetailModels) {
        super(context, orderDetailModels);
    }

    @Override
    public ViewHolder<OrderDetailModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_order, parent, false);
        return new ItemHolder(view);
    }

    public class ItemHolder extends ViewHolder<OrderDetailModel> {
        @BindView(R.id.txt_order_number)
        TextView orderNumberTxt;
        @BindView(R.id.txt_order_create_time)
        TextView createTimeTxt;
        @BindView(R.id.txt_product_list)
        TextView productListTxt;
        @BindView(R.id.view_order_state)
        DistributeView orderStateView;
        @BindView(R.id.txt_product_money)
        TextView moneyTxt;
        @BindView(R.id.btn_action)
        Button actionBtn;
        private OrderDetailModel model;

        ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(OrderDetailModel orderDetailModel) {
            model = orderDetailModel;
            actionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, DiscussActivity.class));
                }
            });
//            switch (model.getState()) {
//                case OrderDetailModel.STATE_SUBMIT:
//                    orderStateView.setHaveSubmitState();
//                    actionBtn.setText(R.string.text_to_pay);
//                    actionBtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            // TODO: 17/8/7 订单支付详情页面
//                        }
//                    });
//                    break;
//                case OrderDetailModel.STATE_PAYMENT:
//                    orderStateView.setPaymentState();
//                    actionBtn.setVisibility(View.GONE);
//                    break;
//                case OrderDetailModel.STATE_DISTRIBUTE:
//                    orderStateView.setPickState();
//                    actionBtn.setText(R.string.text_to_pick);
//                    actionBtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            // TODO: 17/8/7 到开锁界面
//                        }
//                    });
//                    break;
//                case OrderDetailModel.STATE_FINISH:
//                    orderStateView.setFinishState();
//                    actionBtn.setText(R.string.text_order_item_evaluate);
//                    actionBtn.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            // TODO: 17/8/7 到评论界面
//                            context.startActivity(new Intent(context,DiscussActivity.class));
//                        }
//                    });
//                    break;
//                default:
//                   // ToastUtil.showToast(R.string.toast_logic_error);
//                    break;
//            }
        }
    }
}
