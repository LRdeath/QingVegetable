package io.github.vzer.sharevegetable.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import io.github.vzer.sharevegetable.mine.fragment.WalletOrderFragment;

import static io.github.vzer.sharevegetable.mine.fragment.WalletOrderFragment.PAGER_ALL;
import static io.github.vzer.sharevegetable.mine.fragment.WalletOrderFragment.PAGER_REFUNDS;
import static io.github.vzer.sharevegetable.mine.fragment.WalletOrderFragment.PAGER_SUM;
import static io.github.vzer.sharevegetable.mine.fragment.WalletOrderFragment.PAGER_WITHDRAW;

/**
 * @author YangCihang
 * @since 17/8/21.
 * email yangcihang@hrsoft.net
 */

public class WalletOrderPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{
            "全部", "提现详情", "退款详情"
    };

    private WalletOrderFragment allOrderFragment;
    private WalletOrderFragment refundsFragment;
    private WalletOrderFragment withdrawFragment;


    public WalletOrderPagerAdapter(FragmentManager fm) {
        super(fm);
        initVariable();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment mCurrentFragment = null;
        switch (position) {
            case PAGER_ALL:
                mCurrentFragment = allOrderFragment;
                break;
            case PAGER_REFUNDS:
                mCurrentFragment = refundsFragment;
                break;
            case PAGER_WITHDRAW:
                mCurrentFragment = withdrawFragment;
                break;
            default:
                Log.d("错误", "逻辑不可达，请检查");
                break;
        }
        return mCurrentFragment;
    }

    @Override
    public int getCount() {
        return PAGER_SUM;
    }

    private void initVariable() {
        if (allOrderFragment == null) {
            allOrderFragment = new WalletOrderFragment(PAGER_ALL);
        }
        if (withdrawFragment == null) {
            withdrawFragment = new WalletOrderFragment(PAGER_WITHDRAW);
        }
        if (refundsFragment == null) {
            refundsFragment = new WalletOrderFragment(PAGER_REFUNDS);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
