package io.github.vzer.sharevegetable.order.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.order.OrderFragment;
import io.github.vzer.sharevegetable.order.fragment.AllOrderFragment;
import io.github.vzer.sharevegetable.order.fragment.CompleteFragment;
import io.github.vzer.sharevegetable.order.fragment.NoDistributeFragment;
import io.github.vzer.sharevegetable.order.fragment.NoPaymentFragment;
import io.github.vzer.sharevegetable.order.fragment.NoPickUpFragment;

/**
 * @author YangCihang
 * @since 17/7/29.
 * email yangcihang@hrsoft.net
 */

public class OrderViewPagerAdapter extends FragmentPagerAdapter {
    private AllOrderFragment allOrderFragment;
    private CompleteFragment completeFragment;
    private NoDistributeFragment noDistributeFragment;
    private NoPaymentFragment noPaymentFragment;
    private NoPickUpFragment noPickUpFragment;

    public OrderViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        allOrderFragment = new AllOrderFragment();
        completeFragment = new CompleteFragment();
        noDistributeFragment = new NoDistributeFragment();
        noPaymentFragment = new NoPaymentFragment();
        noPickUpFragment = new NoPickUpFragment();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case OrderFragment.PAGER_ALL:
                fragment = allOrderFragment;
                break;
            case OrderFragment.PAGER_NO_PAYMENT:
                fragment = noPaymentFragment;
                break;
            case OrderFragment.PAGER_NO_DISTRIBUTE:
                fragment = noDistributeFragment;
                break;
            case OrderFragment.PAGER_NO_PICK_UP:
                fragment = noPickUpFragment;
                break;
            case OrderFragment.PAGER_NO_COMPLETE:
                fragment = completeFragment;
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getCount() {
        return OrderFragment.PAGER_SUM;
    }

    public AllOrderFragment getAllOrderFragment() {
        return allOrderFragment;
    }

    public CompleteFragment getCompleteFragment() {
        return completeFragment;
    }

    public NoDistributeFragment getNoDistributeFragment() {
        return noDistributeFragment;
    }

    public NoPaymentFragment getNoPaymentFragment() {
        return noPaymentFragment;
    }

    public NoPickUpFragment getNoPickUpFragment() {
        return noPickUpFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case OrderFragment.PAGER_ALL:
                title = "全部";
                break;
            case OrderFragment.PAGER_NO_PAYMENT:
                title = "待付款";
                break;
            case OrderFragment.PAGER_NO_DISTRIBUTE:
                title = "代配送";
                break;
            case OrderFragment.PAGER_NO_PICK_UP:
                title = "待取货";
                break;
            case OrderFragment.PAGER_NO_COMPLETE:
                title = "已完成";
                break;
            default:
                ToastUtil.showToast("逻辑不可达");
                break;
        }
        return title;
    }
}
