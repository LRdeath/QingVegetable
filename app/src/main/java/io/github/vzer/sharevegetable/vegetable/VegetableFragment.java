package io.github.vzer.sharevegetable.vegetable;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.common.widget.NewTip;
import io.github.vzer.factory.model.vegetable.VegetableModel;
import io.github.vzer.factory.model.vegetable.VegetableTypeModel;
import io.github.vzer.factory.presenter.vegetable.VegetableContract;
import io.github.vzer.factory.presenter.vegetable.VegetablePresenter;
import io.github.vzer.sharevegetable.R;

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
    NewTip tipTxt;
    @BindView(R.id.img_shopping)
    FloatingActionButton shoppingFloat;

    PagerAdapter adapter;

    private List<FragmentPresenter> fragmentList = new ArrayList<>();
    private List<VegetableTypeModel> typeList = new ArrayList<>();
    private int tipCount = 0;//商品数量


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
    public void setSumTip(int count) {
        tipCount += count;
        tipTxt.setNewTipCount(tipCount);
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
