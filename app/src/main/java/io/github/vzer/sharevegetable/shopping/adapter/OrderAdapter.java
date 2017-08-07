package io.github.vzer.sharevegetable.shopping.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author abtion.
 * @since 17/8/5 20:48.
 * email caiheng@hrsoft.net
 */

public class OrderAdapter extends RecyclerViewAdapter<VegetableModel> {


    public OrderAdapter(Context context, List<VegetableModel> shoppingModels) {
        super(context, shoppingModels);
    }

    @Override
    public ViewHolder<VegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_firm_order, parent, false);
        return new ItemHolder(view);
    }

    class ItemHolder extends ViewHolder<VegetableModel> {
        @BindView(R.id.txt_vegetable_name)
        TextView txtVegetableName;
        @BindView(R.id.txt_amount)
        TextView txtAmount;
        @BindView(R.id.txt_item_price)
        TextView txtItemPrice;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void onBind(VegetableModel shoppingModel) {
            txtVegetableName.setText(shoppingModel.getName());
            Log.d("msg", shoppingModel.getName());
            txtAmount.setText(String.valueOf(shoppingModel.getCount()));
            txtItemPrice.setText(String.valueOf(shoppingModel.getCount() * shoppingModel.getPrice()));
        }
    }
}
