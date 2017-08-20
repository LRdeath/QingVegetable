package io.github.vzer.sharevegetable.order.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import io.github.vzer.common.app.Application;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.order.OrderFragment;
import io.github.vzer.sharevegetable.order.fragment.OrderContentFragment;

/**
 * ViewPager
 *
 * @author YangCihang
 * @since 17/8/19.
 * email yangcihang@hrsoft.net
 */

public class OrderViewPagerAdapter extends FragmentPagerAdapter {
    private OrderContentFragment orderContentFragment;
    private OrderContentFragment completeFragment;
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
                if (orderContentFragment == null) {
                    orderContentFragment = new OrderContentFragment(OrderContentFragment.PAGER_ALL);
                }
                fragment = orderContentFragment;
                break;
            case OrderFragment.PAGER_NO_PAYMENT:
                if (noPaymentFragment == null) {
                    noPaymentFragment = new OrderContentFragment(OrderContentFragment.PAGER_NO_PAYMENT);
                }
                fragment = noPaymentFragment;
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

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        switch (position) {
            case OrderFragment.PAGER_ALL:
                title = Application.getInstance().getString(R.string.title_order_all);
                break;
            case OrderFragment.PAGER_NO_PAYMENT:
                title = Application.getInstance().getString(R.string.title_order_pay);
                break;

            case OrderFragment.PAGER_NO_PICK_UP:
                title = Application.getInstance().getString(R.string.title_order_pick);
                break;
            case OrderFragment.PAGER_COMPLETE:
                title = Application.getInstance().getString(R.string.title_order_finish);
                break;
            default:
                ToastUtil.showToast(R.string.toast_logic_error);
                break;
        }
        return title;
    }
}
