package io.github.vzer.sharevegetable.vegetable;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.RecyclerViewAdapter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.factory.presenter.vegetable.VegetablePresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.vegetable.animation.ShoppingCartAnimationView;

/**
 * @author: Vzer.
 * @date: 2017/8/1. 18:25
 * @email: vzer@qq.com
 */

@SuppressLint("ValidFragment")
public class VegetableContentFragment extends FragmentPresenter<VegetableContract.Presenter> implements VegetableContract.View {
    @BindView(R.id.rcview_vegetable)
    RecyclerView vegetableRcview;

    RecyclerViewAdapter<VegetableModel> adapter;
    List<VegetableModel> modelList = new ArrayList<>();
    private int curTabType;
    private HashMap<Integer, Integer> dataMap;
    private ShoppingChange shoppingChange;


    
    @Override
    public void showLoading() {

    }

    public VegetableContentFragment(int type,@NonNull VegetableFragment vegetableFragment) {
        curTabType = type;
        shoppingChange = vegetableFragment;
        dataMap = new HashMap<>();
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
        vegetableRcview.setAdapter(adapter);
        mPresenter.LoadType();//加载数据类型
        mPresenter.LoadDatas(curTabType);
    }

    @Override
    protected void initWidget(View root) {
        vegetableRcview.setLayoutManager(new LinearLayoutManager(getContext()));

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
            //Animation animation = getResources().getAnimation(R)
            //imgeAdd.setAnimation();
        }

        @Override
        protected void onBind(VegetableModel vegetableModel) {
            //获取当前item位置,取到缓存数据
            int position = getAdapterPosition();
            //对缓存数据进行处理
            if (dataMap.containsKey(position)) {
                int count = dataMap.get(position);
                if (count == 0) {
                    txtAcount.setText("");
                    imgeSub.setVisibility(View.GONE);
                } else {
                    txtAcount.setText(" " + count + " ");
                    imgeSub.setVisibility(View.VISIBLE);
                }
            } else {
                txtAcount.setText("");
                imgeSub.setVisibility(View.GONE);
            }
            //设置item状态
            txtName.setText(vegetableModel.getName());
            txtStandard.setText(vegetableModel.getStandard());
            txtPrice.setText("¥" + String.valueOf(vegetableModel.getPrice()));
            Glide.with(getContext())
                    .load(vegetableModel.getPictureUri())
                    .centerCrop()
                    .placeholder(R.drawable.ic_defaut)
                    .into(imgeVegetable);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            switch (view.getId()) {
                case R.id.rcview_vegetable_add:
                    onClickAdd(txtAcount, view, imgeSub, position);
                    break;
                case R.id.rcview_vegetable_sub:
                    onClickSub(txtAcount, position, imgeSub);
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 商品减少 逻辑
     */
    private void onClickSub(TextView txtAcount, int position, ImageButton imgeSub) {
        int count = dataMap.get(position);

        if (--count > 0) {
            txtAcount.setText(" " + count + " ");
        } else {
            txtAcount.setText("");
            imgeSub.setVisibility(View.GONE);
        }
        shoppingChange.setSumTip(-1);
        dataMap.put(position, count);
    }

    /**
     * 商品添加 逻辑
     */
    private void onClickAdd(TextView txtAcount, View imgeAdd, ImageButton imgeSub, int position) {

        int count;
        if (dataMap.containsKey(position)) {
            count = dataMap.get(position);

        } else count = 0;
        if (count == 0) {
            imgeSub.setVisibility(View.VISIBLE);
        }
        count++;
        dataMap.put(position, count);
        txtAcount.setText(" " + count + " ");
        shoppingChange.setSumTip(1);
        // TODO: 2017/8/1 加号属性动画
        int[] cur = new int[2];
        imgeAdd.getLocationInWindow(cur);
        playAnimation(cur);
    }

    public void playAnimation(int[] position) {
        //创建一个执行动画view
        ShoppingCartAnimationView animationView = new ShoppingCartAnimationView(getContext());
        //设置动画的开始与结束坐标
        animationView.setStartPosition(new Point(position[0],position[1]));
        int[] des = shoppingChange.getShoppingCoord();
        animationView.setEndPosition(new Point(des[0],des[1]));
        //把view添加到界面中
        ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
        rootView.addView(animationView);
        //开始动画
        animationView.startBeizerAnimation();
    }


   /* public void playAnimation(int[] position) {
        //创建执行动画的View
        final TextView mTxt = new TextView(getContext());
        //mTxt.setBackground(getResources().getDrawable(R.drawable.bg_btn_account_enable));
        mTxt.setText("1");
        mTxt.setTextColor(getResources().getColor(R.color.black));
        mTxt.setTextSize(ScreenUtil.sp2px(10));
        mTxt.setGravity(Gravity.CENTER);
//        mTxt.setWidth(10);
//        mTxt.setHeight(10);
        ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
        rootView.addView(mTxt);

        int[] des = shoppingChange.getShoppingCoord();
        *//*动画开始的位置,也就是商品添加按钮的位置*//*
        Point startPosition = new Point(position[0], position[1]);
        Point endPosition = new Point(des[0], des[1]);

        final int pointX = (startPosition.x + endPosition.x) / 2 - 100;
        final int pointY = startPosition.y -200;
        Point controllPoint = new Point(pointX,pointY);

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new BizierEvaluator2(controllPoint),startPosition,endPosition);
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Point point = (Point) valueAnimator.getAnimatedValue();
                mTxt.setX(point.x);
                mTxt.setY(point.y);
            }
        });

        *//*动画结束,移除小圆*//*
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ViewGroup rootView = (ViewGroup) getActivity().getWindow().getDecorView();
                rootView.removeView(mTxt);
            }
        });
    }*/



}
