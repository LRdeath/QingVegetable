package io.github.vzer.sharevegetable.order.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.OrderFragment;
import io.github.vzer.sharevegetable.order.fragment.OrderContentFragment;

/**
 * @author YangCihang
 * @since 17/7/29.
 * email yangcihang@hrsoft.net
 */

public class OrderViewPagerAdapter extends FragmentPagerAdapter {
    private OrderContentFragment orderContentFragment;
    private OrderContentFragment completeFragment;
    private OrderContentFragment noDistributeFragment;
    private OrderContentFragment noPaymentFragment;
    private OrderContentFragment noPickUpFragment;

    public OrderViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case OrderFragment.PAGER_ALL:
                if(orderContentFragment==null) {
                    orderContentFragment = new OrderContentFragment(OrderContentFragment.PAGER_ALL);
                }
                fragment = orderContentFragment;
                break;
            case OrderFragment.PAGER_NO_PAYMENT:
                if(noPaymentFragment == null) {
                    noPaymentFragment = new OrderContentFragment(OrderContentFragment.PAGER_NO_PAYMENT);
                }
                fragment = noPaymentFragment;
                break;
            case OrderFragment.PAGER_NO_DISTRIBUTE:
                if (noDistributeFragment == null) {
                    noDistributeFragment = new OrderContentFragment(OrderContentFragment.PAGER_NO_DISTRIBUTE);
                }
                fragment = noDistributeFragment;
                break;
            case OrderFragment.PAGER_NO_PICK_UP:
                if (noPickUpFragment == null) {
                    noPickUpFragment = new OrderContentFragment(OrderContentFragment.PAGER_NO_PICK_UP);
                }
                fragment = noPickUpFragment;
                break;
            case OrderFragment.PAGER_COMPLETE:
                if (completeFragment == null) {
                    completeFragment = new OrderContentFragment(OrderContentFragment.PAGER_COMPLETE);
                }
                fragment = completeFragment;
                break;
            default:
                ToastUtil.showToast(R.string.toast_logic_error);
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

    public OrderContentFragment getOrderContentFragment() {
        return orderContentFragment;
    }

    public OrderContentFragment getCompleteFragment() {
        return completeFragment;
    }

    public OrderContentFragment getNoDistributeFragment() {
        return noDistributeFragment;
    }

    public OrderContentFragment getNoPaymentFragment() {
        return noPaymentFragment;
    }

    public OrderContentFragment getNoPickUpFragment() {
        return noPickUpFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        // TODO: 17/8/1 标题规范化 
        switch (position) {
            case OrderFragment.PAGER_ALL:
                title = "全部";
                break;
            case OrderFragment.PAGER_NO_PAYMENT:
                title = "待付款";
                break;
            case OrderFragment.PAGER_NO_DISTRIBUTE:
                title = "待配送";
                break;
            case OrderFragment.PAGER_NO_PICK_UP:
                title = "待取货";
                break;
            case OrderFragment.PAGER_COMPLETE:
                title = "已完成";
                break;
            default:
                ToastUtil.showToast("逻辑不可达");
                break;
        }
        return title;
    }
}
