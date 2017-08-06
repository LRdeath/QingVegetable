package io.github.vzer.sharevegetable.shopping.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.sharevegetable.R;

import static io.github.vzer.sharevegetable.shopping.activity.ShoppingActivity.onAmountChangeListener;

/**
 * @author abtion.
 * @since 17/8/5 16:57.
 */

public class ShoppingContentAdapter extends RecyclerViewAdapter<ShoppingModel> {

    public ShoppingContentAdapter(Context context, List<ShoppingModel> shoppingModels) {
        super(context, shoppingModels);
    }

    @Override
    public ViewHolder<ShoppingModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_shopping_content, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void refresh() {
        super.refresh();
        onAmountChangeListener.onAmountChange();
    }

    class ItemHolder extends ViewHolder<ShoppingModel>{
        @BindView(R.id.txt_vegetable_name)
        TextView txtVegetableName;
        @BindView(R.id.btn_vegetable_add)
        ImageButton btnVegetableAdd;
        @BindView(R.id.txt_vegetable_count)
        TextView txtVegetableCount;
        @BindView(R.id.btn_vegetable_sub)
        ImageButton btnVegetableSub;
        @BindView(R.id.btn_delete)
        ImageView btnDelete;
        @BindView(R.id.img_vegetable)
        ImageView imgVegetable;
        @BindView(R.id.txt_price)
        TextView txtPrice;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void onBind(ShoppingModel shoppingModel) {
            Log.d("msg", shoppingModel.toString());
            txtVegetableName.setText(shoppingModel.getName());
            txtVegetableCount.setText(String.valueOf(shoppingModel.getAmount()));
            txtPrice.setText("¥" + String.valueOf(shoppingModel.getPrice() * shoppingModel.getAmount()));
            Glide.with(context)
                    .load(shoppingModel.getPictureUri())
                    .centerCrop()
                    .placeholder(R.drawable.ic_default)
                    .into(imgVegetable);
        }

        @OnClick({R.id.btn_delete, R.id.btn_vegetable_sub, R.id.btn_vegetable_add})
        public void onViewClicked(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.btn_delete:
                    getListData().remove(position);
                    refresh();
                    break;
                case R.id.btn_vegetable_sub:
                    onClickSub(position,view);
                    break;
                case R.id.btn_vegetable_add:
                    onClickAdd(position,view);
                    break;
                default:
                    break;
            }
        }

        void onClickAdd(int pos, View v) {
            getListData().get(pos).setAmount(getListData().get(pos).getAmount() + 1);
            refresh();
        }

        void onClickSub(int pos, View v) {
            if (getListData().get(pos).getAmount() == 1) {
                getListData().remove(pos);
            } else {
                getListData().get(pos).setAmount(getListData().get(pos).getAmount() - 1);
            }
            refresh();
        }
    }
}
