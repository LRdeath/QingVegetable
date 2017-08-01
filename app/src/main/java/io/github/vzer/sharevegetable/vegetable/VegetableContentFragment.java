package io.github.vzer.sharevegetable.vegetable;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.factory.presenter.vegetable.VegetablePresenter;
import io.github.vzer.sharevegetable.R;

/**
 * @author: Vzer.
 * @date: 2017/8/1. 18:25
 * @email: vzer@qq.com
 */

public class VegetableContentFragment extends FragmentPresenter<VegetableContract.Presenter> implements VegetableContract.View {
    @BindView(R.id.rcview_vegetable)
    RecyclerView rcviewVegetable;

    RecyclerViewAdapter<VegetableModel> adapter;
    List<VegetableModel> modelList = new ArrayList<>();
    private int curTabType;

    @Override
    public void showLoading() {

    }

    public VegetableContentFragment() {
        this(0);
    }

    @SuppressLint("ValidFragment")
    public VegetableContentFragment(int type) {
        curTabType = type;
    }

    @Override
    public void LoadDatasSuccess(List<VegetableModel> vegetableModels) {
        modelList = vegetableModels;
        adapter.addAll(modelList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void LoadTypeSuccess(List<VegetableTypeModel> typeModels) {

    }

    @Override
    protected VegetableContract.Presenter initPresenter() {
        return new VegetablePresenter(this);
    }

    @Override
    protected void initData() {
        adapter = new RecyclerViewAdapter<VegetableModel>(getContext(), modelList) {
            @Override
            public ViewHolder<VegetableModel> onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = inflater.inflate(R.layout.item_rcview_vegetable, parent, false);
                return new VegetableViewHolder(view);
            }
        };
        rcviewVegetable.setAdapter(adapter);
        mPresenter.LoadType();//加载数据类型
        mPresenter.LoadDatas(curTabType);
    }

    @Override
    protected void initWidget(View root) {
        rcviewVegetable.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_vegetable_content;
    }

    /**
     * RecyclerView的ViewHodler
     */
    class VegetableViewHolder extends RecyclerViewAdapter.ViewHolder<VegetableModel> implements View.OnClickListener {
        @BindView(R.id.rcview_vegetable_name)
        TextView txt_name; //商品名字
        @BindView(R.id.rcview_vegetable_price)
        TextView txt_price; //商品价格
        @BindView(R.id.rcview_vegetable_standard)
        TextView txt_standard; //商品规格
        @BindView(R.id.rcview_vegetable_imge)
        ImageView imge_vegetable;  //商品图片
        @BindView(R.id.rcview_vegetable_add)
        ImageButton imge_add;//添加
        @BindView(R.id.rcview_vegetable_sub)
        ImageButton imge_sub;//减少
        @BindView(R.id.rcview_vegetable_count)
        TextView txt_acount;//数量


        public VegetableViewHolder(View itemView) {
            super(itemView);
            imge_add.setOnClickListener(this);
            imge_sub.setOnClickListener(this);
        }

        @Override
        protected void onBind(VegetableModel vegetableModel) {
            txt_name.setText(vegetableModel.getName());
            txt_standard.setText(vegetableModel.getStandard());
            txt_price.setText("¥" + String.valueOf(vegetableModel.getPrice()));
            Glide.with(getContext())
                    .load(vegetableModel.getPictureUri())
                    .centerCrop()
                    .placeholder(R.drawable.ic_defaut)
                    .into(imge_vegetable);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rcview_vegetable_add:
                    onClickAdd(txt_acount, imge_add,imge_sub);
                    break;
                case R.id.rcview_vegetable_sub:
                    onClickSub(txt_acount,imge_add,imge_sub);
                    break;
                default:
                    break;
            }
        }
    }

    private void onClickSub(TextView txt_acount, ImageButton imge_add, ImageButton imge_sub) {
        int count = Integer.parseInt(txt_acount.getText().toString());
        if (--count>0) txt_acount.setText(count+"");
        else {
            txt_acount.setText("");
            imge_sub.setVisibility(View.GONE);
        }
    }

    private void onClickAdd(TextView txt_acount, ImageButton imge_add, ImageButton imge_sub) {
        String txt = txt_acount.getText().toString();
        int count;
        if (TextUtils.isEmpty(txt)){
            imge_sub.setVisibility(View.VISIBLE);
            count =1;

        }else {
            count = Integer.parseInt(txt)+1;
        }
        txt_acount.setText(count+"");
        // TODO: 2017/8/1 加号属性动画
    }
}
