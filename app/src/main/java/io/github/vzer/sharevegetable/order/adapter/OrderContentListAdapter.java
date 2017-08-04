package io.github.vzer.sharevegetable.order.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.OrderModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/1.
 * email yangcihang@hrsoft.net
 */

public class OrderContentListAdapter extends RecyclerViewAdapter<OrderModel> {

    public OrderContentListAdapter(Context context, List<OrderModel> orderModels) {
        super(context, orderModels);
    }

    @Override
    public ViewHolder<OrderModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_order,parent,false);
        return new ItemHolder(view);
    }

    private class ItemHolder extends ViewHolder<OrderModel> {
        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(OrderModel orderModel) {

        }
    }
}
