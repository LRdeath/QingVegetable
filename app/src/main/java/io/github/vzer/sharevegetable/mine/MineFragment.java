package io.github.vzer.sharevegetable.mine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.vzer.common.app.FragmentPresenter;
import io.github.vzer.factory.persistence.Account;
import io.github.vzer.factory.presenter.mine.MineContract;
import io.github.vzer.factory.presenter.mine.MinePresenter;
import io.github.vzer.factory.utils.ToastUtil;
import io.github.vzer.sharevegetable.R;
import io.github.vzer.sharevegetable.account.AccountActivity;
import io.github.vzer.sharevegetable.mine.activity.LocationActivity;
import io.github.vzer.sharevegetable.mine.activity.UserDetailActivity;
import io.github.vzer.sharevegetable.mine.activity.WalletActivity;

/**
 * @author YangCihang
 * @since 17/7/27.
 * email yangcihang@hrsoft.net
 */

public class MineFragment extends FragmentPresenter<MineContract.Presenter> implements MineContract.View {

    @BindView(R.id.img_circle_avatar)
    ImageView avatarImg;
    @BindView(R.id.txt_nickname)
    TextView nicknameTxt;
    @BindView(R.id.txt_logout)
    TextView exitTxt;
    @BindView(R.id.txt_about)
    TextView aboutTxt;
    @BindView(R.id.ly_contract)
    RelativeLayout contractLy;
    @BindView(R.id.ly_user_detail)
    RelativeLayout userDetailLy;
    @BindView(R.id.ly_credit)
    RelativeLayout creditLy;
    @BindView(R.id.ly_coupon)
    RelativeLayout couponLy;
    @BindView(R.id.ly_wallet)
    RelativeLayout walletLy;
    @BindView(R.id.txt_credit_num)
    TextView creditNumTxt;
    @BindView(R.id.txt_coupon_num)
    TextView couponNumTxt;
    @BindView(R.id.txt_money)
    TextView moneyTxt;
    @BindView(R.id.ly_location)
    RelativeLayout locationLy;

    @Override
    public void showLoading() {

    }

    @Override
    protected MineContract.Presenter initPresenter() {
        return new MinePresenter(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initWidget(View root) {
        // TODO: 17/8/10 初始化用户图像和用户名信息
        String url = Account.getPortrait();
        Glide.with(getContext())
                .load(url)
                .centerCrop()
                .into(avatarImg);
    }

    @Override
    protected void initArgs(Bundle arguments) {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_mine;
    }


    /**
     * 登出
     */
    @OnClick(R.id.txt_logout)
    void onGoLogin() {
        mPresenter.goLogin();
        getActivity().finish();
        AccountActivity.show(getContext());
    }

    /**
     * 跳转到拨号
     */
    @OnClick(R.id.ly_contract)
    void onContract() {
        String phoneNum = getResources().getString(R.string.text_phone_num);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 点击钱包
     */
    @OnClick(R.id.ly_wallet)
    void onCheckWallet() {
        // TODO: 17/8/10 到查看钱包详情页面
        startActivity(new Intent(getContext(), WalletActivity.class));
    }

    /**
     * 点击优惠券
     */
    @OnClick(R.id.ly_coupon)
    void onCheckCoupon() {
        // TODO: 17/8/10 到查看优惠券页面
        ToastUtil.showToast("敬请期待");
    }

    /**
     * 点击信用积分
     */
    @OnClick(R.id.ly_credit)
    void onCheckCredit() {
        // TODO: 17/8/10 到查看信用积分页面
        ToastUtil.showToast("敬请期待");
    }

    /**
     * 点击配送地址
     */
    @OnClick(R.id.ly_location)
    void onClickedLocation() {
        startActivity(new Intent(getContext(), LocationActivity.class));
    }

    /**
     * 修改用户详细信息
     */
    @OnClick(R.id.ly_user_detail)
    void toDetailActivity() {
        startActivity(new Intent(getContext(), UserDetailActivity.class));
    }

    @Override
    public void onResume() {
        // TODO: 17/8/21 重新加载时的操作
        super.onResume();
    }

}
