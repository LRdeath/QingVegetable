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
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.vegetable.ShoppingManager;

import static io.github.vzer.sharevegetable.shopping.activity.ShoppingActivity.onAmountChangeListener;

/**
 * @author abtion.
 * @since 17/8/5 16:57.
 */

public class ShoppingContentAdapter extends RecyclerViewAdapter<VegetableModel> {

    public ShoppingContentAdapter(Context context, List<VegetableModel> shoppingModels) {
        super(context, shoppingModels);
    }

    @Override
    public ViewHolder<VegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recview_shopping_content, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void refresh() {
        super.refresh();
        onAmountChangeListener.onAmountChange();
    }


    class ItemHolder extends ViewHolder<VegetableModel> {
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
        protected void onBind(VegetableModel shoppingModel) {
            Log.d("msg", shoppingModel.toString());
            txtVegetableName.setText(shoppingModel.getName());
            txtVegetableCount.setText(String.valueOf(shoppingModel.getCount()));
            txtPrice.setText("¥" + String.valueOf(shoppingModel.getPrice() * shoppingModel.getCount()));
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
                    ShoppingManager.getInstance().clearOneModel(getListData().get(position));
                    itemRefresh(position);
                    break;
                case R.id.btn_vegetable_sub:
                    onClickSub(position, view);
                    break;
                case R.id.btn_vegetable_add:
                    onClickAdd(position, view);
                    break;
                default:
                    break;
            }
        }

        /**
         * 商品添加 事件
         */
        void onClickAdd(int pos, View v) {
            VegetableModel model = getListData().get(pos);
            ShoppingManager.getInstance().add(model);

            refresh();
        }

        /**
         * 商品减少 事件
         */
        void onClickSub(int pos, View v) {
            VegetableModel model = getListData().get(pos);
            int count = ShoppingManager.getInstance().sub(model);

            if (count == 0) {
                itemRefresh(pos);
                /*getListData().remove(model);
                notifyItemRemoved(pos);
                onAmountChangeListener.onAmountChange();*/
            } else {
                refresh();
            }
        }

        /**
         * 清除一项商品
         */
        void itemRefresh(int pos) {
            getListData().remove(pos);
            notifyItemRemoved(pos);
            onAmountChangeListener.onAmountChange();
        }
    }

}
