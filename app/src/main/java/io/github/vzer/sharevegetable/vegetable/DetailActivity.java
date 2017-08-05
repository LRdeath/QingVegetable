package io.github.vzer.sharevegetable.vegetable;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import io.github.vzer.common.app.ActivityPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableEvaModel;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.presenter.vegetable.EvaVegetableContract;
import io.github.vzer.factory.presenter.vegetable.EvaVegetablePresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.vegetable.adapter.DetailData;

/**
 * @author: Vzer.
 * @date: 2017/8/3. 20:43
 * @email: vzer@qq.com
 */

public class DetailActivity extends ActivityPresenter<EvaVegetableContract.Presenter> implements EvaVegetableContract.View {
    @BindView(R.id.vegetable_detail_name)
    TextView nameTxt;
    @BindView(R.id.vegetable_detail_imge)
    ImageView icImge;
    @BindView(R.id.vegetable_detail_standard)
    TextView standardTxt;
    @BindView(R.id.vegetable_detail_des)
    TextView desTxt;
    @BindView(R.id.vegetable_detail_price)
    TextView priceTxt;
    @BindView(R.id.vegetable_detail_count)
    TextView countTxt;
    @BindView(R.id.vegetable_detail_sub)
    ImageButton subImageB;
    @BindView(R.id.vegetable_detail_add)
    ImageButton addImageB;
    @BindView(R.id.rec_vegetable_detail)
    RecyclerView evaRec;

    private VegetableModel model;//当前商品的model
    private ShoppingData shoppingData; //购物车管理类
    private int curType;
    private int curPosition;
    private RecyclerViewAdapter<VegetableEvaModel> adapter;

    @Override
    protected void initData() {

        //初始化评价表
        List<VegetableEvaModel> list = new ArrayList<>();
        adapter = new RecyclerViewAdapter<VegetableEvaModel>(this, list) {
            @Override
            public ViewHolder<VegetableEvaModel> onCreateViewHolder(ViewGroup parent, int viewType) {
                return new EvaViewHolder(inflater.inflate(R.layout.item_recview_vegetable_eva, parent, false));
            }
        };
        evaRec.setAdapter(adapter);
        //通知P层加载评价表
        mPresenter.LoadEva(model.getpId());
    }

    //初始化商品信息
    @Override
    public void initWidget() {
        evaRec.setLayoutManager(new LinearLayoutManager(this));
        nameTxt.setText(model.getName());
        //获取当前商品选购的数量
        int count = 0;
        if (shoppingData.getVegetableList().containsKey(model))
            count = shoppingData.getVegetableList().get(model);

        if (count == 0) {
            countTxt.setText("");
            subImageB.setVisibility(View.GONE);
        } else {
            countTxt.setText(String.valueOf(count));
            subImageB.setVisibility(View.VISIBLE);
        }

        standardTxt.setText(model.getStandard() + " | 月售" + model.getSales() + "份");
        //格式化价格
        String str = "" + String.valueOf(model.getPrice());
        priceTxt.setText(str);
        Glide.with(this)
                .load(model.getPictureUri())
                .centerCrop()
                .placeholder(R.drawable.ic_default)
                .into(icImge);
    }

    @Override
    protected EvaVegetableContract.Presenter initPresenter() {
        return new EvaVegetablePresenter(this);
    }


    @Override
    protected void initWindows() {

    }

    @Override
    protected boolean initArgs(Bundle extras) {
        shoppingData = ShoppingData.getInstance();
        DetailData model = (DetailData) extras.getSerializable(VegetableContentFragment.VEGETABLE_DETAIL);
        curType = model.getType();
        curPosition = model.getPosition();
        Log.d("tag",curType+" "+curPosition);
        this.model = shoppingData.getList(curType).get(curPosition);
        return super.initArgs(extras);
    }

    /*
     * 商品添加事件
     */
    @OnClick(R.id.vegetable_detail_add)
    void addClick() {
        int count = shoppingData.add(curType,curPosition);
        //把减少buton设置为可见
        if (subImageB.getVisibility() == View.GONE) subImageB.setVisibility(View.VISIBLE);
        countTxt.setText(String.valueOf(count));
    }

    /*
     * 商品数量减少事件
     */
    @OnClick(R.id.vegetable_detail_sub)
    void subClick() {
        int count = shoppingData.sub(curType,curPosition);
        String str = "" + count;
        //为0时把减少buton设置为不可见
        if (count == 0) {
            subImageB.setVisibility(View.GONE);
            str = "";
        }
        countTxt.setText(str);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_vegetable_detail;
    }

    @Override
    public void showError(int strId) {

    }

    @Override
    public void showLoading() {

    }

    /**
     * P层
     * 评价表加载成功,
     */
    @Override
    public void LoadEvaSuccess(List<VegetableEvaModel> evaModels) {
        adapter.addAll(evaModels);
        adapter.notifyDataSetChanged();
    }

    /**
     * 商品评价ViewHolder
     */
    class EvaViewHolder extends RecyclerViewAdapter.ViewHolder<VegetableEvaModel> {
        @BindView(R.id.image_vegetable_eva_portrait)
        CircleImageView portraitImage; //头像
        @BindView(R.id.txt_vegetable_eva_name)
        TextView nameTxt;//用户名
        @BindView(R.id.txt_vegetable_eva_date)
        TextView dateTxt;//评价日期
        @BindView(R.id.txt_vegetable_eva_content)
        TextView contentTxt;//评价内容
        @BindView(R.id.imge_vegetable_eva_degree)
        ImageView degreeImage;//评价满意度

        EvaViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(VegetableEvaModel vegetableEvaModel) {
            nameTxt.setText(vegetableEvaModel.getName());
            dateTxt.setText(vegetableEvaModel.getDate());
            contentTxt.setText(vegetableEvaModel.getContent());
            //根据评价等级 加载图片
            if (vegetableEvaModel.getDegree() == 1) {
                degreeImage.setImageResource(R.drawable.ic_smile_selected);
            } else degreeImage.setImageResource(R.drawable.ic_sad_selected);
            Glide.with(DetailActivity.this)
                    .load(vegetableEvaModel.getPortraitUri())
                    .centerCrop()
                    .placeholder(R.drawable.ic_default)
                    .into(portraitImage);
        }
    }
}
