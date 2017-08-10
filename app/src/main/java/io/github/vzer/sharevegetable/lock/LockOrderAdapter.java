package io.github.vzer.sharevegetable.lock;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.order.OrderDetailModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author YangCihang
 * @since 17/8/9.
 * email yangcihang@hrsoft.net
 */

public class LockOrderAdapter extends RecyclerViewAdapter<OrderDetailModel> {

    public LockOrderAdapter(Context context, List<OrderDetailModel> orderDetailModels) {
        super(context, orderDetailModels);
    }

    @Override
    public ViewHolder<OrderDetailModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_lock_order, parent, false);
        return new ItemHolder(view);
    }

    class ItemHolder extends ViewHolder<OrderDetailModel> {
        @BindView(R.id.rec_lock_order_vegetable)
        RecyclerView vegetableRec;
        @BindView(R.id.txt_order_owner)
        TextView ownerTxt;
        private LockOrderVegetableAdapter adapter;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(OrderDetailModel model) {
            ownerTxt.setText("奥特曼");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                list.add("香菜x5");
            }
            GridLayoutManager manager = new GridLayoutManager(context, 2);
            adapter = new LockOrderVegetableAdapter(context, list);
            vegetableRec.setAdapter(adapter);
            vegetableRec.setLayoutManager(manager);
        }
    }
}
