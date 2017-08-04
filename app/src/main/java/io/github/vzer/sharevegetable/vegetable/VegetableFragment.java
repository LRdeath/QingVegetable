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
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.model.shopping.ShoppingModel;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.factory.presenter.vegetable.VegetablePresenter;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.shopping.activity.ShoppingActivity;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
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
    private HashMap<Integer, ShoppingModel> shoppingMap = new HashMap<>(); //<商品Id, 购物车Model>
    PagerAdapter adapter;
    public static String VEGETABLE_SHOPPING = "Vegetable_shopping";

    private List<FragmentPresenter> fragmentList = new ArrayList<>();
    private List<VegetableTypeModel> typeList = new ArrayList<>();
    private int tipCount = 0;//商品数量


    @OnClick(R.id.img_shopping)
    void goShopping() {
        Intent intent = new Intent(getContext(), ShoppingActivity.class);
        Iterator<Map.Entry<Integer, ShoppingModel>> iterator = shoppingMap.entrySet().iterator();
        List<ShoppingModel> list = new ArrayList<>();
        //遍历选择的商品信息,打包
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            ShoppingModel model = (ShoppingModel) entry.getValue();
            if (model.getAmount() > 0) list.add(model);
        }
        Log.d("Tag", list.toString());
        //把选购的商品传给购物车
        intent.putExtra(VEGETABLE_SHOPPING, (Serializable) list);
        startActivity(intent);
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
    public void LoadDatasSuccess(List<VegetableModel> vegetableModels) {

    }

    @Override
    public void LoadTypeSuccess(List<VegetableTypeModel> typeModels) {
        this.typeList.addAll(typeModels);

        for (VegetableTypeModel title :
                typeModels) {
            fragmentList.add(new VegetableContentFragment(title.getType(), this));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setSumTip(int count, VegetableModel model) {
        int sum = 0;
        int id = model.getpId();
        ShoppingModel shoppingModel;
        //将购物车信息更新;
        if (shoppingMap.containsKey(id)) {
            shoppingModel = shoppingMap.get(id);
            sum = shoppingModel.getAmount();
        } else {
            //model不存在,新建一个model
            shoppingModel = new ShoppingModel(model.getpId(), model.getName(),
                    model.getPrice(), model.getStandard(), model.getPictureUri(), 0);
        }
        sum += count;
        //更新购物车商品数量
        shoppingModel.setAmount(sum);
        shoppingMap.put(id, shoppingModel);
        //更新tip数量显示
        tipCount += count;
        if (tipCount == 0) tipTxt.setVisibility(View.GONE);
        else tipTxt.setVisibility(View.VISIBLE);
        String text = tipCount > 99 ? "99+" : String.valueOf(tipCount);
        tipTxt.setText(text);
    }

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

}
