package io.github.vzer.sharevegetable.vegetable.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.vegetable.ShoppingManager;

/**
 * @author: Vzer.
 * @date: 2017/8/5. 23:00
 * @email: vzer@qq.com
 */

public class VegetableAdapter<V> extends RecyclerViewAdapter<VegetableModel> {
    private ShoppingManager shoppingManager;
    private VegetableListener vegetableListener;

    public VegetableAdapter(Context context, List<VegetableModel> vegetableModels) {
        super(context, vegetableModels);
        shoppingManager = ShoppingManager.getInstance();
    }

    @Override
    public ViewHolder<VegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {

        return new VegetableViewHolder(inflater.inflate(R.layout.item_rcview_vegetable, parent, false));
    }

    public void setVegetableListener(VegetableListener listener) {
        vegetableListener = listener;
    }


    /**
     * RecyclerView的ViewHodler
     */
    class VegetableViewHolder extends RecyclerViewAdapter.ViewHolder<VegetableModel> implements View.OnClickListener {
        @BindView(R.id.rcview_vegetable_name)
        TextView txtName; //商品名字
        @BindView(R.id.rcview_vegetable_price)
        TextView txtPrice; //商品价格
        @BindView(R.id.rcview_vegetable_standard)
        TextView txtStandard; //商品规格
        @BindView(R.id.rcview_vegetable_imge)
        ImageView imgeVegetable;  //商品图片
        @BindView(R.id.rcview_vegetable_add)
        ImageView imgeAdd;//添加
        @BindView(R.id.rcview_vegetable_sub)
        ImageView imgeSub;//减少
        @BindView(R.id.rcview_vegetable_count)
        TextView txtAccount;//数量


        VegetableViewHolder(View itemView) {
            super(itemView);
            imgeAdd.setOnClickListener(this);
            imgeSub.setOnClickListener(this);

        }

        @Override
        protected void onBind(VegetableModel vegetableModel) {
            //对缓存数据进行处理
           // int count = shoppingManager.getCount(vegetableModel);
            int count = shoppingManager.getCount(vegetableModel);
            if (count != 0) {
                txtAccount.setText(String.valueOf(count));
                imgeSub.setVisibility(View.VISIBLE);
            } else {
                txtAccount.setText("");
                imgeSub.setVisibility(View.GONE);
            }

            //设置item状态
            txtName.setText(vegetableModel.getName());
            txtStandard.setText("");
            txtStandard.append(vegetableModel.getStandard());
            txtStandard.append(context.getString(R.string.vegetable_sales));
            txtStandard.append(String.valueOf(vegetableModel.getSales()));
            txtStandard.append(context.getString(R.string.vegetable_kind));
            //格式化价格
            String str = context.getString(R.string.money) + String.valueOf(vegetableModel.getPrice());
            txtPrice.setText(str);
            Glide.with(context)
                    .load(vegetableModel.getPictureUri())
                    .centerCrop()
                    .placeholder(R.drawable.ic_default)
                    .into(imgeVegetable);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.rcview_vegetable_add:
                    vegetableListener.onClickAdd(txtAccount, view, imgeSub, position);
                    break;
                case R.id.rcview_vegetable_sub:
                    vegetableListener.onClickSub(txtAccount, position, imgeSub);
                    break;
                default:
                    break;
            }
        }

    }


}
