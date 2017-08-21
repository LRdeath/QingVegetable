package io.github.vzer.sharevegetable.mine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import io.github.vzer.sharevegetable.mine.fragment.GiftCardRechargeFragment;
import io.github.vzer.sharevegetable.mine.fragment.OnlinePayRechargeFragment;

/**
 * @author abtion.
 * @since 17/8/21 17:05.
 * email caiheng@hrsoft.net
 */

public class RechargePagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{
            "线上支付充值", "礼品卡"
    };

    private final int ONLINE_PAY_RECHARGE = 0;
    private final int GIFT_CARD_RECHARGE = 1;

    private OnlinePayRechargeFragment onlinePayRechargeFragment;
    private GiftCardRechargeFragment giftCardRechargeFragment;
    private Fragment mCurrentFragment;


    public RechargePagerAdapter(FragmentManager fm) {
        super(fm);
        initVariable();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case ONLINE_PAY_RECHARGE:
                mCurrentFragment = onlinePayRechargeFragment;
                break;
            case GIFT_CARD_RECHARGE:
                mCurrentFragment = giftCardRechargeFragment;
                break;
            default:
                Log.d("错误", "逻辑不可达，请检查");
                break;
        }
        return mCurrentFragment == null ? onlinePayRechargeFragment : mCurrentFragment;

    }

    @Override
    public int getCount() {
        return 2;
    }

    private void initVariable() {
        if (onlinePayRechargeFragment == null) {
            onlinePayRechargeFragment = new OnlinePayRechargeFragment();
        }
        if (giftCardRechargeFragment == null) {
            giftCardRechargeFragment = new GiftCardRechargeFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
