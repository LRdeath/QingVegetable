package io.github.vzer.sharevegetable.shopping.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.activity.ShoppingActivity;

/**
 * @author abtion.
 * @since 17/8/4 09:43.
 */

public class ShoppingContentAdapter extends RecyclerViewAdapter<ShoppingModel> {

    private Context context;

    public ShoppingContentAdapter(Context context, List<ShoppingModel> shoppingModels) {
        super(context, shoppingModels);
        this.context = context;
    }

    @Override
    public ViewHolder<ShoppingModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_shopping_content, parent, false);
        return new ItemHolder(view);
    }

    public static class ItemHolder extends ViewHolder<ShoppingModel> implements View.OnClickListener {
        @BindView(R.id.txt_vegetable_name)
        TextView txtVegetableName;
        @BindView(R.id.rcview_vegetable_sub)
        ImageButton rcviewVegetableSub;
        @BindView(R.id.rcview_vegetable_count)
        TextView rcviewVegetableCount;
        @BindView(R.id.rcview_vegetable_add)
        ImageButton rcviewVegetableAdd;
        @BindView(R.id.btn_delete)
        ImageView btnDelete;
        @BindView(R.id.img_vegetable)
        ImageView imgVegetable;
        @BindView(R.id.txt_price)
        TextView txtPrice;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(ShoppingModel shoppingModel) {
            txtVegetableName.setText(shoppingModel.getName());
            rcviewVegetableCount.setText(shoppingModel.getAmount());
            txtPrice.setText((int) (shoppingModel.getPrice()*shoppingModel.getAmount()));
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.rcview_vegetable_add:

                    break;
                case R.id.rcview_vegetable_sub:
                    break;
                case R.id.btn_delete:
                    break;
                default:
                    break;
            }
        }
    }
}
