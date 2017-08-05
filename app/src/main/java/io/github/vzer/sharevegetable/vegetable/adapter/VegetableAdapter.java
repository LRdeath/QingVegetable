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
import io.github.vzer.sharevegetable.vegetable.ShoppingChange;
import io.github.vzer.sharevegetable.vegetable.ShoppingData;

/**
 * @author: Vzer.
 * @date: 2017/8/5. 23:00
 * @email: vzer@qq.com
 */

public class VegetableAdapter<V> extends RecyclerViewAdapter<VegetableModel> {
    private ShoppingData shoppingData;
    private VegetableListener vegetableListener;

    public VegetableAdapter(Context context, List<VegetableModel> vegetableModels) {
        super(context, vegetableModels);
        shoppingData = ShoppingData.getInstance();
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
        ImageButton imgeAdd;//添加
        @BindView(R.id.rcview_vegetable_sub)
        ImageButton imgeSub;//减少
        @BindView(R.id.rcview_vegetable_count)
        TextView txtAcount;//数量


        VegetableViewHolder(View itemView) {
            super(itemView);
            imgeAdd.setOnClickListener(this);
            imgeSub.setOnClickListener(this);

        }

        @Override
        protected void onBind(VegetableModel vegetableModel) {

            //对缓存数据进行处理
            HashMap<VegetableModel, Integer> dataMap = shoppingData.getVegetableList();

            if (dataMap.containsKey(vegetableModel)) {
                int count = dataMap.get(vegetableModel);
                if (count != 0) {
                    txtAcount.setText(String.valueOf(count));
                    imgeSub.setVisibility(View.VISIBLE);
                }
            } else {
                txtAcount.setText("");
                imgeSub.setVisibility(View.GONE);
            }
            //设置item状态
            txtName.setText(vegetableModel.getName());
            txtStandard.setText(vegetableModel.getStandard() + " | 月售" + vegetableModel.getSales() + "份");
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
                    vegetableListener.onClickAdd(txtAcount, view, imgeSub, position);
                    break;
                case R.id.rcview_vegetable_sub:
                    vegetableListener.onClickSub(txtAcount, position, imgeSub);
                    break;
                default:
                    break;
            }
        }

    }


}
