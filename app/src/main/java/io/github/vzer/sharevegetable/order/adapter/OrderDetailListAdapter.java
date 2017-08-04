package io.github.vzer.sharevegetable.order.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.OrderVegetableModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/3.
 * email yangcihang@hrsoft.net
 */

public class OrderDetailListAdapter extends RecyclerViewAdapter<OrderVegetableModel> {

    public OrderDetailListAdapter(Context context, List<OrderVegetableModel> orderVegetableModels) {
        super(context, orderVegetableModels);
    }

    @Override
    public ViewHolder<OrderVegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_rec_order_detail,parent,false);
        return new ItemViewHolder(view);
    }

    class ItemViewHolder extends ViewHolder<OrderVegetableModel> {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(OrderVegetableModel orderVegetableModel) {

        }
    }
}
