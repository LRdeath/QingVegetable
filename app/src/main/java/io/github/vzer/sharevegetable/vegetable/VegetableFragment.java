package io.github.vzer.sharevegetable.vegetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.factory.presenter.vegetable.VegetablePresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.activity.ShoppingActivity;

/**
 * 商品选购整体框架
 *
 * @author: Vzer.
 * @date: 2017/8/1.
 * @email: vzer@qq.com
 */

public class VegetableFragment extends FragmentPresenter<VegetableContract.Presenter> implements VegetableContract.View, ShoppingChange {

    @BindView(R.id.tab_vegetable_main)
    TabLayout tabLayout;
    @BindView(R.id.vp_vegetable)
    ViewPager vp_content;
    @BindView(R.id.tip_sum)
    TextView tipTxt;
    @BindView(R.id.img_shopping)
    FloatingActionButton shoppingFloat;
    PagerAdapter adapter;
    public static String VEGETABLE_SHOPPING = "Vegetable_shopping";

    private List<FragmentPresenter> fragmentList = new ArrayList<>();
    private List<VegetableTypeModel> typeList = new ArrayList<>();


    /**
     * 点击购物车 事件
     */
    @OnClick(R.id.img_shopping)
    void goShopping() {
        Intent intent = new Intent(getContext(), ShoppingActivity.class);
       /* Iterator<Map.Entry<Integer, ShoppingModel>> iterator = shoppingMap.entrySet().iterator();
        List<ShoppingModel> list = new ArrayList<>();
        //遍历选择的商品信息,打包
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            ShoppingModel model = (ShoppingModel) entry.getValue();
            if (model.getAmount() > 0) list.add(model);
        }
        //Log.d("Tag", list.toString());
        //把选购的商品传给购物车
        intent.putExtra(VEGETABLE_SHOPPING, (Serializable) list);*/
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateSumTip();
    }

    @Override
    public void showLoading() {
    }

    @Override
    protected VegetableContract.Presenter initPresenter() {
        return new VegetablePresenter(this);
    }

    @Override
    protected void initData() {
        mPresenter.LoadType();
    }

    @Override
    protected void initWidget(View root) {
        fragmentList.add(new VegetableContentFragment(0, this));
        typeList.add(new VegetableTypeModel(0, "常用"));
        ShoppingData.getInstance().addList(new ArrayList<VegetableModel>());
        adapter = new VgFragmentPagerAdapter(getFragmentManager(), fragmentList, typeList);
        vp_content.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp_content);

    }

    @Override
    protected void initArgs(Bundle arguments) {
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_vegetable;
    }


    @Override
    public void LoadTypeSuccess(List<VegetableTypeModel> typeModels) {
        this.typeList.addAll(typeModels);

        for (VegetableTypeModel title :
                typeModels) {
            fragmentList.add(new VegetableContentFragment(title.getType(), this));
            ShoppingData.getInstance().addList(new ArrayList<VegetableModel>());
        }
        adapter.notifyDataSetChanged();
    }


    /**
     * 设置购物车商品数量
     */
    @Override
    public void updateSumTip() {
        //更新tip数量显示
        int tipCount = ShoppingData.getInstance().getTotal();
        if (tipCount == 0) tipTxt.setVisibility(View.GONE);
        else tipTxt.setVisibility(View.VISIBLE);
        String text = tipCount > 99 ? "99+" : String.valueOf(tipCount);
        tipTxt.setText(text);
    }

    /**
     * 获取购物车坐标
     *
     * @return 坐标
     */
    @Override
    public int[] getShoppingCoord() {
        int[] des = new int[2];
        shoppingFloat.getLocationInWindow(des);
        des[0] += shoppingFloat.getWidth() / 2;
        des[1] += shoppingFloat.getHeight() / 2;
        return des;
    }

    /**
     * Vegetable类 FragmentPagerAdapter
     */
    class VgFragmentPagerAdapter extends FragmentPagerAdapter {
        List<FragmentPresenter> fragmentList = new ArrayList<>();
        List<VegetableTypeModel> typeList = new ArrayList<>();

        public VgFragmentPagerAdapter(FragmentManager fm, List<FragmentPresenter> fragmentList, List<VegetableTypeModel> typeList) {
            super(fm);
            this.fragmentList = fragmentList;
            this.typeList = typeList;
            initView();
        }

        private void initView() {

        }


        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return typeList.get(position).getName();
        }
    }

    @Override
    public void LoadDatasSuccess(List<VegetableModel> vegetableModels) {

    }
}
