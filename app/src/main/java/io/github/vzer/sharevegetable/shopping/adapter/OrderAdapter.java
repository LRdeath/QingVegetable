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
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.sharevegetable.R;

/**
 * @author abtion.
 * @since 17/8/5 20:48.
 * email caiheng@hrsoft.net
 */

public class OrderAdapter extends RecyclerViewAdapter<ShoppingModel> {


    public OrderAdapter(Context context, List<ShoppingModel> shoppingModels) {
        super(context, shoppingModels);
    }

    @Override
    public ViewHolder<ShoppingModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_firm_order, parent, false);
        return new ItemHolder(view);
    }

    class ItemHolder extends ViewHolder<ShoppingModel> {
        @BindView(R.id.txt_vegetable_name)
        TextView txtVegetableName;
        @BindView(R.id.txt_amount)
        TextView txtAmount;
        @BindView(R.id.txt_item_price)
        TextView txtItemPrice;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        protected void onBind(ShoppingModel shoppingModel) {
            txtVegetableName.setText(shoppingModel.getName());
            Log.d("msg",shoppingModel.getName());
            txtAmount.setText(String.valueOf(shoppingModel.getAmount()));
            txtItemPrice.setText(String.valueOf(shoppingModel.getAmount()*shoppingModel.getPrice()));
        }
    }
}
